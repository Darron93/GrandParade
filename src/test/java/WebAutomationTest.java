import org.testng.annotations.Test;

public class WebAutomationTest extends BaseClass {

    @Test
    public void changeLanguageToAnother() {

        /*
        Page language change test with JOIN button verification
        1. Go to William Hill home page
        2. Waiting for the page to load
        3. Check if the JOIN button is visible
        4. Click on the list of languages
        5. Change of language to German
        6. Verification if the JOIN button is in the German language
        7. Changing the language to Japanese
        8. Verification if the JOIN button is in Japanese
        9. Change to Greek
        10. Verification if the JOIN button is in Greek
         */

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
