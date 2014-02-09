package no.encodia.loke.invoice.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.NotEmpty;

public class Creditor {

    @JsonProperty
    @NotEmpty
    private String name;

    @JsonProperty
    @NotEmpty
    private String account;

    public Creditor(@JsonProperty("name") String name, @JsonProperty("account") String account) {
        this.name = name;
        this.account = account;
    }

    public String getName() {
        return name;
    }

    public String getAccount() {
        return account;
    }
}
