package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage{

    public LoginPage(WebDriver driver) {
        super(driver);
    }
    // Locators (Mapeamento dos elementos)

    @FindBy(css = "div.login-form input[data-qa='login-email']")
    private WebElement usernameField;

    @FindBy(css = "div.login-form input[data-qa='login-password']")
    private WebElement passwordField;

    @FindBy(css = "button[data-qa='login-button']")
    private WebElement loginButton;

    @FindBy (css = "button[data-qa='signup-button']")
    private WebElement signUpButton;

    @FindBy (css = ".signup-form input[data-qa='signup-name']")
    private WebElement signUpName;

    @FindBy (css = ".signup-form input[data-qa='signup-email']")
    private WebElement signUpEmail;


    @FindBy(css = "li a i.fa-user + b")
    private WebElement loginSuccess;

    @FindBy(css = ".nav > li:nth-child(4) > a:nth-child(1)")
    private WebElement signLogButton;

    @FindBy(css = "a[href='/logout']")
    private WebElement logoutLink;

    public void login(String username, String pass) {
        click(signLogButton);
        write(usernameField, username);
        write(passwordField , pass);
        click(loginButton);
    }

    public boolean isLogoutLinkPresent() {
        try {
            wait.until(ExpectedConditions.visibilityOf(logoutLink));
            return logoutLink.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
    public void signup(String name, String email) {
        click(signLogButton);
        write(signUpName, name);
        write(signUpEmail , email);
        click(signUpButton);

    }
}