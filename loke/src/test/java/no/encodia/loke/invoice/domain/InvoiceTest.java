package no.encodia.loke.invoice.domain;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class InvoiceTest {

    @Test
    public void testIsRegistered() throws Exception {
        Invoice invoice = new Invoice(new TestInvoice(InvoiceFlag.Registered));
        assertTrue(invoice.isRegistered());
    }

    @Test
    public void testIsPaid() throws Exception {
        Invoice invoice = new Invoice(new TestInvoice(InvoiceFlag.Paid));
        assertTrue(invoice.isPaid());
    }

    @Test
    public void testIsArchived() throws Exception {
        Invoice invoice = new Invoice(new TestInvoice(InvoiceFlag.Archived));
        assertTrue(invoice.isArchived());
    }

    private class TestInvoice implements InvoiceWithFlags {

        private List<InvoiceFlag> flags;

        public TestInvoice(InvoiceFlag... flags) {
            this.flags = Arrays.asList(flags);
        }

        public InvoiceId getId() {
            return  null;
        }

        public Iterable<InvoiceFlag> getFlags() {
            return flags;
        }
    }
}
