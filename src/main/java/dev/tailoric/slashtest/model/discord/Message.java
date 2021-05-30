package dev.tailoric.slashtest.model.discord;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Message {
    private long id;
    private long channelId;
    private long guildId;
    private User author;
    private Member member;
    private String content;
    private List<Embed> embeds;
}
