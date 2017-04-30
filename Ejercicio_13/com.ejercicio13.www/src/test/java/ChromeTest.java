

import io.github.bonigarcia.wdm.ChromeDriverManager;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.junit.Assert.*;

public class ChromeTest {

    private static final int TIMEOUT = 30; // seconds
    private WebDriver driver;

    @BeforeClass
    public static void setupClass() {
        ChromeDriverManager.getInstance().setup();
    }

    @Before
    public void setupTest() {
        driver = new ChromeDriver();
    }

    @After
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void testChrome(){
        driver.get("http://www.wordreference.com/");
        driver.findElement(By.id("si")).sendKeys("sistema");
        driver.findElement(By.id("fSelect")).click();
        driver.findElement(By.id("esen")).click();
        driver.findElement(By.className("submit-button")).click();

        WebDriverWait wait = new WebDriverWait(driver, TIMEOUT);
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.tagName("body"), "sistema"));
        System.out.println(driver.findElements(By.className("ToWrd")).get(1).getText());
        String text = driver.findElements(By.className("ToWrd")).get(1).getText();
        String arr[] = text.split(" ");
        assertEquals(arr[0], "system");
    }
}
