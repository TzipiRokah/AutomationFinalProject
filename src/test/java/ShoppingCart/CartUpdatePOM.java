package ShoppingCart;

import Utils.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartUpdatePOM extends BasePage {

    By quantity;
    By quantitySelection;
    By some;

    public CartUpdatePOM(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
        initBys();
    }

    void initBys()
    {
        quantity=By.cssSelector("#a-autoid-0-announce");
        quantitySelection=By.cssSelector("#quantity_2");
        some=By.cssSelector(".a-dropdown-prompt");
    }

    boolean UpdateQuantity()
    {
        click(quantity);
        waitUntilElemntClickable(quantitySelection);
        click(quantitySelection);
        takeScreenShot("ScreanShot\\ShoppingCart\\CartUpdate", "UpdateQuantity", getDriver());
        if(getText(some).equals("2"))
            return true;
        return false;
    }
}
