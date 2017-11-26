package junit5_sample.services;

import junit5_sample.Initial;
import junit5_sample.models.SerpElements;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SerpPage extends Initial
{
    private SerpElements serpElements;
    public SerpPage()
    {
        serpElements = PageFactory.initElements(driver, SerpElements.class);
    }

    public boolean checkSnippetsForQueryMatches(String queryValue)
    {
        for (WebElement snippet : serpElements.allSnippets) {
            if ((snippet.getAttribute("title")).toLowerCase().contains(queryValue)) {
                continue;
            } else {
                return false;
            }
        }

        return true;
    }

    public List<String> savingSnippetsLinks()
    {
        List<String> snippetLinks = new ArrayList<String>();

        for (WebElement snippet : serpElements.allSnippets) {
            snippetLinks.add(snippet.getAttribute("href"));
        }

        return snippetLinks;
    }

    /**
     * add specified amount of different items to cart
     *
     * @param number
     * @return
     */
    public void addItemsToCart(int number)
    {
        List<String> snippetLinks = savingSnippetsLinks();

        int counter = 1;

        for (String snippet : snippetLinks) {
            driver.get(snippet);
            try {
            } catch (Exception e) {
                continue;
            }
            if (counter < number)
                counter++;
            else
                break;
        }
    }
}
