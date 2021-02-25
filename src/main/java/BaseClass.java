import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class BaseClass {

    WebDriver driver;
    String URL = "https://sports.williamhill.com/betting/en-gb";

    protected WebDriver goToUrl(String url) {

        driver.navigate().to(url);
        System.out.println("Url:" + url);
        return driver;
    }

    @BeforeMethod
    protected void beforeMethod() {

        String chromeDriverPath = System.getProperty("user.dir");
        String os = System.getProperty("os.name").toLowerCase();
        System.out.println(chromeDriverPath);
        System.out.println(os);
        if(os.contains("linux")) {
            System.setProperty("webdriver.chrome.driver", chromeDriverPath + "/chromedriverlinux");
        }
        else if(os.contains("mac")) {
            System.setProperty("webdriver.chrome.driver", chromeDriverPath + "/chromedrivermac");
        }
        else {
            System.setProperty("webdriver.chrome.driver", chromeDriverPath + "\\chromedriver.exe");
        }
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);
        System.out.println("------------------------------");
        System.out.println("THE AUTOMATIC TEST HAS STARTED");
        System.out.println("------------------------------");
        goToUrl(URL);
    }

    @AfterMethod
    protected void afterMethod() {

        System.out.println("------------------------------");
        System.out.println("THE AUTOMATIC TEST IS COMPLETE");
        System.out.println("------------------------------");
//        driver.manage().deleteAllCookies();
//        driver.close();
//        driver.quit();
    }
}
