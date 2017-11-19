package junit5_sample.tests;

import junit5_sample.models.*;
import junit5_sample.util.PropertyLoader;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import ru.stqa.selenium.factory.WebDriverPool;

import java.io.IOException;
import java.net.URL;

/**
 * Base class for TestNG-based test classes
 */
public class Initial
{
    protected static Capabilities capabilities;
    protected static URL gridHubUrl;
    protected static WebDriver driver;

    public static String baseUrl;
    public static String cartUrl;

    public static String LOGIN;
    public static String PASS;

    protected static HomeElements homePageElements;
    protected static SearchFormElements searchFormElements;
    protected static SerpElements serpPageElements;
    protected static CartElements cartPageElements;
    protected static LoginElements loginPageElements;
    protected static ItemCardElements itemCardPageElements;

    @BeforeAll
    public static void initTestSuite() throws IOException
    {
        System.setProperty("webdriver.chrome.driver", "c:\\tools\\chromedriver.exe");
        gridHubUrl = null;
        capabilities = PropertyLoader.loadCapabilities();
        driver = WebDriverPool.DEFAULT.getDriver(gridHubUrl, capabilities);

        baseUrl = PropertyLoader.loadProperty("site.url");
        cartUrl = PropertyLoader.loadProperty("cart.url");

        LOGIN = PropertyLoader.loadProperty("login");
        PASS = PropertyLoader.loadProperty("pass");

        cartPageElements = PageFactory.initElements(driver, CartElements.class);
        searchFormElements = PageFactory.initElements(driver, SearchFormElements.class);
        serpPageElements = PageFactory.initElements(driver, SerpElements.class);
        homePageElements = PageFactory.initElements(driver, HomeElements.class);
        loginPageElements = PageFactory.initElements(driver, LoginElements.class);
        itemCardPageElements = PageFactory.initElements(driver, ItemCardElements.class);
    }

    @BeforeEach
    public void initWebDriver()
    {
        driver = WebDriverPool.DEFAULT.getDriver(gridHubUrl, capabilities);
        driver.manage().window().maximize();
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