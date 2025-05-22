class BankAccount {
    private int accountNumber;
    private String accountHolder;
    private double balance;

    public BankAccount(int accountNumber, String accountHolder, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    public int getAccountNumber() { return accountNumber; }
    public String getAccountHolder() { return accountHolder; }
    public double getBalance() { return balance; }
    
    public void withdraw(double amount) throws IllegalArgumentException {
        if (amount > balance) {
            throw new IllegalArgumentException("Insufficient balance");
        }
        balance -= amount;
    }
}

class Bank {
    private BankAccount[] accounts;
    private int accountCount;

    public Bank() {
        accounts = new BankAccount[5];
        accountCount = 0;
    }

    public void addAccount(BankAccount account) {
        if (accountCount < 5) {
            accounts[accountCount++] = account;
        } else {
            System.out.println("Bank at maximum account capacity (5)");
        }
    }

    public void withdrawFromAccount(int accountNumber, double amount) {
        for (int i = 0; i < accountCount; i++) {
            if (accounts[i].getAccountNumber() == accountNumber) {
                try {
                    accounts[i].withdraw(amount);
                    System.out.println("Withdrawal successful. New balance: " + accounts[i].getBalance());
                } catch (IllegalArgumentException e) {
                    System.out.println("Error: " + e.getMessage());
                }
                return;
            }
        }
        System.out.println("Account " + accountNumber + " not found");
    }

    public void displayAllAccounts() {
        System.out.println("Account #\tHolder\t\tBalance");
        System.out.println("----------------------------------------");
        for (int i = 0; i < accountCount; i++) {
            System.out.printf("%-10d\t%-15s\t$%.2f\n",
                accounts[i].getAccountNumber(),
                accounts[i].getAccountHolder(),
                accounts[i].getBalance());
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank();
        
        bank.addAccount(new BankAccount(1001, "Alice", 5000.0));
        bank.addAccount(new BankAccount(1002, "Bob", 3000.0));
        
        bank.withdrawFromAccount(1001, 6000.0); // Should fail
        bank.withdrawFromAccount(1002, 1000.0); // Should succeed
        
        bank.displayAllAccounts();
    }
}
