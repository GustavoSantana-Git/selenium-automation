package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class SignupPage extends BasePage {

    public SignupPage(WebDriver driver) {
        super(driver);
    }

    // Locators for Account Information Form

    @FindBy(id = "id_gender1")
    private WebElement titleMr;

    @FindBy(id = "id_gender2")
    private WebElement titleMrs;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(id = "days")
    private WebElement daySelect;

    @FindBy(id = "months")
    private WebElement monthSelect;

    @FindBy(id = "years")
    private WebElement yearSelect;

    @FindBy(id = "newsletter")
    private WebElement newsletterCheckbox;

    @FindBy(id = "optin")
    private WebElement optinCheckbox;

    @FindBy(id = "first_name")
    private WebElement firstNameField;

    @FindBy(id = "last_name")
    private WebElement lastNameField;

    @FindBy(id = "company")
    private WebElement companyField;

    @FindBy(id = "address1")
    private WebElement address1Field;

    @FindBy(id = "address2")
    private WebElement address2Field;

    @FindBy(id = "country")
    private WebElement countrySelect;

    @FindBy(id = "state")
    private WebElement stateField;

    @FindBy(id = "city")
    private WebElement cityField;

    @FindBy(id = "zipcode")
    private WebElement zipcodeField;

    @FindBy(id = "mobile_number")
    private WebElement mobileNumberField;

    @FindBy(css = "button[data-qa='create-account']")
    private WebElement createAccountButton;

    @FindBy(css = "h2[data-qa='account-created']")
    private WebElement accountCreatedMessage;

    @FindBy(css = "a[data-qa='continue-button']")
    private WebElement continueButton;

    // Methods

    public void selectTitle(String title) {
        if ("Mr".equals(title)) {
            click(titleMr);
        } else if ("Mrs".equals(title)) {
            click(titleMrs);
        }
    }

    public void enterPassword(String password) {
        write(passwordField, password);
    }

    public void selectDateOfBirth(String day, String month, String year) {
        new Select(daySelect).selectByValue(day);
        new Select(monthSelect).selectByValue(month);
        new Select(yearSelect).selectByValue(year);
    }

    public void checkNewsletter(boolean check) {
        if (check) {
            click(newsletterCheckbox);
        }
    }

    public void checkOptin(boolean check) {
        if (check) {
            click(optinCheckbox);
        }
    }

    public void enterFirstName(String firstName) {
        write(firstNameField, firstName);
    }

    public void enterLastName(String lastName) {
        write(lastNameField, lastName);
    }

    public void enterCompany(String company) {
        write(companyField, company);
    }

    public void enterAddress1(String address1) {
        write(address1Field, address1);
    }

    public void enterAddress2(String address2) {
        write(address2Field, address2);
    }

    public void selectCountry(String country) {
        new Select(countrySelect).selectByValue(country);
    }

    public void enterState(String state) {
        write(stateField, state);
    }

    public void enterCity(String city) {
        write(cityField, city);
    }

    public void enterZipcode(String zipcode) {
        write(zipcodeField, zipcode);
    }

    public void enterMobileNumber(String mobile) {
        write(mobileNumberField, mobile);
    }

    public void fillAccountInformation(String title, String password, String day, String month, String year,
                                       boolean newsletter, boolean optin, String firstName, String lastName,
                                       String company, String address1, String address2, String country,
                                       String state, String city, String zipcode, String mobile) {
        // Hide ad iframes before interacting with form fields
        if (driver instanceof JavascriptExecutor) {
            try {
                ((JavascriptExecutor) driver).executeScript(
                    "document.querySelectorAll('iframe').forEach(function(e){e.style.display=\'none\';});"
                );
            } catch (Exception ignored) {}
        }
        selectTitle(title);
        enterPassword(password);
        selectDateOfBirth(day, month, year);
        checkNewsletter(newsletter);
        checkOptin(optin);
        enterFirstName(firstName);
        enterLastName(lastName);
        enterCompany(company);
        enterAddress1(address1);
        enterAddress2(address2);
        selectCountry(country);
        enterState(state);
        enterCity(city);
        enterZipcode(zipcode);
        enterMobileNumber(mobile);
    }

    public void createAccount() {
        click(createAccountButton);
    }

    public boolean isAccountCreatedMessagePresent() {
        try {
            wait.until(ExpectedConditions.visibilityOf(accountCreatedMessage));
            return accountCreatedMessage.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public void clickContinue() {
        click(continueButton);
    }
}
