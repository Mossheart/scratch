package junit5_sample.models;

import junit5_sample.util.Base;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * Created by Dmitriev on 06.04.2016.
 */
public class ItemCardElements extends Base
{
    @FindBy(how = How.XPATH, using = ".//*[@id='isCartBtn_btn']")
    public static WebElement addItemToCartButton;

    @FindBy(how = How.XPATH, using = ".//*[@id='prcIsum']")
    public static WebElement itemPriceValue;

    @FindBy(how = How.XPATH, using = ".//*[@id='qtyTextBox']")
    public static WebElement itemQuantity;

    public ItemCardElements(WebDriver webDriver)
    {
        super(webDriver);
    }
}
