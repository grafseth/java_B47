package ru.gs.addressbook.Tests;

import ru.gs.addressbook.model.GroupData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Random;

public class GroupRemovalTests extends TestBase {

    @Test
    public void canRemoveGroup() {
        app.groups().openGroupsPage();
        if (app.groups().getCount() == 0) {
            app.groups().createGroup(new GroupData("", "test_group", "header", "footer"));
        }
        var oldGroups = app.groups().getList();
        var rnd = new Random();
        var index = rnd.nextInt(oldGroups.size());
        app.groups().removeGroup(oldGroups.get(index));
        var newGroups = app.groups().getList();
        var expectedList = new ArrayList<>(oldGroups);
        expectedList.remove(index);
        Assertions.assertEquals(newGroups.size(), oldGroups.size()-1);
    }

    @Test
    void canRemoveAllGroupsAtOnce() {
        app.groups().openGroupsPage();
        if (app.groups().getCount() == 0) {
            app.groups().createGroup(new GroupData("", "test_group", "header", "footer"));
        }
        app.groups().removeAllGroups();
        Assertions.assertEquals(0, app.groups().getCount());
    }
}