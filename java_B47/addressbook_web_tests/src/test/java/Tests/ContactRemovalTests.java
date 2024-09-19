package Tests;

import model.ContactData;
import org.junit.jupiter.api.Test;

public class ContactRemovalTests extends TestBase {

    @Test
    public void canRemoveContact() {
        app.contacts().openContactsPage();
        if (!app.contacts().isContactPresent()) {
            app.contacts().createContact(new ContactData("test_name", "test_middle", "test_last", "test_nick", "test_phone"));
        }
        app.contacts().removeContact();
    }
}
