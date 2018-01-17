import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LandingPage;
import pages.LoginPage;

import static com.codeborne.selenide.Condition.hidden;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;


public class SignInTest extends BaseTest {

    private LoginPage loginPage;

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
    }


    @Test
    public void userNotFound() {
        loginPage.fillUserInfoField("16@list.ru", "111111");
        loginPage.agreeToLoginButton();
        loginPage.backHomeButton.shouldBe(hidden);
        loginPage.errorMessage.shouldBe(visible);
    }
}
