package Manager;

import org.openqa.selenium.By;

public class GroupHelper {
    private final ApplicationManager manager;

    public GroupHelper(ApplicationManager manager) {
        this.manager = manager;

    }

    public void openGroupsPage() {
        if (!manager.isElementPresent(By.name("new"))) ;
        {
            manager.driver.findElement(By.linkText("groups")).click();
        }
    }
}
