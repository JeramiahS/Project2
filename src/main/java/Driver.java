import java.util.InputMismatchException;
import java.util.Scanner;

public class Driver {
    private static final Login LOGIN = new Login();
    private static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {
        // Initialize the hospital's database
        HospitalDatabase.initializePatientsArray();
        HospitalDatabase.initializeStaffArray();
        // Prompt user to log in as a patient or staff member
        LOGIN.printLoginPrompt();
        try {
            // Get an integer value as input
            // Flush the scanner
            int userInput = SCANNER.nextInt();
            // Flush the scanner
            SCANNER.nextLine();
            if(userInput == 0) {
                // Start the login process as a patient
                // The getLoginInfo method will prompt the user to enter their username and password
                String[] loginInfo = LOGIN.getLoginInfo();
                // Validate login info
                if(LOGIN.validPatientLogin(loginInfo)) {
                    System.out.println("Login successful.");
                    // Pass the login info so that the user can be initialized inside the PatientManager object
                    PatientManager patientManager = LOGIN.getPatientManagerAsPatient(loginInfo);
                    // Enter a loop so that the user can interact with PatientManager
                    // The printPatientMenuDialogue method will prompt the user to input an integer to
                    // perform an action
                    patientManager.printPatientMenuDialogue();
                    int managerMenuOption = SCANNER.nextInt();
                    // Flush the scanner
                    SCANNER.nextLine();
                    while(managerMenuOption != 9) {
                        // Perform the user's desired action
                        switch (managerMenuOption) {
                            case 0:
                                // Print out the current user's info
                                System.out.println(patientManager.getCurrentUserInfo());
                                break;
                            case 1:
                                // patientManager will update the database with the user's new password
                                System.out.println("Enter your new password");
                                String newPassword = SCANNER.next();
                                // Flush the scanner
                                SCANNER.nextLine();
                                patientManager.changeMyPassword(newPassword);
                                System.out.println("Your new password has been saved successfully.");
                                break;
                            case 2:
                                // patientManager will update the database with the user's legal name
                                System.out.println("Enter your new name");
                                String newName = SCANNER.next();
                                // Flush the scanner
                                SCANNER.nextLine();
                                patientManager.changeMyLegalName(newName);
                                System.out.println("Your new name has been saved successfully.");
                                break;
                            case 3:
                                // patientManager will update the database with the user's new email
                                System.out.println("Enter your new email:");
                                String newEmail = SCANNER.next();
                                // Flush the scanner
                                SCANNER.nextLine();
                                patientManager.changeMyEmail(newEmail);
                                System.out.println("Your new email has been saved successfully.");
                                break;
                            case 4:
                                // patientManager will update the database with the patient's new treatment notes
                                System.out.println("Enter your new treatment notes.");
                                String newTreatmentNotes = SCANNER.nextLine();
                                patientManager.changeMyTreatmentNotes(newTreatmentNotes);
                                System.out.println("Your new treatment notes have been saved successfully.");
                                break;
                        }
                        // After performing the desired action the program repeats the menu dialogue and gets the next
                        // int value input
                        patientManager.printPatientMenuDialogue();
                        managerMenuOption = SCANNER.nextInt();
                        // Flush the scanner
                        SCANNER.nextLine();
                    }
                    // Upon exiting the loop, the program calls FileHandler to save the changes to the patients file
                    // FileHandler will pull the patients array from the database to get the info to write to the file
                    FileHandler.setPatientsFile(HospitalDatabase.getPatientsArray());
                }
            }
            else if(userInput == 1) {
                // Log in as a staff member
                String[] loginInfo = LOGIN.getLoginInfo();
                if(LOGIN.validStaffLogin(loginInfo)) {
                    System.out.println("Login successful");
                    // Pass the login info so the user can be initialized in the PatientManager object
                    PatientManager patientManager = LOGIN.getPatientManagerAsStaffMember(loginInfo);
                    // Enter a loop so the user can interact with PatientManager
                    patientManager.printStaffMemberDialogue();
                    int staffMenuOption = SCANNER.nextInt();
                    // Flush the Scanner
                    SCANNER.nextLine();
                    while(staffMenuOption != 9) {
                        switch(staffMenuOption) {
                            case 0:
                                // Print out the current user's info
                                System.out.println(patientManager.getCurrentUserInfo());
                                break;
                            case 1:
                                // patientManager will update the database with the user's new password
                                System.out.println("Enter your new password");
                                String newPassword = SCANNER.next();
                                // Flush the scanner
                                SCANNER.nextLine();
                                patientManager.changeMyPassword(newPassword);
                                System.out.println("Your new password has been saved successfully.");
                                break;
                            case 2:
                                // patientManager will update the database with the user's legal name
                                System.out.println("Enter your new name");
                                String newName = SCANNER.next();
                                // Flush the scanner
                                SCANNER.nextLine();
                                patientManager.changeMyLegalName(newName);
                                System.out.println("Your new name has been saved successfully.");
                                break;
                            case 3:
                                // patientManager will update the database with the user's new email
                                System.out.println("Enter your new email:");
                                String newEmail = SCANNER.next();
                                // Flush the scanner
                                SCANNER.nextLine();
                                patientManager.changeMyEmail(newEmail);
                                System.out.println("Your new email has been saved successfully.");
                                break;
                            case 4:
                                System.out.println("Enter your new department's name:");
                                String newDepartment = SCANNER.nextLine();
                                patientManager.changeMyDepartment(newDepartment);
                                System.out.println("Your new department has been saved successfully.");
                                break;
                            case 5:
                                System.out.println("Enter the patient's name:");
                                String patientName = SCANNER.nextLine();
                                System.out.println(patientManager.getPatient(patientName));
                                break;
                            case 6:
                                // patientManager will return the list of Patient objects sorted alphabetically
                                Patient[] patientsList = patientManager.getPatientsArrayAlphabetically();
                                for(Patient patient : patientsList) {
                                    // Call the toString method of every Patient object
                                    System.out.println(patient.toString());
                                }
                                break;
                            case 7:
                                // patientManager will return the list of Patient objects sorted by ID value
                                Patient[] patientArray = patientManager.getPatientsByID();
                                for(Patient patient : patientArray) {
                                    System.out.println(patient.toString());
                                }
                                break;
                            case 8:
                                // patientManager will return the list of patient emails sorted alphabetically
                                String[] patientEmails = patientManager.getPatientEmailsArray();
                                for(String email : patientEmails) {
                                    System.out.println(email);
                                }
                                break;
                        }
                        patientManager.printStaffMemberDialogue();
                        staffMenuOption = SCANNER.nextInt();
                        // Flush the Scanner
                        SCANNER.nextLine();
                    }
                    // Upon exiting the loop, the program calls FileHandler to save the changes to the
                    // medicalstaff file
                    // FileHandler will pull the staff array from the database to get the info to write to the file
                    FileHandler.setStaffFile(HospitalDatabase.getStaffArray());
                }
            }
            // Throw IllegalArgumentException if the user enters any integer that is not 0 or 1
            else throw new IllegalArgumentException("Invalid input. Enter either '0' or '1'.");
        }
        catch(InputMismatchException inputMismatchException) {
            System.out.println("Invalid input. Enter either '0' or '1'.");
        }
        catch(IllegalArgumentException argumentException) {
            // Prints out the specific message based on the method throwing this exception
            System.out.println(argumentException.getMessage());
        }
    }

}