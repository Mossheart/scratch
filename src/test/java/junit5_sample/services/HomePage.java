package junit5_sample.services;

import junit5_sample.Initial;
import junit5_sample.models.HomeElements;
import org.openqa.selenium.support.PageFactory;
import org.springframework.stereotype.Service;

@Service
public class HomePage extends Initial
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
