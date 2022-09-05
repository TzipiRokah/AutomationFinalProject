package Authentication;

import ReadDtat.LoginData;
import Utils.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LogoutPOM extends BasePage {

    By accountButten;
    By logOutButten;
    By singOutPage;

    public LogoutPOM(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
        initBys();
    }

    void initBys()
    {
        accountButten=By.cssSelector("#nav-link-accountList");
        logOutButten=By.cssSelector("#nav-item-signout");
        singOutPage=By.cssSelector(".a-spacing-small");
    }

    boolean LogOut()
    {
        mouseHover(accountButten);
        waitUntilElemntClickable(logOutButten);
        click(logOutButten);
        try{
            waitUntilVisibilityElemntLocated(singOutPage);
            takeScreenShot("ScreanShot\\Authentication\\Logout","Logout",getDriver());
            return true;
        }catch (Exception e){
            takeScreenShot("ScreanShot\\Authentication\\Logout","Logout",getDriver());
            return false;
        }
    }
}
