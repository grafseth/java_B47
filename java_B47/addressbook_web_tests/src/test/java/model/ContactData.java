package model;

public record ContactData(String firstname, String middlename, String lastname, String nickname, String home) {

    public ContactData() {
        this("", "", "", "", "");
    }

    public ContactData withFirstname(String firstname) {
        return new ContactData(firstname, this.middlename, this.lastname, this.nickname, this.home);
    }
    public ContactData withMiddlename(String middlename) {
        return new ContactData(this.firstname, middlename, this.lastname, this.nickname, this.home);
    }
    public ContactData withLastname(String lastname) {
        return new ContactData(this.firstname, this.middlename, lastname, this.nickname, this.home);
    }
    public ContactData withNickname(String nickname) {
        return new ContactData(this.firstname, this.middlename, this.lastname, nickname, this.home);
    }
    public ContactData withHome(String home) {
        return new ContactData(this.firstname, this.middlename, this.lastname, this.nickname, home);
    }
}
