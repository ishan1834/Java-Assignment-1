package JAVA;

import java.util.Scanner;

public class UserInterface {
    private Account[] accounts;
    private int accountCount;
    private Scanner scanner;

    public UserInterface() {
      //suppose that i holding 10000 account----
        accounts = new Account[10000];
        accountCount = 0;
        scanner = new Scanner(System.in);
    }

    // Creating new account by the help of user details----
    public void createAccount() {
        System.out.print("Enter account holder name: ");
        String name = scanner.nextLine();

        System.out.print("Enter initial deposit amount: ");
        double initialDeposit = scanner.nextDouble();
        scanner.nextLine(); 

        System.out.print("Enter email address: ");
        String email = scanner.nextLine();

        System.out.print("Enter phone number: ");
        String phone = scanner.nextLine();

        int accountNumber = 1001 + accountCount;
        accounts[accountCount] = new Account(accountNumber, name, initialDeposit, email, phone);
        accountCount++;

        System.out.println("Account created successfully with Account Number: " + accountNumber);
    }

    // user account number to find the account details to fetch the current balance
    private Account findAccount(int accNumber) {
        for (int i = 0; i < accountCount; i++) {
            if (accounts[i].getAccountNumber() == accNumber) {
                return accounts[i];
            }
        }
        return null;
    }

    // Deposit money by entering account balance and also enter the money you want to deposit----
    public void performDeposit() {
        System.out.print("Enter account number: ");
        int accNum = scanner.nextInt();
        System.out.print("Enter amount to deposit: ");
        double amt = scanner.nextDouble();
        scanner.nextLine();

        Account acc = findAccount(accNum);
        if (acc != null) {
            acc.deposit(amt);
        } else {
            System.out.println("Account not found!");
        }
    }

    // Withdraw money by the help enetering account number and amount details----
    public void performWithdrawal() {
        System.out.print("Enter account number: ");
        int accNum = scanner.nextInt();
        System.out.print("Enter amount to withdraw: ");
        double amt = scanner.nextDouble();
        scanner.nextLine();

        Account acc = findAccount(accNum);
        if (acc != null) {
            acc.withdraw(amt);
        } else {
            System.out.println("Account not found!");
        }
    }

    // Show account details by the user etails-----
    public void showAccountDetails() {
        System.out.print("Enter account number: ");
        int accNum = scanner.nextInt();
        scanner.nextLine();

        Account acc = findAccount(accNum);
        if (acc != null) {
            acc.displayAccountDetails();
        } else {
            System.out.println("Account not found!");
        }
    }

    // to make update or changes in an accoount by the help of entering an account number----
    public void updateContact() {
        System.out.print("Enter account number: ");
        int accNum = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter new email: ");
        String email = scanner.nextLine();
        System.out.print("Enter new phone number: ");
        String phone = scanner.nextLine();

        Account acc = findAccount(accNum);
        if (acc != null) {
            acc.updateContactDetails(email, phone);
        } else {
            System.out.println("Account not found!");
        }
    }

    // all menue is listed here----
    public void mainMenu() {
        while (true) {
            System.out.println("\nWelcome to the Banking Application!");
            System.out.println("1. Create a new account");
            System.out.println("2. Deposit money");
            System.out.println("3. Withdraw money");
            System.out.println("4. View account details");
            System.out.println("5. Update contact details");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1: createAccount(); break;
                case 2: performDeposit(); break;
                case 3: performWithdrawal(); break;
                case 4: showAccountDetails(); break;
                case 5: updateContact(); break;
                case 6: System.out.println("Thank you for using the Banking Application!"); return;
                default: System.out.println("Invalid choice! Try again.");
            }
        }
    }

    public static void main(String[] args) {
        UserInterface ui = new UserInterface();
        ui.mainMenu();
  
