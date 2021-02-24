import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.UnsupportedEncodingException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.testng.Assert.assertTrue;

public class WilliamHillHomePagePO {

    @FindBy(xpath = "//span[contains(text(),'Join')]")
    WebElement joinButton;

    @FindBy(xpath = "//span[@class='sb-header-logo__image']")
    WebElement williamHillLogo;

    @FindBy(xpath = "//img[contains(@alt, 'Flag')]")
    WebElement languageButton;

    @FindAll({@FindBy(xpath = "//span[@class='sb-header-drawer-item__name']")})
    List<WebElement> languageList;



    WebDriver driver;

    public WilliamHillHomePagePO(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void waitForPageToLoad() {
        System.out.println("Wait for the page to load");
        waitForVisible(driver, williamHillLogo, 20);
    }

    public void checkIfJoinButtonIsDisplayed() {

        if(elementIsDisplayed(joinButton)) {
            System.out.println("Join button is displayed properly");
            assertTrue(2>1);
        }else {
            System.out.println("Join button is not displayed properly");
            assertTrue(2<1);
        }
    }

    public void changeLanguage(String language) {

        System.out.println("Click on the language list");
        languageButton.click();
        for(WebElement e : languageList) {
            if(e.getText().contains(language)) {
                System.out.println("Choose language to: " + language);
                waitForVisible(driver, e, 5);
                e.click();
                break;
            }
            else {
                System.out.println("Not Recognize the language: " + language);
                assertTrue(2<1);
            }
        }
    }

    public void waitForVisible(WebDriver driver, WebElement element, int timeInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, timeInSeconds);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public boolean elementIsDisplayed(WebElement element) {
        try {
           element.isDisplayed();
           return true;
        }catch(NoSuchElementException e) {
            return false;
        }
    }

}
