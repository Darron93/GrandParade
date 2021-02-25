import org.testng.annotations.Test;

public class WebAutomationTest extends BaseClass {

    @Test
    public void changeLanguageToAnother() {

        WilliamHillHomePagePO homePage = new WilliamHillHomePagePO(driver);

        homePage.waitForPageToLoad();
        homePage.checkIfJoinButtonIsDisplayed();
        homePage.clickOnTheLanguageList();
        homePage.changeLanguageAndVerify("German");
        homePage.checkIfJoinButtonIsDisplayed();
        homePage.clickOnTheLanguageList();
        homePage.changeLanguageAndVerify("Japanese");
        homePage.checkIfJoinButtonIsDisplayed();
        homePage.clickOnTheLanguageList();
        homePage.changeLanguageAndVerify("Greek");
    }
}
