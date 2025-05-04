public class Patient extends GenericUser {
    private String treatmentNotes;

    public Patient(String id, String userName, String password, String legalName, String email, String treatmentNotes) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.legalName = legalName;
        this.email = email;
        this.treatmentNotes = treatmentNotes;
    }

    public void setTreatmentNotes(String treatmentNotes) {
        this.treatmentNotes = treatmentNotes;
    }

    @Override
    public String toString() {
        // Returns the patient's general information
        return this.id + ", " + this.legalName + ", " + this.email + ", " + this.treatmentNotes;
    }

    public String toFile() {
        // Returns the patient's full information to written to the file
        return this.id + ", "  + this.userName  + ", " + this.password + ", " + this.legalName + ", " + this.email +
                ", " + this.treatmentNotes;
    }

}