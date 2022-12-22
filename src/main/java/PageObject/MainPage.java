package PageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage extends BasePage{

    public MainPage() {
        PageFactory.initElements(this.driver, this);
    }
    @FindBy(xpath = "//input[@data-test-selector='nav-search-input']")
    WebElement searchInput;

    @FindBy(xpath = "//li[contains(@id, 'jump-to-suggestion-repository')]")
    WebElement suggestionRepository;

    public void inputSearch(String word) {
        searchInput.sendKeys(word);
        suggestionRepository.click();
    }
}
