package emailApp;
import emailApp.Email;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class Email {
    Scanner scanner = new Scanner(System.in);
    private String fName;
    private String lName;
    private String email;
    private String dept;
    private String password;
    private String alterMail;
    private int mailCapacity = 500;

    public Email() {
    }

    public Email(String fName, String lName) {
        this.fName = fName;
        this.lName = lName;
        System.out.println("New Employee : " + this.fName + " " + this.lName);
        this.dept = this.setDept();
        this.password = this.generatePassword(8);
        this.email = this.generateMail();

    }
    private String generateMail() {
        return this.fName.toLowerCase() + "0" + this.lName.toLowerCase() + "@" + this.dept.toLowerCase();
    }

    private String setDept() {
        System.out.println("Departments code \n1 for Sales \n2 for Accounting \n3 for Development");
        boolean flag = false;
        do {
            System.out.println("Enter your choise");
            int node = scanner.nextInt();
            switch (node) {
                case 1:
                    return "Sales";
                case 2:
                    return "Accounting";
                case 3:
                    return "Development";
                case 0:
                    return "none";
                default:
                    System.out.println("invalid choice");
            }
        }
        while (!flag);
        return null;
    }

    private String generatePassword(int lenght) {
        Random r = new Random();
        String capitalChars = "ASDFGHJKLMNBVCXZQWERTYUIOP";
        String smallChars = capitalChars.toLowerCase();
        String numbers = "0123455789";
        String symbols = "@#$%^&*";
        /*List<String> password = new ArrayList<String>();
        password.add(capitalChars);
        password.add(smallChars);
        password.add(numbers) ;
        password.add(symbols);*/
        String values = capitalChars + smallChars + numbers + symbols;
        String passwords = "";
        for (int i = 0; i <= lenght; i++) {
            passwords = passwords + values.charAt(r.nextInt(values.length()));
        }
        return passwords;

    }

    public void changePassword() {
        boolean flag = false;
        do {
            System.out.println("if you want chang password enter (Y) otherwise enter (N) ");
            char choise = scanner.next().charAt(0);

            if (choise == 'Y' || choise == 'y') {
                flag = true;
                System.out.println("Please Enter Current Password");
                String temp = scanner.next();
                if (temp.equals(this.password)) {
                    System.out.println("Enter New Password ");
                    this.password = scanner.next();
                    System.out.println("Password Changes Successfully");
                } else {
                    System.out.println("Incorrect password ");
                }
            } else if (choise == 'N' || choise == 'n') {
                flag = true;
                System.out.println("Password Changing Option Cancelled");
            } else {
                System.out.println("Enter A valid Choise");
            }
        }
        while (!flag);

    }

    public void setCapacity() {
        System.out.println("current capacity is : " + this.mailCapacity + "mb");
        System.out.println("enter new capacity");
        this.mailCapacity = scanner.nextInt();
        System.out.println("mail capacity is set");
    }

    public void setAlterMail() {
        System.out.println("enter alternate Email");
        this.alterMail = scanner.next();
        System.out.println("alternate Email is set");
    }

    public void displayInfo() throws InterruptedException {
        System.out.println("Welcome " + this.fName + " " + this.lName);
        System.out.println("Department " + this.dept);
        System.out.println("email " + this.email);
        System.out.println("password " + this.password);
        System.out.println("alternate mail " + this.alterMail);
        System.out.println("Mail Capacity " + this.mailCapacity + "mb");
        System.out.println("**********************************************");
        Thread.sleep(1200);

    }
    public void storeFile() {
        try {
            FileWriter in = new FileWriter("D:\\EmailApp\\info.txt");
            in.write(" First Name:" + this.fName);
            in.append(" \nLast Name:").append(this.lName);

            in.append(" \nEmail:").append(this.email);
            in.append(" \nDepartment:").append(this.dept);
            in.append(" \nEmail-Capacity:").append(String.valueOf(this.mailCapacity));
            in.append(" \nAlternative-Email:").append(this.alterMail);
            in.close();
            System.out.println("Data stored ....");
            Thread.sleep(1200);


        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public void readFile() throws IOException {
        FileReader f1 = new FileReader("D:\\EmailApp\\info.txt");
        int i;
        while ((i = f1.read()) != -1) {
            System.out.print((char) i);

        }
        f1.close();
    }
}