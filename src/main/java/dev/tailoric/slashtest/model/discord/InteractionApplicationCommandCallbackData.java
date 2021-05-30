package dev.tailoric.slashtest.model.discord;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class InteractionApplicationCommandCallbackData {
    boolean tts;
    String content;
    List<Embed> embeds;
    AllowedMentions allowedMentions;
    int flags;
}
