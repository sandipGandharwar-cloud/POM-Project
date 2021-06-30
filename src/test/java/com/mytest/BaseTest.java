package com.mytest;

import com.mypages.BasePage;
import com.mypages.Page;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import java.util.concurrent.TimeUnit;

public class BaseTest {

    public Page page;
    WebDriver driver;

    @BeforeMethod
    @Parameters(value = {"browser"})
    public void setUp(String browser) {
        if (browser.equals("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
            driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
            System.out.println("chrome browser launched");
//            driver.manage().window().maximize();
        } else if (browser.equals("ff")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
            driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
            driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
            System.out.println("Firefox browser launched");
//            driver.manage().window().maximize();
        } else {
            System.out.println("No browser is defined in xml file....");
        }
        driver.get("https://accounts.lambdatest.com/login");
//        driver.get("https://twitter.com/login");
        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        page = new BasePage(driver);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }


}
