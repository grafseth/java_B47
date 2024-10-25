package ru.gs.addressbook.Tests;

import ru.gs.addressbook.model.ContactData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ContactRemovalTests extends TestBase {

    @Test
    public void canRemoveContact() {
        app.contacts().openContactsPage();
        if (app.contacts().getCount() == 0) {
            app.contacts().createContact(new ContactData("","test_name", "test_middle", "test_last", "test_nick", "test_phone", "","", "", "", ""));
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
            app.contacts().createContact(new ContactData("","test_name", "test_middle", "test_last", "test_nick", "test_phone", "","", "", "", ""));
        }
        // int contactCount=app.contact().getCount();
        List<ContactData> oldContacts=app.hbm().getContactList();
        var rnd=new Random();
        var index=rnd.nextInt(oldContacts.size());
        app.contacts().removeContact(oldContacts.get(index));
        List<ContactData> newContacts=app.hbm().getContactList();
        var expectedList=new ArrayList<>(oldContacts);
        expectedList.remove(index);
        //int newGroupCount=app.contact().getCount();
        Assertions.assertEquals(newContacts,expectedList);
    }
}
