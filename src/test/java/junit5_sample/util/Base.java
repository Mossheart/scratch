package junit5_sample.util;

import org.openqa.selenium.WebDriver;

/**
 * Abstract class representation of a Base in the UI. Base object pattern
 */
public abstract class Base
{
    public static WebDriver driver;

    public Base(WebDriver driver)
    {
        this.driver = driver;
    }
}