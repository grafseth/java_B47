package ru.gs.addressbook.Tests;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import ru.gs.addressbook.common.CommonFunctions;
import ru.gs.addressbook.model.ContactData;
import ru.gs.addressbook.model.GroupData;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


public class ContactCreationTests extends TestBase {

    @Test
    void canCreateContact() {
        var contact = new ContactData()
                .withFirstname(CommonFunctions.randomString(10))
                .withLastname(CommonFunctions.randomString(10))
                .withPhoto(randomFile("src/test/resources/images/"));
        app.contacts().Create(contact);
    }

    private static List<ContactData> contactProvider() throws IOException {
        var result = new ArrayList<ContactData>();
        //    for (var firstname : List.of(" ", "test_name")) {
//        for (var middlename : List.of(" ", "test_middle")) {
//            for (var lastname : List.of(" ", "test_last")) {
//                for (var nickname : List.of(" ", "test_nick")) {
//                    for (var home : List.of(" ", "test_phone")) {
//
//                            result.add(new ContactData()
//                                    .withFirstname(firstname)
//                                    .withMiddlename(middlename)
//                                    .withLastname(lastname)
//                                    .withNickname(nickname)
//                                    .withHome(home));
//                        }
//                }
//            }
//        }
//    }

        var mapper = new ObjectMapper();
        var value = mapper.readValue(new File("contacts.json"), new TypeReference<List<ContactData>>() {});
        result.addAll(value);
        return result;
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

    public static List<ContactData> contactProvider() {

    var result = new ArrayList<ContactData>();
    for (var firstname : List.of(" ", "test_name")) {
        for (var middlename : List.of(" ", "test_middle")) {
            for (var lastname : List.of(" ", "test_last")) {
                for (var nickname : List.of(" ", "test_nick")) {
                    for (var home : List.of(" ", "test_phone")) {
                            result.add(new ContactData()
                                    .withFirstname(firstname)
                                    .withMiddlename(middlename)
                                    .withLastname(lastname)
                                    .withNickname(nickname)
                                    .withHome(home));
                        }
                }
            }
        }
    }

    for (int i = 0; i < 5; i++) {
        result.add(new ContactData()
                .withFirstname(CommonFunctions.randomString(i*10))
                .withMiddlename(CommonFunctions.randomString(i*10))
                .withLastname(CommonFunctions.randomString(i*10))
                .withNickname(CommonFunctions.randomString(i*10))
                .withHome(CommonFunctions.randomString(i*10)));
            }
    return result;
    }

    @ParameterizedTest
    @MethodSource("contactProvider")
    public void canCreateMultipleContacts(ContactData contacts) {
        var oldContacts = app.contacts().getList();
        app.contacts().Create(contacts);
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
}