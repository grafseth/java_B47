package ru.gs.addressbook.Manager;

import ru.gs.addressbook.model.GroupData;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;

public class GroupHelper extends HelperBase {

    public GroupHelper(ApplicationManager manager) {
        super(manager);

    }

    private static void selectAllGroups() {
        var checkboxes = ApplicationManager.driver.findElements(By.name("selected[]"));
        for (var checkbox : checkboxes) {
            checkbox.click();
        }
    }

    public void openGroupsPage() {
        if (!manager.isElementPresent(By.name("new"))) ;
        {
            click(By.linkText("groups"));
        }
    }

    public void createGroup(GroupData group) {
        openGroupsPage();
        initGroupCreation();
        fillGroupForm(group);
        submitGroupCreation();
        returnToGroupsPage();
    }

    public void removeGroup(GroupData group) {
        openGroupsPage();
        selectGroup(group);
        removerSelectedGroups();
        returnToGroupsPage();
    }

    public void modifyGroup(GroupData group, GroupData modifiedGroup) {
        openGroupsPage();
        selectGroup(group);
        initGroupModification();
        fillGroupForm(modifiedGroup);
        submitGroupModification();
        returnToGroupsPage();
    }

    public int getCount() {
        openGroupsPage();
        return ApplicationManager.driver.findElements(By.name("selected[]")).size();
    }

    public void removeAllGroups() {
        openGroupsPage();
        selectAllGroups();
        removerSelectedGroups();
    }

    public List<GroupData> getList() {
        openGroupsPage();
        var groups = new ArrayList<GroupData>();
        var spans = ApplicationManager.driver.findElements(By.cssSelector("span.group"));
        for (var span : spans) {
            var name = span.getText();
            var checkbox = span.findElement(By.name("selected[]"));
            var id = checkbox.getAttribute("value");
            groups.add(new GroupData().withId(id).withName(name));
        }
        return groups;
    }

    private void submitGroupCreation() {
        click(By.name("submit"));
    }

    private void initGroupCreation() {
        click(By.name("new"));
    }

    private void removerSelectedGroups() {
        click(By.name("delete"));
    }

    private void returnToGroupsPage() {
        click(By.linkText("group page"));
    }

    private void submitGroupModification() {
        click(By.name("update"));
    }

    private void fillGroupForm(GroupData group) {
        type(By.name("group_name"), group.name());
        type(By.name("group_header"), group.header());
        type(By.name("group_footer"), group.footer());
    }

    private void initGroupModification() {
        click(By.name("edit"));
    }

    private void selectGroup(GroupData group) {

        click(By.cssSelector(String.format("input[value='%s']", group.Id())));
    }
}