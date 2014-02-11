package no.encodia.loke.invoice.api;

import org.joda.time.DateTime;
import org.junit.Test;

import static com.yammer.dropwizard.testing.JsonHelpers.asJson;
import static com.yammer.dropwizard.testing.JsonHelpers.jsonFixture;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

public class InvoiceRepresentationTest {

    @Test
    public void testSerialization() throws Exception {
        final InvoiceRepresentation response = new InvoiceRepresentation(
                "abcd-ef-ghi",
                DateTime.parse("2014-02-05"), DateTime.parse("2014-03-04"));

        assertThat("InvoiceRepresentation can be serialized to JSON",
                asJson(response),
                is(equalTo(jsonFixture("fixtures/invoice-representation.json"))));
    }
}
