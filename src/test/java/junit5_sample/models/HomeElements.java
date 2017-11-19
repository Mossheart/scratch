package junit5_sample.models;

import junit5_sample.util.Base;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * Sample page
 */
public class HomeElements extends Base
{
    @FindBy(how = How.TAG_NAME, using = "h1")
    public static WebElement header;

    @FindBy(how = How.XPATH, using = ".//*[@id='gh-ug']")
    public static WebElement signingMenu;

    @FindBy(how = How.XPATH, using = ".//*[@id='gh-uo']/a")
    public static WebElement signOut;

    public HomeElements(WebDriver webDriver)
    {
        super(webDriver);
    }
}