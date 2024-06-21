import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class HelloWebDriver {
    public static void main(String[] args) throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.setBinary("C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe");
        WebDriver driver = new ChromeDriver(options);
/*
        driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(15, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
*/


        driver.get("https://www.google.com.co/");

        //Explicit
/*
        new WebDriverWait(driver, 10).until(CustomConditions.jQueryAJAXsCompleted());
*/

   /*     new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(By.id("APjFqb")));*/

/*
        WebElement searchInput = driver.findElement(By.id("APjFqb"));
*/

        WebElement searchInput = waitForElementLocatedBy(driver, By.id("APjFqb"));


        searchInput.sendKeys("Stray kids");
        //findElements returns a list of web elements, it can be empty, no exception is nothing if found
        //findElement returns the first found element, not nullable, if nothing found an exception is thrown
     /*   WebElement searchBtn = driver.findElement(By.id("search-icon-legacy"));
        searchBtn.click();*/
        searchInput.sendKeys(Keys.ENTER);


        //Synchronization issues
        //-Developer confidence
        //-Client-server specifications (speed)
        //-Javascript engine performance
        //-Networks
        //-Ambiguous criteria of page load finished state

        //Solutions
        //-General timeouts
        //-Waits

        //Do not use Thread.sleep to solve the problem of synchronization, there are proper wrappers in WebDriverWait and Expected Conditions
        //However it can help detect issues and debug mode

        //There are three pageLoadStrategy -> normal (default, all content has been loaded), eager, none




        driver.quit();
    }

    //Explicit/Fluent waits
    private static WebElement waitForElementLocatedBy(WebDriver driver, By by) {
        return new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(by));
    }

    //Fluent waits give more flexibility
    /*
    *
    * Wait<WebDriver> wait = new FluentWait<>(driver)
    * .withTimeout(Duration.ofSeconds(15))
    * .pollingEvery(Duration.ofSeconds(3))
    * .ignoring(NoSuchElementException.class)
    * .ignoring(StaleElementReferenceException.class)
    * .withMessage("Timeout for waiting search result list was exceeded")
    * */

    //Implicit waits
    // driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    //side effects for other waits
    //can slow down the test
    //will wait till the maximim value of timeout
}
