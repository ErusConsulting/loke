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

        PaymentIdentifierFactory paymentIdentifierFactory = new PaymentIdentifierFactory();

        return new TextualInvoice(new InvoiceId(),
                DateTime.parse(invoiceDate), DateTime.parse(dueDate),
                amount,
                creditor.getName(), BankAccount.createBankAccount(creditor.getAccount()),
                paymentIdentifierFactory.createFrom(identifier));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TextualInvoiceRequest that = (TextualInvoiceRequest) o;

        if (Double.compare(that.amount, amount) != 0) return false;
        if (!creditor.equals(that.creditor)) return false;
        if (!dueDate.equals(that.dueDate)) return false;
        if (!identifier.equals(that.identifier)) return false;
        if (!invoiceDate.equals(that.invoiceDate)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = invoiceDate.hashCode();
        result = 31 * result + dueDate.hashCode();
        temp = Double.doubleToLongBits(amount);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + creditor.hashCode();
        result = 31 * result + identifier.hashCode();
        return result;
    }

    private class PaymentIdentifierFactory {

        public PaymentIdentifier createFrom(Identifier identifier) {

            if(isKidIdentifier(identifier)) {
                return new KidIdentifier(identifier.getValue());
            }
            else {
                return new MessageIdentifier(identifier.getValue());
            }
        }

        private boolean isKidIdentifier(Identifier identifier) {
            return "kid".equalsIgnoreCase(identifier.getType());
        }
    }
}
