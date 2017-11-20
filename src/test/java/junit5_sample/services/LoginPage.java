package junit5_sample.services;

import junit5_sample.Base;
import org.springframework.stereotype.Service;

@Service
public class LoginPage extends Base
{
    public void loggingIn()
    {
        loginPageElements.loginLink.click();

        loginPageElements.emailForm.sendKeys(LOGIN);

        loginPageElements.passwordForm.sendKeys(PASS);

        loginPageElements.signButton.click();
    }
}
