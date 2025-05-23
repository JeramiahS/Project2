import java.util.ArrayList;

public class PatientManager {
    private GenericUser USER;

    public PatientManager(int userType, String[] loginInfo) {
        // userType value serves as a flag to tell PatientManager if the user is a patient or staff member
        if(userType == 0) {
            try {
                // Grab the correct patient based on the login info
                USER = HospitalDatabase.getCurrentPatient(loginInfo);
            }
            catch (Exception e){
                // Catch Exception if patient happens to not be in the database
                System.out.println(e.getMessage());
            }
        }
        else {
            try {
                USER = HospitalDatabase.getCurrentStaffMember(loginInfo);
            }
            catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
    }

    public void printPatientMenuDialogue() {
        System.out.println("Enter a number to continue.");
        System.out.println("0. Get my info");
        System.out.println("1. Change my password");
        System.out.println("2. Change my name");
        System.out.println("3. Change my email");
        System.out.println("4. Edit my notes");
        System.out.println("9. Exit the program");
    }

    public void printStaffMemberDialogue() {
        System.out.println("Enter a number to continue.");
        System.out.println("0. Get my info");
        System.out.println("1. Change my password");
        System.out.println("2. Change my name");
        System.out.println("3. Change my email");
        System.out.println("4. Change my department");
        System.out.println("5. Look up a patient");
        System.out.println("6. Get list of patients alphabetically");
        System.out.println("7. Get list of patients by ID value");
        System.out.println("8. Get list of patient emails");
        System.out.println("9. Exit the program");
    }

    public String getCurrentUserInfo() {
        // Calls the current user's toString method
        return USER.toString();
    }

    public Patient[] getPatientsByID() throws IllegalArgumentException {
        // Checks if the current user is a patient before trying to get the list of other patients
        if(USER instanceof Patient) {
            throw new IllegalArgumentException("You must be a staff member to perform this task.");
        }
        else {
            // Retrieve a copy of the patients array from the database
            Patient[] patientsList = HospitalDatabase.getPatientsArray();
            // Sort the array by ID number using a bubble sort algorithm
            for(int i = 0; i < patientsList.length - 1; i++) {
                for(int j = 0; j < patientsList.length - i - 1; j++) {
                    // Compare the ID number of the two patients at indexes j and j + 1
                    if(patientsList[j].getID().compareTo(patientsList[j + 1].getID()) > 0) {
                        // Temporary variable to hold the patient that is to be swapped
                        Patient temp = patientsList[j];
                        // Replace the patient at index [j] with the patient at index [j + 1]
                        patientsList[j] = patientsList[j + 1];
                        // Place the patient in the temporary variable back into the array at index [j + 1]
                        patientsList[j + 1] = temp;
                    }
                }
            }
            // Return the patientsList array to the method caller
            return patientsList;
        }
    }

    public Patient[] getPatientsArrayAlphabetically() throws IllegalArgumentException {
        if(USER instanceof Patient) {
            throw new IllegalArgumentException("You must be a staff member to perform this task.");
        }
        else {
            Patient[] patientsList = HospitalDatabase.getPatientsArray();
            // Sort the array alphabetically by first name using a bubble sort algorithm
            for(int i = 0; i < patientsList.length - 1; i++) {
                for(int j = 0; j < patientsList.length - i - 1; j++) {
                    // Compare the names of the two patients at indexes j and j + 1
                    if(patientsList[j].getLegalName().compareTo(patientsList[j + 1].getLegalName()) > 0) {
                        // Temporary variable to hold the patient that is to be swapped
                        Patient temp = patientsList[j];
                        // Replace the patient at index [j] with the patient at index [j + 1]
                        patientsList[j] = patientsList[j + 1];
                        // Place the patient in the temporary variable back into the array at index [j + 1]
                        patientsList[j + 1] = temp;
                    }
                }
            }
            // Return the patientsList array to the method caller
            return patientsList;
        }
    }

    public String[] getPatientEmailsArray() throws IllegalArgumentException {
        if(USER instanceof Patient) {
            throw new IllegalArgumentException("You must be a staff member to perform this task.");
        }
        else {
            // Get the patients array fom the database and sort it alphabetically using getPatientsArrayAlphabetically()
            Patient[] patientsList = getPatientsArrayAlphabetically();
            // Create an arrayList to store the patient emails
            ArrayList<String> patientEmails = new ArrayList<>();
            // For-loop to read the patientsList array
            for(Patient patient : patientsList) {
                // Add the patient's email to the ArrayList
                patientEmails.add(patient.getEmail());
            }
            // Convert the arrayList into a String array and return it to the method caller
            return patientEmails.toArray(new String[0]);
        }
    }

    public void changeMyPassword(String newPassword) {
        if(USER instanceof Patient) {
            HospitalDatabase.setCurrentPatientPassword((Patient) USER, newPassword);
        }
        else {
            HospitalDatabase.setCurrentStaffMemberPassword((MedicalStaff) USER, newPassword);
        }
    }

    public void changeMyLegalName(String newLegalName) {
        if(USER instanceof Patient) {
            HospitalDatabase.setCurrentPatientLegalName((Patient) USER, newLegalName);
        }
        else {
            HospitalDatabase.setCurrentStaffMemberLegalName((MedicalStaff) USER, newLegalName);
        }
    }

    public void changeMyEmail(String newEmail) {
        if(USER instanceof Patient) {
            HospitalDatabase.setCurrentPatientEmail((Patient) USER, newEmail);
        }
        else {
            HospitalDatabase.setCurrentStaffMemberEmail((MedicalStaff) USER, newEmail);
        }
    }


    public void changeMyTreatmentNotes(String newTreatmentNotes) throws IllegalArgumentException {
        if(USER instanceof MedicalStaff) {
            throw new IllegalArgumentException("You must be a patient to edit your treatment notes.");
        }
        else {
            HospitalDatabase.setCurrentPatientTreatmentNotes((Patient) USER, newTreatmentNotes);
        }
    }

    public void changeMyDepartment(String newDepartment) throws IllegalArgumentException{
        if(USER instanceof Patient) {
            throw new IllegalArgumentException("You must be a staff member to change your department.");
        }
        else {
            HospitalDatabase.setCurrentStaffMemberDepartment((MedicalStaff) USER, newDepartment);
        }
    }

    public String getPatient(String patientName) throws IllegalArgumentException {
        if(USER instanceof Patient) {
            throw new IllegalArgumentException("You must be a staff member to look up a patient.");
        }
        else {
            return HospitalDatabase.getPatient(patientName).toString();
        }
    }

}