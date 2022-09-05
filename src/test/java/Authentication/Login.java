package Authentication;

import ReadDtat.LoginData;
import ReadDtat.ReadFromExcel;
import Utils.SingletonWD;
import io.qameta.allure.Description;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Login {

    WebDriver driver;
    WebDriverWait wait;
    LoginPOM lPOM;
    LoginData lData;
    ReadFromExcel lExcel;

    @BeforeClass
    void setUp()
    {
        driver = SingletonWD.getTheDriver(2);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.lPOM= new LoginPOM(driver, wait);
        this.lExcel=new ReadFromExcel();
        lPOM.GoToPage();
    }

    @Description("Check without email")
    @Test(priority = 1,description = "Check without email")
    void withoutEmail()
    {
        lData=lExcel.readLogin("src/test/java/ReadDtat/data.xlsx",1);
        Assert.assertTrue(lPOM.WithoutEmail(lData));
    }

    @Description("Check with non existent email")
    @Test(priority = 2,description = "Check with non existent email")
    void withNonExistentEmail()
    {
        lData=lExcel.readLogin("src/test/java/ReadDtat/data.xlsx",2);
        Assert.assertTrue(lPOM.WithNonExistentEmail(lData));
    }

    @Description("Check without password")
    @Test(priority = 3,description = "Check without password")
    void withoutPassword()
    {
        lData=lExcel.readLogin("src/test/java/ReadDtat/data.xlsx",3);
        Assert.assertTrue(lPOM.WithoutPassword(lData));
    }

    @Description("Check with wrong password")
    @Test(priority = 4,description = "Check with wrong password")
    void withWrongPassword()
    {
        lData=lExcel.readLogin("src/test/java/ReadDtat/data.xlsx",4);
        Assert.assertTrue(lPOM.WithWrongPassword(lData));
    }

    @Description("Check all correct")
    @Test(priority = 5,description = "Check all correct")
    void allcorrect()
    {
        lData=lExcel.readLogin("src/test/java/ReadDtat/data.xlsx",5);
        Assert.assertTrue(lPOM.Allcorrect(lData));
    }
}
