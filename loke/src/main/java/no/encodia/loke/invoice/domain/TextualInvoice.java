package no.encodia.loke.invoice.domain;

import org.joda.time.DateTime;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class TextualInvoice implements InvoiceWithFlags {

    private InvoiceId id;

    private DateTime invoiceDate;
    private DateTime dueDate;

    private double amount;

    private String creditor;
    private BankAccount creditorAccount;

    private PaymentIdentifier paymentIdentifier;

    private List<InvoiceFlag> flags;

    public TextualInvoice(InvoiceId id, DateTime invoiceDate, DateTime dueDate, double amount, String creditor, BankAccount creditorAccount, PaymentIdentifier paymentIdentifier, InvoiceFlag... flags) {
        this.id = id;
        this.invoiceDate = invoiceDate;
        this.dueDate = dueDate;
        this.amount = amount;
        this.creditor = creditor;
        this.creditorAccount = creditorAccount;
        this.paymentIdentifier = paymentIdentifier;
        this.flags = Arrays.asList(flags);
    }

    public InvoiceId getId() {
        return id;
    }
    public DateTime getInvoiceDate() { return invoiceDate; }
    public DateTime getDueDate() { return dueDate; }

    public Iterable<InvoiceFlag> getFlags() {
        return flags;
    }

    public String toString() {
        return "TextualInvoice{" +
                "id=" + id +
                ", invoiceDate=" + invoiceDate +
                ", dueDate=" + dueDate +
                ", amount=" + amount +
                ", creditor='" + creditor + '\'' +
                ", creditorAccount=" + creditorAccount +
                ", paymentIdentifier=" + paymentIdentifier +
                ", flags=" + flags +
                '}';
    }
}
