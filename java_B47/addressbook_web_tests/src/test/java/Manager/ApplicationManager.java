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
    private ContactsHelper contacts;

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
            session.login("admin", "secret");
        }
    }

    public LoginHelper session() {
        if (session == null) {
            session = new LoginHelper(this);
        }
        return session;
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

    public ContactsHelper contacts() {
        if (contacts == null) {
            contacts = new ContactsHelper(this);
        }
        return contacts;
    }
}