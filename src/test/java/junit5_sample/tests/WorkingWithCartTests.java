package junit5_sample.tests;

import junit5_sample.Base;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Created by Dmitriev on 06.04.2016.
 */
public class WorkingWithCartTests extends Base
{
    @Test
    public void checkEmptyCart()
    {
        homePage.gotoCartPage();

        assertEquals(cartPage.getTotalPriceOfGoodsInCart(), 0.00);
    }

    @Test
    @Disabled
    public void checkSubtotalWithOneItem()
    {
        String queryValue = "quadcopter";

        int itemsNumber = 1;

        homePage.gotoHomePage();

        searchForm.enterQueryAndClickSearch(queryValue);

        serpPage.addItemsToCart(itemsNumber);

        assertTrue(cartPage.compareTotalToSumOfParticularPrices());
    }

    @Test
    @Disabled
    public void checkSubtotalForTwoSamplesOfOneItem()
    {
        String queryValue = "quadcopter";

        int quantity = 2;

        homePage.gotoHomePage();

        searchForm.enterQueryAndClickSearch(queryValue);

        serpPage.addItemsToCart(1);

        assertTrue(cartPage.changeQuantityAndRefresh(quantity));

        assertTrue(cartPage.compareTotalToSumOfParticularPrices());
    }

    @Test
    @Disabled
    public void checkSubtotalWithTwoItems()
    {
        String queryValue = "quadcopter";

        int itemsNumber = 2;

        homePage.gotoHomePage();

        searchForm.enterQueryAndClickSearch(queryValue);

        serpPage.addItemsToCart(itemsNumber);

        assertTrue(cartPage.compareTotalToSumOfParticularPrices());
    }

    @Test
    @Disabled
    public void deletingOneOfTwoItems()
    {
        String queryValue = "quadcopter";

        int itemsNumber = 2;
        int quantity = 0;

        homePage.gotoHomePage();

        searchForm.enterQueryAndClickSearch(queryValue);

        serpPage.addItemsToCart(itemsNumber);

        assertTrue(cartPage.compareTotalToSumOfParticularPrices());

        assertTrue(cartPage.changeQuantityAndRefresh(quantity));

        assertTrue(cartPage.compareTotalToSumOfParticularPrices());
    }

    @Test
    @Disabled
    public void changingQuantityFromTwoToOne()
    {
        String queryValue = "quadcopter";

        int quantity1 = 2;
        int quantity2 = 1;

        homePage.gotoHomePage();

        searchForm.enterQueryAndClickSearch(queryValue);

        serpPage.addItemsToCart(1);

        assertTrue(cartPage.changeQuantityAndRefresh(quantity1));

        assertTrue(cartPage.changeQuantityAndRefresh(quantity2));

        assertTrue(cartPage.compareTotalToSumOfParticularPrices());
    }

    @Test
    @Disabled
    public void settingQuantityToZero()
    {
        String queryValue = "quadcopter";

        int quantity = 0;

        homePage.gotoHomePage();

        searchForm.enterQueryAndClickSearch(queryValue);

        serpPage.addItemsToCart(1);

        assertTrue(cartPage.changeQuantityAndRefresh(quantity));

        assertEquals(cartPage.getTotalPriceOfGoodsInCart(), 0.00);
    }

    @Test
    @Disabled
    public void addingAndDeletingTwoItems()
    {
        String queryValue = "quadcopter";

        int itemsNumber = 2;

        homePage.gotoHomePage();

        searchForm.enterQueryAndClickSearch(queryValue);

        serpPage.addItemsToCart(itemsNumber);

        assertTrue(cartPage.changeQuantityAndRefresh(0));

        assertTrue(cartPage.changeQuantityAndRefresh(0));

        assertEquals(cartPage.getTotalPriceOfGoodsInCart(), 0.00);
    }
}