package junit5_sample;

import junit5_sample.models.*;
import junit5_sample.services.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import java.util.List;

@ContextConfiguration(classes = Application.class)
public abstract class Base extends Initial
{
    @Autowired
    protected HomeElements homeElements;
    @Autowired
    protected SerpElements serpElements;
    @Autowired
    protected CartElements cartElements;
    @Autowired
    protected LoginElements loginElements;
    @Autowired
    protected ItemCardElements itemCardElements;

    @Autowired
    protected HomePage homePage;
    @Autowired
    protected CartPage cartPage;
    @Autowired
    protected LoginPage loginPage;
    @Autowired
    protected SearchForm searchForm;
    @Autowired
    protected SerpPage serpPage;

    public WebElement element(String xpath)
    {
        return driver.findElement(By.xpath(xpath));
    }

    public List<WebElement> elements(String xpath)
    {
        return driver.findElements(By.xpath(xpath));
    }
}