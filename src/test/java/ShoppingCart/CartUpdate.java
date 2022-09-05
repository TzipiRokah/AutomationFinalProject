package ShoppingCart;

import ReadDtat.ReadFromExcel;
import Utils.SingletonWD;
import io.qameta.allure.Description;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class CartUpdate {

    WebDriver driver;
    WebDriverWait wait;
    CartUpdatePOM aPOM;

    @BeforeClass
    void setUp()
    {
        driver = SingletonWD.getTheDriver(2);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.aPOM= new CartUpdatePOM(driver, wait);
    }

    @Description("Check update quantity")
    @Test(priority = 1,description = "Check update quantity")
    void updateQuantity()
    {
        aPOM.UpdateQuantity();
    }
}
