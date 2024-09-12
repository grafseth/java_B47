package Tests;

import model.GroupData;
import org.junit.jupiter.api.Test;

public class GroupRemovalTests extends TestBase {

    @Test
    public void canRemoveGroup() {
        app.groups.openGroupsPage(app);
        if (!app.isGroupPresent()) ;
        {
            app.createGroup(new GroupData("test_group", "header", "footer"));
        }
        app.removeGroup();
    }
}