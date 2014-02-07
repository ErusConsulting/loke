package no.encodia.loke.invoice.domain;

public class Invoice {

    private InvoiceWithFlags wrappedInvoice;

    public Invoice(InvoiceWithFlags forInvoice) {
        wrappedInvoice = forInvoice;
    }

    public InvoiceId getId() {
        return wrappedInvoice.getId();
    }

    public boolean isRegistered() {
        return InvoiceFlag.Registered.appliedTo(wrappedInvoice);
    }

    public boolean isPaid() {
        return InvoiceFlag.Paid.appliedTo(wrappedInvoice);
    }

    public boolean isArchived() {
        return InvoiceFlag.Archived.appliedTo(wrappedInvoice);
    }
}
