package junit5_sample.models;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class SearchFormElements
{
    protected static WebDriver driver;

    public SearchFormElements(WebDriver driver)
    {
        this.driver = driver;
    }

    @FindBy(how = How.XPATH, using = ".//*[@id='gh-ac']")
    public static WebElement searchForm;

    @FindBy(how = How.XPATH, using = ".//*[@id='gh-btn']")
    public static WebElement performSearch;
}
