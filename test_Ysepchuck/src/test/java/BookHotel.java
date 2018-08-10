import com.google.common.io.Files;
import org.junit.After;
import org.junit.Before;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.Date;
import java.io.File;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.*;
import static org.openqa.selenium.OutputType.*;

public class BookHotel {
    ChromeDriver wd;


    @Before
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", "/Users/vladimir/Documents/chromedriver");
        wd = new ChromeDriver();
        getTimeouts();
        System.setProperty(ChromeDriverService.CHROME_DRIVER_LOG_PROPERTY, System.getProperty("Users/vladimir/Documents/") + "/target/chromedriver.log");
        System.setProperty(ChromeDriverService.CHROME_DRIVER_EXE_PROPERTY, System.getProperty("Users/vladimir/Documents/") + "/driver/chromedriver.exe");
        ChromeDriverService service = new ChromeDriverService.Builder()
                .usingAnyFreePort()
                .withVerbose(true)
                .build();
        service.start();
    }

    
    @Test
    public void BookHotel() {
        wd.get("http://knickerbocker-hotel-new-york.nochi.com/?btest=119");
        JavascriptExecutor je =(JavascriptExecutor)wd;
        je.executeScript("arguments[0].scrollIntoView(true);",wd.findElement(By.xpath("//*[@id=\"container\"]/div/div/div/div[4]/ul/li[1]/a")));
        wd.findElement(By.xpath("//*[@id=\"container\"]/div/div/div/div[4]/ul/li[1]/a")).click();
        screen();
        wd.findElement(By.xpath("//*[@id=\"container\"]/div/div/div/div[5]/div[3]/div[1]/div/div/ul/li[2]/a")).click();
        screen();
        wd.findElement(By.xpath("//*[@id=\"container\"]/div/div/div/div[5]/div[3]/div[1]/div/div/ul/li[3]/a")).click();
        screen();
        wd.findElement(By.xpath("//*[@id=\"container\"]/div/div/div/div[5]/div[3]/div[1]/div/div/ul/li[4]/a")).click();
        screen();
        wd.findElement(By.xpath("//*[@id=\"container\"]/div/div/div/div[5]/div[3]/div[1]/div/div/ul/li[5]/a")).click();
        screen();
        wd.findElement(By.xpath("//*[@id=\"container\"]/div/div/div/div[5]/div[3]/div[1]/div/div/div/button")).click();
        getTimeouts();
        wd.findElement(By.xpath("//*[@id=\"container\"]/div/div/div/div[5]/div[3]/div[2]/div/form/div[1]/div[3]/div[1]/div/span/span[2]")).click();
        wd.findElement(By.xpath("//*[@id=\"container\"]/div/div/div/div[5]/div[3]/div[2]/div/form/div[2]/div[2]/table[2]/thead/tr[1]/th[3]/span/svg")).click();
        wd.findElement(By.xpath("//*[@id=\"container\"]/div/div/div/div[5]/div[3]/div[2]/div/form/div[2]/div[2]/table[2]/thead/tr[1]/th[3]/span/svg")).click();
        wd.findElement(By.xpath("//*[@id=\"container\"]/div/div/div/div[5]/div[3]/div[2]/div/form/div[2]/div[2]/table[2]/thead/tr[1]/th[3]/span/svg")).click();
        wd.findElement(By.xpath("//*[@id=\"container\"]/div/div/div/div[5]/div[3]/div[2]/div/form/div[2]/div[2]/table[2]/tbody/tr[4]/td[5]/div")).click();
        wd.findElement(By.xpath("//div[@class='h-page__container']/div/div[5]/div[3]/div[2]/div/form/div[1]/div[3]/div[3]/div[2]/div/div[1]/div/div[2]/div[1]/div[2]/div[2]/div[3]")).click();
        if (!wd.findElement(By.xpath("//div[@class='h-page__container']//select[.='—<112345678910111213141516']//option[4]")).isSelected()) {
            wd.findElement(By.xpath("//div[@class='h-page__container']//select[.='—<112345678910111213141516']//option[4]")).click();
        }
        if (!wd.findElement(By.xpath("//div[@class='h-page__container']/div/div[5]/div[3]/div[2]/div/form/div[1]/div[3]/div[3]/div[2]/div/div[1]/div/div[2]/div[2]/div[2]/select[2]//option[12]")).isSelected()) {
            wd.findElement(By.xpath("//div[@class='h-page__container']/div/div[5]/div[3]/div[2]/div/form/div[1]/div[3]/div[3]/div[2]/div/div[1]/div/div[2]/div[2]/div[2]/select[2]//option[12]")).click();
        }
        wd.findElement(By.xpath("//div[@class='h-page__container']/div/div[5]/div[3]/div[2]/div/form/div[1]/div[2]/div/div[2]/button[2]")).click();
        wd.findElement(By.xpath("//ul[@class='location-tabs-wrapper']//li[normalize-space(.)='Поблизости']")).click();
        wd.findElement(By.xpath("//div[@class='room-blank__rates']/div[4]/div[4]/button")).click();
    }

    private void screen() {
        File tmp =((TakesScreenshot)wd).getScreenshotAs(OutputType.FILE);
        File screen = new File("screen-"+ System.currentTimeMillis()+".png");
        try {
            Files.copy(tmp, screen);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private WebDriver.Timeouts getTimeouts() {
        return wd.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
    }

    @After
    public void tearDown() {
        wd.quit();
    }
    
    public static boolean isAlertPresent(FirefoxDriver wd) {
        try {
            wd.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }
}
