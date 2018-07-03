package com.app;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class FaceBookTest {
    FirefoxDriver wd;
    
    @BeforeMethod
    public void setUp() throws Exception {
        System.setProperty("webdriver.gecko.driver", "/Users/vladimir/Documents/geckodriver");
        wd = new FirefoxDriver();
        wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }
    
    @Test
    public void FaceBookTest() {
        wd.get("https://www.facebook.com/");
        wd.findElement(By.id("email")).click();
        wd.findElement(By.id("email")).clear();
        wd.findElement(By.id("email")).sendKeys("");
        wd.findElement(By.id("pass")).click();
        wd.findElement(By.id("pass")).clear();
        wd.findElement(By.id("pass")).sendKeys("");
        wd.findElement(By.id("u_0_2")).click();
        wd.findElement(By.className("linkWrap noCount")).click();
        wd.findElement(By.name("q")).click();
        wd.findElement(By.cssSelector("input._58al")).click();
        wd.findElement(By.xpath("//div[@class='_1nq2']/span[1]/div/div/div[2]/ul/li/a/div/div[2]/div/div")).click();
        wd.findElement(By.cssSelector("div._1mf._1mj")).click();
        wd.findElement(By.id("js_e6")).click();
    }
    
//    @AfterMethod
//    public void tearDown() {
//        wd.quit();
//    }
//
//    public static boolean isAlertPresent(FirefoxDriver wd) {
//        try {
//            wd.switchTo().alert();
//            return true;
//        } catch (NoAlertPresentException e) {
//            return false;
//        }
//    }
}
