package junit5_sample.tests;

import junit5_sample.services.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Created by Dmitriev on 06.04.2016.
 */
public class LoggedInTests extends Initial
{
    @Test
    public void future()
    {
        /**
         * going to baseUrl
         */
        HomePage.gotoHomePage();
        /**
         * remember the title for later check
         */
        String title = driver.getTitle();
        /**
         * logging in
         */
        LoginPage.loggingIn();
        /**
         * check that we returned to Base after successful logging in
         */
        assertEquals(driver.getTitle(), title);
        /**
         * variable of query
         */
        String queryValue = "quadcopter";
        /**
         * number of different items
         */
        int itemsNumber = 2;
        /**
         * entering query and going to search results
         */
        SearchForm.enterQueryAndClickSearch(queryValue);
        /**
         * add items to cart
         */
        assertTrue(SerpPage.addItemsToCart(itemsNumber));
        /**
         * check sum in the cart
         */assertTrue(CartPage.compareTotalToSumOfParticularPrices());
        /**
         * saving one item for later
         */
        CartPage.saveForLater();
        /**
         * check that subtotal of cart equals price of item left there
         */
        assertTrue(CartPage.compareTotalToSumOfParticularPrices());
        /**
         * return item from future
         */
        CartPage.returnFromLater();
        /**
         * check that subtotal equals sum of item's prices
         */
        assertTrue(CartPage.compareTotalToSumOfParticularPrices());
    }

    @AfterEach
    public void clearCartAndSignOut()
    {
        CartPage.changeQuantityAndRefresh(0);
        CartPage.changeQuantityAndRefresh(0);
        HomePage.clickSigningMenu();
        HomePage.clickSignOut();
    }
}