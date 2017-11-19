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
        HomePage.gotoHomePage();

        String title = driver.getTitle();

        LoginPage.loggingIn();

        assertEquals(driver.getTitle(), title);

        String queryValue = "quadcopter";

        int itemsNumber = 2;

        SearchForm.enterQueryAndClickSearch(queryValue);

        assertTrue(SerpPage.addItemsToCart(itemsNumber));

        assertTrue(CartPage.compareTotalToSumOfParticularPrices());

        CartPage.saveForLater();

        assertTrue(CartPage.compareTotalToSumOfParticularPrices());

        CartPage.returnFromLater();

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