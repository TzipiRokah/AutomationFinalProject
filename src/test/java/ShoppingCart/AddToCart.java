package ShoppingCart;

import ReadDtat.ReadFromExcel;
import Utils.SingletonWD;
import io.qameta.allure.Description;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class AddToCart {

    WebDriver driver;
    WebDriverWait wait;
    AddToCartPOM aPOM;
    ReadFromExcel rExcel;

    @BeforeClass
    void setUp()
    {
        driver = SingletonWD.getTheDriver(2);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.aPOM= new AddToCartPOM(driver, wait);
        this.rExcel=new ReadFromExcel();
        aPOM.GoToPage();
    }

    @Description("Check item selection")
    @Test(priority = 1,description = "Check item selection")
    void itemSelection()
    {
        String searchWord=rExcel.readShoppingCart("src/test/java/ReadDtat/data.xlsx",1);
        aPOM.ItemSelection(searchWord);
    }

    @Description("Check add to cart")
    @Test(priority = 2,description = "Check add to cart")
    void addToCart()
    {
        aPOM.AddToCart();
    }

    @Description("Check icon updated")
    @Test(priority = 3,description = "Check icon updated")
    void iconUpdated()
    {
        Assert.assertTrue(aPOM.IconUpdated());
    }

    @Description("Check insert to cart")
    @Test(priority = 4,description = "Check insert to cart")
    void insertToCart()
    {
        Assert.assertTrue(aPOM.InsertToCart());
    }

    @Description("Check same price")
    @Test(priority = 5,description = "Check same price")
    void samePrice()
    {
        Assert.assertTrue(aPOM.SamePrice());
    }

    @Description("Check same name")
    @Test(priority = 6,description = "Check same name")
    void sameName()
    {
        Assert.assertTrue(aPOM.SameName());
    }

}
