package ShoppingCart;

import Utils.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DeleteFromCartPOM extends BasePage {

    By deleteButten;
    By cartStatus;

    public DeleteFromCartPOM(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
        initBys();
    }

    void initBys()
    {
        deleteButten=By.cssSelector("[value=\"Delete\"]");
        cartStatus=By.cssSelector("[class=\"a-spacing-mini a-spacing-top-base\"]");
    }

    boolean Delete()
    {
        waitUntilElemntClickable(deleteButten);
        click(deleteButten);
        waitUntilVisibilityElemntLocated(cartStatus);
        takeScreenShot("ScreanShot\\ShoppingCart\\DeleteFromCart", "Delete", getDriver());
        if(getText(cartStatus).equals("Your Amazon Cart is empty."))
            return true;
        return false;
    }
}
