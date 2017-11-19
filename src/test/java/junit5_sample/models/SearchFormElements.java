package junit5_sample.models;

import junit5_sample.util.Base;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * Created by Dmitriev on 29.03.2016.
 */
public class SearchFormElements extends Base
{
    @FindBy(how = How.XPATH, using = ".//*[@id='gh-ac']")
    public static WebElement searchForm;

    @FindBy(how = How.XPATH, using = ".//*[@id='gh-btn']")
    public static WebElement performSearch;

    public SearchFormElements(WebDriver webDriver)
    {
        super(webDriver);
    }
}