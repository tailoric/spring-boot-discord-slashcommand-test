package dev.tailoric.slashtest.model.discord;

import com.fasterxml.jackson.annotation.JsonValue;

public enum InteractionCallbackType {
    Pong(1),
    ChannelMessageWithSource(4),
    DeferredChannelMessageWithSource(5),
    DeferredUpdateMessage(6),
    UpdateMessage(7);

    public final int number;
    @JsonValue
    public int toValue(){
        return number;
    }
    InteractionCallbackType(int i) {
        this.number = i;
    }
}
