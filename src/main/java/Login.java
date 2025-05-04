import java.util.InputMismatchException;
import java.util.Scanner;

public class Login {
    private static final Scanner SCANNER = new Scanner(System.in);

    public void printLoginPrompt() {
        System.out.println("Enter a number to continue:");
        System.out.println("0. Log in as a patient");
        System.out.println("1. Log in as a staff member");
    }

    public int getUserInput() throws IllegalArgumentException {
       return SCANNER.nextInt();
    }

    public String[] getLoginInfo() {
        System.out.println("Enter your username:");
        String username = SCANNER.next();
        System.out.println("Enter your password:");
        String password = SCANNER.next();
        return new String[] {username, password};
    }

    public boolean validPatientLogin(String[] loginInfo) throws IllegalArgumentException {
        if(!HospitalDatabase.patientLoginIsValid(loginInfo)) {
            throw new IllegalArgumentException("Invalid username and/or password");
        }
        else {
            return true;
        }
    }

    public boolean validStaffLogin(String[] loginInfo) throws IllegalArgumentException {
        if(!HospitalDatabase.staffLoginIsValid(loginInfo)) {
            throw new IllegalArgumentException("Invalid username and/or password.");
        }
        else {
            return true;
        }
    }

    public PatientManager getPatientManagerAsPatient(String[] loginInfo) {
        return new PatientManager(0, loginInfo);
    }

    public PatientManager getPatientManagerAsStaffMember(String[] loginInfo) {
        return new PatientManager(1, loginInfo);
    }

}