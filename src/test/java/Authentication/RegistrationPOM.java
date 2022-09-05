package Authentication;

import ReadDtat.RegistrationData;
import Utils.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegistrationPOM extends BasePage {

    By accountButten;
    By firstName;
    By lastName;
    By email;
    By password;
    By firstNameError;
    By lastNameError;
    By emailError;
    By passwordError;
    By createAccountButten;
    By antherPage;

    public RegistrationPOM(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
        initBys();
    }

    void initBys()
    {
        accountButten=By.cssSelector("#gh-ug-flex a");
        firstName=By.cssSelector("#firstname");
        lastName=By.cssSelector("#lastname");
        email=By.cssSelector("#Email");
        password=By.cssSelector("#password");
        firstNameError= By.cssSelector("#firstname_err");
        lastNameError=By.cssSelector("#lastname_err");
        emailError=By.cssSelector("#Email_err");
        passwordError=By.cssSelector(".password-comp .error-message");
        createAccountButten=By.cssSelector("#EMAIL_REG_FORM_SUBMIT");
        antherPage=By.cssSelector("[name=\"SEND_RECLAIM_EMAIL\"]");
    }

    void inputValue(RegistrationData rData)
    {
        waitUntilVisibilityElemntLocated(firstName);
        typeInto(rData.getFirstName(),firstName);
        typeInto(rData.getLastName(),lastName);
        typeInto(rData.getEmail(),email);
        typeInto(rData.getPassword(),password);
    }

    public void GoToPage()
    {
        getDriver().get("https://www.ebay.com/");
        waitUntilElemntClickable(accountButten);
        click(accountButten);
    }

    public boolean WithoutFirstName(RegistrationData rData)
    {
        inputValue(rData);
        try{
            waitUntilVisibilityElemntLocated(firstNameError);
        }catch (Exception e){
            click(firstName);
            click(lastName);
        }
        takeScreenShot("ScreanShot\\Authentication\\Registration","WithoutFirstName",getDriver());
        String ErrorFirstName=getText(firstNameError);
        if(rData.getError().equals(ErrorFirstName))
            return true;
        return false;
    }

    public boolean WithoutLastName(RegistrationData rData)
    {
        inputValue(rData);
        waitUntilVisibilityElemntLocated(lastNameError);
        String ErrorLastName=getText(lastNameError);
        takeScreenShot("ScreanShot\\Authentication\\Registration","WithoutLastName",getDriver());
        if(rData.getError().equals(ErrorLastName))
            return true;
        return false;
    }

    public boolean WithoutEmail(RegistrationData rData)
    {
        inputValue(rData);
        waitUntilVisibilityElemntLocated(emailError);
        takeScreenShot("ScreanShot\\Authentication\\Registration","WithoutEmail",getDriver());
        String ErrorEmail=getText(emailError);
        if(rData.getError().equals(ErrorEmail))
            return true;
        return false;
    }

    public boolean WithoutPassword(RegistrationData rData)
    {
        inputValue(rData);
        click(email);
        waitUntilVisibilityElemntLocated(passwordError);
        takeScreenShot("ScreanShot\\Authentication\\Registration","WithoutPassword",getDriver());
        String ErrorPassword=getText(passwordError);
        if(rData.getError().equals(ErrorPassword))
            return true;
        return false;
    }

    public boolean WithWrongEmail(RegistrationData rData)
    {
        inputValue(rData);
        waitUntilVisibilityElemntLocated(emailError);
        takeScreenShot("ScreanShot\\Authentication\\Registration","WithWrongEmail",getDriver());
        String ErrorWrongEmail=getText(emailError);
        if(rData.getError().equals(ErrorWrongEmail))
            return true;
        return false;
    }

    public boolean WithShortPassword(RegistrationData rData)
    {
        inputValue(rData);
        click(email);
        waitUntilVisibilityElemntLocated(passwordError);
        takeScreenShot("ScreanShot\\Authentication\\Registration","WithShortPassword",getDriver());
        String ErrorShortPassword=getText(passwordError);
        if(rData.getError().equals(ErrorShortPassword))
            return true;
        return false;
    }

    public boolean WithWrongPassword(RegistrationData rData)
    {
        inputValue(rData);
        click(email);
        waitUntilVisibilityElemntLocated(passwordError);
        takeScreenShot("ScreanShot\\Authentication\\Registration","WithWrongPassword",getDriver());
        String ErrorWrongPassword=getText(passwordError);
        if(rData.getError().equals(ErrorWrongPassword))
            return true;
        return false;

    }

    public boolean AllCorrect(RegistrationData rData)
    {
        inputValue(rData);
        waitUntilElemntClickable(createAccountButten);
        click(createAccountButten);
        waitUntilVisibilityElemntLocated(antherPage);
        takeScreenShot("ScreanShot\\Authentication\\Registration","AllCorrect",getDriver());
        if(getDriver().getCurrentUrl().equals("https://signup.ebay.com/pa/crte?ru=https%3A%2F%2Fwww.ebay.com%2F"))
            return true;
        return false;
    }
}
