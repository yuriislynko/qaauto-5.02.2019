package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import page.*;

import static java.lang.Thread.sleep;

public class PasswordResetTest extends BaseTest {

    @Test
    public void successfulPasswordResetTest () {
        String userEmail = "michael.orekh@gmail.com";

        //1
        Assert.assertTrue(landingPage.isPageLoaded(), "Landing page is not loaded.");

        //2
        ResetPasswordPage resetPasswordPage = landingPage.clickForgotPassword ();
        Assert.assertTrue(resetPasswordPage.isPageLoaded(), "Reset Password page is not loaded.");

        //3
        ResetPasswordLinkPage resetPasswordLinkPage = resetPasswordPage.enterEmail(userEmail);
        /*try {
            sleep(120000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assert.assertTrue(resetPasswordLinkPage.isPageLoaded(), "Reset Password Link Page is not loaded");

        //4
        ChooseNewPasswordPage chooseNewPasswordPage = resetPasswordLinkPage.getResetLink("https://www.linkedin.com/e/v2?e=bvbs27-jtphrnha-uo&lipi=urn%3Ali%3Apage%3Aemail_security_password_reset_checkpoint%3BAbYhyWKJS8uXj5xP1iGreg%3D%3D&a=checkpoint-password-reset&midToken=AQFQPsg72lZL-g&tracking=eml-jav-saved-job&ek=security_password_reset_checkpoint&encryptedEmail=AgEsZ86wkHWGsQAAAWm5BPSPxrhWevksLgzCb4NWvsShrYHYyhR3Bt-O9Lojohnbb9jIjd4&requestSubmissionId=AgFLf2wV5F8ARAAAAWm5BPSXu1npVTv4PqPeLXhDw6EARhH3IcEXqSQXvy1WifGKhuEhZOIBLxDwVezBF5Jd9gDVoO29Xp8-ZuAKtpZ_Xdw&oneTimeToken=-1926451700920554861&_sig=2Nx6ZZtcU16oI1");
        Assert.assertTrue(chooseNewPasswordPage.isPageLoaded(), "Choose New Password Page is not loaded");

        //5
        SuccessfulPasswordResetPage successfulPasswordResetPage = chooseNewPasswordPage.changingPassword("Val_Val1!.1", "Val_Val1!.1");
        Assert.assertTrue(successfulPasswordResetPage.isPageLoaded(), "Successful Password Reset Page is not loaded");

        //6
        HomePage homePage = successfulPasswordResetPage.changingPasswordConfirmation();
        Assert.assertTrue(homePage.isPageLoaded(), "Home Page is not loaded");*/
    }
}
