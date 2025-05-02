import org.example.Transaction;

import java.util.List;

public class Ledger {

    private List<Transaction> transactions;

    public Ledger() {
        this.transactions = FileManager.readFile(); // from existing transaction from file or creates empty list
    } // End of Ledger constructor
    public void addDeposit(Transaction transaction) {


        this.transactions.add(transaction); // for the other file
            this.transactions.add(transaction); // for the other file

        FileManager.appendTransaction(transaction);// persist transaction to file

            FileManager.appendTransaction(transaction);// persist transaction to file
    } // End of addDeposit method

    public void makePayment(Transaction transactions) {
        // Method to add a payment transaction

                this.transactions.add(transactions);
                FileManager.appendTransaction(transactions);
        // End of makePayment method
    } // Closing brace to end makePayment method
} // Closing brace to end Ledger class


