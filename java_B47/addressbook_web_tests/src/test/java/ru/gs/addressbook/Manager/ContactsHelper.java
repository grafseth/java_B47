package ru.gs.addressbook.Manager;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import ru.gs.addressbook.model.ContactData;
import ru.gs.addressbook.model.GroupData;

import java.util.ArrayList;
import java.util.List;

public class ContactsHelper extends HelperBase {

    public ContactsHelper(ApplicationManager manager) {
        super(manager);
    }

    public void openContactsPage()
    {
        click(By.linkText("home"));
    }

    public void createContact(ContactData contact) {
        openNewContactPage();
        fillContactForm(contact);
        submitContactCreation();
        returnToHomePage();
    }

    public void Create(ContactData contact, GroupData group) {
        initContactCreation();
        fillContactForm(contact);
        selectGroup(group);
        submitContactCreation();
        returnToHomePage();
    }

    private void selectGroup(GroupData group) {
        new Select(ApplicationManager.driver.findElement(By.name("new_group"))).selectByValue(group.Id());
    }

    private void initContactCreation() {
        click(By.linkText("add new"));
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

    }

    public void modifyContact(ContactData contact, ContactData modifiedContact) {
        openContactsPage();
        selectContactToModify(contact);
        fillContactForm(modifiedContact);
        submitContactModification();
    }

    private void selectContactToModify(ContactData contact) {

        click(By.cssSelector(String.format("[href=\"edit.php?id=%s\"]", contact.id())));
    }

    public int getCount() {
        openContactsPage();
        return ApplicationManager.driver.findElements(By.xpath("//img[@alt='vCard']")).size();
    }

    private void submitContactModification() {
        click(By.name("update"));
    }

    public boolean isContactPresent() {
        openContactsPage();
        return manager.isElementPresent(By.name("selected[]"));
    }

    private void fillContactForm(ContactData contact) {
        type(By.name("firstname"), contact.firstname());
        type(By.name("middlename"), contact.middlename());
        type(By.name("lastname"), contact.lastname());
        type(By.name("nickname"), contact.nickname());
        type(By.name("home"), contact.home());
        //attach(By.name("photo"), contact.photo());
    }

    private void removeSelectedContact() {
        click(By.xpath("//input[@value='Delete']"));
    }

    private void selectContact(ContactData contact) {
        click(By.cssSelector(String.format("input[id='%s']", contact.id())));
    }

    private void returnToHomePage() {
        click(By.linkText("home page"));
    }

    private void submitContactCreation() {
        click(By.name("submit"));
    }

    public List<ContactData> getList() {
        openContactsPage();
        var contacts = new ArrayList<ContactData>();
        var centers = ApplicationManager.driver.findElements(By.cssSelector("tr[name=\"entry\"]"));
        for (var cnt : centers) {
            var lastName = cnt.findElement(By.cssSelector("td:nth-child(2)"));
            var last = lastName.getText();
            if (last == null || last.isEmpty()) {
                last = "";
            }
            var firstName = cnt.findElement(By.cssSelector("td:nth-child(3)"));
            var first = firstName.getText();
            if (first == null || first.isEmpty()) {
                first = "";
            }
            var address = cnt.findElement(By.cssSelector("td:nth-child(4)"));
            var addr = address.getText();
            if (addr == null || addr.isEmpty()) {
                addr = "";
            }
            var checkbox = cnt.findElement(By.name("selected[]"));
            var id = checkbox.getAttribute("id");
            contacts.add(new ContactData().withId(id).withLastname(last).withFirstname(first).withAddress(addr));
        }
        return contacts;
    }

    public String getPhones(ContactData contact) {
        return manager.driver
                .findElement(By.xpath(String.format("//input[@id=%s]/../../td[6]", contact.id()))).getText();
    }
}
