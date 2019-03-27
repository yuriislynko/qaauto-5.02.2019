package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.Thread.sleep;

public class ResetPasswordLinkPage {
    private WebDriver driver;

    @FindBy(xpath = "//form[@id='sendemail-form']")
    private WebElement sendEmailForm;
    private String message;

    public ResetPasswordLinkPage(WebDriver driver, String message) {
        this.driver = driver;
        this.message = message;
        PageFactory.initElements(driver, this);
    }

    public boolean isPageLoaded() {
        return sendEmailForm.isDisplayed()
                && driver.getCurrentUrl().contains("/request-password-reset-submit");
                /*&& driver.getTitle().contains("Please check your mail for reset password link.  | LinkedIn");*/
                //&& driver.getTitle().contains("Please check your mail for reset password link");
    }

    public String getLink ()
    {

        List<String> linksList = new ArrayList<String>();
        String urlRegex = "((https?|ftp|gopher|telnet|file):((\\/\\/)|(\\\\))+[\\w\\d:#@%\\/;$()~_?\\+-=\\\\\\.&]*)";
        Pattern pattern = Pattern.compile(urlRegex, Pattern.CASE_INSENSITIVE);
        Matcher urlMatcher = pattern.matcher(this.message);

        while (urlMatcher.find())
        {
            linksList.add(this.message.substring(urlMatcher.start(0), urlMatcher.end(0)));
        }

        for (String str: linksList) {


            if (str.contains("sig="))

                return str.replace("amp;","");
        }

        return "";

    }


    public ChooseNewPasswordPage getResetLink (String resetLink) {
        /*try {
            sleep(180000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        String link = this.getLink();
        driver.get(resetLink);
        return new ChooseNewPasswordPage(driver);
    }
}


