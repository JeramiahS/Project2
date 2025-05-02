public class Driver {
    private static final Login LOGIN = new Login();

    public static void main(String[] args) {
        HospitalDatabase.initializePatientsArray();
        HospitalDatabase.initializeStaffArray();
        LOGIN.displayLoginPrompt();
    }

}