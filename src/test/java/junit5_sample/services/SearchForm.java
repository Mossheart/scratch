package junit5_sample.services;

import junit5_sample.Base;
import org.openqa.selenium.By;
import org.springframework.stereotype.Service;

@Service
public class SearchForm extends Base
{
    public void enterQueryAndClickSearch(String queryValue)
    {
        driver.findElement(By.xpath(searchFormElements.SEARCH_FORM)).clear();

        driver.findElement(By.xpath(searchFormElements.SEARCH_FORM)).sendKeys(queryValue);

        driver.findElement(By.xpath(searchFormElements.PERFORM_SEARCH)).click();
    }
}
