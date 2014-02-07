package no.encodia.loke.invoice.domain;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BankAccountTest {

    @Test(expected = IllegalArgumentException.class)
    public void nonNumericalBankAccountIsNotAllowed() throws Exception {
        BankAccount.createBankAccount("abc123abcdes");
    }

    @Test(expected = IllegalArgumentException.class)
    public void lessThanElevenDigitsIsNotAllowed() throws Exception {
        BankAccount.createBankAccount("1234567890");
    }

    @Test(expected = IllegalArgumentException.class)
    public void moreThanElevenDigitsIsNotAllowed() throws Exception {
        BankAccount.createBankAccount("123456789012");
    }

    @Test
    public void numericalElevenDigitsAreAllowed() throws Exception {
        BankAccount account = BankAccount.createBankAccount("12345678901");

        assertEquals("12345678901", account.value());
    }

    @Test
    public void dottedNotationIsAllowed() throws Exception {
        BankAccount account = BankAccount.createBankAccount("1234.56.78901");

        assertEquals("12345678901", account.value());
    }

    @Test
    public void spacesAreAllowed() throws Exception {
        BankAccount account = BankAccount.createBankAccount("1234 56 78901");

        assertEquals("12345678901", account.value());
    }
}
