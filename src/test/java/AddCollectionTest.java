import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AddCollectionPage;
import pages.LandingPage;
import pages.LoginPage;
import pages.ProfilePage;

public class AddCollectionTest extends BaseTest {
    private ProfilePage profilePage;

    @BeforeMethod
    public void loginRealUser() {
        LoginPage loginPage = new LoginPage();
        loginPage.fillUserInfoField("vicroft@mail.ru", "iop115a");
        LandingPage landingPage = loginPage.agreeToLoginButton();
    }


    @Test
    public void uploadCollection() {
        AddCollectionPage collection = new AddCollectionPage();
        collection.makeAddCollectionButtonVisible();
        collection.clickOnNewCreateCollectionButton();
        collection.fillCollectionTitleField("Test collection");
        collection.fillCollectionDescriptionField("Test description");
        collection.selectedCollectionPrivacyCheckBox();
        collection.clickOnCreateCollectionButton();
        LandingPage landingPage = new LandingPage();
        profilePage = landingPage.clickOnProfileLink();
        profilePage.clickOnListOfCollectionsButton();
        collection.checkThatCollectionIsCreated("Test collection", "Test description");
    }

}


