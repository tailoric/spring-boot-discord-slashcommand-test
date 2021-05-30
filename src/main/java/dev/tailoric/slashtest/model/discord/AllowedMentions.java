package dev.tailoric.slashtest.model.discord;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class AllowedMentions {
    List<String> parse;
    List<Long> roles;
    List<Long> users;
    boolean repliedUser;
}
