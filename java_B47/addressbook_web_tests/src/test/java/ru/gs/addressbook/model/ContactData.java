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
                          String photo,
                          String secondary) {
    public ContactData(){
        this("","","","","","","","","","","");
    }
    public ContactData withId(String id) {
        return new ContactData(id, this.firstname, this.middlename, this.lastname, this.nickname, this.home, this.photo, this.address, this.mobile, this.work, this.secondary);
    }
    public ContactData withFirstname(String firstname) {
        return new ContactData(this.id, firstname, this.middlename, this.lastname, this.nickname, this.address, this.home, this.mobile, this.mobile, this.work, this.secondary);
    }
    public ContactData withMiddlename(String middlename) {
        return new ContactData(this.id, this.firstname, middlename, this.lastname, this.nickname, this.home, this.photo, this.address, this.mobile, this.work, this.secondary);
    }
    public ContactData withLastname(String lastname) {
        return new ContactData(this.id, this.firstname, this.middlename, lastname, this.nickname, this.home, this.photo, this.address, this.mobile, this.work, this.secondary);
    }
    public ContactData withNickname(String nickname) {
        return new ContactData(this.id, this.firstname, this.middlename, this.lastname, nickname, this.home, this.photo, this.address, this.mobile, this.work, this.secondary);
    }
    public ContactData withHome(String home) {
        return new ContactData(this.id, this.firstname, this.middlename, this.lastname, this.nickname, home, this.photo, this.address, this.mobile, this.work, this.secondary);
    }
    public ContactData withPhoto(String photo) {
        return new ContactData(this.id, this.firstname, this.middlename, this.lastname, this.nickname, this.home, photo, this.address, this.mobile, this.work, this.secondary);
    }
    public ContactData withAddress(String address) {
        return new ContactData(this.id, this.firstname, this.middlename, this.lastname, this.nickname, this.home, this.photo, address, this.mobile, this.work, this.secondary);
    }
    public ContactData withMobile(String mobile) {
        return new ContactData(this.id, this.firstname, this.middlename, this.lastname, this.nickname, this.home, this.photo, this.address, mobile, this.work, this.secondary);
    }
    public ContactData withWork(String work) {
        return new ContactData(this.id, this.firstname, this.middlename, this.lastname, this.nickname, this.home, this.photo, this.address, this.mobile, work, this.secondary);
    }
    public ContactData withSecondary(String secondary) {
        return new ContactData(this.id, this.firstname, this.middlename, this.lastname, this.nickname, this.home, this.photo, this.address, this.mobile, this.work, secondary);
    }
}
