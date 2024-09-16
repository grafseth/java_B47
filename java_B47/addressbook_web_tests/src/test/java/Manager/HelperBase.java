package Manager;

import org.openqa.selenium.By;

public class HelperBase {
    protected static ApplicationManager manager;

    public HelperBase(ApplicationManager manager) {
        HelperBase.manager = manager;
    }

    public HelperBase() {
    }

    protected static void click(By locator) {
        ApplicationManager.driver.findElement(locator).click();
    }

    protected static void type(By locator, String text) {
        click(locator);
        ApplicationManager.driver.findElement(locator).clear();
        ApplicationManager.driver.findElement(locator).sendKeys(text);
    }
}
