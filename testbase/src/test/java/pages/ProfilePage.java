package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byLinkText;
import static com.codeborne.selenide.Selectors.byTitle;
import static com.codeborne.selenide.Selenide.*;

public class ProfilePage {
        SelenideElement
        linkOnCollections=$("[data-test='user-nav-link-collections']"),
        moreOptions = $(byTitle("More")),
        profileTab = $x("//a[@href='/profile']"),
        logOutButton  = $x("//a[@href='/logout']");

  /*
    public ProfilePage() {
        open("/@izyaz");
    }

*/
    public DeleteCollectionPage clickOnListOfCollectionsButton() {
        linkOnCollections.click();
        return new DeleteCollectionPage();
    }

    public void clickOnMoreOptions() {
        moreOptions.click();
    }

    public void clickOnLogOutButton() {
        logOutButton.click();
    }
}
