import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginTests {

    WebDriver driver;

    @BeforeMethod
    public void beforeMethod(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\slynko_y\\IdeaProjects\\qaauto-5.02.2019\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.linkedin.com/");
    }

    @AfterMethod
    public void afterMethod(){
        driver.quit();
    }

    @DataProvider
    public Object[][] ValidData() {
        return new Object[][]{
                {"valerii.ant@meta.ua", "Val_123456"},
                {"valerii.ANT@meta.ua", "Val_123456"},
                {" valerii.ant@meta.ua ", "Val_123456"}
        };
    }

    @Test(dataProvider = "ValidData")
    public void successfulLoginTest(String userEmail, String userPassword) {
        LandingPage landingPage = new LandingPage(driver);
        Assert.assertTrue(landingPage.isPageLoaded(), "Landing page is not loaded.");

        landingPage.login(userEmail, userPassword);

        HomePage homePage = new HomePage(driver);
        Assert.assertTrue(homePage.isPageLoaded(), "Home page is not loaded.");
    }

    @DataProvider
    public Object[][] InvalidData() {
        return new Object[][]{
                {"valerii.ant@", "1", "Hmm, we don't recognize that email. Please try again."},
                {"valerii.ant", "1", "Please enter a valid email address."},
                {"380905550055", "1", "Be sure to include \"+\" and your country code."}
        };
    }

    @Test(dataProvider = "InvalidData")
    public void negativeLoginTest(String userEmail, String userPassword, String alertMessage) {
        LandingPage landingPage = new LandingPage(driver);
        Assert.assertTrue(landingPage.isPageLoaded(), "Landing page is not loaded.");

        landingPage.login(userEmail, userPassword);

        LoginSubmit loginSubmit = new LoginSubmit(driver);
        Assert.assertTrue(loginSubmit.isPageLoaded(), "Login submit page is not loaded.");

        loginSubmit.passwordErrorMessageBlock.getText().equals(alertMessage);


        /*Assert.assertEquals(loginSubmit.passwordErrorMessageBlock.getText(),
                "Hmm, we don't recognize that email. Please try again.",
                "Wrong validation message text for 'login' field");

        Assert.assertEquals(loginSubmit.passwordErrorMessageBlock.getText(),
                "Please enter a valid email address.",
                "Wrong validation message text for 'login' field");
*/
    }
}