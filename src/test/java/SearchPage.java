import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class SearchPage {
    private WebDriver driver;

    @FindBy(xpath = "//h3[contains(@class, 'search-results__total')]")
    private WebElement resultsTotal;

    @FindAll({@FindBy(xpath = "//div[@class='search-result__info pt3 pb4 ph0']")})
    public List<WebElement> searchResultsList;

    public SearchPage (WebDriver driverFromTest) {
        this.driver = driverFromTest;
        PageFactory.initElements(driver, this);
    }

    public boolean isPageLoaded() {
        return resultsTotal.isDisplayed()
                && driver.getCurrentUrl().contains("search/results")
                && driver.getTitle().contains("| Search | LinkedIn");
    }

    public int getSearchResultCount () {
        return searchResultsList.size();
    }


    public List<String> getSearchResultsList () {
        List<String> searchListResults = new ArrayList<String>();
        for (WebElement searchResultsList : searchResultsList) {
            searchListResults.add(searchResultsList.getText());
        }
        return searchListResults;
    }

}
