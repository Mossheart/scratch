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
        /*
         * go to cart page
         */
        HomePage.gotoCartPage();
        /*
         * check that we've got 0 in total price with empty cart
         */
        assertEquals(CartPage.getTotalPriceOfGoodsInCart(), 0.00);
    }

    @Test
    @Disabled
    public void checkSubtotalWithOneItem()
    {
        /*
         * variable of query
         */
        String queryValue = "quadcopter";
        /*
         * number of different items
         */
        int itemsNumber = 1;
        /*
         * going to BaseUrl
         */
        HomePage.gotoHomePage();
        /*
         * entering query and going to search results
         */
        SearchForm.enterQueryAndClickSearch(queryValue);
        /*
         * add items to cart
         */
        assertTrue(SerpPage.addItemsToCart(itemsNumber));
        /*
         * check sum in the cart
         */
        assertTrue(CartPage.compareTotalToSumOfParticularPrices());
    }

    @Test
    public void checkSubtotalForTwoSamplesOfOneItem()
    {
        /*
         * variable of query
         */
        String queryValue = "quadcopter";
        /*
         * quantity of item
         */
        int quantity = 2;
        /*
         * going to BaseUrl
         */
        HomePage.gotoHomePage();
        /*
         * entering query and going to search results
         */
        SearchForm.enterQueryAndClickSearch(queryValue);
        /*
         * add item to cart
         */
        assertTrue(SerpPage.addItemsToCart(1));
        /*
         * change quantity
         */
        assertTrue(CartPage.changeQuantityAndRefresh(quantity));
        /*
         * check subtotal
         */
        assertTrue(CartPage.compareTotalToSumOfParticularPrices());
    }

    @Test
    public void checkSubtotalWithTwoItems()
    {
        /*
         * variable of query
         */
        String queryValue = "quadcopter";
        /*
         * number of different items
         */
        int itemsNumber = 2;
        /*
         * going to BaseUrl
         */
        HomePage.gotoHomePage();
        /*
         * entering query and going to search results
         */
        SearchForm.enterQueryAndClickSearch(queryValue);
        /*
         * add items to cart
         */
        assertTrue(SerpPage.addItemsToCart(itemsNumber));
        /*
         * check sum in the cart
         */
        assertTrue(CartPage.compareTotalToSumOfParticularPrices());
    }

    @Test
    public void deletingOneOfTwoItems()
    {
        /*
         * variable of query
         */
        String queryValue = "quadcopter";
        /*
         * number of different items and variable to perform deleting one of items
         */
        int itemsNumber = 2;
        int quantity = 0;
        /*
         * going to BaseUrl
         */
        HomePage.gotoHomePage();
        /*
         * entering query and going to search results
         */
        SearchForm.enterQueryAndClickSearch(queryValue);
        /*
         * add items to cart
         */
        assertTrue(SerpPage.addItemsToCart(itemsNumber));
        /*
         * check sum in the cart
         */
        assertTrue(CartPage.compareTotalToSumOfParticularPrices());
        /*
         * change quantity of first item to zero, this action equals to it's deleting
         */
        assertTrue(CartPage.changeQuantityAndRefresh(quantity));
        /*
         * check new sum in the cart
         */
        assertTrue(CartPage.compareTotalToSumOfParticularPrices());
    }

    @Test
    public void changingQuantityFromTwoToOne()
    {
        /*
         * variable of query
         */
        String queryValue = "quadcopter";
        /*
         * quantity of item
         */
        int quantity1 = 2;
        int quantity2 = 1;
        /*
         * going to BaseUrl
         */
        HomePage.gotoHomePage();
        /*
         * entering query and going to search results
         */
        SearchForm.enterQueryAndClickSearch(queryValue);
        /*
         * add item to cart
         */
        assertTrue(SerpPage.addItemsToCart(1));
        /*
         * change quantity to 2
         */
        assertTrue(CartPage.changeQuantityAndRefresh(quantity1));
        /*
         * change quantity to 1
         */
        assertTrue(CartPage.changeQuantityAndRefresh(quantity2));
        /*
         * check subtotal
         */
        assertTrue(CartPage.compareTotalToSumOfParticularPrices());
    }

    @Test
    public void settingQuantityToZero()
    {
        /*
         * variable of query
         */
        String queryValue = "quadcopter";
        /*
         * quantity of item
         */
        int quantity = 0;
        /*
         * going to BaseUrl
         */
        HomePage.gotoHomePage();
        /*
         * entering query and going to search results
         */
        SearchForm.enterQueryAndClickSearch(queryValue);
        /*
         * add item to cart
         */
        assertTrue(SerpPage.addItemsToCart(1));
        /*
         * change quantity
         */
        assertTrue(CartPage.changeQuantityAndRefresh(quantity));
        /*
         * check subtotal
         */
        assertEquals(CartPage.getTotalPriceOfGoodsInCart(), 0.00);
    }

    @Test
    public void addingAndDeletingTwoItems()
    {
        /*
         * variable of query
         */
        String queryValue = "quadcopter";
        /*
         * number of different items
         */
        int itemsNumber = 2;
        /*
         * going to BaseUrl
         */
        HomePage.gotoHomePage();
        /*
         * entering query and going to search results
         */
        SearchForm.enterQueryAndClickSearch(queryValue);
        /*
         * add items to cart
         */
        assertTrue(SerpPage.addItemsToCart(itemsNumber));
        /*
         * deleting first item
         */
        assertTrue(CartPage.changeQuantityAndRefresh(0));
        /*
         * deleting second item
         */
        assertTrue(CartPage.changeQuantityAndRefresh(0));
        /*
         * check sum in the cart
         */
        assertEquals(CartPage.getTotalPriceOfGoodsInCart(), 0.00);
    }
}