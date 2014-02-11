package no.encodia.loke.invoice;

import com.google.common.base.Function;
import com.yammer.metrics.annotation.Timed;
import no.encodia.loke.invoice.api.InvoiceRepresentation;
import no.encodia.loke.invoice.api.TextualInvoiceRequest;
import no.encodia.loke.invoice.domain.InvoiceWithFlags;
import no.encodia.loke.invoice.domain.TextualInvoice;

import javax.validation.Valid;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

import static com.google.common.collect.Lists.transform;

@Path("/invoices")
@Produces(MediaType.APPLICATION_JSON)
public class InvoiceResource {

    private final List<InvoiceWithFlags> invoices;

    public InvoiceResource() {
        invoices = new ArrayList<>();
    }

    @GET
    @Timed
    public List<InvoiceRepresentation> getInvoices() {
        return transform(invoices, new Function<InvoiceWithFlags, InvoiceRepresentation>() {
            public InvoiceRepresentation apply(InvoiceWithFlags input) {
                return InvoiceRepresentation.map((TextualInvoice)input);
            }
        });
    }

    @POST
    @Timed
    public void createInvoice(@Valid TextualInvoiceRequest invoiceRequest) {
        TextualInvoice invoice = invoiceRequest.build();

        System.out.println("Received invoice request: " + invoice);
        invoices.add(invoice);
    }
}
