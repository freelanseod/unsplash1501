import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.LandingPage;
import pages.LoginPage;
import pages.ProfilePage;

import static com.codeborne.selenide.Condition.hidden;
import static com.codeborne.selenide.Condition.visible;


public class SignInTest extends BaseTest {

    private LoginPage loginPage;

    @BeforeClass
    public void beforeEach(){
        LandingPage landingPage = new LandingPage();
        loginPage = landingPage.clickOnLoginButton();
    }

    @Test
    public void userCanLogin() {
        loginPage.fillUserInfoField("vicroft@mail.ru", "iop115a");
        loginPage.agreeToLoginButton();
        loginPage.homeButton.shouldBe(visible);
        /*
        ProfilePage profilePage = new ProfilePage();
        profilePage.clickOnListOfCollectionsButton();
        profilePage.clickOnMoreOptions();
        profilePage.clickOnLogOutButton();
        */
    }


    @Test
    public void userNotFound() {
        loginPage.fillUserInfoField("16@list.ru", "111111");
        loginPage.agreeToLoginButton();
        loginPage.backHomeButton.shouldBe(hidden);
        loginPage.errorMessage.shouldBe(visible);
    }
}
