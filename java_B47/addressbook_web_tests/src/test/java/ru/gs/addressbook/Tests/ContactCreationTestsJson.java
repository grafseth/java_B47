package ru.gs.addressbook.Tests;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import ru.gs.addressbook.common.CommonFunctions;
import ru.gs.addressbook.model.ContactData;
import ru.gs.addressbook.model.GroupData;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


public class ContactCreationTestsJson extends TestBase {

    public static List<ContactData> contactProvider() throws IOException {
        var result = new ArrayList<ContactData>();


        var json="";
        try (var resder=new FileReader("contacts.xml");
             var breader=new BufferedReader(resder))
        {
            var line= breader.readLine();
            while(line !=null){
                json=json+line;
                line=breader.readLine();
            }

        }
var mapper = new XmlMapper();
    var value = mapper.readValue(new File("contacts.xml"), new TypeReference<List<ContactData>>() {});
    //var value = mapper.readValue(new File("groups.json"), new TypeReference <List<GroupData>>() {});
    result.addAll(value);
    return result;
    }

    @ParameterizedTest
    @MethodSource("contactProvider")
    public void canCreateMultipleContacts(ContactData contacts) {
        app.contacts().openContactsPage();
        var oldContacts = app.contacts().getList();
        app.contacts().createContact(contacts);
        var newContacts = app.contacts().getList();
        Comparator<ContactData> compareById = (o1, o2) -> {
            return Integer.compare(Integer.parseInt(o1.id()), Integer.parseInt(o2.id()));
        };
        newContacts.sort(compareById);
        var maxId = newContacts.get(newContacts.size() - 1).id();
        var expectedList = new ArrayList<>(oldContacts);
        expectedList.add(contacts.withId(maxId));
        expectedList.sort(compareById);
        Assertions.assertEquals(newContacts, expectedList);
    }

@Test
void canCreateContactInGroup() {
    var contact = new ContactData()
            .withFirstname(CommonFunctions.randomString(10))
            .withLastname(CommonFunctions.randomString(10))
            .withPhoto(randomFile("src/test/resources/images/"));
    if (app.hbm().getGroupCount() == 0) {
        app.hbm().createGroup(new GroupData("", "test_group", "header", "footer"));
    }
    var group = app.hbm().getGroupList().get(0);

    var oldRelated = app.hbm().getContactsInGroup(group);
    app.contacts().Create(contact, group);
    var newRelated = app.hbm().getContactsInGroup(group);
    Assertions.assertEquals(oldRelated.size()+1, newRelated.size());
}

@Test
void canCreateContact() {
    var contact = new ContactData()
            .withFirstname(CommonFunctions.randomString(10))
            .withLastname(CommonFunctions.randomString(10))
            .withPhoto(randomFile("src/test/resources/images/"));
    app.contacts().createContact(contact);
}
}