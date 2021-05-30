package dev.tailoric.slashtest.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import dev.tailoric.slashtest.model.discord.InteractionApplicationCommandCallbackData;
import dev.tailoric.slashtest.model.discord.InteractionCallbackType;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class InteractionResponse {
    InteractionCallbackType type;
    InteractionApplicationCommandCallbackData data;
}
