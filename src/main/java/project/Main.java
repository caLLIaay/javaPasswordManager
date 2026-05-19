package project;


public class Main {
    public static void main(String[] args) {
        Account firstAccount = new Account("google.com", "alex", "IchBinCaLLIaa");
        Account secondAccount = new Account("youtube.com", "boton", "le5adsfdfg5");
        Account thirdAccount = new Account("openai.com", "btwimkafuu", "peiwrgejlgnf");

        AccountService service = new AccountService();
        try {
            service.addAccount(firstAccount);

        } catch (InvalidPasswordException invalidPasswordException) {
            System.out.println("ERROR: " + invalidPasswordException.getMessage());
        }

        try {
            service.addAccount(secondAccount);
        } catch (InvalidPasswordException invalidPasswordException) {
            System.out.println("ERROR: " + invalidPasswordException.getMessage());
        }

        try {
            service.addAccount(thirdAccount);
        } catch (InvalidPasswordException invalidPasswordException) {
            System.out.println("ERROR: " + invalidPasswordException.getMessage());
        }
        service.showAllAccounts();

        try {
           Account accountFoundBySite = service.findBySite("openai.com");
           System.out.println("Account registered on website " + accountFoundBySite.getSiteName() + " was found!");
           System.out.println(accountFoundBySite);
        } catch (AccountNotFoundException accountNotFoundException) {
            System.out.println("ERROR: " + accountNotFoundException.getMessage());
        }


        try {
            service.findBySite("chatgpt.com");
        } catch (AccountNotFoundException accountNotFoundException) {
            System.out.println("ERROR: " + accountNotFoundException.getMessage());
        }
    }

}