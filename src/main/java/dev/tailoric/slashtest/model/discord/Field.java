package dev.tailoric.slashtest.model.discord;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Field {
    String name;
    String value;
    boolean inline;
}
