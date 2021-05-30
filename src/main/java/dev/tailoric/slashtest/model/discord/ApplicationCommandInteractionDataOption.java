package dev.tailoric.slashtest.model.discord;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ApplicationCommandInteractionDataOption {
    private String name;
    private int type;
    private List<ApplicationCommandInteractionDataOption> options;
}
