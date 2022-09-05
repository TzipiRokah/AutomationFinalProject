package ShoppingCart;

import Utils.SingletonWD;
import io.qameta.allure.Description;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class DeleteFromCart {

    WebDriver driver;
    WebDriverWait wait;
    DeleteFromCartPOM dPOM;

    @BeforeClass
    void setUp()
    {
        driver = SingletonWD.getTheDriver(2);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.dPOM= new DeleteFromCartPOM(driver, wait);
    }

    @Description("Check delete from cart")
    @Test(priority = 1,description = "Check delete from cart")
    void delete()
    {
        dPOM.Delete();
    }

//    @AfterSuite
//    void close()
//    {
//        driver.quit();;
//    }
}
