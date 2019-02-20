import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
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

    @Test
    public void successfulLoginTest() {
        LandingPage landingPage = new LandingPage(driver);
        landingPage.login("valerii.ant@meta.ua", "Val_123456");

        HomePage homePage = new HomePage(driver);

        Assert.assertTrue(homePage.isProfileMenuItemDisplayed(), "profileMenuItem is not displayed on Home page.");
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.linkedin.com/feed/", "Home page URL is not correct");
    }

    @Test
    public void negativeLoginTest() {
        LandingPage landingPage = new LandingPage(driver);
        landingPage.login("valerii.ant@meta.ua", "1");

        LoginSubmit loginSubmit = new LoginSubmit(driver);

        Assert.assertTrue(loginSubmit.isErrorMessageDisplayed(), "passwordErrorMessageBlock is not displayed on the page");
        Assert.assertEquals(loginSubmit.passwordErrorMessageBlock.getText(),
                "Hmm, that's not the right password. Please try again or request a new one.",
                "Wrong validation message text for 'password' field");

    }
}