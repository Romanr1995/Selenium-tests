package ru.stqa.tests.selenium;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MyFirstTest {

    private WebDriver driver;
    private WebDriverWait wait;

    @Before
    public void start() {
        driver = new ChromeDriver(new ChromeDriverService.Builder().withVerbose(true).build());
        wait = new WebDriverWait(driver, 10);
    }

    @Test
    public void myFirstTest() {
        try {
            driver.get("http://localhost/litecart/admin/");
            driver.findElement(By.name("username")).sendKeys("admin");
            driver.findElement(By.name("password")).sendKeys("admin");
            driver.findElement(By.name("login")).click();
        } catch (Exception e) {
            stop();
        }
    }

    @After
    public void stop() {
        driver.quit();
        driver = null;
    }
}
