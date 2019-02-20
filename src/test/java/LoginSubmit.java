import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import sun.security.util.Password;

public class LoginSubmit {
    WebDriver driver;

    WebElement passwordErrorMessageBlock;

    public LoginSubmit (WebDriver driver) {
        this.driver = driver;
        initElement();
    }

    public void initElement (){
        passwordErrorMessageBlock = driver.findElement(By.xpath("//div[@id='error-for-password']"));
    }

    public boolean isErrorMessageDisplayed (){
        return passwordErrorMessageBlock.isDisplayed();
    }
}