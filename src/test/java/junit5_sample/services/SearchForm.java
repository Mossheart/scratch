package junit5_sample.services;

import junit5_sample.Initial;
import junit5_sample.models.SearchFormElements;
import org.openqa.selenium.support.PageFactory;
import org.springframework.stereotype.Service;

@Service
public class SearchForm extends Initial
{
    private SearchFormElements searchFormElements;
    public SearchForm()
    {
        searchFormElements = PageFactory.initElements(driver, SearchFormElements.class);
    }

    public void enterQueryAndClickSearch(String queryValue)
    {
        searchFormElements.searchForm.clear();

        searchFormElements.searchForm.sendKeys(queryValue);

        searchFormElements.performSearch.click();
    }
}
