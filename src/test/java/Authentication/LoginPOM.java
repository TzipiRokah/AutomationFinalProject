package Authentication;

import ReadDtat.LoginData;
import Utils.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPOM extends BasePage {

    By loginLink;
    By email;
    By continueButten;
    By password;
    By loginButten;
    By ErrorOne;
    By ErrorTwo;
    By singInButten;
    By accountButten;

    void initBys()
    {
        loginLink=By.cssSelector("#nav-link-accountList");
        email=By.cssSelector("#ap_email");
        continueButten=By.cssSelector("#continue");
        password= By.cssSelector("#ap_password");
        loginButten=By.cssSelector("#signInSubmit");
        ErrorOne=By.cssSelector(".a-list-item");
        ErrorTwo=By.cssSelector("#auth-email-missing-alert .a-alert-content");
        singInButten=By.cssSelector("#signInSubmit");
        accountButten=By.cssSelector("#nav-link-accountList");
    }

    public LoginPOM(WebDriver driver, WebDriverWait wait)
    {
        super(driver, wait);
        initBys();
    }

    void GoToPage()
    {
        while (true)
        {
            getDriver().get("https://www.amazon.com/?language=en_US&currency=USD");
            try {
                waitUntilElemntClickable(loginLink);
                click(loginLink);
                break;
            }catch (Exception e){}
        }
    }

    String returnError()
    {
        String Error=null;
            try {
                waitUntilVisibilityElemntLocated(ErrorOne);
                Error = getText(ErrorOne);
            } catch (Exception e) {
                Error = getText(ErrorTwo);
            }
        return Error;
    }

    boolean WithoutEmail(LoginData lData)
    {
        waitUntilElemntClickable(continueButten);
        click(continueButten);
        takeScreenShot("ScreanShot\\Authentication\\Login","WithoutEmail",getDriver());
        if(lData.getError().equals(returnError()))
            return true;
        return false;
    }

    boolean WithNonExistentEmail(LoginData lData)
    {
        typeInto(lData.getEmail(),email);
        click(continueButten);
        takeScreenShot("ScreanShot\\Authentication\\Login","WithNonExistentEmail",getDriver());
        if(lData.getError().equals(returnError()))
            return true;
        return false;
    }

    boolean WithoutPassword(LoginData lData)
    {
        waitUntilVisibilityElemntLocated(email);
        findElemnt(email).clear();
        typeInto(lData.getEmail(),email);
        click(continueButten);
        takeScreenShot("ScreanShot\\Authentication\\Login","WithoutPassword",getDriver());
        try {
            waitUntilVisibilityElemntLocated(password);
            findElemnt(password);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    boolean WithWrongPassword(LoginData lData)
    {
        typeInto(lData.getPassword(),password);
        click(singInButten);
        takeScreenShot("ScreanShot\\Authentication\\Login","WithWrongPassword",getDriver());
        if(lData.getError().equals(returnError()))
            return true;
        return false;
    }

    boolean Allcorrect(LoginData lData)
    {
        typeInto(lData.getPassword(),password);
        System.out.println(lData.getPassword());
        waitUntilElemntClickable(singInButten);
        click(singInButten);
        waitUntilVisibilityElemntLocated(accountButten);
        String thisUrl="https://www.amazon.com/?language=en_US&currency=USD&ref_=nav_ya_signin";
        takeScreenShot("ScreanShot\\Authentication\\Login","AllGood",getDriver());
        if(getDriver().getCurrentUrl().equals(thisUrl))
            return true;
        return false;
    }
}
