import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class BadCodeExample {
    public static void main(String[] args) { //psv
        //System.out.println("Hello, World!!!"); //sout

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\slynko_y\\IdeaProjects\\qaauto-5.02.2019\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com.ua/");
        //Home_assignment
        String searchTerm = "Selenium";
        WebElement searchField;
        searchField = driver.findElement(By.name("q"));
        searchField.sendKeys(searchTerm);
        searchField.sendKeys(Keys.ENTER);

        List<WebElement> searchResultElements = driver.findElements(By.xpath("//div[@class='g']"));
        System.out.println("Results count: " + searchResultElements.size());

        //For each WebElement in searchResultElement print text
        List<WebElement> elements = driver.findElements(By.xpath("//div[@class='g']"));
        for (WebElement searchResultElement : searchResultElements) {
            String searchResultElementText = searchResultElement.getText();
            System.out.println(searchResultElementText);

            if(searchResultElement.getText().toLowerCase().contains(searchTerm.toLowerCase()))
            {
                System.out.println("searchTerm found");
            }
            else
            {
                System.out.println("searchTerm not found");
            }
        }
    }
}