package Manager;

import model.ContactData;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;

public class ContactsHelper extends HelperBase {

    public ContactsHelper(ApplicationManager manager) {
        super(manager);
    }

    public void openContactsPage() {
        manager.isElementPresent(By.name("MainForm"));

    }

    public int getCount() {
        openContactsPage();
        return ApplicationManager.driver.findElements(By.name("selected[]")).size();
    }


    public void createContact(ContactData contact) {
        openContactsPage();
        openNewContactPage();
        fillContactForm(contact);
        submitContactCreation();
        returnToHomePage();
    }

    private void openNewContactPage() {
        if (!manager.isElementPresent(By.name("submit"))) ;
        {
            click(By.xpath("//a[contains(@href, 'edit.php')]"));
        }
    }

    public void removeContact(ContactData contact) {
        openContactsPage();
        selectContact(contact);
        removeSelectedContact();
        returnToHomePage();
    }

    public void modifyContact(ContactData contact, ContactData modifiedContact) {
        openContactsPage();
        selectContact(contact);
        initContactModification();
        fillContactForm(modifiedContact);
        submitContactModification();
        returnToHomePage();
    }

    private void initContactModification() {
        click(By.xpath("=(//img[@alt='Edit'])[2]"));
    }

    private void submitContactModification() {
        click(By.name("update"));
    }


    private void fillContactForm(ContactData contact) {
        type(By.name("firstname"), contact.firstname());
        type(By.name("middlename"), contact.middlename());
        type(By.name("lastname"), contact.lastname());
        type(By.name("nickname"), contact.nickname());
        type(By.name("home"), contact.home());
        attach(By.name("photo"), contact.photo());
    }

    private void removeSelectedContact() {
        click(By.xpath("//input[@value='Delete']"));
    }

    private void selectContact(ContactData contact) {
        click(By.cssSelector(String.format("input[value='%s']", contact.id())));
    }

    private void returnToHomePage() {
        click(By.linkText("home"));
    }

    private void submitContactCreation() {
        click(By.name("submit"));
    }

    public List<ContactData> getList() {
        openContactsPage();
        var contacts = new ArrayList<ContactData>();
        var tds = ApplicationManager.driver.findElements(By.className("td.center"));
        for (var td : tds) {
            var name = td.getText();
            var checkbox = td.findElement(By.className("td.center"));
            var id = checkbox.getAttribute("value");
            contacts.add(new ContactData().withId(id).withFirstname(name));
        }
        return contacts;
    }

}

