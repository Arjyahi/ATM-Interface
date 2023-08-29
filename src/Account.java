import java.util.ArrayList;
import java.util.List;
import java.io.*;
public class Account {
    private String accountNumber;
    private double balance;
    private List<String> transactionHistory;

    // Constructor
    public Account(String accountNumber) {
        this.accountNumber = accountNumber;
        this.balance = 0.0;
        this.transactionHistory = new ArrayList<>();
    }
    
    public void loadTransactionHistory(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                transactionHistory.add(line);
            }
        } catch (IOException e) {
            System.out.println("Error loading transaction history.");
        }
    }

    public void saveTransactionHistory(String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (String transaction : transactionHistory) {
                writer.write(transaction + "\n");
            }
        } catch (IOException e) {
            System.out.println("Error saving transaction history.");
        }
    }
    
    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public List<String> getTransactionHistory() {
        return transactionHistory;
    }

    public void deposit(double amount) {
        balance += amount;
        transactionHistory.add("Deposit: +" + amount);
    }

    public boolean withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            transactionHistory.add("Withdraw: -" + amount);
            return true;
        }
        return false;
    }
    
    public void addTransaction(String transaction) {
        transactionHistory.add(transaction);
    }

    public boolean transfer(Account targetAccount, double amount) {
        if (balance >= amount) {
            balance -= amount;
            targetAccount.deposit(amount);
            transactionHistory.add("Transfer: -" + amount + " to " + targetAccount.accountNumber);
            return true;
        }
        return false;
    }
}

