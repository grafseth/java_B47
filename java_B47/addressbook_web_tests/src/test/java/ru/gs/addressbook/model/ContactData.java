package ru.gs.addressbook.model;

public record ContactData(String id, String firstname, String middlename, String lastname, String nickname,
                          String home, String photo, String address) {

    public ContactData() {
        this("", "", "", "", "", "","", "");
    }

    public ContactData withFirstname(String firstname) {
        return new ContactData(this.id, firstname, this.middlename, this.lastname, this.nickname, this.home, this.photo, this.address);
    }

    public ContactData withMiddlename(String middlename) {
        return new ContactData(this.id, this.firstname, middlename, this.lastname, this.nickname, this.home, this.photo, this.address);
    }

    public ContactData withLastname(String lastname) {
        return new ContactData(this.id, this.firstname, this.middlename, lastname, this.nickname, this.home, this.photo, this.address);
    }

    public ContactData withNickname(String nickname) {
        return new ContactData(this.id, this.firstname, this.middlename, this.lastname, nickname, this.home, this.photo, this.address);
    }

    public ContactData withHome(String home) {
        return new ContactData(this.id, this.firstname, this.middlename, this.lastname, this.nickname, home, this.photo, this.address);
    }

    public ContactData withPhoto(String photo) {
        return new ContactData(this.id, this.firstname, this.middlename, this.lastname, this.nickname, this.home, photo, this.address);
    }

    public ContactData withId(String id) {
        return new ContactData(id, this.firstname, this.middlename, this.lastname, this.nickname, this.home, this.photo, this.address);
    }

    public ContactData withAddress(String address) {
        return new ContactData(this.id, this.firstname, this.middlename, this.lastname, this.nickname, this.home, this.photo, address);
    }
}
