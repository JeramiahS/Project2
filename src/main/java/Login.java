import java.util.InputMismatchException;
import java.util.Scanner;

public class Login {

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
                // Validate login info by querying the hospital's database
                if(HospitalDatabase.patientLoginIsValid(loginInfo)) {
                    System.out.println("Login successful.");
                    // If the login is valid, the patient should interact with PatientManager to view/edit their info

                }
            }
            else if(input == 1) {
                String[] loginInfo = getLoginInfo();
                if(HospitalDatabase.staffLoginIsValid(loginInfo)) {
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