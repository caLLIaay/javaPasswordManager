package project;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class AccountFileReader {
    private String pathToFile;

    AccountFileReader() {
        this.pathToFile = null;
    }
    AccountFileReader(String pathToFile) {
        this.pathToFile = pathToFile;
    }

    public void setPathToFile(String pathToFile) {
        this.pathToFile = pathToFile;
    }

    public String getPathToFile() {
        return pathToFile;
    }

    public ArrayList<Account> readAccountsFromFile() throws IOException {
        ArrayList<Account> accountsList = new ArrayList<>();
        AccountLineValidator accountLineValidator = new AccountLineValidator();

        try (BufferedReader fileReader = new BufferedReader(new FileReader(getPathToFile()))) {
            String line;
            while ((line = fileReader.readLine()) != null) {
                if (accountLineValidator.lineValidator(line)) {
                    String[] lineData = line.split(";", -1);
                    Account tempAccount = new Account(
                            lineData[0],
                            lineData[1],
                            lineData[2]
                    );
                    accountsList.add(tempAccount);
                    continue;
                }
                System.out.println("ERROR: line with data \"" + line + "\" was skipped.");
            }
        }// closing FileReader

        return accountsList;
    }


}
