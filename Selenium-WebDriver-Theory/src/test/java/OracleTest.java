import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class OracleTest {
    private WebDriver driver;

    @BeforeEach
    public void setUp(){
        driver = new ChromeDriver();
    }

    @Test
    public void commonSearchTermResultsAreNotEmpty() throws InterruptedException {
        driver.get("https://docs.oracle.com/en/");

        WebElement searchInput = waitForElementLocatedBy(driver, By.id("search-bar-input"));
        searchInput.sendKeys("java");
        searchInput.sendKeys(Keys.RETURN);

        Thread.sleep(3000);
        List<WebElement> searchResults = driver.findElements(By.cssSelector(".card-bg.card-small.oj-conveyorbelt-item"));
        System.out.println(searchResults.size());
        assertTrue(searchResults.size()>0);
    }

    @AfterEach
    public void down(){
        driver.quit();
        driver=null;
    }

    private static WebElement waitForElementLocatedBy(WebDriver driver, By by){
        return new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.presenceOfElementLocated(by));
    }
}
