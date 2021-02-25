import org.testng.annotations.Test;

public class WebAutomationTest extends BaseClass {

    @Test
    public void changeLanguageToAnother() {

        /*
        Test zmiany jezyka strony wraz z weryfikacja przycisku JOIN
        1. Przejscie na strone glowna William Hill
        2. Oczekiwanie na zaladowanie strony
        3. Sprawdzenie czy przycisk JOIN jest widoczny
        4. Klikniecie w liste zawierajaca jezyki
        5. Zmiana jezyka na niemiecki
        6. Weryfikacja czy przycisk JOIN jest w jezyku niemieckim
        7. Zmiana jezyka na japonski
        8. Weryfikacja czy przycisk JOIN jest w jezyku japonskim
        9. Zmiana na jezyk grecki
        10. Weryfikacja czy przycisk JOIN jest w jezyku greckim
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
