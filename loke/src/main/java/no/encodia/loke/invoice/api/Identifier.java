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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Identifier that = (Identifier) o;

        if (!type.equals(that.type)) return false;
        if (!value.equals(that.value)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = type.hashCode();
        result = 31 * result + value.hashCode();
        return result;
    }
}
