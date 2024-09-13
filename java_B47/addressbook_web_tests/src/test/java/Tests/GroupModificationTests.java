package Tests;

import model.GroupData;
import org.junit.jupiter.api.Test;

public class GroupModificationTests extends TestBase {
    @Test
    void canModifyGroup() {
        app.groups().openGroupsPage();
        if (!app.groups().isGroupPresent())
        {
            app.groups().createGroup(new GroupData("test_group", "header", "footer"));
        }
        app.groups().modifyGroup(new GroupData().withName("modified name"));
    }
}
