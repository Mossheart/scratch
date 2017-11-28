package junit5_sample.tests;

import junit5_sample.Base;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Created by Dmitriev on 06.04.2016.
 */
public class LoggedInTests extends Base
{
    @Test
    @Disabled
    public void future()
    {
        homePage.gotoHomePage();

        String title = driver.getTitle();

        loginPage.loggingIn();

        assertEquals(driver.getTitle(), title);

        String queryValue = "quadcopter";

        int itemsNumber = 2;

        searchForm.enterQueryAndClickSearch(queryValue);

        serpPage.addItemsToCart(itemsNumber);

        assertTrue(cartPage.compareTotalToSumOfParticularPrices());

        cartPage.saveForLater();

        assertTrue(cartPage.compareTotalToSumOfParticularPrices());

        cartPage.returnFromLater();

        assertTrue(cartPage.compareTotalToSumOfParticularPrices());
    }

    @AfterEach
    public void clearCartAndSignOut()
    {
        cartPage.changeQuantityAndRefresh(0);
        cartPage.changeQuantityAndRefresh(0);
        homePage.clickSigningMenu();
        homePage.clickSignOut();
    }
}