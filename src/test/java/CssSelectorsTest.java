import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class CssSelectorsTest {
    @Test
    public void findElements(){
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
        driver.get("https://testeroprogramowania.github.io/selenium/basics.html");
        //button
        By cssId = By.cssSelector("#clickOnMe");
        driver.findElement(cssId);

        //clasa
        By cssClass = By.cssSelector(".topSecret");
        driver.findElement(cssClass);

        By cssTag = By.cssSelector("input");
        driver.findElement(cssTag).sendKeys("Pierwszy");

        By cssName =By.cssSelector("[name='fname']");
        driver.findElement(cssName);

        By cssClass2 = By.cssSelector("[class='topSecret']");
        driver.findElement(cssClass2);

        By all = By.cssSelector("*");
        driver.findElement(all);

        //szuka pod takiej div/table/tbody podnej nazwy

        By ulinsideDiv = By.cssSelector("div ul");
        driver.findElement(ulinsideDiv);
        By trInTable = By.cssSelector("table tr");
        driver.findElement(trInTable);
        By trInBody = By.cssSelector("tbody tr");
        driver.findElement(trInBody);

        //szuka tylko w pierwszym wierszu po div/tbody

        By firtChildUlinDiv = By.cssSelector("div>ul");
        By firtChildTrinTbody = By.cssSelector("tbody>tr");
        driver.findElement(firtChildTrinTbody);
        driver.findElement(firtChildUlinDiv);

        //pierwszy formularz form, który znajduje sie zaraz po tagu label - elementy, ktore wystepuje na tym samym poziomie
        // + pierwszy element
        // ~ wszystkie, które występują po tagu

        By firstFormAfterLabel = By.cssSelector("label + form");
        By allFormsAfterLabel = By.cssSelector("label ~ form");
        driver.findElement(firstFormAfterLabel);
        driver.findElement(allFormsAfterLabel);

        //wyszukanie dla czesci atrybutu np. nazwy
        By attrContains = By.cssSelector("input[name*='name']");
        driver.findElement(attrContains);

        //wyszukanie wartości atrybutu rozpoczynającego sie konkretną frazą
        By attrStarts = By.cssSelector("[name^='f']");
        driver.findElement(attrStarts);

        //wyszukanie wartości atrybutu konczącego sie konkretną frazą
        By attrEnds = By.cssSelector("[name$='name']");
        driver.findElement(attrEnds);

        //wyszukiwanie okreslonego dziecka (kolejnosc)
        By firstChild =By.cssSelector("li:first-child");
        By lastChild =By.cssSelector("li:last-child");
        By thirdChild =By.cssSelector("li:nth-child(3)");

        driver.findElement(firstChild);
        driver.findElement(lastChild);
        driver.findElement(thirdChild);



    }
}
