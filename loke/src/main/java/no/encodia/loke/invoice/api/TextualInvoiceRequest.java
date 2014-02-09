package no.encodia.loke.invoice.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import no.encodia.loke.invoice.domain.*;
import org.joda.time.DateTime;

public class TextualInvoiceRequest {

    @JsonProperty private final String invoiceDate;
    @JsonProperty private final String dueDate;
    @JsonProperty private final double amount;
    @JsonProperty private final String creditorName;
    @JsonProperty private final String creditorAccount;
    @JsonProperty private final String identifierType;
    @JsonProperty private final String identifierValue;

    public TextualInvoiceRequest(@JsonProperty("invoiceDate") String invoiceDate,
                                 @JsonProperty("dueDate") String dueDate,
                                 @JsonProperty("amount") double amount,
                                 @JsonProperty("creditorName") String creditorName,
                                 @JsonProperty("creditorAccount") String creditorAccount,
                                 @JsonProperty("identifierType") String identifierType,
                                 @JsonProperty("identifierValue") String identifierValue) {
        this.invoiceDate = invoiceDate;
        this.dueDate = dueDate;
        this.amount = amount;
        this.creditorName = creditorName;
        this.creditorAccount = creditorAccount;
        this.identifierType = identifierType;
        this.identifierValue = identifierValue;
    }

    public TextualInvoice build() {

        PaymentIdentifier paymentIdentifier;
        if("kid".equalsIgnoreCase(identifierType)) {
            paymentIdentifier = new KidIdentifier(identifierValue);
        }
        else {
            paymentIdentifier = new MessageIdentifier(identifierValue);
        }

        return new TextualInvoice(new InvoiceId(),
                DateTime.parse(invoiceDate), DateTime.parse(dueDate),
                amount,
                creditorName, BankAccount.createBankAccount(creditorAccount),
                paymentIdentifier);
    }
}
