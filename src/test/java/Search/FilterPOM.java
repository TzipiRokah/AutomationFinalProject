package Search;

import Utils.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class FilterPOM extends BasePage {

    By maxPriceInput;
    By go;
    By goOne;
    By goTwo;
    By itemsByPrice;
    By shortBy;
    By highToLow;
    By choiceColor;
    By choiceColorBr;
    By choiceColorBl;
    By itemsByName;
    By color;
    By colorOne;
    By colorTwo;
    List<WebElement> l;

    public FilterPOM(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
        initBys();
    }

    void initBys()
    {
        maxPriceInput=By.cssSelector("#high-price");
        goOne=By.cssSelector(".a-button-inner .a-button-input");
        goTwo=By.cssSelector("[id=\"#high-price\"]");
        itemsByPrice=By.cssSelector(".a-price-whole");
        shortBy=By.cssSelector("#a-autoid-0-announce");
        highToLow=By.cssSelector("#s-result-sort-select_2");
        choiceColorBr=By.cssSelector("[title=\"Brown\"] div");
        choiceColorBl=By.cssSelector("[title=\"Black\"] div");
        itemsByName=By.cssSelector("[class=\"a-size-base-plus a-color-base a-text-normal\"]");
        colorOne=By.cssSelector("[class=\"a-spacing-small po-color\"] [class=\"a-size-base\"]");
        colorTwo=By.cssSelector("[class=\"a-spacing-none a-spacing-top-small po-color\"] [class=\"a-size-base a-color-tertiary\"]");
    }

    boolean PriceRange(int maxPrice)
    {
        typeInto(String.valueOf(maxPrice),maxPriceInput);
        try{
            waitUntilElemntClickable(goOne);
            go=goOne;
        }catch (Exception E){
            go=goTwo;
        }
        click(go);
        waitUntilVisibilityElemntLocated(itemsByPrice);
        l=findElemnts(itemsByPrice);
        takeScreenShot("ScreanShot\\Search\\Filter","PriceRange",getDriver());
        int i;
        int count=0;
        for (i=0;i<l.size();i++)
        {
            int resultText=Integer.parseInt(l.get(i).getText());
            if(resultText==maxPrice)
                count++;
        }
        if(count>1)
            return false;
        return true;
    }

    boolean ShortByHighToLow()
    {
        waitUntilElemntClickable(shortBy);
        click(shortBy);
        waitUntilElemntClickable(highToLow);
        click(highToLow);
        waitUntilVisibilityElemntLocated(itemsByPrice);
        l=findElemnts(itemsByPrice);
        takeScreenShot("ScreanShot\\Search\\Filter","ShortByHighToLow",getDriver());
        int i,priceOne=999,priceTwo,count=0;
        for (i=0;i<l.size();i++)
        {
            priceTwo=Integer.parseInt(l.get(i).getText());
            System.out.println(priceOne);
            if(priceOne<priceTwo)
                count++;
            priceOne=priceTwo;
        }
        if(count>1)
            return false;
        return true;
    }

    boolean ColorChoice()
    {
        String Color;
        try{
            waitUntilElemntClickable(choiceColorBr);
            choiceColor=choiceColorBr;
            Color="Brown";
        }catch (Exception e){
            choiceColor=choiceColorBl;
            Color="Black";
        }
        click(choiceColor);
        waitUntilElemntClickable(itemsByName);
        click(itemsByName);
        try{
            waitUntilVisibilityElemntLocated(colorOne);
            color=colorOne;
        }catch (Exception e){
            color=colorTwo;
        }
        if(getText(color).equals(Color))
            return true;
        return false;
    }
}
