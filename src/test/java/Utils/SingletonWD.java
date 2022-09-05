package Utils;
import org.openqa.selenium.WebDriver;
import static Utils.WebDriverUtils.createDriverObj;

public class SingletonWD {

    private static SingletonWD theSingleTon = null;
    private static WebDriver driver;

    private SingletonWD(int whichBrowser) // 1 firefox, 2 chrome, 3 edge
    {
        driver = createDriverObj(whichBrowser);
    }

    private static void initTheSingelton(int numOfBrowser)
    {
        if(theSingleTon == null)
        {
            theSingleTon = new SingletonWD(numOfBrowser);
        }
    }

    public static WebDriver getTheDriver(int browserTypeNum)
    {
        initTheSingelton(browserTypeNum);
        return driver;
    }
}
