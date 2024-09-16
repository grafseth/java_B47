package Tests;

import model.ContactData;
import org.junit.jupiter.api.Test;

public class ContactCreationTests extends TestBase {

    @Test
    public void canCreateContact() {
        app.contacts().createContact(new ContactData("test_name", "test_middle", "test_last", "test_nick", "test_phone"));
    }
}

