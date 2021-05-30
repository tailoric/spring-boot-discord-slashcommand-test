package dev.tailoric.slashtest.model.discord;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Member {
    private User user;
    private String nick;
    private List<Long> roles;
    private String joinedAt;
    private String premiumSince;
    private boolean deaf;
    private boolean mute;
    private boolean pending;
    private String permissions;
}
