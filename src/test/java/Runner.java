import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Runner {

    private static final String Search_Phrase = "selenium";
    private static WebDriver driver;
    @BeforeAll
    public static void LoadDriver(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void run(){
        driver.get("http://www.github.com");

        HomePage homePage = new HomePage(driver);
        SearchResultsPage searchResultsPage = new SearchResultsPage(driver);

        homePage.searchComponent().performSearch(Search_Phrase);
        List<String> searchresult = searchResultsPage.searchResultsItemsText();
        List<String> actualresult = searchResultsPage.searchResultsItemswithText(Search_Phrase);

        Assertions.assertEquals(actualresult,searchresult);


    }

    @AfterAll
    public static void tearDown(){
        driver.close();
    }
}
