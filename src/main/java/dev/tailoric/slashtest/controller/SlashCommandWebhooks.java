package dev.tailoric.slashtest.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.crypto.tink.proto.Ed25519PublicKey;
import com.google.crypto.tink.subtle.Base64;
import com.google.crypto.tink.subtle.Ed25519Verify;
import com.google.protobuf.InvalidProtocolBufferException;
import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.crypto.Ed25519Verifier;
import com.nimbusds.jose.jwk.OctetKeyPair;
import dev.tailoric.slashtest.model.InteractionReceive;
import dev.tailoric.slashtest.model.InteractionResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import javax.mail.internet.ContentType;
import javax.servlet.http.HttpServletRequest;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.*;
import java.text.ParseException;

@Slf4j
@RestController
@RequestMapping
public class SlashCommandWebhooks {

    private final ObjectMapper mapper;
    @Autowired
    public SlashCommandWebhooks(ObjectMapper mapper) {
        this.mapper = mapper;
    }
    @RequestMapping(value = "/slash/incoming", method = RequestMethod.POST, produces = "application/json")
    public InteractionResponse receive(@RequestBody InteractionReceive interaction, HttpServletRequest request) {
        var response = new InteractionResponse();
        response.setType(1);
        return response;
    }

}
