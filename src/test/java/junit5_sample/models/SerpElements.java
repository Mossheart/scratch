package junit5_sample.models;

import junit5_sample.util.Base;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

/**
 * Created by Dmitriev on 29.03.2016.
 */
public class SerpElements extends Base
{
    @FindBy(how = How.XPATH, using = ".//*[@class='lvtitle']/a")
    public static List<WebElement> allSnippets;

    public SerpElements(WebDriver webDriver) {
        super(webDriver);
    }
}