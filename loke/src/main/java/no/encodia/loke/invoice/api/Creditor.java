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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Creditor creditor = (Creditor) o;

        if (!account.equals(creditor.account)) return false;
        if (!name.equals(creditor.name)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + account.hashCode();
        return result;
    }
}
