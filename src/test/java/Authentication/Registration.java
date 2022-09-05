package Authentication;

import ReadDtat.ReadFromExcel;
import ReadDtat.RegistrationData;
import Utils.SingletonWD;
import io.qameta.allure.Description;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Registration {

    WebDriver driver;
    WebDriverWait wait;
    RegistrationPOM rPOM;
    ReadFromExcel rExcel;
    RegistrationData rData;

    @BeforeClass
    void setUp()
    {
        driver = SingletonWD.getTheDriver(2);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.rPOM= new RegistrationPOM(driver, wait);
        this.rExcel=new ReadFromExcel();
        this.rData=new RegistrationData();
        rPOM.GoToPage();
    }

    @Description("Check without first name")
    @Test(priority = 1,description = "Check without first name")
    void withoutFirstName()
    {
        rData=rExcel.readRegistration("src/test/java/ReadDtat/data.xlsx",1);
        Assert.assertTrue(rPOM.WithoutFirstName(rData));
    }

    @Description("Check without last name")
    @Test(priority = 2,description = "Check without last name")
    void withoutLastName()
    {
        rPOM.refresh();
        rData=rExcel.readRegistration("src/test/java/ReadDtat/data.xlsx",2);
        Assert.assertTrue(rPOM.WithoutLastName(rData));
    }

    @Description("Check without email")
    @Test(priority = 3,description = "Check without email")
    void withoutEmail()
    {
        rPOM.refresh();
        rData=rExcel.readRegistration("src/test/java/ReadDtat/data.xlsx",3);
        Assert.assertTrue(rPOM.WithoutEmail(rData));
    }

    @Description("Check without password")
    @Test(priority = 4,description = "Check without password")
    void withoutPassword()
    {
        rPOM.refresh();
        rData=rExcel.readRegistration("src/test/java/ReadDtat/data.xlsx",4);
        Assert.assertTrue(rPOM.WithoutPassword(rData));
    }

    @Description("Check with wrong email")
    @Test(priority = 5,description = "Check with wrong email")
    void withWrongEmail()
    {
        rPOM.refresh();
        rData=rExcel.readRegistration("src/test/java/ReadDtat/data.xlsx",5);
        Assert.assertTrue(rPOM.WithWrongEmail(rData));
    }

    @Description("Check with short password")
    @Test(priority = 6,description = "Check Without First Name")
    void withShortPassword()
    {
        rPOM.refresh();
        rData=rExcel.readRegistration("src/test/java/ReadDtat/data.xlsx",6);
        Assert.assertTrue(rPOM.WithShortPassword(rData));
    }

    @Description("Check with wrong password")
    @Test(priority = 7,description = "Check With wrong password")
    void withWrongPassword()
    {
        rPOM.refresh();
        rData=rExcel.readRegistration("src/test/java/ReadDtat/data.xlsx",7);
        Assert.assertTrue(rPOM.WithWrongPassword(rData));
    }

    @Description("Check with all correct")
    @Test(priority = 8,description = "Check with all correct")
    void allCorrect()
    {
        rPOM.refresh();
        rData=rExcel.readRegistration("src/test/java/ReadDtat/data.xlsx",8);
        Assert.assertTrue(rPOM.AllCorrect(rData));
    }
}
