package no.encodia.loke.invoice.domain;

public final class BankAccount {

    private final String accountNumber;

    private BankAccount(String accountNumber) {
        this.accountNumber = accountNumber;

    }

    public String value() {
        return accountNumber;
    }

    public String toString() {
        // maybe dotted notation?
        return value();
    }

    public static BankAccount createBankAccount(String requestedAccountNumber) {
        String accountNumber = requestedAccountNumber;

        accountNumber = accountNumber.replaceAll("\\.", "");
        accountNumber = accountNumber.replaceAll(" ", "");

        if(!accountNumber.matches("^[0-9]*$")) {
            throw new IllegalArgumentException("Account number must be numerical");
        }

        if(accountNumber.length() == 11) {
            throw new IllegalArgumentException("Account number must be exactly 11 digits");
        }

        return new BankAccount(accountNumber);
    }
}
