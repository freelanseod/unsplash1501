import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AddCollectionPage;
import pages.LoginPage;

import static com.codeborne.selenide.Selenide.open;

public class AddCollectionTest extends BaseTest {

    @BeforeMethod
    public void loginRealUser() {
        LoginPage page = new LoginPage();
        page.fillUserInfoField("izi_er@bk.ru", "iop115a");
        page.agreeToLoginButton();
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
        collection.checkThatCollectionIsCreated("Test collection", "Test description");
    }

}


