package no.encodia.loke.invoice.domain;

import java.sql.Date;

public class TextualInvoiceTest {

    public void buildATextualInvoice() {

        TextualInvoice invoice = new TextualInvoice(
                new InvoiceId(),
                Date.valueOf("2014-01-01"), Date.valueOf("2014-02-24"),
                500, "Atum Økonomi",
                BankAccount.createBankAccount("3705.04.24058"),
                new KidIdentifier("12345678"),
                InvoiceFlag.Registered);

        Invoice wrapper = new Invoice(invoice);

        if(!wrapper.isRegistered()) {
            throw new RuntimeException("Invoice should be registered!");
        }
    }
}
