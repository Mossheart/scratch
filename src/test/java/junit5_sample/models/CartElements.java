package junit5_sample.models;

import junit5_sample.util.Base;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

/**
 * Created by Dmitriev on 06.04.2016.
 */
public class CartElements extends Base
{
    @FindBy(how = How.XPATH, using = ".//*[@id='syncTotal']/span[2]")
    public static WebElement totalPrice;

    @FindBy(how = How.XPATH, using = ".//*[@class='fw-b']")
    public static List<WebElement> subtotalItemPrices;

    @FindBy(how = How.XPATH, using = ".//*[@class='nowrap tr normal']")
    public static WebElement subtotalPrice;

    @FindBy(how = How.XPATH, using = ".//input[@type='number']")
    public static WebElement itemQuantity;

    @FindBy(how = How.XPATH, using = ".//*[@class='uqtyLink']")
    public static WebElement refreshQuantity;

    @FindBy(how = How.XPATH, using = ".//*[@class='ItemInfoTable']//tr[2]/td[2]")
    public static WebElement priceOfOneItem;

    @FindBy(how = How.XPATH, using = ".//*[@aria-label='Save for later']")
    public static WebElement saveForLater;

    @FindBy(how = How.XPATH, using = ".//*[@aria-label='Add back to cart']")
    public static WebElement returnFromLater;

    public CartElements(WebDriver webDriver)
    {
        super(webDriver);
    }
}