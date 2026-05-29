package project;


import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        final String pathToFile = "data.txt";
        final String pathToLogFile = "log.txt";
        AccountFileReader reader = new AccountFileReader(pathToFile);
        AccountService service = new AccountService();

        System.out.println("=============================\n");
        try {
            ArrayList<Account> tempAccountList = reader.readAccountsFromFile();
            service.addAccount(tempAccountList);
        } catch (IOException ioException) {
            String logMessage = "ERROR: " + ioException.getMessage();
            service.logWriter(pathToLogFile, logMessage);
        }

        service.showAllAccounts();
    }
}