package dev.tailoric.slashtest.model;

import lombok.Data;

@Data
public class InteractionReceive {
    private int type;
    private String token;
    private long id;
    private long guildId;
    private long channelId;
}
