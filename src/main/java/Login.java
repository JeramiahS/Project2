import java.io.File;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Login {
    private static final File PATIENTS_FILE = new File("src/main/resources/patient.csv");
    private static final File STAFF_FILE = new File("src/main/resources/medicalstaff.csv");
    private static final ClinicDatabase DATABASE = new ClinicDatabase(PATIENTS_FILE, STAFF_FILE);

    public void displayLoginPrompt() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a number to log in:");
        System.out.println("0. Log in as a patient");
        System.out.println("1. Log in as a staff member");
        int input = scanner.nextInt();
        // Validate user input
        try {
            if(input == 0) {
                String[] loginInfo = getLoginInfo();
                // Validate login info by querying the clinic's database
                if(DATABASE.isPatientLoginValid(loginInfo)) {
                    System.out.println("Login successful.");
                }
            }
            else if(input == 1) {
                String[] loginInfo = getLoginInfo();
                if(DATABASE.isStaffLoginValid(loginInfo)) {
                    System.out.println("Staff member login successful.");
                    // TODO: Apply staff privileges mechanics
                    System.out.println("Patient manager privileges applied.");
                    // TODO: Apply login mechanics
                }
            }
            else {
                // Redo prompt if entry > 1 or entry < 0
                System.out.println("Invalid entry.");
                displayLoginPrompt();
            }
        }
        catch(InputMismatchException mismatchException) {
            // Redo the prompt if input is anything other than an integer
            System.out.println("Invalid input. Enter either '0' or '1'.");
            displayLoginPrompt();
        }
        catch (Exception e) {
            // Redo the login entry if username and/or password is invalid
            System.out.println(e.getMessage());
            getLoginInfo();
        }
    }

    // Helper method prompts the user to enter their info and returns a String array containing said info
    private static String[] getLoginInfo() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your username:");
        String username = scanner.next();
        System.out.println("Enter your password:");
        String password = scanner.next();
        return new String[]{username, password};
    }

}