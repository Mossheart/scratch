package junit5_sample.models;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.springframework.stereotype.Component;

/**
 * Created by Dmitriev on 29.03.2016.
 */
@Component
public class SearchFormElements
{
    @FindBy(how = How.XPATH, using = ".//*[@id='gh-ac']")
    public WebElement searchForm;

    @FindBy(how = How.XPATH, using = ".//*[@id='gh-btn']")
    public WebElement performSearch;

    public static final String SEARCH_FORM = ".//*[@id='gh-ac']";
    public static final String PERFORM_SEARCH = ".//*[@id='gh-btn']";
}