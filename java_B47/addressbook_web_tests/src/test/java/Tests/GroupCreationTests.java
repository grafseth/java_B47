package Tests;

import model.GroupData;
import org.junit.jupiter.api.Test;

public class GroupCreationTests extends TestBase {

    @Test
    public void canCreateGroup() {
        app.groups.openGroupsPage();
        app.createGroup(new GroupData("test_group", "header", "footer"));

    }


    @Test
    public void canCreateGroupWithEmptyName() {
        app.groups.openGroupsPage();
        app.createGroup(new GroupData());

    }
    @Test
    public void canCreateGroupWithNameOnly() {
        app.groups.openGroupsPage();
        var emptyGroup = new GroupData();
        var groupWithName = emptyGroup.withName("some name");
    app.createGroup(groupWithName);

    }
    @Test
    public void canCreateGroupWithHeader() {
        app.groups.openGroupsPage();
        app.createGroup(new GroupData().withHeader("some header"));

    }
    @Test
    public void canCreateGroupWithFooter() {
        app.groups.openGroupsPage();
        app.createGroup(new GroupData().withFooter("some footer"));

    }
}
