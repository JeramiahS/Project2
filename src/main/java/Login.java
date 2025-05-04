import java.util.InputMismatchException;
import java.util.Scanner;

public class Login {
    private static final Scanner SCANNER = new Scanner(System.in);

    public void printLoginPrompt() {
        System.out.println("Enter a number to continue:");
        System.out.println("0. Log in as a patient");
        System.out.println("1. Log in as a staff member");
    }

    public int getUserInput() {
       return SCANNER.nextInt();
    }

    public void logInAsPatient() {
        String[] loginInfo = getLoginInfo();
    }

    public void logInAsStaffMember() {
        String[] loginInfo = getLoginInfo();
    }

    private String[] getLoginInfo() {
        System.out.println("Enter your username:");
        String username = SCANNER.next();
        System.out.println("Enter your password:");
        String password = SCANNER.next();
        return new String[] {username, password};
    }
}