package dev.tailoric.slashtest.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import dev.tailoric.slashtest.model.discord.*;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class InteractionReceive {
    private long id;
    private long applicationId;
    private InteractionType type;
    private ApplicationCommandInteractionData data;
    private long guildId;
    private long channelId;
    private Member member;
    private User user;
    private String token;
    private int version;
    private Message message;
}
