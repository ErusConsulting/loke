package no.encodia.loke.invoice.domain;

public enum InvoiceFlag {
    Registered ('r'),
    Paid ('p'),
    Archived ('a');


    private char identifier;

    InvoiceFlag(char identifier) {
        this.identifier = identifier;
    }

    public boolean appliedTo(InvoiceWithFlags invoice) {
        for(InvoiceFlag flag : invoice.getFlags()) {
            if(flag.identifier == identifier) {
                return true;
            }
        }

        return false;
    }
}
