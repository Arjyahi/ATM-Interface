public class User {
    private String userId;
    private String pin;
    private Account account;  // Reference to the associated account

    // Constructor
    public User(String userId, String pin) {
        this.userId = userId;
        this.pin = pin;
    }

    // Getters and setters
    public String getUserId() {
        return userId;
    }

    public String getPin() {
        return pin;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}


