package usingwebdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SwitchToActiveWindow {
    public static void main(String[] args) {
        ChromeOptions options = new ChromeOptions();
        options.setBinary("C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe");
        WebDriver driver = new ChromeDriver(options);

        driver.get("https://formy-project.herokuapp.com/switch-window");

        WebElement newTab = driver.findElement(By.id("new-tab-button"));
        newTab.click();

        String originalHandle = driver.getWindowHandle();
        System.out.println(driver.getWindowHandles());
        for (String handle1:driver.getWindowHandles()) {
            driver.switchTo().window(handle1);
        }

        driver.switchTo().window(originalHandle);

        driver.quit();
    }
}
