public abstract class GenericUser {
    protected String id;
    protected String userName;
    protected String password;
    protected String legalName;
    protected String email;

    protected String getID() {
        return this.id;
    }

    protected String getUserName() {
        return this.userName;
    }

    protected String getPassword() {
        return this.password;
    }

    protected String getLegalName() {
        return this.legalName;
    }

    protected String getEmail() {
        return this.email;
    }

    protected void setPassword(String password) {
        this.password = password;
    }

    protected void setLegalName(String legalName) {
        this.legalName = legalName;
    }

    protected void setEmail(String email) {
        this.email = email;
    }

}