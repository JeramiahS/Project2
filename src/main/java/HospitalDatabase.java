import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class HospitalDatabase {
    private static Patient[] patients;
    private static MedicalStaff[] staff;

    public HospitalDatabase() {
        // Take in the patients file and convert to an ArrayList containing all patient info
        try(BufferedReader br = new BufferedReader(new FileReader(FileHandler.getPatientsFile()))) {
            // Create an ArrayList of Strings to contain patient info
            ArrayList<String> patientsList = new ArrayList<>();
            // Read the first line in the file
            String line = br.readLine();
            // While-loop to read the whole file
            while(line != null) {
                // Add the line of patient's info to the ArrayList
                patientsList.add(line);
                // Read the next line of text
                line = br.readLine();
            }
            // Convert the ArrayList into a String array so that it can be passed to ObjectFactory
            String[] patientsInfo = patientsList.toArray(new String[0]);
            // ObjectFactory converts the String array of patient info into an array containing Patient objects
            patients = ObjectFactory.getPatientsArray(patientsInfo);
        }
        catch(IOException ioException) {
            System.out.println("Patients file not found. Check file path and/or file name spelling.");
        }
        try(BufferedReader br = new BufferedReader(new FileReader(FileHandler.getStaffFile()))) {
            ArrayList<String> staffList = new ArrayList<>();
            String line = br.readLine();
            while(line != null) {
                staffList.add(line);
                line = br.readLine();
            }
            String[] staffInfo = staffList.toArray(new String[0]);
            staff = ObjectFactory.getStaffArray(staffInfo);
        }
        catch(IOException ioException) {
            System.out.println("Medical staff file not found. Check file path and/or file name spelling.");
        }
    }

    public boolean patientLoginIsValid(String[] loginInfo) throws Exception {
        // Loop to check each patient in the database
        for (Patient patient : patients) {
            // Check each patient for a matching username and password
            if (loginInfo[0].equals(patient.getUserName()) && loginInfo[1].equals(patient.getPassword())) {
                // Upon finding a match, the method will return true indicating a successful login attempt
                return true;
            }
        }
        // Otherwise, if a match is not found, the method will throw an exception to indicate a failed login attempt
        throw new Exception("Invalid username and/or password");
    }

    public boolean staffLoginIsValid(String[] loginInfo) throws Exception {
        // Loop to check each staff member in the database
        for (MedicalStaff medicalStaff : staff) {
            // Check each staff member for a matching username and password
            if (loginInfo[0].equals(medicalStaff.getUserName()) && loginInfo[1].equals(medicalStaff.getPassword())) {
                // Upon finding a match, the method will return true indicating a successful login attempt
                return true;
            }
        }
        // Otherwise, if a match is not found, the method will return false
        throw new Exception("Invalid username and/or password.");
    }

    public void getPatientsListByID() {
        sortPatientsByID();
        for(Patient patient : patients) {
            System.out.println(patient);
        }
    }

    // Helper method to sort the patients array by ID value
    private void sortPatientsByID() {
        Patient temp;
        // Sort patients list by ID value using a bubble sort algorithm
        for(int i = 0; i < patients.length - 1; i++) {
            for(int j = 0; j < patients.length - 1; j++) {
                // Compare the ID values of the two patients at index j and j + 1
                if(patients[j].getID().compareToIgnoreCase(patients[j + 1].getID()) > 0) {
                    temp = patients[j];
                    patients[j] = patients[j + 1];
                    patients[j + 1] = temp;
                }
            }
        }
    }

    public void getPatientsListByName() {
        sortPatientsAlphabetically();
        for(Patient patient : patients) {
            System.out.println(patient);
        }
    }

    // Helper method to sort the patients array alphabetically
    private void sortPatientsAlphabetically() {
        Patient temp;
        // Sort patients list alphabetically by using a bubble sort algorithm
        for(int i = 0; i < patients.length - 1; i++) {
            for(int j = 0; j < patients.length - i - 1; j++) {
                // Compare the names of the two patients at index j and index j + 1
                if(patients[j].getLegalName().compareToIgnoreCase(patients[j + 1].getLegalName()) > 0) {
                    // Swap the patients in the array
                    temp = patients[j];
                    patients[j] = patients[j + 1];
                    patients[j + 1] = temp;
                }
            }
        }
    }

    public Patient getPatientInfo(String idNumber) throws Exception {
        for(Patient patient : patients) {
            if(idNumber.equals(patient.getID())) {
                return patient;
            }
        }
        throw new Exception("Patient not found.");
    }

    public MedicalStaff getStaffInfo(String idNumber) throws Exception {
        for(MedicalStaff staffMember : staff) {
            if(idNumber.equals(staffMember.getID())) {
                return staffMember;
            }
        }
        throw new Exception("Staff member not found.");
    }

    public String getPatientID(String email, String password) throws Exception {
        for(Patient patient : patients) {
            if(patient.getPassword().equals(email) && patient.getID().equals(password)) {
                return patient.getID();
            }
        }
        throw new Exception("Patient not found.");
    }

    public void printPatientEmails() {
        sortPatientsAlphabetically();
        for(Patient patient : patients) {
            System.out.println(patient.getEmail());
        }
    }

    public void editPatientInfo(String idNumber, int indexValue, String changeValue) {
        // Search the database for the appropriate patient
        for(Patient patient : patients) {
            // Find the right patient based on ID
            if(idNumber.equals(patient.getID())) {
                // TODO: Finish this if-statement
            }
        }
        // FIXME: Finish this switch statement
        switch(indexValue) {
            case 0:
                break;
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
        }
    }

    public void editStaffInfo() {

    }

}