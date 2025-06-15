package org.example;

public class Main {
    public static void main(String[] args) {
        BankAccount account1 = new BankAccount("John", 1000);

        //firstAccount.balance - 10000000000;

        account1.deposit(100);
        account1.withdraw(500);

    }
}