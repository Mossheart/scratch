package junit5_sample.services;

import junit5_sample.Base;
import org.springframework.stereotype.Service;

@Service
public class HomePage extends Base
{
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
