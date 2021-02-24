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

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class WilliamHillHomePagePO {

    @FindBy(xpath = "//button[@data-test-id='@sitebase/registration-button_pi-header__registration-button']/span")
    WebElement joinButton;

    @FindBy(xpath = "//span[@class='sb-header-logo__image']")
    WebElement williamHillLogo;

    @FindBy(xpath = "//img[contains(@alt, 'Flag')]")
    WebElement languageButton;

    @FindAll({@FindBy(xpath = "//span[@class='sb-header-drawer-item__name']")})
    List<WebElement> languageList;

    @FindBy(xpath = "//*[@id='@sportsbook/sub-nav-end-language-menu-ja-jp']")
    WebElement japaneseLanguage;

    @FindBy(xpath = "//*[@id='@sportsbook/sub-nav-end-language-menu-el-gr']")
    WebElement greekLanguage;

    @FindBy(xpath = "//*[@id='@sportsbook/sub-nav-end-language-menu-de-de']")
    WebElement deutschLanguage;


    WebDriver driver;

    public WilliamHillHomePagePO(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void waitForPageToLoad() {
        System.out.println("Wait for the page to load");
        waitForVisible(driver, williamHillLogo, 30);
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

    public void checkLanguageAndChoose(WebElement languageElement, String languageLabel) {
        System.out.println("Wait for language");
        waitForVisible(driver, languageElement);
        try {
            assertEquals(languageElement.getText(), languageLabel);
            System.out.println("Properly language: " + languageLabel + ", Language on list: " + languageElement.getText());
            System.out.println("PASSED");
        }catch(AssertionError ar) {
            System.out.println("Properly language: " + languageLabel + ", Language on list: " + languageElement.getText());
            System.out.println("FAILED");
            assertTrue(2<1);
        }
        System.out.println("Click on language");
        languageElement.click();
        waitForPageToLoad();
    }

    public void verifyButtonLanguage(WebElement buttonElement, String languageButton) {
        System.out.println("Wait for button");
        waitForVisible(driver, buttonElement);
        try {
            assertEquals(buttonElement.getText(), languageButton);
            System.out.println("Properly language: " + languageButton + ", Language on button: " + buttonElement.getText());
            System.out.println("PASSED");
        }catch(AssertionError ar) {
            System.out.println("Properly language: " + languageButton + ", Language on button: " + buttonElement.getText());
            System.out.println("FAILED");
            assertTrue(2<1);
        }
        System.out.println("-----------------------");
    }

    public void clickOnTheLanguageList() {
        System.out.println("Click on the language list");
        languageButton.click();
    }

    public void changeLanguageAndVerify(String language) {

        switch (language){
            case"Japanese":
                checkLanguageAndChoose(japaneseLanguage, "日本語");
                verifyButtonLanguage(joinButton, "登録");
                break;
            case"German":
                checkLanguageAndChoose(deutschLanguage, "Deutsch");
                verifyButtonLanguage(joinButton, "Anmelden");
                break;
            case"Greek":
                checkLanguageAndChoose(greekLanguage, "Ελληνική");
                verifyButtonLanguage(joinButton, "Εγγραφή");
                break;
        }
    }

    public void waitForVisible(WebDriver driver, WebElement element, int timeInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, timeInSeconds);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForVisible(WebDriver driver, WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
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
