package junit5_sample;

import junit5_sample.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration(classes = Application.class)
public abstract class Base extends Initial
{
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