import model.GroupData;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class GroupCreationTests extends TestBase {

    @Test
    public void canCreateGroup() {
        openGroupsPage();
        createGroup(new GroupData("test_group", "header", "footer"));

    }


    @Test
    public void canCreateGroupWithEmptyName() {
        openGroupsPage();
        createGroup(new GroupData());

    }
    @Test
    public void canCreateGroupWithNameOnly() {
        openGroupsPage();
        var emptyGroup = new GroupData();
        var groupWithName = emptyGroup.withName("some name");
    createGroup(groupWithName);

    }
    @Test
    public void canCreateGroupWithHeader() {
        openGroupsPage();
        createGroup(new GroupData().withHeader("some header"));

    }
    @Test
    public void canCreateGroupWithFooter() {
        openGroupsPage();
        createGroup(new GroupData().withFooter("some footer"));

    }
}
