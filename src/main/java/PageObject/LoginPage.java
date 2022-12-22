package PageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {
    @FindBy(xpath = "//input[@id='login_field']")
    WebElement loginButton;

    @FindBy(xpath = "//input[@id='password']")
    WebElement passwordButton;

    @FindBy(xpath = "//input[@value='Sign in']")
    WebElement signInButton;

    public LoginPage() {
        PageFactory.initElements(driver, this);
    }

    public void signIn(String login, String password) {
        loginButton.sendKeys(login);
        passwordButton.sendKeys(password);
        signInButton.click();
    }
}
