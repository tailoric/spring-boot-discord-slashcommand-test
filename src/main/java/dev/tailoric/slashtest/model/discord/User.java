package dev.tailoric.slashtest.model.discord;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class User {
    long id;
    String username;
    String discriminator;
    String avatar;
    boolean bot;
    boolean system;
    boolean mfaEnabled;
    String locale;
    boolean verified;
    String email;
    int flags;
    int premiumType;
    int publicFlags;
}
