import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AddCollectionPage;
import pages.DeleteCollectionPage;
import pages.LandingPage;
import pages.LoginPage;
import pages.ProfilePage;


public class DeleteCollectionTest extends BaseTest {

    @BeforeMethod
    public void createBeforeDeleting() {
        LoginPage loginPage = new LoginPage();
        loginPage.fillUserInfoField("izi_er@bk.ru", "iop115a");
        LandingPage landingPage = loginPage.agreeToLoginButton();
        AddCollectionPage newcollection = landingPage.clickOnProfileLink();
        newcollection.makeAddCollectionButtonVisible();
        newcollection.clickOnNewCreateCollectionButton();
        newcollection.fillCollectionTitleField("Test collection");
        newcollection.clickOnCreateCollectionButton();
        landingPage.clickOnProfileLink();
    }


    @Test
    public void deleteCollection() {
        ProfilePage profilePage = new ProfilePage();
        profilePage.clickOnListOfCollectionsButton();
        DeleteCollectionPage delete = new DeleteCollectionPage();
        delete.clickOnTitleCollectionName();
        delete.clickOnEditCollectionButton();
        delete.clickOnDeleteCollectionButton();
        delete.clickOnAgreeToDeleteButton();
        delete.checkThatCollectionIsDeleted("Test collection");
    }
}