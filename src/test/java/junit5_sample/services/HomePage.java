package junit5_sample.services;

import junit5_sample.Base;
import junit5_sample.models.HomeElements;
import org.openqa.selenium.support.PageFactory;
import org.springframework.stereotype.Service;

@Service
public class HomePage extends Base
{
    private HomeElements homeElements;
    public HomePage()
    {
        homeElements = PageFactory.initElements(driver, HomeElements.class);
    }

    public void gotoHomePage()
    {
        driver.get(baseUrl);
    }

    public void gotoCartPage()
    {
        driver.get(cartUrl);
    }

    public void clickSigningMenu()
    {
        homeElements.signingMenu.click();
    }

    public void clickSignOut()
    {
        homeElements.signOut.click();
    }
}
