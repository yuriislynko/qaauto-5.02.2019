package test;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import page.HomePage;
import page.LoginSubmit;

public class LoginTests extends BaseTest {

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

        /*page.LoginSubmit loginSubmit = landingPage.login(userEmail, userPassword, page.LoginSubmit.class);*/
        LoginSubmit loginSubmit = landingPage.login(userEmail, userPassword);

        Assert.assertTrue(loginSubmit.isPageLoaded(), "Login submit page is not loaded.");
        Assert.assertEquals(loginSubmit.getUserEmailValidationText(), alertUserMessage,
                "Login is incorrect");
        Assert.assertEquals(loginSubmit.getUserPasswordValidationText(), alertPasswordMessage,
                "Password is incorrect");
    }
}