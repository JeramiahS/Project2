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

    public String getDepartment() {
        return this.department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public String toString() {
        // TODO: Finish this method. Do not include the username and password in this method
        return null;
    }

    public String toFile() {
        // TODO: Finish this method. Include the username and password in this method
        return null;
    }

}