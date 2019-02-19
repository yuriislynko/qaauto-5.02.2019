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

        WebElement userEmailField = driver.findElement(By.xpath("//input[@id='login-email']"));
        WebElement userPasswordField = driver.findElement(By.xpath("//input[@id='login-password']"));
        WebElement signInButton = driver.findElement(By.xpath("//input[@id='login-submit']"));

        userEmailField.sendKeys("valerii.ant@meta.ua");
        userPasswordField.sendKeys("Val_123456");
        signInButton.click();

        WebElement profileMenuItem = driver.findElement(By.xpath("//li[@id='profile-nav-item']"));

        profileMenuItem.isDisplayed();
        Assert.assertTrue(profileMenuItem.isDisplayed(), "profileMenuItem is not displayed on Home page.");
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.linkedin.com/feed/", "Home page URL is not correct");
    }
    //Home_assignment
    @Test (priority = 1)
    public void negativeSymbolsLoginTest(){

        WebElement userEmailField = driver.findElement(By.xpath("//input[@id='login-email']"));
        WebElement userPasswordField = driver.findElement(By.xpath("//input[@id='login-password']"));
        WebElement signInButton = driver.findElement(By.xpath("//input[@id='login-submit']"));

        userEmailField.sendKeys("valerii.ant");
        userPasswordField.sendKeys("1");
        signInButton.click();

        WebElement alertMessage = driver.findElement(By.xpath("//div[@id='error-for-username']"));
        String textAlert = alertMessage.getText();
        Assert.assertEquals(textAlert, "Please enter a valid email address.", "Message is not correct");
    }

    @Test (priority = 2)
    public void negativeDigitsLoginTest(){

        WebElement userEmailField = driver.findElement(By.xpath("//input[@id='login-email']"));
        WebElement userPasswordField = driver.findElement(By.xpath("//input[@id='login-password']"));
        WebElement signInButton = driver.findElement(By.xpath("//input[@id='login-submit']"));

        userEmailField.sendKeys("380955000102");
        userPasswordField.sendKeys("1");
        signInButton.click();

        WebElement alertMessage = driver.findElement(By.xpath("//div[@id='error-for-username']"));
        String textAlert = alertMessage.getText();
        Assert.assertEquals(textAlert, "Be sure to include \"+\" and your country code.", "Message is not correct");
    }

    @Test (priority = 3)
    public void negativeEmailLoginTest(){

        WebElement userEmailField = driver.findElement(By.xpath("//input[@id='login-email']"));
        WebElement userPasswordField = driver.findElement(By.xpath("//input[@id='login-password']"));
        WebElement signInButton = driver.findElement(By.xpath("//input[@id='login-submit']"));

        userEmailField.sendKeys("valerii.ant@");
        userPasswordField.sendKeys("1");
        signInButton.click();

        WebElement alertMessage = driver.findElement(By.xpath("//div[@id='error-for-username']"));
        String textAlert = alertMessage.getText();
        Assert.assertEquals(textAlert, "Hmm, we don't recognize that email. Please try again.", "Message is not correct");
    }

    @Test (priority = 4)
    public void negativePassTest(){

        WebElement userEmailField = driver.findElement(By.xpath("//input[@id='login-email']"));
        WebElement userPasswordField = driver.findElement(By.xpath("//input[@id='login-password']"));
        WebElement signInButton = driver.findElement(By.xpath("//input[@id='login-submit']"));

        userEmailField.sendKeys("valerii.ant@meta.ua");
        userPasswordField.sendKeys("1");
        signInButton.click();

        WebElement alertMessage = driver.findElement(By.xpath("//div[@id='error-for-password']"));
        String textAlert = alertMessage.getText();
        Assert.assertEquals(textAlert, "Hmm, that's not the right password. Please try again or request a new one.", "Message is not correct");
    }
}