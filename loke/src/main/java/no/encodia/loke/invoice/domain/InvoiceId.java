package no.encodia.loke.invoice.domain;

import java.util.UUID;

public final class InvoiceId {

    private final String id;

    public InvoiceId(String id) {
        this.id = id;
    }

    public InvoiceId() {
        this.id = UUID.randomUUID().toString();
    }

    public String value() {
        return id;
    }
}
