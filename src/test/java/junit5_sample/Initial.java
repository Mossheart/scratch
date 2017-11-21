package junit5_sample;

import junit5_sample.util.PropertyLoader;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextBeforeModesTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.web.ServletTestExecutionListener;
import ru.stqa.selenium.factory.WebDriverPool;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URL;

/**
 * Base class for TestNG-based test classes
 */
@TestExecutionListeners({ServletTestExecutionListener.class, DirtiesContextBeforeModesTestExecutionListener.class, DependencyInjectionTestExecutionListener.class, DirtiesContextTestExecutionListener.class})
@ExtendWith(SpringExtension.class)
public class Initial
{
    protected static Capabilities capabilities;
    protected static URL gridHubUrl;
    protected static WebDriver driver;

    public static String baseUrl;
    public static String cartUrl;

    public static String LOGIN;
    public static String PASS;

    @BeforeAll
    public static void initTestSuite() throws IOException
    {
        System.setProperty("webdriver.chrome.driver", new File("chromedriver").getAbsolutePath());
        System.setProperty("webdriver.gecko.driver", new File("geckodriver").getAbsolutePath());

        if ("".equals(PropertyLoader.loadProperty("grid.url")))
        {
            gridHubUrl = null;
        } else
        {
            gridHubUrl = new URL(PropertyLoader.loadProperty("grid.url"));
        }
        capabilities = PropertyLoader.loadCapabilities();

        baseUrl = PropertyLoader.loadProperty("site.url");
        cartUrl = PropertyLoader.loadProperty("cart.url");

        LOGIN = PropertyLoader.loadProperty("login");
        PASS = PropertyLoader.loadProperty("pass");
    }

    @BeforeEach
    public void initWebDriver() throws IOException
    {
        driver = WebDriverPool.DEFAULT.getDriver(gridHubUrl, capabilities);

        // webdriver lost his .maximize() for Chrome
        String browser = PropertyLoader.loadProperty("capabilities");
        if (browser.contains("chrome"))
        {
            java.awt.Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
            driver.manage().window().setPosition(new Point(0, 0));
            Dimension maximizedScreenSize =
                    new Dimension((int) screenSize.getWidth(), (int) screenSize.getHeight());
            driver.manage().window().setSize(maximizedScreenSize);
        } else
        {
            driver.manage().window().maximize();
        }
    }

    @AfterEach
    public void clearCookies()
    {
        driver.manage().deleteAllCookies();
    }

    @AfterAll
    public static void tearDown()
    {
        WebDriverPool.DEFAULT.dismissAll();
    }
}