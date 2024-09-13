package Manager;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ApplicationManager {
    protected static WebDriver driver;
    private LoginHelper session;
    private GroupHelper groups;

    public void init(String Browser) {
        if (driver == null) {
            if ("chrome".equals(Browser)) {
                driver = new ChromeDriver();
            } else if ("firefox".equals(Browser)) {
                driver = new FirefoxDriver();
            } else {
                throw new IllegalArgumentException(String.format("Unknown browser %s", Browser));
            }
            Runtime.getRuntime().addShutdownHook(new Thread(driver::quit));
            driver.get("http://localhost/addressbook/");
            driver.manage().window().setSize(new Dimension(1288, 885));
            session();
            LoginHelper.login("admin", "secret");
        }
    }

    public void session() {
        if (session == null) {
            session = new LoginHelper(this);
        }
    }

    public GroupHelper groups() {
        if (groups == null) {
            groups = new GroupHelper(this);
        }
        return groups;
    }

    public boolean isElementPresent(By locator) {
        try {
            driver.findElement(locator);
            return true;
        } catch (NoSuchElementException exception) {
            return false;
        }
    }

}
