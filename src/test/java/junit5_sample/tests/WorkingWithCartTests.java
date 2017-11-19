package junit5_sample.tests;

import junit5_sample.services.CartPage;
import junit5_sample.services.HomePage;
import junit5_sample.services.SearchForm;
import junit5_sample.services.SerpPage;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Created by Dmitriev on 06.04.2016.
 */
public class WorkingWithCartTests extends Initial
{
    @Test
    public void checkEmptyCart()
    {
        HomePage.gotoCartPage();

        assertEquals(CartPage.getTotalPriceOfGoodsInCart(), 0.00);
    }

    @Test
    @Disabled
    public void checkSubtotalWithOneItem()
    {
        String queryValue = "quadcopter";

        int itemsNumber = 1;

        HomePage.gotoHomePage();

        SearchForm.enterQueryAndClickSearch(queryValue);

        assertTrue(SerpPage.addItemsToCart(itemsNumber));

        assertTrue(CartPage.compareTotalToSumOfParticularPrices());
    }

    @Test
    public void checkSubtotalForTwoSamplesOfOneItem()
    {
        String queryValue = "quadcopter";

        int quantity = 2;

        HomePage.gotoHomePage();

        SearchForm.enterQueryAndClickSearch(queryValue);

        assertTrue(SerpPage.addItemsToCart(1));

        assertTrue(CartPage.changeQuantityAndRefresh(quantity));

        assertTrue(CartPage.compareTotalToSumOfParticularPrices());
    }

    @Test
    public void checkSubtotalWithTwoItems()
    {
        String queryValue = "quadcopter";

        int itemsNumber = 2;

        HomePage.gotoHomePage();

        SearchForm.enterQueryAndClickSearch(queryValue);

        assertTrue(SerpPage.addItemsToCart(itemsNumber));

        assertTrue(CartPage.compareTotalToSumOfParticularPrices());
    }

    @Test
    public void deletingOneOfTwoItems()
    {
        String queryValue = "quadcopter";

        int itemsNumber = 2;
        int quantity = 0;

        HomePage.gotoHomePage();

        SearchForm.enterQueryAndClickSearch(queryValue);

        assertTrue(SerpPage.addItemsToCart(itemsNumber));

        assertTrue(CartPage.compareTotalToSumOfParticularPrices());

        assertTrue(CartPage.changeQuantityAndRefresh(quantity));

        assertTrue(CartPage.compareTotalToSumOfParticularPrices());
    }

    @Test
    public void changingQuantityFromTwoToOne()
    {
        String queryValue = "quadcopter";

        int quantity1 = 2;
        int quantity2 = 1;

        HomePage.gotoHomePage();

        SearchForm.enterQueryAndClickSearch(queryValue);

        assertTrue(SerpPage.addItemsToCart(1));

        assertTrue(CartPage.changeQuantityAndRefresh(quantity1));

        assertTrue(CartPage.changeQuantityAndRefresh(quantity2));

        assertTrue(CartPage.compareTotalToSumOfParticularPrices());
    }

    @Test
    public void settingQuantityToZero()
    {
        String queryValue = "quadcopter";

        int quantity = 0;

        HomePage.gotoHomePage();

        SearchForm.enterQueryAndClickSearch(queryValue);

        assertTrue(SerpPage.addItemsToCart(1));

        assertTrue(CartPage.changeQuantityAndRefresh(quantity));

        assertEquals(CartPage.getTotalPriceOfGoodsInCart(), 0.00);
    }

    @Test
    public void addingAndDeletingTwoItems()
    {
        String queryValue = "quadcopter";

        int itemsNumber = 2;

        HomePage.gotoHomePage();

        SearchForm.enterQueryAndClickSearch(queryValue);

        assertTrue(SerpPage.addItemsToCart(itemsNumber));

        assertTrue(CartPage.changeQuantityAndRefresh(0));

        assertTrue(CartPage.changeQuantityAndRefresh(0));

        assertEquals(CartPage.getTotalPriceOfGoodsInCart(), 0.00);
    }
}