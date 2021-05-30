package dev.tailoric.slashtest.model.discord;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;

public enum InteractionType {
    PING(1),
    APPLICATION_COMMAND(2),
    MESSAGE_COMPONENT(3);

    @Getter
    private final int type;
    InteractionType(int type) {
        this.type = type;
    }
    @JsonValue
    public int toValue(){
        return getType();
    }
    public static InteractionType forType(int type){
        for (var element :
                values()) {
            if (element.type == type) {
                return element;
            }
        }
        return null;
    }

    //We are doing it like this because of a Jackson inconsistency which makes @JsonValue return the ordinal number
    // see here for more info https://github.com/FasterXML/jackson-databind/issues/1850#issuecomment-445341265
    @JsonCreator
    public static InteractionType forValue(int v){
        return InteractionType.forType(v);
    }

}
