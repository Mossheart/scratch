package junit5_sample.models;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.springframework.stereotype.Component;

/**
 * Created by Dmitriev on 06.04.2016.
 */
@Component
public class ItemCardElements
{
    @FindBy(how = How.XPATH, using = ".//*[@id='isCartBtn_btn']")
    public WebElement addItemToCartButton;

    @FindBy(how = How.XPATH, using = ".//*[@id='prcIsum']")
    public WebElement itemPriceValue;

    @FindBy(how = How.XPATH, using = ".//*[@id='qtyTextBox']")
    public WebElement itemQuantity;
}
