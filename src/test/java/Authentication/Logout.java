package Authentication;
import Utils.SingletonWD;
import io.qameta.allure.Description;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Logout {

        WebDriver driver;
        WebDriverWait wait;
        LogoutPOM lPOM;

        @BeforeClass
        void setUp()
        {
            driver = SingletonWD.getTheDriver(2);
            wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            this.lPOM=new LogoutPOM(driver,wait);
        }

        @Description("Check Logout")
        @Test(priority = 1,description = "Check Logout")
        void logOut() {
            Assert.assertTrue(lPOM.LogOut());
        }
}
