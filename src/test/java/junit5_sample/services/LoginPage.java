package junit5_sample.services;

import junit5_sample.Initial;
import junit5_sample.models.LoginElements;
import org.openqa.selenium.support.PageFactory;
import org.springframework.stereotype.Service;

@Service
public class LoginPage extends Initial
{
    private LoginElements loginElements;
    public LoginPage()
    {
        loginElements = PageFactory.initElements(driver, LoginElements.class);
    }

    public void loggingIn()
    {
        loginElements.loginLink.click();

        loginElements.emailForm.sendKeys(LOGIN);

        loginElements.passwordForm.sendKeys(PASS);

        loginElements.signButton.click();
    }
}
