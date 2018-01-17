package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byLinkText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;

public class LandingPage {

    public SelenideElement
            loginMainButton = $(byLinkText("Login")),
            profileLink = $x("//div[./a[@href = '/@izyaz']]");

    public LandingPage() {
        open("/");
    }

    public LoginPage clickOnLoginButton() {
        loginMainButton.click();
        return new LoginPage();
    }

    public AddCollectionPage clickOnProfileLink() {
        profileLink.click();
        return new AddCollectionPage();
    }
}


