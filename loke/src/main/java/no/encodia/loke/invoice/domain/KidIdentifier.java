package no.encodia.loke.invoice.domain;

public final class KidIdentifier implements PaymentIdentifier {
    private String kid;

    public KidIdentifier(String kid) {
        this.kid = kid;
    }

    public String getTitle() {
        return "KID";
    }

    public String getValue() {
        return kid;
    }
}
