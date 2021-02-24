import org.testng.annotations.Test;

import java.io.UnsupportedEncodingException;

public class WebAutomationTest extends BaseClass {

    @Test
    public void webAutomationTest() throws Exception {

        WilliamHillHomePagePO homePage = new WilliamHillHomePagePO(driver);

        goToUrl("日本語");
        homePage.waitForPageToLoad();
        homePage.checkIfJoinButtonIsDisplayed();
        homePage.changeLanguage("日本語");
    }
}
