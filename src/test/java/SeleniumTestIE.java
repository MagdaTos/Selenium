import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.testng.annotations.Test;

public class SeleniumTestIE {

    @Test
    public  void openGooglePage() {


/*
        InternetExplorerOptions options = new InternetExplorerOptions();
        options.withInitialBrowserUrl("https://www.google.pl/");*/

        WebDriver driver = getDriver("chrome");
        driver.manage().window().maximize();
        Dimension windowsize = new Dimension(200, 200);
        driver.manage().window().setSize(windowsize);
        driver.get("https://www.google.com");
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("window.open('https://www.testeroprogramowania.pl', 'blank', 'height-200, widt-200')");
        driver.close();
    }
    public WebDriver getDriver(String browser) {
        switch (browser) {
            case "chrome":

                return new ChromeDriver();
            case "firefox":
/*                System.setProperty("webdriver.gecko.driver", "C:\\Program Files\\geckodriver\\geckodriver.exe");*/
                return new FirefoxDriver();
            case "ie":
/*                System.setProperty("webdriver.ie.driver", "C:\\Program Files\\webdriver_ie\\IEDriverServer.exe");*/
                return new InternetExplorerDriver();
            default:
                throw new InvalidArgumentException("Iwalid browser name");

        }
    }
}
