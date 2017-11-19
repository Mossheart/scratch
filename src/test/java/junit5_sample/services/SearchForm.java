package junit5_sample.services;

import static junit5_sample.models.SearchFormElements.*;

public class SearchForm
{
    public static void enterQueryAndClickSearch(String queryValue)
    {
        /**
         * clear the search form
         */
        searchForm.clear();
        /**
         * typing query
         */
        searchForm.sendKeys(queryValue);
        /**
         * search button clicking
         */
        performSearch.click();
    }
}
