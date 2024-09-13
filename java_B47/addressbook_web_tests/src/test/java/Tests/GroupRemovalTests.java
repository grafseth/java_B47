package Tests;

import model.GroupData;
import org.junit.jupiter.api.Test;

public class GroupRemovalTests extends TestBase {

    @Test
    public void canRemoveGroup() {
        app.groups().openGroupsPage();
        if (!app.groups().isGroupPresent())
        {
            app.groups().createGroup(new GroupData("test_group", "header", "footer"));
        }
        app.groups().removeGroup();
    }
}