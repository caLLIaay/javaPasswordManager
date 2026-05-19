package project;

import java.util.ArrayList;

public class AccountService {
    private final ArrayList<Account> accountsList = new ArrayList<>();

    public void addAccount(Account account) {
        String accountPassword = account.getUserPassword();
        if (accountPassword.length() < 8) {
            throw new InvalidPasswordException("Account registered on the website: " + account.getSiteName() +
                    "with username: " + account.getUsername() + "\n" +
                    "Incorrect password. The password must be at least 8 characters long.\n");
        }
        accountsList.add(account);
    }

    public Account findBySite(String site) throws AccountNotFoundException {
        for(Account account : accountsList) {
            if(account.getSiteName().equals(site)) {
                return account;
            }
        }

        throw new AccountNotFoundException("The account registered on the website " + site + " was not found.\n");
    }

    public void showAllAccounts() {
        Account account;
        int accountNumber = 1;
        for (Account value : accountsList) {
            account = value;
            System.out.println("Account №" + accountNumber);
            System.out.println(account.toString());
            accountNumber++;
        }
    }

}
