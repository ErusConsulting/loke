package no.encodia.loke.invoice;

import com.google.common.base.Function;
import com.yammer.metrics.annotation.Timed;
import no.encodia.loke.invoice.api.InvoiceRepresentation;
import no.encodia.loke.invoice.api.TextualInvoiceRequest;
import no.encodia.loke.invoice.domain.InvoiceId;
import no.encodia.loke.invoice.domain.InvoiceWithFlags;
import no.encodia.loke.invoice.domain.TextualInvoice;
import org.joda.time.DateTime;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import static com.google.common.collect.Lists.transform;

@Path("/invoices")
@Produces(MediaType.APPLICATION_JSON)
public class InvoiceResource {

    private final List<InvoiceWithFlags> invoices;

    @Context
    UriInfo uriInfo;

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

    @GET
    @Path("/{id}")
    @Timed
    public InvoiceRepresentation getInvoice(@PathParam("id") String id) {
        InvoiceId invoiceId = new InvoiceId(id);

        for(InvoiceWithFlags invoice : invoices) {
            if(invoice.getId().equals(invoiceId)) {
                return InvoiceRepresentation.map((TextualInvoice) invoice);
            }
        }

        throw new WebApplicationException(Response.Status.NOT_FOUND);
    }

    @POST
    @Timed
    public Response createInvoice(@Valid TextualInvoiceRequest invoiceRequest) {
        TextualInvoice invoice = invoiceRequest.build();
        invoices.add(invoice);

        UriBuilder ub = uriInfo.getAbsolutePathBuilder();
        URI invoiceUri = ub.path(invoice.getId().value()).build();

        return Response.created(invoiceUri).build();
    }
}
