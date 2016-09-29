package Tests;

import com.labox.appium.config.BaseTest;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

   @Test
    public void logintest(){
       app.loginPage.login("ewfew", "jefhe");
   }
}
