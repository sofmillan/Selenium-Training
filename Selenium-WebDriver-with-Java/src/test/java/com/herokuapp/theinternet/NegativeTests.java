package com.herokuapp.theinternet;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class NegativeTests {
    @Test
    public void incorrectUserNameTest(){
        WebDriver driver = new ChromeDriver();

        String url = "https://the-internet.herokuapp.com/login";
        driver.get(url);

        driver.manage().window().maximize();

        WebElement username = driver.findElement(By.id("username"));
        username.sendKeys("ricky");


        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("SuperSecretPassword!");


        WebElement loginButton = driver.findElement(By.tagName("button"));
        loginButton.click();

        WebElement errorMessage = driver.findElement(By.id("flash"));
        String expectedMessage = "Your username is invalid!";
        String actualMessage = errorMessage.getText();
        assertTrue(actualMessage.contains(expectedMessage), "Actual message does not contain expected message");

        driver.quit();
    }

    @Test
    public void incorrectPasswordTest(){
        WebDriver driver = new ChromeDriver();

        String url = "https://the-internet.herokuapp.com/login";
        driver.get(url);

        driver.manage().window().maximize();

        WebElement username = driver.findElement(By.id("username"));
        username.sendKeys("tomsmith");


        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("gguggugi!");


        WebElement loginButton = driver.findElement(By.tagName("button"));
        loginButton.click();

        WebElement errorMessage = driver.findElement(By.id("flash"));
        String expectedMessage = "Your password is invalid!";
        String actualMessage = errorMessage.getText();
        assertTrue(actualMessage.contains(expectedMessage), "Actual message does not contain expected message");

        driver.quit();
    }
}
