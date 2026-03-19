package base;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.LoginPage;
import utils.Config;

public class SignUpTest extends BaseTest{
    LoginPage lp;


    @BeforeEach
    public void init() {
        lp = new LoginPage(driver);
    }
    @Test
    public void testSignup() {

        lp.signup(Config.get("USER_STANDARD_NAME"), Config.get("USER_STANDARD"));
//         assert driver.getCurrentUrl().contains("/dashboard") : "Login falhou, URL atual: " + driver.getCurrentUrl();
    }
}
