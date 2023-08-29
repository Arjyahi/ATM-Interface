
import java.util.HashMap;
import java.util.Scanner;

public class ATM {
    private HashMap<String, User> users;
    private HashMap<String, Account> accounts;
    private User currentUser;
    private Scanner scanner;

    public ATM() {
        users = new HashMap<>();
        accounts = new HashMap<>();
        scanner = new Scanner(System.in);
        // Load transaction history
        loadTransactionHistories();
        // Add users and accounts here
    }
    private void loadTransactionHistories() {
        for (Account account : accounts.values()) {
            account.loadTransactionHistory(account.getAccountNumber() + "_transactions.txt");
        }
    }

    private void saveTransactionHistories() {
        for (Account account : accounts.values()) {
            account.saveTransactionHistory(account.getAccountNumber() + "_transactions.txt");
        }
    }

      

    public void authenticateUser() {
        System.out.print("Enter User ID: ");
        String userId = scanner.nextLine();
        System.out.print("Enter PIN: ");
        String pin = scanner.nextLine();
        
        
            users = new HashMap<>();
            accounts = new HashMap<>();
            scanner = new Scanner(System.in);
            
            

            // Populating users and accounts
            User user1 = new User("user1", "1234");
            Account account1 = new Account("1234567890");
            user1.setAccount(account1);
            account1.deposit(1000.0); 
            account1.addTransaction("Initial deposit: +$1000.0");

            User user2 = new User("user2", "5678");
            Account account2 = new Account("0987654321");
            user2.setAccount(account2);
            account2.deposit(2500.0); 
            account2.addTransaction("Initial deposit: +$2500.0");

            users.put(user1.getUserId(), user1);
            users.put(user2.getUserId(), user2);

            accounts.put(account1.getAccountNumber(), account1);
            accounts.put(account2.getAccountNumber(), account2);
            
            Runtime.getRuntime().addShutdownHook(new Thread(this::saveTransactionHistories));
        

        if (users.containsKey(userId) && users.get(userId).getPin().equals(pin)) {
            currentUser = users.get(userId);
            displayMenu();
        } else {
            System.out.println("Authentication failed.");
        }
    }
   
   
 // 

    public void displayMenu() {
        while (true) {
            System.out.println("1. Transaction History");
            System.out.println("2. Withdraw");
            System.out.println("3. Deposit");
            System.out.println("4. Transfer");
            System.out.println("5. Check Balance"); // Added option
            System.out.println("6. Quit");
            System.out.print("Enter choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    // Display transaction history
                    for (String transaction : currentUser.getAccount().getTransactionHistory()) {
                        System.out.println(transaction);
                    }
                    break;
                case 2:
                    // Withdraw
                    System.out.print("Enter amount to withdraw: ");
                    double withdrawAmount = scanner.nextDouble();
                    scanner.nextLine();  // Consume newline
                    if (currentUser.getAccount().withdraw(withdrawAmount)) {
                        System.out.println("Withdrawal successful.");
                    } else {
                        System.out.println("Insufficient balance.");
                    }
                    break;
                case 3:
                    // Deposit
                    System.out.print("Enter amount to deposit: ");
                    double depositAmount = scanner.nextDouble();
                    scanner.nextLine();  // Consume newline
                    currentUser.getAccount().deposit(depositAmount);
                    System.out.println("Deposit successful.");
                    break;
                case 4:
                    // Transfer
                    System.out.print("Enter target account number: ");
                    String targetAccountNumber = scanner.nextLine();
                    if (accounts.containsKey(targetAccountNumber)) {
                        System.out.print("Enter amount to transfer: ");
                        double transferAmount = scanner.nextDouble();
                        scanner.nextLine();  // Consume newline
                        if (currentUser.getAccount().transfer(accounts.get(targetAccountNumber), transferAmount)) {
                            System.out.println("Transfer successful.");
                        } else {
                            System.out.println("Insufficient balance.");
                        }
                    } else {
                        System.out.println("Target account not found.");
                    }
                    break;
                case 5:
                    // Check Balance
                    System.out.println("Current balance: $" + currentUser.getAccount().getBalance());
                    break;
                case 6:
                    // Quit
                    System.out.println("Thank you for using the ATM.");
                    return;
                default:
                    System.out.println("Invalid choice.");
                    break;
            }
        }
    }
   

    public static void main(String[] args) {
        ATM atm = new ATM();
        atm.authenticateUser();
    }
}
