package junit5_sample.services;

import junit5_sample.Base;
import junit5_sample.models.CartElements;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;

@Service
public class CartPage extends Base
{
    private CartElements cartElements;
    public CartPage()
    {
        cartElements = PageFactory.initElements(driver, CartElements.class);
    }

    /**
     * function gets "US $**,**" and extracts number
     *
     * @param priceString
     * @return
     */
    public double parseEbayPriceToDouble(String priceString)
    {
        priceString = priceString.substring(priceString.indexOf("$") + 1);

        priceString = priceString.replace(",", ".");

        return Double.parseDouble(priceString);
    }

    public double getTotalPriceOfGoodsInCart()
    {
        return parseEbayPriceToDouble(cartElements.totalPrice.getText());
    }

    public void saveForLater()
    {
        cartElements.saveForLater.click();
    }

    public void returnFromLater()
    {
        cartElements.returnFromLater.click();
    }

    public boolean compareTotalToSumOfParticularPrices()
    {
        double total = parseEbayPriceToDouble(cartElements.subtotalPrice.getText());

        double sum = 0.0;
        for (WebElement subprice : cartElements.subtotalItemPrices) {
            double sub;
            try {
                sub = parseEbayPriceToDouble(subprice.getText());
            } catch (Exception e) {
                continue;
            }
            sum += sub;
        }

        DecimalFormat df = new DecimalFormat("#.##");
        String strsum = df.format(sum);
        strsum = strsum.replace(",", ".");
        sum = Double.parseDouble(strsum);

        boolean checker = false;
        if (total == sum)
            checker = true;
        return checker;
    }

    /**
     * changing quantity of item with right multiplying of price
     *
     * @param quantity
     * @return
     */
    public boolean changeQuantityAndRefresh(int quantity)
    {
        double oneItemPrice = parseEbayPriceToDouble(cartElements.subtotalPrice.getText());

        cartElements.itemQuantity.clear();
        cartElements.itemQuantity.sendKeys(Integer.toString(quantity));
        cartElements.refreshQuantity.click();

        if (quantity == 0)
            ;
        else return parseEbayPriceToDouble(cartElements.subtotalPrice.getText()) == oneItemPrice * quantity;
        return false;
    }
}
