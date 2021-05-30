package dev.tailoric.slashtest;

import dev.tailoric.slashtest.filter.SlashCommandVerifier;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "discord")
@Data
public class DiscordConfig {
    private String publicKey;
    @Bean
    public FilterRegistrationBean<SlashCommandVerifier> verifyFilter(){
        var verifyingBean = new FilterRegistrationBean<SlashCommandVerifier>();
        verifyingBean.setFilter(new SlashCommandVerifier(publicKey));
        verifyingBean.addUrlPatterns("/slash/*");
        return verifyingBean;
    }
}
