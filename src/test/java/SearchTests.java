import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class SearchTests extends BaseTest {

    @Test
    public void basicSearchTest(){
        String searchTerm = "HR";

        Assert.assertTrue(landingPage.isPageLoaded(), "Landing page is not loaded.");

        HomePage homePage = landingPage.login("valerii.ant@meta.ua", "Val_123456");
        Assert.assertTrue(homePage.isPageLoaded(), "Home page is not loaded.");

        SearchPage searchPage = homePage.search(searchTerm);
        Assert.assertTrue(searchPage.isPageLoaded(), "Search page is not loaded.");

        Assert.assertEquals(searchPage.getSearchResultCount(), 10,
                "Search results count is wrong.");

        List<String> SearchResultsList= searchPage.getSearchResultsList();

        for(String searchResult : SearchResultsList) {
            Assert.assertTrue(searchResult.contains(searchTerm),
                    "Please write this message");
        }

    }
}