package junit5_sample.services;

import org.openqa.selenium.WebElement;

import java.text.DecimalFormat;

import static junit5_sample.models.CartElements.*;

public class CartPage
{
    /**
     * function gets "US $**,**" and extracts number
     *
     * @param priceString
     * @return
     */
    public static double parseEbayPriceToDouble(String priceString)
    {
        priceString = priceString.substring(priceString.indexOf("$") + 1);

        priceString = priceString.replace(",", ".");

        return Double.parseDouble(priceString);
    }

    public static double getTotalPriceOfGoodsInCart()
    {
        return parseEbayPriceToDouble(totalPrice.getText());
    }

    public static void saveForLater()
    {
        saveForLater.click();
    }
    public static void returnFromLater()
    {
        returnFromLater.click();
    }

    public static boolean compareTotalToSumOfParticularPrices()
    {
        /**
         * get subtotal price
         */
        double total = parseEbayPriceToDouble(subtotalPrice.getText());
        /**
         * get sum of subtotal item prices
         */
        double sum = 0.0;
        for (WebElement subprice : subtotalItemPrices) {
            double sub;
            try {
                sub = parseEbayPriceToDouble(subprice.getText());
            } catch (Exception e) {
                continue;
            }
            sum += sub;
        }
        /**
         * formatting sum to right format to prevent calculations with double problems
         */
        DecimalFormat df = new DecimalFormat("#.##");
        String strsum = df.format(sum);
        strsum = strsum.replace(",", ".");
        sum = Double.parseDouble(strsum);
        /**
         * check that calculated by us and ebay sums are equal
         */
        boolean checker = false;
        if (total == sum) checker = true;
        return checker;
    }

    /**
     * changing quantity of item with right multiplying of price
     *
     * @param quantity
     * @return
     */
    public static boolean changeQuantityAndRefresh(int quantity)
    {
        double oneItemPrice = parseEbayPriceToDouble(subtotalPrice.getText());

        itemQuantity.clear();
        itemQuantity.sendKeys(Integer.toString(quantity));
        refreshQuantity.click();

        if (quantity == 0) ;
        else if (parseEbayPriceToDouble(subtotalPrice.getText()) == oneItemPrice * quantity)
            return true;
        else return false;
        return false;
    }
}
