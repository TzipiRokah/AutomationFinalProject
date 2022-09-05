package Search;

import ReadDtat.ReadFromExcel;
import Utils.SingletonWD;
import io.qameta.allure.Description;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Filter {

    WebDriver driver;
    WebDriverWait wait;
    FilterPOM fPOM;

    @BeforeClass
    void setUp()
    {
        driver = SingletonWD.getTheDriver(2);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.fPOM= new FilterPOM(driver, wait);
    }

    @Description("Check item search")
    @Test(priority = 1,description = "Check item search")
    void priceRange()
    {
        Assert.assertTrue(fPOM.PriceRange(100));
    }

    @Description("Check short by high to low")
    @Test(priority = 2,description = "Check short by high to low")
    void shortByHighToLow()
    {
        Assert.assertTrue(fPOM.ShortByHighToLow());
    }

    @Description("Check color choice")
    @Test(priority = 3,description = "Check color choice")
    void colorChoice()
    {
        Assert.assertTrue(fPOM.ColorChoice());
    }
}
