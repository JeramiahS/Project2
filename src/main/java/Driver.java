import java.util.InputMismatchException;
import java.util.Scanner;

public class Driver {
    private static final Login LOGIN = new Login();

    public static void main(String[] args) throws Exception {
        HospitalDatabase.initializePatientsArray();
        HospitalDatabase.initializeStaffArray();
        // Prompt user to log in
        LOGIN.printLoginPrompt();
        // TODO: Write a method in Login that encapsulates the try-block below and returns a PatientManager object
        try {
            if(LOGIN.getUserInput() == 0) {
                // Log in as a patient
                LOGIN.logInAsPatient();
                // Validate login info and initialize the patient manager
                // TODO: Write a method in Login that validates the login
                if(HospitalDatabase.patientLoginIsValid(loginInfo)) {
                    // TODO: Write a method in Login that returns a PatientManager object
                    // TODO: The program should enter a loop so the the user can interact with PatientManager
                }
            }
            else if(LOGIN.getUserInput() == 1) {
                // Log in as a staff member
                LOGIN.logInAsStaffMember();
                if(HospitalDatabase.staffLoginIsValid(loginInfo)) {
                    // If the login is valid, create a new PatientManager object with the user's type and login info
                    // userType == 1 indicates to the PatientManager that the user is a staff member
                    PatientManager patientManager = new PatientManager(1, loginInfo);
                    // TODO: The program should enter a loop so the user can interact with PatientManager
                }
            }
            else {
                throw new Exception("Enter either '0' or '1'.");
                // Restart the log in prompt if the user enters an invalid integer
            }
        }
        catch(InputMismatchException inputMismatchException) {
            // Restart the log in prompt if the user enters anything other than an integer value
        }
    }

}