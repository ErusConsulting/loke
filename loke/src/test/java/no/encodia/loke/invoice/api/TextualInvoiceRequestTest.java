package no.encodia.loke.invoice.api;

import org.junit.Test;

import static com.yammer.dropwizard.testing.JsonHelpers.fromJson;
import static com.yammer.dropwizard.testing.JsonHelpers.jsonFixture;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class TextualInvoiceRequestTest {

    @Test
    public void testDeserialization() throws Exception {
        final TextualInvoiceRequest request = new TextualInvoiceRequest(
                "2013-12-04", "2014-01-10",
                13.37,
                new Creditor("Kreditoren", "12345678901"),
                new Identifier("kid", "12345678"));

        assertThat("TextualInvoiceRequest can be deserialized from JSON",
                fromJson(jsonFixture("fixtures/textual-invoice-request.json"), TextualInvoiceRequest.class),
                is(request));
    }
}
