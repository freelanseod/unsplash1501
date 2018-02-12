import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AddCollectionPage;
import pages.DeleteCollectionPage;
import pages.LandingPage;
import pages.LoginPage;
import pages.ProfilePage;


public class DeleteCollectionTest extends BaseTest {
    private ProfilePage profilePage;

    @BeforeMethod
    public void createBeforeDeleting() {
        LoginPage loginPage = new LoginPage();
        loginPage.fillUserInfoField("zaloz@bk.ru", "123456");
        LandingPage landingPage = loginPage.agreeToLoginButton();
        AddCollectionPage collection = new AddCollectionPage();
        collection.makeAddCollectionButtonVisible();
        collection.clickOnNewCreateCollectionButton();
        collection.fillCollectionTitleField("Test collection");
        collection.clickOnCreateCollectionButton();
    }


    @Test
    public void deleteCollection() {
        LandingPage landingPage = new LandingPage();
        profilePage = landingPage.clickOnProfileLink();
        profilePage.clickOnListOfCollectionsButton();
        DeleteCollectionPage delete = new DeleteCollectionPage();
        delete.clickOnTitleCollectionName();
        delete.clickOnEditCollectionButton();
        delete.clickOnDeleteCollectionButton();
        delete.clickOnAgreeToDeleteButton();
        delete.checkThatCollectionIsDeleted("Test collection");
    }
}