import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LandingPage;
import pages.RegistrationPage;

import static com.codeborne.selenide.Condition.visible;

public class RegTest extends BaseTest {
    private RegistrationPage registrationPage;

    @BeforeMethod
    public void beforeEach(){
        LandingPage landingPage = new LandingPage();
        registrationPage = landingPage.clickOnJoinButton();
    }

    @Test
    public void userCanSingUp() {
        registrationPage.fillUserName("testname", "testsurname");
        registrationPage.fillUserDate("zseq@bk.ru", "zseqtest");
        registrationPage.fillUserPassword("123456789Q");
        registrationPage.clickOnJoinButton();
        registrationPage.homeButton.shouldBe(visible);
    }



}
