package no.encodia.loke.invoice.domain;

public interface InvoiceWithFlags {
    InvoiceId getId();
    Iterable<InvoiceFlag> getFlags();
}
