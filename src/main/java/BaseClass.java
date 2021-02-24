import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.HashMap;
import java.util.Map;

public class BaseClass {

    WebDriver driver;

    protected WebDriver goToUrl(String url) {

        driver.navigate().to(url);
        System.out.println("Url:" + url);
        return driver;
    }

    @BeforeMethod
    protected void beforeMethod() {

        String chromeDriverPath = System.getProperty("user.dir");
        System.out.println(chromeDriverPath);
        System.out.println(System.getProperty("os.name"));
        if(System.getProperty("os.name").contains("Linux")) {
            System.setProperty("webdriver.chrome.driver", chromeDriverPath + "/chromedriverlinux");
        }
        else {
            System.setProperty("webdriver.chrome.driver", chromeDriverPath + "\\chromedriver.exe");
        }
        ChromeOptions options = new ChromeOptions();
//        options.addArguments("intl.accept_languages", "ja-jp,ja");
        driver = new ChromeDriver(options);
        System.out.println("------------------------------");
        System.out.println("THE AUTOMATIC TEST HAS STARTED");
        System.out.println("------------------------------");

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
