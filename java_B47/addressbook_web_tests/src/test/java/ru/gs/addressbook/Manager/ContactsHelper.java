package ru.gs.addressbook.Manager;

import org.openqa.selenium.support.ui.Select;
import ru.gs.addressbook.model.ContactData;
import org.openqa.selenium.By;
import ru.gs.addressbook.model.GroupData;

import java.util.ArrayList;
import java.util.List;

public class ContactsHelper extends HelperBase {

    public ContactsHelper(ApplicationManager manager) {
        super(manager);
    }

    public void openContactsPage() {
        manager.isElementPresent(By.name("MainForm"));

    }

    public void Create(ContactData contact) {
        initContactCreation();
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
        new Select(manager.driver.findElement(By.name("new_group"))).selectByValue(group.Id());
    }

    private void initContactCreation() {
        click(By.xpath("//a[contains(text(),'add new')]"));
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
        openNewContactPage();
        initContactModification(contact.id());
        fillContactForm(modifiedContact);
        submitContactModification();
        returnToHomePage();
    }

    public int getCount() {
        openContactsPage();
        return ApplicationManager.driver.findElements(By.xpath("//img[@alt='vCard']")).size();
    }

    private void initContactModification(String contact) {
        click(By.xpath(String.format("//img[@alt='Edit'])[value='%s']", contact)));

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
        //attach(By.name("photo"), contact.photo());
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
        var trs = ApplicationManager.driver.findElements(By.cssSelector("tr.center"));
        for (var tr : trs) {
            var name = tr.getText();
            var checkbox = tr.findElement(By.name("selected[]"));
            var id = checkbox.getAttribute("value");
            contacts.add(new ContactData().withId(id)
                    .withFirstname(name));
        }
        return contacts;
        }
    }