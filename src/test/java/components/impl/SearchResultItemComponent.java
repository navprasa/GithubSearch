package components.impl;

import components.WebComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class SearchResultItemComponent extends WebComponent {

    private static final By TITLE_SELECTOR = By.xpath("//a[@class='v-align-middle']");
    private static final By DESCRIPTION_SELECTOR = By.xpath("//p[@class='mb-1']");

    public SearchResultItemComponent(WebElement rootElement) {
        super(rootElement);
    }

    public boolean containsSearchPhrase (String searchPhrase){
        return containsSearchPhraseIgnoringCase(searchPhrase,TITLE_SELECTOR) ||
                containsSearchPhraseIgnoringCase(searchPhrase, DESCRIPTION_SELECTOR);
    }

    private boolean containsSearchPhraseIgnoringCase(String searchPhrase, By selector){
        return findElement(selector).getText().toLowerCase().contains(searchPhrase);
    }
}
