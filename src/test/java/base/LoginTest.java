package base;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.LoginPage;
import utils.Config;

import static org.junit.jupiter.api.Assertions.*;

@Feature("Authentication")
public class LoginTest extends BaseTest {
    LoginPage lp;


    @BeforeEach
    public void init() {
        // O 'driver' vem da BaseTest (super), já inicializado.
        lp = new LoginPage(driver);
    }

    @Test
    @Description("Test successful login with valid credentials")
    @Severity(SeverityLevel.CRITICAL)
    public void testLogin() {

        lp.login(Config.get("USER_STANDARD"), Config.get("PASSWORD_STANDARD"));
        assertTrue(lp.isLogoutLinkPresent(), "Logout link should be visible after successful login");

    }

    @Test
    @Description("Test login with invalid credentials")
    @Severity(SeverityLevel.NORMAL)
    public void testInvalidLogin() {
        lp.login("invaliduser@example.com", "wrongpassword");
        assertTrue(lp.isErrorMessagePresent(), "Error message should be visible after invalid login");
        assertFalse(lp.isLogoutLinkPresent(), "Logout link should not be visible after invalid login");
    }

    @Test
    @Description("Test logout functionality after successful login")
    @Severity(SeverityLevel.NORMAL)
    public void testLogout() {
        lp.login(Config.get("USER_STANDARD"), Config.get("PASSWORD_STANDARD"));
        assertTrue(lp.isLogoutLinkPresent(), "Logout link should be visible after successful login");
        lp.logout();
        assertFalse(lp.isLogoutLinkPresent(), "Logout link should not be visible after logout");
    }

}
