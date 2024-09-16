package Tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ContactCreationTests extends TestBase{
    private static WebDriver driver;


    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("http://localhost/addressbook/");
        driver.manage().window().setSize(new Dimension(1288, 885));
        driver.findElement(By.name("user")).sendKeys("admin");
        driver.findElement(By.name("pass")).click();
        driver.findElement(By.name("pass")).sendKeys("secret");
        driver.findElement(By.xpath("//input[@value=\'Login\']")).click();
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void canCreateContact() {

        app.contatcts().createContact(new ContactData());

           driver.findElement(By.linkText("add new")).click();
        driver.findElement(By.name("firstname")).click();
        driver.findElement(By.name("firstname")).sendKeys("John");
        driver.findElement(By.name("middlename")).click();
        driver.findElement(By.name("middlename")).sendKeys("Doe");
        driver.findElement(By.name("lastname")).click();
        driver.findElement(By.name("lastname")).sendKeys("Johnson");
        driver.findElement(By.name("nickname")).click();
        driver.findElement(By.name("nickname")).sendKeys("Missing");
        driver.findElement(By.name("home")).click();
        driver.findElement(By.name("home")).sendKeys("+7123456789");
        driver.findElement(By.cssSelector("input:nth-child(75)")).click();
        driver.findElement(By.linkText("home page")).click();
        driver.findElement(By.linkText("Logout")).click();
    }
}
