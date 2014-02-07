package no.encodia.loke.invoice.service;

import no.encodia.loke.invoice.domain.InvoiceFlag;
import no.encodia.loke.invoice.domain.InvoiceId;

public interface InvoiceFlagManager {
    void add(InvoiceId invoiceId, InvoiceFlag flag);
    Iterable<InvoiceFlag> getFlagsFor(InvoiceId invoiceId);
}
