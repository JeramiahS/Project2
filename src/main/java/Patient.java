public class Patient extends GenericUser {
    private String treatmentNotes;

    public Patient(String id, String userName, String password,
                   String legalName, String email, String treatmentNotes) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.legalName = legalName;
        this.email = email;
        this.treatmentNotes = treatmentNotes;
    }

    public String getTreatmentNotes() {
        return this.treatmentNotes;
    }

    public void setTreatmentNotes(String treatmentNotes) {
        this.treatmentNotes = treatmentNotes;
    }

    @Override
    public String toString() {
        return null;
    }

}