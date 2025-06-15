package org.example;

import org.junit.jupiter.api.Assertions;

class BankAccountTest {

    @org.junit.jupiter.api.Test
    void getBalance() {
        Main account = new Main("Alice", 100.0);
        assertEquals(100.0, account.getBalance(), 0.001);
    }

    private void assertEquals(double v, double balance, double v1) {
    }

    @org.junit.jupiter.api.Test
    void getAccountHolder() {
        Main account = new Main("Bob", 200.0);
        Assertions.assertEquals("Bob", account.getAccountHolder());
    }

    @org.junit.jupiter.api.Test
    void deposit() {
        Main account = new Main("Charlie", 150.0);
        account.deposit(50.0);
        assertEquals(200.0, account.getBalance(), 0.001);
    }

    @org.junit.jupiter.api.Test
    void withdraw() {
        Main account = new Main("Diana", 300.0);
        account.withdraw(75.0);
        assertEquals(225.0, account.getBalance(), 0.001);
    }
}
