package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byLinkText;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;

public class LandingPage {

    public SelenideElement
            loginMainButton = $(byLinkText("Login")),
            joinButton=$(byLinkText("Join free")),
     //       profileLink = $x("//div[./a[@href = '/@izyaz']]"),
            linkOnCollections=$("[data-test='user-nav-link-collections']");

    public LandingPage() {
        open("/");
    }

    public LoginPage clickOnLoginButton() {
        loginMainButton.click();
        return new LoginPage();
    }

    public ProfilePage clickOnProfileLink() {
      actions().click($("#app > div > header > nav > div.aApNa > div.ODWzM._1N39c > a")).build().perform();
    return new ProfilePage();
    }

    public RegistrationPage clickOnJoinButton() {
        joinButton.click();
        return new RegistrationPage();
    }



}
