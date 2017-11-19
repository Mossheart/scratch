package junit5_sample.services;

import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

import static junit5_sample.models.SerpElements.*;

public class SerpPage
{
    public static boolean checkSnippetsForQueryMatches(String queryValue) {
        /**
         * check every snippet's title for containing the query
         * if we find snippet without query we return false
         */
        for ( WebElement snippet: allSnippets) {
            if ((snippet.getAttribute("title")).toLowerCase().contains(queryValue)) {
                continue;
            }
            else {
                return false;
            }
        }

        return true;
    }

    public static List<String> savingSnippetsLinks() {
        List<String> snippetLinks = new ArrayList<String>();

        for (WebElement snippet: allSnippets) {
            snippetLinks.add(snippet.getAttribute("href"));
        }

        return snippetLinks;
    }

    /**
     * add specified amount of different items to cart
     * @param number
     * @return
     */
    public static boolean addItemsToCart(int number) {
        /**
         * list of links we've got on search results page
         */
        List<String> snippetLinks = savingSnippetsLinks();
        /**
         * variable for controlling number of added items
         */
        int counter = 1;
        /**
         * adding items from list until we get enough different items in the cart
         */
        for (String snippet : snippetLinks) {
            driver.get(snippet);
            try {
            } catch (Exception e) {continue;}
            if (counter < number) counter++;
            else break;
        }

        return true;
    }
}
