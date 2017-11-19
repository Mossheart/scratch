package junit5_sample.models;

import junit5_sample.util.Base;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * Created by Dmitriev on 04.04.2016.
 */
public class LoginElements extends Base
{
    @FindBy(how = How.XPATH, using = ".//*[@id='gh-ug']/a")
    public static WebElement loginLink;

    @FindBy(how = How.XPATH, using = ".//*[@class='fld'][@type='text']")
    public static WebElement emailForm;

    @FindBy(how = How.XPATH, using = ".//*[@class='fld'][@type='password']")
    public static WebElement passwordForm;

    @FindBy(how = How.XPATH, using = ".//*[@id='sgnBt']")
    public static WebElement signButton;

    @FindBy(how = How.XPATH, using = ".//*[@id='csi']")
    public static WebElement staySigned;

    public LoginElements(WebDriver webDriver)
    {
        super(webDriver);
    }
}