# ATM-Interface
This complex project consists of 4 different classes and is a console based application. 
When the system starts, user is prompted with user id and pin,  on entering details successfully, then atm functionalities are unlocked. 
The project allows following operations: 1. transaction history 2. withdraw 3. deposit 4. transfer 5. check balance 6. quit 

1. **User Class:**
   - This class represents a user of the ATM system.
   - It has fields for the user's ID, PIN, and a reference to their associated account.
   - The `User` constructor takes the user ID and PIN as parameters.
   - Getter and setter methods are provided for accessing and modifying user attributes.
   - This class establishes a link between users and their respective accounts.

2. **Account Class:**
   - Represents a bank account associated with a user.
   - It has fields for the account number, balance, and a list to store transaction history.
   - The `Account` constructor takes the account number as a parameter and initializes the balance and transaction history list.
   - Provides methods for loading and saving transaction history from/to a file.
   - Offers methods to interact with the account such as deposit, withdraw, transfer, and add transaction.
   - The transaction history records are maintained for auditing and tracking account activity.

3. **ATM Class:**
   - The main class that simulates an ATM system.
   - Contains `HashMap`s to store users and accounts, along with a reference to the current user.
   - `authenticateUser` method prompts the user for ID and PIN to authenticate and set the current user.
   - The `displayMenu` method presents a menu of options: Transaction History, Withdraw, Deposit, Transfer, Check Balance, and Quit.
   - The user's input determines the action taken in response to their choice.
   - Utilizes other classes like `User` and `Account` for its operations.
   - Implements loading and saving of transaction histories for accounts.

4. **BalanceUpdater Class:**
   - This class encapsulates methods to update account balances for various operations.
   - `updateBalanceDeposit` method increases the balance when a deposit is made.
   - `updateBalanceWithdraw` method handles balance update when a withdrawal is made.
   - `updateBalanceTransfer` method updates the balances for both the source and target accounts during a transfer.

These classes and methods together create a basic console-based ATM system. Users can authenticate themselves, view transaction history, perform deposits, withdrawals, transfers, and check their account balances. The `BalanceUpdater` class ensures that the balances are updated consistently and appropriately during various transactions.
