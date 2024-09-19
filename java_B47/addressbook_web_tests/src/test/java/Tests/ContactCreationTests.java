package Tests;

import model.ContactData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.ArrayList;
import java.util.List;


public class ContactCreationTests extends TestBase {

    public static List<ContactData> contactProvider() {

    var result = new ArrayList<ContactData>();
    for (var firstname : List.of(" ", "test_name")) {
        for (var middlename : List.of(" ", "test_middle")) {
            for (var lastname : List.of(" ", "test_last")) {
                for (var nickname : List.of(" ", "test_nick")) {
                    for (var home : List.of(" ", "test_phone")) {
                    result.add(new ContactData(firstname, middlename, lastname, nickname, home));
                }
            }
        }
    }
    }
    for (int i = 0; i < 5; i++) {
        result.add(new ContactData(randomString(i * 10), randomString(i * 10), randomString(i * 10), randomString(i * 10), randomString(i * 10)));
    }
    return result;
    }

    @ParameterizedTest
    @MethodSource("contactProvider")
    public void canCreateMultipleContacts(ContactData contacts) {

        int contactCount = app.contacts().getCount();
        app.contacts().createContact(contacts);
        int newContactCount = app.contacts().getCount();
        Assertions.assertEquals(contactCount + 1, newContactCount);

    }
}