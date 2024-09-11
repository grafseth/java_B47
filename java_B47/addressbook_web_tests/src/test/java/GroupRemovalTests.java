import org.junit.jupiter.api.Test;

public class GroupRemovalTests extends TestBase {

    @Test
    public void canRemoveGroup() {
        openGroupsPage();
        if (!isGroupPresent()) ;
        {
            createGroup("test_group", "test_header", "test_footer");
        }
        removeGroup();
    }
}