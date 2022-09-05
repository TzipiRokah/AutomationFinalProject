package ShoppingCart;

import Utils.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddToCartPOM extends BasePage {

    By inputSearch;
    By searchButten;
    By itemsByName;
    By price;
    By name;
    By addToCart;
    By closePop;
    By cartIcon;
    By priceInCart;
    By nameInCart;
    String Name;
    String Price;

    public AddToCartPOM(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
        initBys();
    }

    void initBys()
    {

        inputSearch=By.cssSelector("#twotabsearchtextbox");
        searchButten=By.cssSelector("#nav-search-submit-button");
        itemsByName=By.cssSelector("[class=\"a-size-medium a-color-base a-text-normal\"]");
        price=By.cssSelector("[class=\"a-section a-spacing-none aok-align-center\"] [class=\"a-price-whole\"]");
        name=By.cssSelector("#productTitle");
        addToCart=By.cssSelector("#add-to-cart-button");
        closePop=By.cssSelector("#attach-close_sideSheet-link");
        cartIcon=By.cssSelector("#nav-cart-count");
        priceInCart=By.cssSelector("#sc-subtotal-amount-buybox span");
        nameInCart=By.cssSelector(".a-truncate-cut");
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

    void ItemSelection(String searchWord)
    {
        typeInto(searchWord, inputSearch);
        click(searchButten);
        waitUntilVisibilityElemntLocated(itemsByName);
        click(itemsByName);
        waitUntilVisibilityElemntLocated(price);
        Price=getText(price);
        Name=getText(name).substring(0,51);
        takeScreenShot("ScreanShot\\ShoppingCart\\AddToCart", "ItemSelection", getDriver());
    }

    void AddToCart()
    {
        click(addToCart);
        try {
            waitUntilElemntClickable(closePop);
            click(closePop);
        } catch (Exception e) {
        }
        takeScreenShot("ScreanShot\\ShoppingCart\\AddToCart", "AddToCart", getDriver());
    }

    boolean IconUpdated()
    {
        waitTextToNotBe(cartIcon,"0");
        takeScreenShot("ScreanShot\\ShoppingCart\\AddToCart", "IconUpdated", getDriver());
        if(getText(cartIcon).equals("1"))
            return true;
        return false;
    }

    boolean InsertToCart()
    {
        click(cartIcon);
        try {
            waitUntilVisibilityElemntLocated(priceInCart);
            takeScreenShot("ScreanShot\\ShoppingCart\\AddToCart", "InsertToCart", getDriver());
            return true;
        }catch (Exception e){
            takeScreenShot("ScreanShot\\ShoppingCart\\AddToCart", "InsertToCart", getDriver());
            return false;
        }
    }

    boolean SamePrice()
    {
        String PriceInCart=getText(priceInCart).substring(1,4);
        takeScreenShot("ScreanShot\\ShoppingCart\\AddToCart", "SamePrice", getDriver());
        System.out.println(Price+" "+PriceInCart);
        if(Price.equals(PriceInCart))
            return true;
        return false;
    }

    boolean SameName()
    {
        String NameInCart=getText(nameInCart).substring(0,51);
        takeScreenShot("ScreanShot\\ShoppingCart\\AddToCart", "SameName", getDriver());
        if(Name.equals(NameInCart))
            return true;
        return false;
    }
}
