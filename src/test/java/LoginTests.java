import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginTests {

    WebDriver driver;
    LandingPage landingPage;

    @BeforeMethod
    public void beforeMethod(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\slynko_y\\IdeaProjects\\qaauto-5.02.2019\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.linkedin.com/");
        landingPage = new LandingPage(driver);
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
        Assert.assertTrue(landingPage.isPageLoaded(), "Landing page is not loaded.");

        HomePage homePage = landingPage.login(userEmail, userPassword, HomePage.class);
        Assert.assertTrue(homePage.isPageLoaded(), "Home page is not loaded.");
    }

    @DataProvider
    public Object[][] InvalidData() {
        return new Object[][]{
                {"valerii.ant@", "pass", "Hmm, we don't recognize that email. Please try again.", ""},
                {"valerii.ant", "pass", "Please enter a valid email address.", ""},
                {"380905550055", "pass", "Be sure to include \"+\" and your country code.", ""},
                {"valerii.ant@meta.ua", "pass", "", "Hmm, that's not the right password. Please try again or request a new one."}
        };
    }

    @Test(dataProvider = "InvalidData")
    public void negativeLoginTest(String userEmail,
                                  String userPassword,
                                  String alertUserMessage,
                                  String alertPasswordMessage) {
        Assert.assertTrue(landingPage.isPageLoaded(), "Landing page is not loaded.");

        //landingPage.login(userEmail, userPassword);

        //LoginSubmit loginSubmit = landingPage.loginToLoginSubmit(userEmail, userPassword);
        LoginSubmit loginSubmit = landingPage.login(userEmail, userPassword, LoginSubmit.class);

        Assert.assertTrue(loginSubmit.isPageLoaded(), "Login submit page is not loaded.");
        Assert.assertEquals(loginSubmit.getUserEmailValidationText(), alertUserMessage,
                "Login is incorrect");
        Assert.assertEquals(loginSubmit.getUserPasswordValidationText(), alertPasswordMessage,
                "Password is incorrect");
    }
}