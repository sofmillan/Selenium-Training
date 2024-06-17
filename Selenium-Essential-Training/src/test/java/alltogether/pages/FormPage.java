package alltogether.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class FormPage {
    public static void submitForm(WebDriver driver){
        driver.findElement(By.id("first-name")).sendKeys("Ricky");
        driver.findElement(By.id("last-name")).sendKeys("Shen");
        driver.findElement(By.id("job-title")).sendKeys("Singer");
        driver.findElement(By.id("radio-button-1")).click();
        driver.findElement(By.id("checkbox-1")).click();
        driver.findElement(By.cssSelector("option[value='1']")).click();
        driver.findElement(By.id("datepicker")).sendKeys("05/20/2025");
        driver.findElement(By.id("datepicker")).sendKeys(Keys.RETURN); //close the datepicker
        driver.findElement(By.cssSelector(".btn.btn-lg.btn-primary")).click();
    }
}
