package ru.gs.addressbook.Tests;

import ru.gs.addressbook.model.ContactData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.gs.addressbook.model.GroupData;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ContactRemovalTests extends TestBase {

    @Test
    public void canRemoveContact() {
        app.contacts().openContactsPage();
        if (app.contacts().getCount() == 0) {
            app.contacts().createContact(new ContactData("", "test_name", "test_middle", "test_last", "test_nick", "test_phone", "", "", "", "", ""));
        }

        var oldContacts = app.contacts().getList();
        var rnd = new Random();
        var index = rnd.nextInt(oldContacts.size());

        app.contacts().removeContact(oldContacts.get(index));
        var newContacts = app.contacts().getList();
        var expectedList = new ArrayList<>(oldContacts);
        expectedList.remove(index);
        Assertions.assertEquals(newContacts, expectedList);
    }


    @Test
    public void canRemoveContactFromBD() {
        if (app.contacts().getCount() == 0) {
            app.contacts().createContact(new ContactData("", "test_name", "test_middle", "test_last", "test_nick", "test_phone", "", "", "", "", ""));
        }
        // int contactCount=app.contact().getCount();
        List<ContactData> oldContacts = app.hbm().getContactList();
        var rnd = new Random();
        var index = rnd.nextInt(oldContacts.size());
        app.contacts().removeContact(oldContacts.get(index));
        List<ContactData> newContacts = app.hbm().getContactList();
        var expectedList = new ArrayList<>(oldContacts);
        expectedList.remove(index);
        //int newGroupCount=app.contact().getCount();
        Assertions.assertEquals(newContacts, expectedList);
    }

    @Test
    public void canAddContactInGroup()
    {
        if (app.hbm().getContactCount()==0){
            app.hbm().createContact(new ContactData("","",
                    "", "", "","","",
                    "","","", ""));
        }
        var contact=app.hbm().getContactList().get(0);
        if (app.hbm().getGroupCount()==0){
            app.hbm().createGroup(new GroupData("", "", "", ""));
        }

        var group=app.hbm().getGroupList().get(0);
        var oldRelated=app.hbm().getContactsInGroup(group);
        app.contacts().Create(contact, group);
        var newRelated=app.hbm().getContactsInGroup(group);
        Assertions.assertEquals(oldRelated.size()+1,newRelated.size());
    }

    @Test
    public void canRemoveContactInGroup() throws SQLException {

        if (app.hbm().getContactCount() == 0) {
            app.hbm().createContact(new ContactData("", "",
                    "", "", "", "", "",
                    "", "", "", ""));
        }

        if (app.hbm().getGroupCount() == 0) {
            app.hbm().createGroup(new GroupData("", "", "", ""));
        }

        var group = app.hbm().getGroupList().get(0);
        var contact = app.hbm().getContactList().get(0);

        var oldRelated = app.hbm().getContactsInGroup(group);

        if (oldRelated.size() == 0) {
            app.contacts().Create(contact, group);
            oldRelated = app.hbm().getContactsInGroup(group);
        }
    }
}
