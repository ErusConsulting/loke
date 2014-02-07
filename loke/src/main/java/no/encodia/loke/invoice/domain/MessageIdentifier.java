package no.encodia.loke.invoice.domain;

public final class MessageIdentifier implements PaymentIdentifier {
    private String message;

    public MessageIdentifier(String message) {
        this.message = message;
    }

    public String getTitle() {
        return "Message";
    }

    public String getValue() {
        return message;
    }
}
