package base;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.LoginPage;
import utils.Config;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LogoutTest extends BaseTest {
    LoginPage lp;

    @BeforeEach
    public void init() {
        // O 'driver' vem da BaseTest (super), já inicializado.
        lp = new LoginPage(driver);
    }

    @Test
    public void testLogout() {
        lp.login(Config.get("USER_STANDARD"), Config.get("PASSWORD_STANDARD"));
        assertTrue(lp.isLogoutLinkPresent(), "Logout link should be visible after successful login");
        lp.logout();
        assertFalse(lp.isLogoutLinkPresent(), "Logout link should not be visible after logout");
    }
}
