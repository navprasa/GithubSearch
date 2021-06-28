import components.impl.SearchComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends WebPage {

    public  HomePage(WebDriver driver){
        super(driver);
    }

    private static final By SEARCH_COMPONENT_SELECTOR = By.cssSelector("[name='q']");

    public SearchComponent searchComponent(){
        return new SearchComponent(findElement(SEARCH_COMPONENT_SELECTOR));

    }

}
