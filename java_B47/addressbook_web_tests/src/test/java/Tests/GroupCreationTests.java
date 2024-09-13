package Tests;

import model.GroupData;
import org.junit.jupiter.api.Test;

public class GroupCreationTests extends TestBase {

    @Test
    public void canCreateGroup() {

        app.groups().createGroup(new GroupData("test_group", "header", "footer"));

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
