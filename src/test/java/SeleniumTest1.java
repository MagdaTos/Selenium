import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SeleniumTest1{

    @Test
    public  void openGooglePage() {


/*
        InternetExplorerOptions options = new InternetExplorerOptions();
        options.withInitialBrowserUrl("https://www.google.pl/");*/

        WebDriver driver = getDriver("chrome");

        driver.manage().window().maximize();

        driver.get("https://www.google.com");

// znalezienie przycisku

        WebElement agreeButton = driver.findElement(By.xpath("//div[contains(text(),'Zgadzam')]"));

// klikniecie przycisku

        agreeButton.click();

// znajdz pole wyszukiwania

        WebElement searchField = driver.findElement(By.name("q"));

// wprowadz wartosc Selenium do pola

        searchField.sendKeys("Selenium");

// zasymuluj nacisniecie przycisku Enter

        searchField.sendKeys(Keys.ENTER);

// znalezc rezultat

        WebElement result = driver.findElement(By.xpath("//a[contains(@href,'selenium.dev')]//h3"));

        Assert.assertTrue(result.isDisplayed());



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

