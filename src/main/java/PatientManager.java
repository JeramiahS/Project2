public class PatientManager {
    private GenericUser USER;

    public PatientManager(int userType, String[] loginInfo) {
        // userType value serves as a flag to tell PatientManager if the user is a patient or staff member
        if(userType == 0) {
            try {
                USER = HospitalDatabase.getCurrentPatient(loginInfo);
            }
            catch (Exception e){
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

    public void getCurrentUserInfo() {
        // Calls the current user's toString method
        System.out.println(USER);
    }

    public void getPatientsByID() throws Exception{
        // Checks if the current user is a patient before trying to get the list of other patients
        if(USER instanceof Patient) {
            throw new Exception("You must be a staff member to perform this task.");
        }
        else {
            // Retrieve a copy of the patients array from the database
            Patient[] patientsList = HospitalDatabase.getPatientsList();
            // TODO: Finish this method
        }
    }

    public void getPatientsAlphabetically() throws Exception {
        if(USER instanceof Patient) {
            throw new Exception("You must be a staff member to perform this task.");
        }
        else {
            Patient[] patientsList = HospitalDatabase.getPatientsList();
            // TODO: Finish this method
        }
    }

}