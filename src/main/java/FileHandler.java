import java.io.File;

public class FileHandler {
    private static final File PATIENTS_FILE = new File("src/main/resources/patient.csv");
    private static final File STAFF_FILE = new File("src/main/resources/medicalstaff.csv");

    private FileHandler() throws Exception {
        throw new Exception("This class is not to be instantiated.");
    }
    public static File getPatientsFile() {
        return PATIENTS_FILE;
    }

    public static File getStaffFile() {
        return STAFF_FILE;
    }

}