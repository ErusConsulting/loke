package no.encodia.loke.invoice.service;

import no.encodia.loke.invoice.domain.Invoice;
import no.encodia.loke.invoice.domain.InvoiceFlag;

public class InvoiceManagementService {

    private InvoiceFlagManager flagManager;

    public void register(Invoice invoice) {
        if(invoice.isRegistered()) {
            throw new UnsupportedOperationException("Invoice is already registered");
        }

        flagManager.add(invoice.getId(), InvoiceFlag.Registered);
    }

    public void pay(Invoice invoice) {
        if(!invoice.isRegistered()) {
            throw new UnsupportedOperationException("Invoice must be registered before it can be paid");
        }

        if(invoice.isPaid()) {
            throw new UnsupportedOperationException("Invoice is already paid");
        }

        flagManager.add(invoice.getId(), InvoiceFlag.Paid);
    }

    public void archive(Invoice invoice) {
        if(!invoice.isArchived()) {
            throw new UnsupportedOperationException("Invoice must be registered before it can be paid");
        }

        flagManager.add(invoice.getId(), InvoiceFlag.Archived);
    }
}
