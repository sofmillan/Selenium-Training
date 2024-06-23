package com.herokuapp.theinternet;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PositiveTests {
    @Test
    public void loginTest() throws InterruptedException {
        WebDriver driver = new ChromeDriver();

        String url = "https://the-internet.herokuapp.com/login";
        driver.get(url);

        driver.manage().window().maximize();

        WebElement username = driver.findElement(By.id("username"));
        username.sendKeys("tomsmith");


        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("SuperSecretPassword!");


        WebElement loginButton = driver.findElement(By.tagName("button"));
        loginButton.click();


        String expectedUrl = "https://the-internet.herokuapp.com/secure";
        String actualUrl = driver.getCurrentUrl();
        assertEquals(expectedUrl, actualUrl, "Actual page url is not the same as expected");


        WebElement logoutButton = driver.findElement(By.xpath("//a[@class='button secondary radius']"));
        assertTrue(logoutButton.isDisplayed());

        WebElement successMessage = driver.findElement(By.className("success"));
        String expectedMessage = "You logged into a secure area!";
        String actualMessage = successMessage.getText();
        assertTrue(actualMessage.contains(expectedMessage), "Actual message does not contain expected message");


        driver.quit();
    }
}
