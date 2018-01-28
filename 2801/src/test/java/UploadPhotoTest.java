import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LandingPage;
import pages.LoginPage;
import pages.UploadPhotoPage;


public class UploadPhotoTest extends BaseTest {

    @BeforeMethod
    public void loginRealUser() {
        LoginPage loginPage = new LoginPage();
        loginPage.fillUserInfoField("izi_er@bk.ru", "iop115a");
        LandingPage landingPage = loginPage.agreeToLoginButton();
    }


    @Test
    public void uploadPhoto() {
        UploadPhotoPage photo = new UploadPhotoPage();
        photo.clickOnSubmitPhotoButton();
        photo.clickOnAddPhotoButton();
        photo.uploadFilePhoto();
        photo.addTagesToPhoto(new String[]{"zzz", "yyyy", "xxxx"});
        photo.writeStoryAboutPhoto("test title", "test story");
        photo.selectedNoLocationCheckBox();
        photo.checkThatPhotoIsUpload("Thank you");
    }

}
