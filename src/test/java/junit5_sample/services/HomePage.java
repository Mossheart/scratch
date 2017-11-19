package junit5_sample.services;

import static junit5_sample.models.HomeElements.*;
import static junit5_sample.tests.Initial.baseUrl;
import static junit5_sample.tests.Initial.cartUrl;

public class HomePage
{
    public static void gotoHomePage()
    {
        driver.get(baseUrl);
    }

    public static void gotoCartPage()
    {
        driver.get(cartUrl);
    }

    public static void clickSigningMenu()
    {
        signingMenu.click();
    }

    public static void clickSignOut()
    {
        signOut.click();
    }
}
