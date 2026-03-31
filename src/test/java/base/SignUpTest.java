package base;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.LoginPage;
import pages.SignupPage;
import utils.Config;

import static org.junit.jupiter.api.Assertions.assertTrue;

@Feature("User Registration")
public class SignUpTest extends BaseTest {
    LoginPage lp;
    SignupPage sp;


    @BeforeEach
    public void init() {
        lp = new LoginPage(driver);
        sp = new SignupPage(driver);
    }

    @Test
    @Description("Test complete signup process with new user details")
    @Severity(SeverityLevel.CRITICAL)
    public void testSignup() {
        lp.signup("TestUser", "testuser" + System.currentTimeMillis() + "@example.com");
        sp.fillAccountInformation("Mr", "password123", "15", "5", "1990", true, true, "Test", "User", "Company", "Address1", "Address2", "United States", "State", "City", "12345", "1234567890");
        sp.createAccount();
        assertTrue(sp.isAccountCreatedMessagePresent(), "Account should be created successfully");
    }

    @Test
    @Description("Test signup attempt with an already existing email")
    @Severity(SeverityLevel.NORMAL)
    public void testExistingEmailSignup() {
        lp.signup("NewUser", Config.get("USER_STANDARD"));
        assertTrue(lp.isSignupErrorPresent(), "Error message should be visible when signing up with an existing email");
    }
}
