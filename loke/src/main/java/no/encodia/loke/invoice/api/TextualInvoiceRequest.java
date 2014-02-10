package no.encodia.loke.invoice.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import no.encodia.loke.invoice.domain.*;
import org.joda.time.DateTime;

public class TextualInvoiceRequest {

    @JsonProperty private final String invoiceDate;
    @JsonProperty private final String dueDate;
    @JsonProperty private final double amount;
    @JsonProperty private final Creditor creditor;
    @JsonProperty private final Identifier identifier;

    public TextualInvoiceRequest(@JsonProperty("invoiceDate") String invoiceDate,
                                 @JsonProperty("dueDate") String dueDate,
                                 @JsonProperty("amount") double amount,
                                 @JsonProperty("creditor") Creditor creditor,
                                 @JsonProperty("identifier") Identifier identifier) {
        this.invoiceDate = invoiceDate;
        this.dueDate = dueDate;
        this.amount = amount;
        this.creditor = creditor;
        this.identifier = identifier;
    }

    public TextualInvoice build() {

        PaymentIdentifier paymentIdentifier;
        if("kid".equalsIgnoreCase(identifier.getType())) {
            paymentIdentifier = new KidIdentifier(identifier.getValue());
        }
        else {
            paymentIdentifier = new MessageIdentifier(identifier.getValue());
        }

        return new TextualInvoice(new InvoiceId(),
                DateTime.parse(invoiceDate), DateTime.parse(dueDate),
                amount,
                creditor.getName(), BankAccount.createBankAccount(creditor.getAccount()),
                paymentIdentifier);
    }
}
