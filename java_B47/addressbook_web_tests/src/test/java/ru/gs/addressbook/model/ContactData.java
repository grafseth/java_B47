package ru.gs.addressbook.model;

public record ContactData(String id,
                          String firstname,
                          String middlename,
                          String lastname,
                          String nickname,
                          String address,
                          String home,
                          String mobile,
                          String work,
                          String email,
                          String photo,
                          String secondary,
                          String email2,
                          String email3) {
    public ContactData(){
        this("","","","","","","","","","", "", "", "", "");
    }
    public ContactData withFirstname(String firstname) {
        return new ContactData(this.id, firstname, this.middlename, this.lastname, this.nickname, this.address, this.home, this.mobile, this.work, this.email, this.photo, this.secondary, this.email2, this.email3);
    }
    public ContactData withMiddlename(String middlename) {
        return new ContactData(this.id, this.firstname, middlename, this.lastname, this.nickname, this.home, this.photo, this.address, this.mobile, this.work, this.email, this.secondary, this.email2, this.email3);
    }
    public ContactData withLastname(String lastname) {
        return new ContactData(this.id, this.firstname, this.middlename, lastname, this.nickname, this.home, this.photo, this.address, this.mobile, this.work, this.email, this.secondary, this.email2, this.email3);
    }
    public ContactData withNickname(String nickname) {
        return new ContactData(this.id, this.firstname, this.middlename, this.lastname, nickname, this.home, this.photo, this.address, this.mobile, this.work, this.email, this.secondary, this.email2, this.email3);
    }
    public ContactData withHome(String home) {
        return new ContactData(this.id, this.firstname, this.middlename, this.lastname, this.nickname, home, this.photo, this.address, this.mobile, this.work, this.email, this.secondary, this.email2, this.email3);
    }
    public ContactData withPhoto(String photo) {
        return new ContactData(this.id, this.firstname, this.middlename, this.lastname, this.nickname, this.home, photo, this.address, this.mobile, this.work, this.email, this.secondary, this.email2, this.email3);
    }
    public ContactData withId(String id) {
        return new ContactData(id, this.firstname, this.middlename, this.lastname, this.nickname, this.home, this.photo, this.address, this.mobile, this.work, this.email, this.secondary, this.email2, this.email3);
    }
    public ContactData withAddress(String address) {
        return new ContactData(this.id, this.firstname, this.middlename, this.lastname, this.nickname, this.home, this.photo, address, this.mobile, this.work, this.email, this.secondary, this.email2, this.email3);
    }
    public ContactData withMobile(String mobile) {
        return new ContactData(this.id, this.firstname, this.middlename, this.lastname, this.nickname, this.home, this.photo, this.address, mobile, this.work, this.email, this.secondary, this.email2, this.email3);
    }
    public ContactData withWork(String work) {
        return new ContactData(this.id, this.firstname, this.middlename, this.lastname, this.nickname, this.home, this.photo, this.address, this.mobile, work, this.email, this.secondary, this.email2, this.email3);
    }
    public ContactData withSecondary(String secondary) {
        return new ContactData(this.id, this.firstname, this.middlename, this.lastname, this.nickname, this.home, this.photo, this.address, this.mobile, this.work, this.email, secondary, this.email2, this.email3);
    }
    public ContactData withEmail(String email) {
        return new ContactData(this.id, this.firstname, this.middlename, this.lastname, this.nickname, this.home, this.photo, this.address, this.mobile, this.work, email, this.secondary, this.email2, this.email3);
    }
    public ContactData withEmail2(String email2) {
        return new ContactData(this.id, this.firstname, this.middlename, this.lastname, this.nickname, this.home, this.photo, this.address, this.mobile, this.work, this.email, this.secondary, email2, this.email3);
    }
    public ContactData withEmail3(String email3) {
        return new ContactData(this.id, this.firstname, this.middlename, this.lastname, this.nickname, this.home, this.photo, this.address, this.mobile, this.work, this.email, this.secondary, this.email2, email3);
    }
}
