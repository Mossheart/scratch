package junit5_sample.tests;

import junit5_sample.Base;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SearchQueryTests extends Base
{
    @Test
    public void simpleCheck_Success()
    {
        String queryValue = "iphone";

        homePage.gotoHomePage();

        searchForm.enterQueryAndClickSearch(queryValue);

        assertTrue(serpPage.checkSnippetsForQueryMatches(queryValue));
    }

    @Test
    @Disabled
    public void simpleCheck_Failure()
    {
        String queryValue = "samsung";

        homePage.gotoHomePage();

        searchForm.enterQueryAndClickSearch(queryValue);

        assertTrue(serpPage.checkSnippetsForQueryMatches("iphone"));
    }

    @Test
    @Disabled
    public void usingMatcher_Success()
    {
        String queryValue = "samsung";

        homePage.gotoHomePage();

        searchForm.enterQueryAndClickSearch(queryValue);

        List<WebElement> allSnippets = driver.findElements(By.xpath(".//*[@class='lvtitle']/a"));
        for (WebElement snippet : allSnippets)
            assertThat(snippet.getText().toLowerCase(), containsString(queryValue));
    }

    @Test
    @Disabled
    public void usingMatcher_Failure()
    {
        String queryValue = "samsung";

        homePage.gotoHomePage();

        searchForm.enterQueryAndClickSearch(queryValue);

        List<WebElement> allSnippets = driver.findElements(By.xpath(".//*[@class='lvtitle']/a"));
        for (WebElement snippet : allSnippets)
            assertThat(snippet.getText().toLowerCase(), containsString("iphone"));
    }
}