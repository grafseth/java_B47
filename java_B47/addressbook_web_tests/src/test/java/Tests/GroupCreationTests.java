package Tests;

import model.GroupData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GroupCreationTests extends TestBase {

    @Test
    public void canCreateGroup() {
        int groupCount = app.groups().getCount();

        app.groups().createGroup(new GroupData("test_group", "header", "footer"));

        int newGroupCount = app.groups().getCount();
        Assertions.assertEquals(groupCount + 1, newGroupCount);
    }


    @Test
    public void canCreateGroupWithEmptyName() {
        app.groups().createGroup(new GroupData());

    }
    @Test
    public void canCreateGroupWithNameOnly() {
        app.groups().createGroup(new GroupData().withName("some name"));

    }
    @Test
    public void canCreateGroupWithHeader() {
        app.groups().createGroup(new GroupData().withHeader("some header"));

    }
    @Test
    public void canCreateGroupWithFooter() {
        app.groups().createGroup(new GroupData().withFooter("some footer"));

    }
}
