public class ObjectFactory {

    // getPatientsArray method takes a String array of patient info and returns an array of Patient objects
    public static Patient[] getPatientsArray(String[] patientInfo) {
        // Create an array of Patient objects based on the length of the array from the parameter
        Patient[] patients = new Patient[patientInfo.length];
        // For-loop to read each String of patient info
        for(int i = 0; i < patientInfo.length; i++) {
            // For each String in the patientInfo array, split the string based on the regex
            // to get the patient's attributes
            String[] attributes = patientInfo[i].split(",");
            // Create and store the new Patient object based on the attributes
            patients[i] = new Patient(attributes[0], attributes[1], attributes[2], attributes[3], attributes[4], attributes[5]);
        }
        return patients;
    }

    public static MedicalStaff[] getStaffArray(String[] staffInfo) {
        MedicalStaff[] staff = new MedicalStaff[staffInfo.length];
        for(int i = 0; i < staffInfo.length; i++) {
            String[] attributes = staffInfo[i].split(",");
            staff[i] = new MedicalStaff(attributes[0], attributes[1], attributes[2], attributes[3], attributes[4], attributes[5]);
        }
        return staff;
    }

}