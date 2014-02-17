package no.encodia.loke.invoice;

import com.sun.jersey.api.client.ClientResponse;
import com.yammer.dropwizard.testing.ResourceTest;
import no.encodia.loke.invoice.api.TextualInvoiceRequest;
import org.junit.Test;

import javax.ws.rs.core.MediaType;
import java.net.URI;

import static com.yammer.dropwizard.testing.JsonHelpers.fromJson;
import static com.yammer.dropwizard.testing.JsonHelpers.jsonFixture;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertEquals;

/**
 * Integration tests, testing the contract for {@link no.encodia.loke.invoice.InvoiceResource}
 */
public class InvoiceResourceTest extends ResourceTest {

    @Override
    protected void setUpResources() throws Exception {
        addResource(new InvoiceResource());
    }

    @Test
    public void createAndGet() throws Exception {

        ClientResponse createdResponse = client()
                .resource("/invoices")
                .type(MediaType.APPLICATION_JSON)
                .post(ClientResponse.class, fromJson(jsonFixture("fixtures/textual-invoice-request.json"), TextualInvoiceRequest.class));

        URI location = createdResponse.getLocation();

        ClientResponse invoiceResponse = client()
                .resource(location)
                .get(ClientResponse.class);

        assertThat("Retrieval of invoices yields 200 OK",
                invoiceResponse.getClientResponseStatus(),
                is(equalTo(ClientResponse.Status.OK)));
    }

    @Test
    public void canNotGetNonExistingInvoice() throws Exception {

        ClientResponse response = client()
                .resource("/invoices/test-foobar")
                .get(ClientResponse.class);

        assertThat("Retrieval of non-existing invoice gives 404 Not found",
                response.getClientResponseStatus(),
                is(equalTo(ClientResponse.Status.NOT_FOUND)));
    }

}
