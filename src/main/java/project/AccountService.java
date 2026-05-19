package project;

import java.io.Writer;
import java.util.ArrayList;
import java.io.FileWriter;
import java.io.IOException;

public class AccountService {

    private final ArrayList<Account> accountsList = new ArrayList<>();

    public void addAccount(Account account) {

        String accountPassword = account.getUserPassword();

        if (accountPassword.length() < 8) {

            throw new InvalidPasswordException(
                    "Account registered on the website: " +
                            account.getSiteName() +
                            " with username: " +
                            account.getUsername() +
                            "\nIncorrect password. The password must be at least 8 characters long.\n"
            );
        }

        accountsList.add(account);
    }

    public Account findBySite(String site)
            throws AccountNotFoundException {

        for (Account account : accountsList) {

            if (account.getSiteName().equals(site)) {
                return account;
            }
        }

        throw new AccountNotFoundException(
                "The account registered on the website " +
                        site +
                        " was not found.\n"
        );
    }

    public void showAllAccounts() {

        int accountNumber = 1;

        for (Account account : accountsList) {

            System.out.println("Account №" + accountNumber);
            System.out.println(account);

            accountNumber++;
        }
    }

    public void saveAccountsToFile(String filePath)
            throws IOException {

        try (Writer writer = new FileWriter(filePath)) {

            System.out.println(
                    "Saving accounts from account list to txt file..."
            );

            for (Account account : accountsList) {

                writer.write(
                        account.getSiteName() + ";" +
                                account.getUsername() + ";" +
                                account.getUserPassword() + "\n"
                );
            }
        }

        System.out.println(
                "Accounts were successfully saved to: " + filePath
        );
    }
}