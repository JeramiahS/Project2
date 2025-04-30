import java.io.BufferedReader;
import java.io.File;
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

    public Patient[] getPatientsListByID() {
        // TODO: Finish this method
        return null;
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

    public void editPatientInfo(String idNumber, int indexValue, String changeValue) {
        for(Patient patient : patients) {
            if(idNumber.equals(patient.getID())) {
                // TODO: Finish this if-statement
            }
        }
        // TODO: Finish this switch statement
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

}