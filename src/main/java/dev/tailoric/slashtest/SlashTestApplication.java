package dev.tailoric.slashtest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;

@SpringBootApplication
@Slf4j
public class SlashTestApplication extends WebSecurityConfigurerAdapter implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(SlashTestApplication.class, args);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http.authorizeRequests(a -> a
                .anyRequest().permitAll()
        )
                // ignore csrf tokens since discord is supposed to send to this endpoint
                .csrf().ignoringAntMatchers("/slash/incoming").and()
                .exceptionHandling(e -> e
                        .authenticationEntryPoint(new HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED))
                )
                .oauth2Login();
    }

    @Override
    public void run(String... args) throws Exception {
        // TODO: register a slash command on startup
        log.info("hi");
    }
}
