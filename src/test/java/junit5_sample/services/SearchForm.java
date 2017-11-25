package junit5_sample.services;

import junit5_sample.Base;
import junit5_sample.models.SearchFormElements;
import org.openqa.selenium.support.PageFactory;
import org.springframework.stereotype.Service;

@Service
public class SearchForm extends Base
{
    public void enterQueryAndClickSearch(String queryValue)
    {
        SearchFormElements searchFormElements = PageFactory.initElements(driver, SearchFormElements.class);

        searchFormElements.searchForm.clear();

        searchFormElements.searchForm.sendKeys(queryValue);

        searchFormElements.performSearch.click();
    }
}
