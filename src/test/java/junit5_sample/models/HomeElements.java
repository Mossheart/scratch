package junit5_sample.models;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class HomeElements
{
    @FindBy(how = How.TAG_NAME, using = "h1")
    public WebElement header;

    @FindBy(how = How.XPATH, using = ".//*[@id='gh-ug']")
    public WebElement signingMenu;

    @FindBy(how = How.XPATH, using = ".//*[@id='gh-uo']/a")
    public WebElement signOut;

    protected WebDriver driver;

    public HomeElements(WebDriver driver)
    {
        this.driver = driver;
    }
}