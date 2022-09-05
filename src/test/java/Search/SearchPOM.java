package Search;

import Utils.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class SearchPOM extends BasePage {

    By inputSearch;
    By searchButten;
    By itemsByName;
    By resultsFor;
    By numberOfResults;
    List<WebElement> l;

    public SearchPOM(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
        initBys();
    }

    void initBys()
    {
        inputSearch=By.cssSelector("#twotabsearchtextbox");
        searchButten=By.cssSelector("#nav-search-submit-button");
        itemsByName=By.cssSelector("[class=\"a-size-base-plus a-color-base a-text-normal\"]");
        resultsFor=By.cssSelector("[class=\"a-section a-spacing-small a-spacing-top-small\"] span:nth-child(3)");
        numberOfResults=By.cssSelector("[class=\"a-section a-spacing-small a-spacing-top-small\"] span");
    }

    void GoToPage()
    {
        while (true)
        {
            getDriver().get("https://www.amazon.com/?language=en_US&currency=USD");
            try {
                waitUntilVisibilityElemntLocated(inputSearch);
                break;
            }catch (Exception e){}
        }
    }

    boolean ItemSearch(String searchWord)
    {
        typeInto(searchWord,inputSearch);
        click(searchButten);
        waitUntilVisibilityElemntLocated(resultsFor);
        takeScreenShot("ScreanShot\\Search\\Search","ItemSearch",getDriver());
        String ResultsFor=getText(resultsFor).substring(1,21);
        System.out.println(ResultsFor+searchWord);
        if(ResultsFor.equals(searchWord))
            return true;
        return false;
    }

    boolean DisplayAllResults()
    {
        waitUntilVisibilityElemntLocated(itemsByName);
        l=findElemnts(itemsByName);
        takeScreenShot("ScreanShot\\Search\\Search","DisplayAllResults",getDriver());
        String NumberOfResults=getText(numberOfResults).substring(0,2);
        if(Integer.parseInt(NumberOfResults)==l.size())
            return true;
        return false;
    }

    boolean AllResultsContainSearchTerm(String searchWord)
    {
        takeScreenShot("ScreanShot\\Search\\Search","ItemSearch",getDriver());
        int i;
        for (i=1;i<l.size();i++)
        {
            String resultText=l.get(i).getText();
            if(!resultText.contains("Linon"))
                return false;
        }
        return true;
    }
}
