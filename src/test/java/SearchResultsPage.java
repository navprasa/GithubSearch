import components.WebComponent;
import components.impl.SearchResultItemComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

public class SearchResultsPage extends WebPage {

    public SearchResultsPage(WebDriver driver){
        super(driver);
    }

    private static final By SEARCH_RESULTS_ITEM_SELECTOR = By.xpath("//ul[@class='repo-list']");


    public List<String> searchResultsItemsText(){
        return searchResultItems().stream()
                .map(WebComponent::getText)
                .collect(Collectors.toList());
    }

    public List<String> searchResultsItemswithText(String searchPhrase){
        return searchResultItems().stream()
                .filter(item->item.containsSearchPhrase(searchPhrase))
                .map(WebComponent::getText)
                .collect(Collectors.toList());
    }

    private List<SearchResultItemComponent> searchResultItems(){
        return findElements(SEARCH_RESULTS_ITEM_SELECTOR).stream()
                .map(SearchResultItemComponent::new)
                .collect(Collectors.toList());
    }
}
