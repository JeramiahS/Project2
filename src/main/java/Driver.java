import java.util.InputMismatchException;
import java.util.Scanner;

public class Driver {
    private static final Login LOGIN = new Login();

    public static void main(String[] args) {
        // Initialize the hospital's database
        HospitalDatabase.initializePatientsArray();
        HospitalDatabase.initializeStaffArray();
        // Prompt user to log in as a patient or staff member
        LOGIN.printLoginPrompt();
        try {
            // Get the integer value of the user's input
            int userInput = LOGIN.getUserInput();
            if(userInput == 0) {
                String[] loginInfo = LOGIN.getLoginInfo();
                // Validate login info
                if(LOGIN.validPatientLogin(loginInfo)) {
                    // Pass the login info so that the user can be initialized inside the PatientManager object
                    PatientManager patientManager = LOGIN.getPatientManagerAsPatient(loginInfo);
                    // TODO: The program should enter a loop so the user can interact with PatientManager
                }
            }
            else if(userInput == 1) {
                // Log in as a staff member
                String[] loginInfo = LOGIN.getLoginInfo();
                if(LOGIN.validStaffLogin(loginInfo)) {
                    PatientManager patientManager = LOGIN.getPatientManagerAsStaffMember(loginInfo);
                    // TODO: The program should enter a loop so the user can interact with PatientManager
                }
            }
            // Throw IllegalArgumentException if the user enters any integer that is not 0 or 1
            else throw new IllegalArgumentException("Invalid input. Enter either '0' or '1'.");
        }
        catch(InputMismatchException inputMismatchException) {
            System.out.println("Invalid input. Enter either '0' or '1'.");
            // TODO: Restart the log in prompt if the user enters anything other than an integer value
        }
        catch(IllegalArgumentException argumentException) {
            // Prints out the specific message based on the method throwing this exception
            System.out.println(argumentException.getMessage());
        }
    }

}