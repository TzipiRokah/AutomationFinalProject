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

public class Search {

    WebDriver driver;
    WebDriverWait wait;
    ReadFromExcel rExcel;
    SearchPOM sPOM;

    @BeforeClass
    void setUp()
    {
        driver = SingletonWD.getTheDriver(2);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.sPOM= new SearchPOM(driver, wait);
        this.rExcel=new ReadFromExcel();
        sPOM.GoToPage();
    }

    @Description("Check item search")
    @Test(priority = 1,description = "Check item search")
    void itemSearch()
    {
        String serchItem=rExcel.readSearch("src/test/java/ReadDtat/data.xlsx",1);
        Assert.assertTrue(sPOM.ItemSearch(serchItem));
    }

    @Description("Check display all results")
    @Test(priority = 2,description = "Check display all results")
    void displayAllResults()
    {
        Assert.assertTrue(sPOM.DisplayAllResults());
    }

    @Description("All results contain the search term")
    @Test(priority = 3,description = "All results contain the search term")
    void allResultsContainSearchTerm()
    {
        String serchItem=rExcel.readSearch("src/test/java/ReadDtat/data.xlsx",1);
        Assert.assertTrue(sPOM.AllResultsContainSearchTerm(serchItem));
    }
}
