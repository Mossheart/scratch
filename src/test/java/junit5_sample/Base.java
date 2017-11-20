package junit5_sample;

import junit5_sample.models.*;
import junit5_sample.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration(classes = Application.class)//, locations = "classPath:applicationContext.xml")
public abstract class Base extends Initial
{
    @Autowired
    protected HomeElements homePageElements;
    @Autowired
    protected SearchFormElements searchFormElements;
    @Autowired
    protected SerpElements serpPageElements;
    @Autowired
    protected CartElements cartPageElements;
    @Autowired
    protected LoginElements loginPageElements;
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
}