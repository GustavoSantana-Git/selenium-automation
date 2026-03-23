package base;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.LoginPage;
import utils.Config;

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
//         assert driver.getCurrentUrl().contains("/dashboard") : "Login falhou, URL atual: " + driver.getCurrentUrl();
    }

}
