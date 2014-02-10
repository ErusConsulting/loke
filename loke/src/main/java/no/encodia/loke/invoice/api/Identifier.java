package no.encodia.loke.invoice.api;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Identifier {

    @JsonProperty private final String type;
    @JsonProperty private final String value;

    public Identifier(@JsonProperty("type") String type,
                      @JsonProperty("value") String value) {
        this.type = type;
        this.value = value;
    }

    public String getType() {
        return type;
    }

    public String getValue() {
        return value;
    }
}
