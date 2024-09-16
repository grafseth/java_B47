package Manager;

import model.ContactData;
import org.openqa.selenium.By;

public class ContactsHelper extends HelperBase {

    public ContactsHelper(ApplicationManager manager) {

    }

    public void openContactsPage() {
        if (!manager.isElementPresent(By.name("submit"))) ;
        {
            click(By.linkText("add new"));
        }
    }

    public void createContact(ContactData contact){
                openContactsPage();
                fillContactForm(contact);
                submitContactCreation();
                returnToHomePage();
}
public void removeContact() {
    openContactsPage();
    selectContact();
    removeSelectedContact();
    returnToHomePage();
    }

    private void removeSelectedContact() {
        click(By.name("Delete"));
    }

    private void selectContact() {
        click(By.name("selected[]"));
    }

    private void returnToHomePage()  {
        click(By.linkText("home page"));
    }


    private void submitContactCreation() {
        click(By.name("submit"));
    }

    private void fillContactForm(ContactData contact) {
        type(By.name("contact_firstname"), contact.firstname());
        type(By.name("contact_middlename"), contact.middlename());
        type(By.name("contact_lastname"), contact.lastname());
        type(By.name("contact_nickname"), contact.nickname());
        type(By.name("+7123456789"), contact.home());
    }


}

