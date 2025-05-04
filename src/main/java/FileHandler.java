import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileHandler {
    private static final File PATIENTS_FILE = new File("src/main/resources/patient.csv");
    private static final File STAFF_FILE = new File("src/main/resources/medicalstaff.csv");

    private FileHandler() throws Exception {
        throw new Exception("This class is not to be instantiated.");
    }
    public static File getPatientsFile() {
        // Returns the file containing the patients' info to the method caller
        return PATIENTS_FILE;
    }

    public static File getStaffFile() {
        // Returns the file containing the staff members' info to the method caller
        return STAFF_FILE;
    }

    public static void setPatientsFile(Patient[] patientsArray) {
        // Attempt to write to the file containing the patients' information
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(PATIENTS_FILE))) {
            // For-loop to iterate through the entire array of Patient objects
           for(Patient patient : patientsArray) {
               // Calls the current Patient object's toFile method and writes that string to the file w/ a new line
               bw.write(patient.toFile() + "\n");
           }
        }
        catch(IOException ioException) {
            System.out.println("Invalid file path and/or file name.");
        }
    }

    public static void setStaffFile(MedicalStaff[] staffArray) {
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(STAFF_FILE))) {
            for(MedicalStaff staffMember : staffArray) {
                bw.write(staffMember.toFile());
            }
        }
        catch(IOException ioException) {
            System.out.println("Invalid file path and/or file name.");
        }
    }

}