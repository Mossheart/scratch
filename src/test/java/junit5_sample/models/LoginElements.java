package junit5_sample.models;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * Created by Dmitriev on 04.04.2016.
 */
public class LoginElements
{
    @FindBy(how = How.XPATH, using = ".//*[@id='gh-ug']/a")
    public WebElement loginLink;

    @FindBy(how = How.XPATH, using = ".//*[@class='fld'][@type='text']")
    public WebElement emailForm;

    @FindBy(how = How.XPATH, using = ".//*[@class='fld'][@type='password']")
    public WebElement passwordForm;

    @FindBy(how = How.XPATH, using = ".//*[@id='sgnBt']")
    public WebElement signButton;

    @FindBy(how = How.XPATH, using = ".//*[@id='csi']")
    public WebElement staySigned;

    protected WebDriver driver;

    public LoginElements(WebDriver driver)
    {
        this.driver = driver;
    }
}