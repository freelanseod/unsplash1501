import org.testng.annotations.*;
import pages.LandingPage;
import pages.LoginPage;
import pages.ProfilePage;

import static com.codeborne.selenide.Condition.visible;


public class SignInTest extends BaseTest {

    private LoginPage loginPage;
    private ProfilePage profilePage;

    @BeforeMethod
    public void beforeEach(){
       LandingPage landingPage = new LandingPage();
       loginPage = landingPage.clickOnLoginButton();
    }

    @Test
    public void userCanLogin() {
        loginPage.fillUserInfoField("free-lanse516@list.ru", "iop115a");
        loginPage.agreeToLoginButton();
        loginPage.homeButton.shouldBe(visible);
        LandingPage landingPage = new LandingPage();
        profilePage = landingPage.clickOnProfileLink();
        profilePage.clickOnMoreOptions();
        profilePage.clickOnLogOutButton();
    }


    @Test
    public void userNotFound() {
        loginPage.fillUserInfoField("16@list.ru", "111111");
        loginPage.clickonLoginButton();
        loginPage.checkThatUserNotLogin();

    }
}
