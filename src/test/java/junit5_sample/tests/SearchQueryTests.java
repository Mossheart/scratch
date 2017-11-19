package junit5_sample.tests;

import junit5_sample.services.HomePage;
import junit5_sample.services.SearchForm;
import junit5_sample.services.SerpPage;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SearchQueryTests extends Initial
{
    @Test
    public void simpleCheck_Success()
    {
        /**
         * variable of query
         */
        String queryValue = "iphone";
        /**
         * going to BaseUrl
         */
        HomePage.gotoHomePage();
        /**
         * entering query and going to search results
         */
        SearchForm.enterQueryAndClickSearch(queryValue);
        /**
         * checking results for query matching
         */
        assertTrue(SerpPage.checkSnippetsForQueryMatches(queryValue));
    }

    @Test
    public void simpleCheck_Failure()
    {
        /**
         * variable of query
         */
        String queryValue = "samsung";
        /**
         * going to BaseUrl
         */
        HomePage.gotoHomePage();
        /**
         * entering query and going to search results
         */
        SearchForm.enterQueryAndClickSearch(queryValue);
        /**
         * checking results for query matching
         */
        assertTrue(SerpPage.checkSnippetsForQueryMatches("iphone"));
    }

    @Test
    public void usingMatcher_Success()
    {
        /**
         * variable of query
         */
        String queryValue = "samsung";
        /**
         * going to BaseUrl
         */
        HomePage.gotoHomePage();
        /**
         * entering query and going to search results
         */
        SearchForm.enterQueryAndClickSearch(queryValue);
        /**
         * checking results for query matching
         */
        List<WebElement> allSnippets = driver.findElements(By.xpath(".//*[@class='lvtitle']/a"));
        for (WebElement snippet : allSnippets)
            assertThat(snippet.getText().toLowerCase(), containsString(queryValue));
    }

    @Test
    public void usingMatcher_Failure()
    {
        /**
         * variable of query
         */
        String queryValue = "samsung";
        /**
         * going to BaseUrl
         */
        HomePage.gotoHomePage();
        /**
         * entering query and going to search results
         */
        SearchForm.enterQueryAndClickSearch(queryValue);
        /**
         * checking results for query matching
         */
        List<WebElement> allSnippets = driver.findElements(By.xpath(".//*[@class='lvtitle']/a"));
        for (WebElement snippet : allSnippets)
            assertThat(snippet.getText().toLowerCase(), containsString("iphone"));
    }
}