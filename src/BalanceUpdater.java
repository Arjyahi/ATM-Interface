public class BalanceUpdater {
    public static boolean updateBalanceDeposit(Account account, double amount) {
        if (amount > 0) {
            account.deposit(amount);
            return true;
        }
        return false;
    }

    public static boolean updateBalanceWithdraw(Account account, double amount) {
        if (amount > 0 && account.withdraw(amount)) {
            return true;
        }
        return false;
    }

    public static boolean updateBalanceTransfer(Account sourceAccount, Account targetAccount, double amount) {
        if (amount > 0 && sourceAccount.transfer(targetAccount, amount)) {
            return true;
        }
        return false;
    }
}
