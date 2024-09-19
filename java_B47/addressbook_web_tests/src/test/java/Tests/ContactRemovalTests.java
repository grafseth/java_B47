package Tests;

import model.ContactData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ContactRemovalTests extends TestBase {

    @Test
    public void canRemoveContact() {
        app.contacts().openContactsPage();
        if (app.contacts().getCount() == 0) {
            app.contacts().createContact(new ContactData("test_name", "test_middle", "test_last", "test_nick", "test_phone"));
        }
        int contactCount = app.contacts().getCount();
        app.contacts().removeContact();
        int newContactCount = app.contacts().getCount();
        Assertions.assertEquals(contactCount - 1, newContactCount);
            }
}
