package dev.tailoric.slashtest.model.discord;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class ApplicationCommandInteractionData {
    private long id;
    private String name;
    private ApplicationCommandInteractionDataResolved resolved;
    private List<ApplicationCommandInteractionDataOption> options;
    private String customId;
    private int componentType;
}
