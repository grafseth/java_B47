package ru.gs.addressbook.Manager.hbm;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
public class ContactRecord {
    @Id
    public int id;
    public String firstname;

    @Column(nullable = true)
    private String nickname;

    public String lastname;

    @Column(nullable = true)
    public String middlename="";

    @Column(nullable = true)
    public String company="";

    @Column(nullable = true)
    public String title="";

    @Column(nullable = true)
    public String fax="";

    @Column(nullable = true)
    public String homepage="";

    @Column(name = "address", nullable = false)
    public String address;
    public String home;
    public String mobile;
    public String work;
    public String phone2;
    public String email;
    public String email2;
    public String email3;

    public ContactRecord(int id, String firstname, String lastname, String address){

        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.address = address;
    }
}