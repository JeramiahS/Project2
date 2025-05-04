public class MedicalStaff extends GenericUser {
    private String department;

    public MedicalStaff(String id, String userName, String password, String legalName, String email, String department) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.legalName = legalName;
        this.email = email;
        this.department = department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public String toString() {
        // Returns the staff member's general information
        return this.id + ", " + this.legalName + ", " + this.email + ", " + this.department;
    }

    public String toFile() {
        // Returns the staff member's full information to be written to the file
        return this.id + ", "  + this.userName  + ", " + this.password + ", " + this.legalName + ", " + this.email +
                ", " + this.department;
    }

}