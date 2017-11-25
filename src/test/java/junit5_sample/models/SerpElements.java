package junit5_sample.models;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

/**
 * Created by Dmitriev on 29.03.2016.
 */
public class SerpElements
{
    @FindBy(how = How.XPATH, using = ".//*[@class='lvtitle']/a")
    public List<WebElement> allSnippets;

    protected WebDriver driver;

    public SerpElements(WebDriver driver)
    {
        this.driver = driver;
    }
}