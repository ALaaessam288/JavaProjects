package emailApp;

import java.io.IOException;


public class EmailApp {
    public static void main(String[] args) throws IOException, InterruptedException {
        InputHandler inputHandler = new InputHandler();
        Email email = inputHandler.createEmail();
        int choise = -1;
        do {
            System.out.println("""
                    ********************\s
                     1 display info\s
                     2 change password\s
                     3 change mail capacity\s
                     4 set Alter mail\s
                     5 store to file
                     6 read from file
                     7 Exit""");
            choise = inputHandler.getChoice();
            switch (choise) {
                case 1 -> email.displayInfo();
                case 2 -> email.changePassword();
                case 3 -> email.setCapacity();
                case 4 -> email.setAlterMail();
                case 5 -> email.storeFile();
                case 6 -> email.readFile();
                case 7 -> System.out.println("Thanks for using the app");
                default -> System.out.println("Invalid choice! Please re-enter a proper choice");
            }
        }
        while (choise != 7);
    }
}
