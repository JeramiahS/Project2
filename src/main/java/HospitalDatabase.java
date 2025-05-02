import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class HospitalDatabase {
    private static Patient[] patients;
    private static MedicalStaff[] staff;

    private HospitalDatabase() throws Exception {
        throw new Exception("This class is not to be instantiated.");
    }

    public static void initializePatientsArray() {
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
    }

    public static void initializeStaffArray() {
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

    public static boolean patientLoginIsValid(String[] loginInfo) throws Exception {
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

    public static boolean staffLoginIsValid(String[] loginInfo) throws Exception {
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

    public static Patient[] getPatientsList() {
        return patients;
    }

    public Patient getPatientInfo(String legalName) throws Exception {
        for(Patient patient : patients) {
            if(legalName.equals(patient.getID())) {
                return patient;
            }
        }
        throw new Exception("Patient not found.");
    }

    public static Patient getCurrentPatient(String[] loginInfo) throws Exception {
        for(Patient patient : patients) {
            if(patient.getPassword().equals(loginInfo[0]) && patient.getID().equals(loginInfo[1])) {
                return patient;
            }
        }
        throw new Exception("Patient not found.");
    }

    public static MedicalStaff getCurrentStaffMember(String[] loginInfo) throws Exception {
        for(MedicalStaff staffMember : staff) {
            if(staffMember.getPassword().equals(loginInfo[0]) && staffMember.getID().equals(loginInfo[1])) {
                return staffMember;
            }
        }
        throw new Exception("Patient not found.");
    }

    public static void setPatientPassword(String legalName, String newPassword) {
        // Look through the patients array for a matching name
        for(Patient patient : patients) {
            // Verify the patient's name
            if(legalName.equalsIgnoreCase(patient.getLegalName())) {
                // Change the patient's password to the new password
                patient.setPassword(newPassword);
            }
        }
    }

    public static void setPatientLegalName(String legalName, String newLegalName) {
        for(Patient patient : patients) {
            if(legalName.equalsIgnoreCase(patient.getLegalName())) {
                patient.setLegalName(newLegalName);
            }
        }
    }

    public static void setPatientEmail(String legalName, String newEmail) {
        for(Patient patient : patients) {
            if(legalName.equals(patient.getLegalName())) {
                patient.setEmail(newEmail);
            }
        }
    }

    public static void setPatientTreatmentNotes(String legalName, String newTreatmentNotes) {
        for(Patient patient : patients) {
            if(legalName.equals(patient.getLegalName())) {
                patient.setTreatmentNotes(newTreatmentNotes);
            }
        }
    }

    public static void setStaffMemberPassword(String legalName, String newPassword) {
        for(MedicalStaff staffMember : staff) {
            if(legalName.equalsIgnoreCase(staffMember.getLegalName())) {
                staffMember.setPassword(newPassword);
            }
        }
    }

    public static void setStaffMemberLegalName(String legalName, String newLegalName) {
        for(MedicalStaff staffMember : staff) {
            if(legalName.equalsIgnoreCase(staffMember.getLegalName())) {
                staffMember.setLegalName(newLegalName);
            }
        }
    }

    public static void setStaffMemberEmail(String legalName, String newEmail) {
        for(MedicalStaff staffMember : staff) {
            if(legalName.equalsIgnoreCase(staffMember.getLegalName())) {
                staffMember.setEmail(newEmail);
            }
        }
    }

    public static void setStaffMemberDepartment(String legalName, String newDepartment) {
        for(MedicalStaff staffMember : staff) {
            if(legalName.equalsIgnoreCase(staffMember.getLegalName())) {
                staffMember.setDepartment(newDepartment);
            }
        }
    }

}