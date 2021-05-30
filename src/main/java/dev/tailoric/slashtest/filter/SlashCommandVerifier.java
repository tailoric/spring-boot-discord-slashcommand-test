package dev.tailoric.slashtest.filter;


import com.google.crypto.tink.subtle.Ed25519Verify;
import dev.tailoric.slashtest.helper.CachedBodyHttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.GeneralSecurityException;

/**
 * Filter for verifying the signature that is sent with every slash command
 * see here https://discord.com/developers/docs/interactions/slash-commands#security-and-authorization
 */
@Component
@Slf4j
public class SlashCommandVerifier implements Filter {
    private final Ed25519Verify verifier;
    @Autowired
    public SlashCommandVerifier(@Value("${discord.public-key}") String publicKey){
        byte[] b = new BigInteger(publicKey, 16).toByteArray();
        this.verifier = new Ed25519Verify(b);
    }
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        var req = (HttpServletRequest) request;
        var res = (HttpServletResponse) response;
        var wrappedReq = new CachedBodyHttpServletRequest(req);
        var body = wrappedReq.getReader().readLine().strip();
        var signature = req.getHeader("X-Signature-Ed25519");
        var timestamp = req.getHeader("X-Signature-Timestamp");
        var sigBytes = new BigInteger(signature, 16).toByteArray();
        var message = timestamp+body;
        log.debug(signature);
        log.debug(timestamp);
        log.debug(message);
        try{
            verifier.verify(sigBytes, message.getBytes(StandardCharsets.UTF_8));
        }
        catch (GeneralSecurityException e){
            log.error("Error while verifying slash command:", e);
            res.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            res.getWriter().print("invalid request signature");
            return;
        }
        chain.doFilter(wrappedReq, response);
    }
}
