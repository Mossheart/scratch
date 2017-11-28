package junit5_sample.models;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class SearchFormElements
{
    @FindBy(how = How.XPATH, using = ".//*[@id='gh-ac']")
    public WebElement searchForm;

    @FindBy(how = How.XPATH, using = ".//*[@id='gh-btn']")
    public WebElement performSearch;

    protected WebDriver driver;

    public SearchFormElements(WebDriver driver)
    {
        this.driver = driver;
    }
}
