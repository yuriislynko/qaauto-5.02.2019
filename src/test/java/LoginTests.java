import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class LoginTests {

    @Test
    public void successfulLoginTest() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\slynko_y\\IdeaProjects\\qaauto-5.02.2019\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.linkedin.com/");

        String loginEmail = "baltimore.1729@meta.ua";
        String loginPassword = "QWErty_10%";

        WebElement searchField;
        searchField = driver.findElement(By.xpath("//input[@id='login-email']"));
        searchField.sendKeys(loginEmail);//Login field filling
        searchField = driver.findElement(By.xpath("//input[@id='login-password']"));
        searchField.sendKeys(loginPassword);//Password field filling
        searchField = driver.findElement(By.xpath("//input[@id='login-submit']"));
        searchField.click();//Submit credentials

        searchField = driver.findElement(By.xpath("//span[.='Профиль'][contains(@class, 'nav-item__dropdown')]"));
        searchField.click();

        searchField = driver.findElement(By.xpath("//span[contains(@class, 'linkcard-link')]"));
        searchField.click();
        //extra_check
        if (driver.findElements(By.xpath("//button[@data-control-name='add_start_date']")).size() != 0)
        {
            System.out.println("PASSED");
        }
            else
        {
            System.out.println("FAILED");
        }
    }
}
