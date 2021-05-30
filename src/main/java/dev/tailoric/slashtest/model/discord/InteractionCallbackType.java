package dev.tailoric.slashtest.model.discord;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;

public enum InteractionCallbackType {
    Pong(1),
    ChannelMessageWithSource(4),
    DeferredChannelMessageWithSource(5),
    DeferredUpdateMessage(6),
    UpdateMessage(7);

    @Getter
    private final int callBackType;

    @JsonValue
    public int toValue(){
        return getCallBackType();
    }
    InteractionCallbackType(int callBackType) {
        this.callBackType = callBackType;
    }
    public static InteractionCallbackType forType(int type){
        for (var element :
                values()) {
            if (element.callBackType == type) {
                return element;
            }
        }
        return null;
    }
    @JsonCreator
    public static InteractionCallbackType forValue(int v){
        return InteractionCallbackType.forType(v);
    }
}
