package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import page.HomePage;
import page.SearchPage;

import java.util.List;

public class SearchTests extends BaseTest {

    @Test
    public void basicSearchTest() throws InterruptedException {
        String searchTerm = "HR";

        Assert.assertTrue(landingPage.isPageLoaded(), "Landing page is not loaded.");

        HomePage homePage = landingPage.login("michael.orekh@gmail.com", "Or.ru1999");
        Assert.assertTrue(homePage.isPageLoaded(), "Home page is not loaded.");

        SearchPage searchPage = homePage.search(searchTerm);
        Assert.assertTrue(searchPage.isPageLoaded(), "Search page is not loaded.");

        Assert.assertEquals(searchPage.getSearchResultCount(), 10,
                "Search results count is wrong.");

        List<String> SearchResultsList= searchPage.getSearchResultsList();

        for(String searchResult : SearchResultsList) {
            Assert.assertTrue(searchResult.contains(searchTerm),
                    "SearchTerm: "+searchTerm+" not found in: \n"+searchResult);
        }
    }
}