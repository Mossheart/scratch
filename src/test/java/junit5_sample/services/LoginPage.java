package junit5_sample.services;

import junit5_sample.Base;
import org.springframework.stereotype.Service;

@Service
public class LoginPage extends Base
{
    public void loggingIn()
    {
        loginElements.loginLink.click();

        loginElements.emailForm.sendKeys(LOGIN);

        loginElements.passwordForm.sendKeys(PASS);

        loginElements.signButton.click();
    }
}
