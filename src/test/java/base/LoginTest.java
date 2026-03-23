package base;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.LoginPage;
import utils.Config;

import static org.junit.jupiter.api.Assertions.*;

public class LoginTest extends BaseTest {
    LoginPage lp;


    @BeforeEach
    public void init() {
        // O 'driver' vem da BaseTest (super), já inicializado.
        lp = new LoginPage(driver);
    }

    @Test
    public void testLogin() {

        lp.login(Config.get("USER_STANDARD"), Config.get("PASSWORD_STANDARD"));
        assertTrue(lp.isLogoutLinkPresent(), "Logout link should be visible after successful login");

    }

}
