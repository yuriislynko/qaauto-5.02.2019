import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchTests extends BaseTest {

    @Test
    public void basicSearchTest(){
        Assert.assertTrue(landingPage.isPageLoaded(), "Landing page is not loaded.");

        HomePage homePage = landingPage.login("valerii.ant@meta.ua", "Val_123456");
        Assert.assertTrue(homePage.isPageLoaded(), "Home page is not loaded.");
    }
}
