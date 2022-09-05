package Utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverUtils {
    public static WebDriver createDriverObj(int browserType) {
        WebDriver webDriver = null;
        switch(browserType) {
            case 1:
                WebDriverManager.firefoxdriver().setup();
                webDriver = new FirefoxDriver();
                break;
            case 2:
                WebDriverManager.chromedriver().setup();
                webDriver = new ChromeDriver();
                break;
            case 3:
                WebDriverManager.edgedriver().setup();
                webDriver = new EdgeDriver();
                break;
            default:
                break;
        }
        return webDriver;
    }
}
