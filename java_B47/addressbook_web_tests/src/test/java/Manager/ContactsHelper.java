package Manager;

import model.ContactData;
import org.openqa.selenium.By;

public class ContactsHelper extends HelperBase {

    public ContactsHelper(ApplicationManager manager) {
    super(manager);
    }

    public void openContactsPage() {
        if (!manager.isElementPresent(By.name("MainForm"))) ;
        {
            click(By.linkText("add new"));
        }
    }
    public boolean isContactPresent() {
        openContactsPage();
        return manager.isElementPresent(By.name("selected[]"));
    }
    public void createContact(ContactData contact) {
        openContactsPage();
        fillContactForm(contact);
        submitContactCreation();
        returnToHomePage();
    }

    public void removeContact() {
        openContactsPage();
        selectContact();
        removeSelectedContact();
            }

    private void fillContactForm(ContactData contact) {
        type(By.name("firstname"), contact.firstname());
        type(By.name("middlename"), contact.middlename());
        type(By.name("lastname"), contact.lastname());
        type(By.name("nickname"), contact.nickname());
        type(By.name("home"), contact.home());
    }

    private void removeSelectedContact() {
        click(By.name("Delete"));
    }

    private void selectContact() {
        click(By.name("selected[]"));
    }

    private void returnToHomePage() {
        click(By.linkText("home page"));
    }

    private void submitContactCreation() {
        click(By.name("submit"));
    }

}

