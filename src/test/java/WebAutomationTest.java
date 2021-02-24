import org.testng.annotations.Test;

import java.io.UnsupportedEncodingException;

public class WebAutomationTest extends BaseClass {

    @Test
    public void webAutomationTest() throws Exception {

        WilliamHillHomePagePO homePage = new WilliamHillHomePagePO(driver);

        goToUrl("https://sports.williamhill.com/betting/en-gb");
        homePage.waitForPageToLoad();
        homePage.checkIfJoinButtonIsDisplayed();
        homePage.changeLanguage("日本語");
    }
}
