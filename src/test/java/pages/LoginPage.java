package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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



    public void login(String username, String pass) {
        click(signLogButton);
        write(usernameField, username);
        write(passwordField , pass);
        click(loginButton);


    }
    public void signup(String name, String email) {
        click(signLogButton);
        write(signUpName, name);
        write(signUpEmail , email);
        click(signUpButton);

    }
}