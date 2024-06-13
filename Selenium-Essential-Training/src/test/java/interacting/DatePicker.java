package interacting;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DatePicker {
    public static void main(String[] args) {
        ChromeOptions options = new ChromeOptions();
        options.setBinary("C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe");
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://formy-project.herokuapp.com/datepicker");

        WebElement dateField = driver.findElement(By.id("datepicker"));
        dateField.sendKeys("20/07/2025");
        dateField.sendKeys(Keys.RETURN);
        driver.quit();
    }
}
