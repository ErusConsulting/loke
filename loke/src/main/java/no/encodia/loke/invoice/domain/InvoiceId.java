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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        InvoiceId invoiceId = (InvoiceId) o;

        return id.equals(invoiceId.id);

    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
