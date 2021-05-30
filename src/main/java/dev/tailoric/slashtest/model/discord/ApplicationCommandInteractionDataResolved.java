package dev.tailoric.slashtest.model.discord;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.Map;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ApplicationCommandInteractionDataResolved {
    private Map<Long, User> users;
    private Map<Long, Member> members;

}
