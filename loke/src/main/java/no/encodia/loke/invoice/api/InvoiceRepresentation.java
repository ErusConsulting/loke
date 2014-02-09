package no.encodia.loke.invoice.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import no.encodia.loke.invoice.domain.TextualInvoice;
import org.joda.time.DateTime;

public class InvoiceRepresentation {

    @JsonProperty private String invoiceId;
    @JsonProperty private String invoiceDate;
    @JsonProperty private String dueDate;

    public InvoiceRepresentation(String invoiceId, DateTime invoiceDate, DateTime dueDate) {
        this.invoiceId = invoiceId;
        this.invoiceDate = invoiceDate.toString("YYYY-MM-dd");
        this.dueDate = dueDate.toString("YYYY-MM-dd");
    }

    public static InvoiceRepresentation map(TextualInvoice invoice) {
        return new InvoiceRepresentation(
                invoice.getId().value(),
                invoice.getInvoiceDate(),
                invoice.getDueDate());
    }
}
