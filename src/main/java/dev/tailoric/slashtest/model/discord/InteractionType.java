package dev.tailoric.slashtest.model.discord;

import com.fasterxml.jackson.annotation.JsonValue;

public enum InteractionType {
    PING,
    APPLICATION_COMMAND,
    MESSAGE_COMPONENT;

    @JsonValue
    public int toValue(){
        return ordinal();
    }
}
