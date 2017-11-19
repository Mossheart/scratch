package junit5_sample.services;

import static junit5_sample.models.LoginElements.*;
import static junit5_sample.tests.Initial.LOGIN;
import static junit5_sample.tests.Initial.PASS;

public class LoginPage
{
    public static void loggingIn()
    {
        /**
         * click a link to log-in form
         */
        loginLink.click();
        /**
         * enter email
         */
        emailForm.sendKeys(LOGIN);
        /**
         * enter password
         */
        passwordForm.sendKeys(PASS);
        /**
         * click to enter the account
         */
        signButton.click();
    }
}
