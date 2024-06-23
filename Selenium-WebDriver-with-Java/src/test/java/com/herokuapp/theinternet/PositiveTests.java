package com.herokuapp.theinternet;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PositiveTests {
    @Test
    public void loginTest() throws InterruptedException {
        WebDriver driver = new ChromeDriver();

        String url = "https://the-internet.herokuapp.com/login";
        driver.get(url);

        driver.manage().window().maximize();

        WebElement username = driver.findElement(By.id("username"));
        WebElement password = driver.findElement(By.name("password"));
        WebElement loginButton = driver.findElement(By.tagName("button"));
        WebElement logoutButton = driver.findElement(By.xpath("//a[@class='button secondary radius']"));
        WebElement successMessage = driver.findElement(By.cssSelector("#flash"));
        driver.quit();
    }
}
