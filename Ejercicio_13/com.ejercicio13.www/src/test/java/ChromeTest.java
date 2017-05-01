

import io.github.bonigarcia.wdm.ChromeDriverManager;
import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
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
    
    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {     
                 { "sistema", "system" }, { "diccionario", "dictionary" }, {"aplicación", "application"},  { "librería", "library" }  
           });
    }


    private String fInput;

    private String fExpected;

    public ChromeTest(String input, String expected) {
        fInput= input;
        fExpected= expected;
    }

    @Test
    public void testSistema(){
            driver.get("http://www.wordreference.com/");
            driver.findElement(By.id("si")).sendKeys(fInput);
            driver.findElement(By.id("fSelect")).click();
            driver.findElement(By.id("esen")).click();
            driver.findElement(By.className("submit-button")).click();

            WebDriverWait wait = new WebDriverWait(driver, TIMEOUT);
            wait.until(ExpectedConditions.textToBePresentInElementLocated(By.tagName("body"), fInput));
            System.out.println(driver.findElements(By.className("ToWrd")).get(1).getText());
            String text = driver.findElements(By.className("ToWrd")).get(1).getText();
            String arr[] = text.split(" ");
            boolean check = false;
            
            for (int i = 0; i < arr.length; i++) {
    			if (arr[i].equals(fExpected)){
    				check = true;
    			}
    		}
            assertTrue("Spanish " + fInput + " to English " + fExpected, check);
    }
}