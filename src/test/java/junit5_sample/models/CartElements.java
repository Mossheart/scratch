package junit5_sample.models;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Dmitriev on 06.04.2016.
 */
@Component
public class CartElements
{
    @FindBy(how = How.XPATH, using = ".//*[@id='syncTotal']/span[2]")
    public WebElement totalPrice;// = driver.findElement(By.xpath(".//*[@id='syncTotal']/span[2]"));

    @FindBy(how = How.XPATH, using = ".//*[@class='fw-b']")
    public List<WebElement> subtotalItemPrices;

    @FindBy(how = How.XPATH, using = ".//*[@class='nowrap tr normal']")
    public WebElement subtotalPrice;

    @FindBy(how = How.XPATH, using = ".//input[@type='number']")
    public WebElement itemQuantity;

    @FindBy(how = How.XPATH, using = ".//*[@class='uqtyLink']")
    public WebElement refreshQuantity;

    @FindBy(how = How.XPATH, using = ".//*[@class='ItemInfoTable']//tr[2]/td[2]")
    public WebElement priceOfOneItem;

    @FindBy(how = How.XPATH, using = ".//*[@aria-label='Save for later']")
    public WebElement saveForLater;

    @FindBy(how = How.XPATH, using = ".//*[@aria-label='Add back to cart']")
    public WebElement returnFromLater;
}