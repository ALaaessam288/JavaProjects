
    // InputHandler.java
package emailApp;

import java.util.Scanner;

    public class InputHandler {
        private final Scanner scanner;

        public InputHandler() {
            this.scanner = new Scanner(System.in);
        }

        public Email createEmail() {
            System.out.println("Please Enter First Name");
            String fName = scanner.next();
            System.out.println("Please Enter Last Name");
            String lName = scanner.next();
            return new Email(fName, lName);
        }

        public int getChoice() {
            System.out.println("Enter your choice:");
            return scanner.nextInt();
        }
    }


