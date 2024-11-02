package ru.gs.addressbook.Tests;

import ru.gs.addressbook.model.ContactData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.gs.addressbook.model.GroupData;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;

 public class ContactModificationTest extends TestBase {
    @Test
    void canModifyContact() {
        app.contacts().openContactsPage();
        if (app.contacts().getCount() == 0) {
            app.contacts().createContact(
//                    new ContactData(
//                            "",
//                            "test_name",
//                            "test_middle",
//                            "test_last",
//                            "test_nick",
//                            "test_phone",
//                            "", "", "", "", ""));
                    new ContactData("","","","","","","","","","", ""));
        }
        var oldContacts = app.contacts().getList();
        var rnd = new Random();
        var index = rnd.nextInt(oldContacts.size());
        var testData = new ContactData().withFirstname("modified_Name");
        app.contacts().modifyContact(oldContacts.get(index), testData);
        var newContacts = app.contacts().getList();
        var expectedList = new ArrayList<>(oldContacts);
        expectedList.set(index, testData.withId(oldContacts.get(index).id()));
        Comparator<ContactData> compareById = (o1, o2) -> {
            return Integer.compare(Integer.parseInt(o1.id()), Integer.parseInt(o2.id()));
        };
        newContacts.sort(compareById);
        expectedList.sort(compareById);
        Assertions.assertEquals(newContacts, expectedList);
    }

     @Test
     public void canAddContactInGroup()
     {
         if (app.contacts().getCount() == 0) {
             app.contacts().createContact(
                     new ContactData("","","","","","","","","","", ""));
         }
         var contact=app.hbm().getContactList().get(0);
         if (app.hbm().getGroupCount()==0){
             app.groups().createGroup(new GroupData("", "", "", ""));
         }
         var group=app.hbm().getGroupList().get(0);
         var oldRelated=app.hbm().getContactsInGroup(group);
         app.contacts().createGroupWithoutNewContact(contact, group);
         var newRelated=app.hbm().getContactsInGroup(group);
         Assertions.assertEquals(oldRelated.size()+1,newRelated.size());
     }
}
