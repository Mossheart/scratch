package junit5_sample.models;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Dmitriev on 29.03.2016.
 */
@Component
public class SerpElements
{
    @FindBy(how = How.XPATH, using = ".//*[@class='lvtitle']/a")
    public List<WebElement> allSnippets;

    public static final String ALL_SNIPPETS = ".//*[@class='lvtitle']/a";
}