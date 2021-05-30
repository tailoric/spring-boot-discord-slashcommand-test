package dev.tailoric.slashtest.model.discord;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Embed {
    private String title;
    private String type;
    private String description;
    private String url;
    private String timestamp;
    private int color;
    private Footer footer;
    private List<Field> fields;
}
