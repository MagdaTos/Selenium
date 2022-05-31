import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;

public class XpathTest {

    @Test
    public void findElements() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://testeroprogramowania.github.io/selenium/basics.html");
        //clickOnMe - button
        By buttonId = By.xpath("//button[@id='clickOnMe']");
        WebElement clickOnMeButton = driver.findElement(buttonId);

        //fname - input
//        By firstName = By.name("fname");
//        WebElement firstNameInput = driver.findElement(firstName);
        WebElement firstNameInput2 = driver.findElement(By.xpath("//input[@name='fname']"));

        //topSecret class
        WebElement paraHidden = driver.findElement(By.xpath("//p[@class='topSecret']"));
        // tak samo
        // By paraHidden = By.className("topSecret");
        //driven.findElement(paraHidden);

        //wszystkie inputy
        By input1 = By.xpath("//input");
        WebElement input =driver.findElement(input1);
        input.sendKeys("Pierwszy");
        List<WebElement> inputs = driver.findElements(input1);
        System.out.println(inputs.size());

        //po tekscie całym np.linku

        WebElement schoolLink = driver.findElement(By.xpath("//a[text()='Visit W3Schools.com!']"));

        //szukanie po fragmencie np. tylko czesci linku
        WebElement partialLink = driver.findElement(By.xpath("//a[contains(text(), 'Visit')]"));

        //wyszukianie po xpath konkretna ściezka
        By fullPath = By.xpath("/html/body/div/ul");
        driver.findElement(fullPath);

        //wyszukanie po xpath bez konkrentej sciezki tylko wszedzie tam gdzie mamy np. ul
        By shortPath = By.xpath("//ul");
        driver.findElement(shortPath);

        //   //*  - element o dowolnym tagu - zwroci wszystkie elementu
        By allXpath = By.xpath("//*");
        driver.findElement(allXpath);

        //index drugi element. Liczenie od 1
        By secondElement = By.xpath("(//input)[2]");

        //last elemtn
        By lastElement = By.xpath("(//input)[last()]");
        driver.findElement(lastElement);

        By elementAttribute = By.xpath("//*[@name]");
        driver.findElement(elementAttribute);

        By attrEq = By.xpath("//button[@id='clickOnMe']");
        By attrNotEq = By.xpath("//*[@id='clickOnMe']");
        By attrCont = By.xpath("//*[contains(@name,'ame')]");
        By startWith = By.xpath("//*[starts-with(@name, 'user')]");
        By endWith = By.xpath("//*[substring(@name,string-length(@name)-string-length('name')+1)='name']");
        driver.findElement(attrEq);
        driver.findElement(attrNotEq);
        driver.findElement(attrCont);
        driver.findElement(startWith);
        driver.findElement(endWith);

        //dzieci
        By child = By.xpath("//div/child::ul");
        driver.findElement(child);

        //"potomkowie" - wszystko poniżej
        By desc = By.xpath("//div/descendant::ul");
        driver.findElement(desc);

        //rodzice
        By parent = By.xpath("//div/descendant::ul");
        driver.findElement(parent);

        //"przodkowe - to co powyżej
        By asc = By.xpath("//div/ancestor::*");
        driver.findElement(asc);

        //Wszystkie tagi wystepujące po naszym tagu zwracne sa tez elementy zagniezdzone
        By foll = By.xpath("//img/following::*");
        driver.findElement(foll);

        //Tylko elementy na tym samym poziomie
        By dollSib = By.xpath("//img/following-sibling::*");
        driver.findElement(dollSib);

        //wszystkie tagi nad
        By prec = By.xpath("//img/preceding::*");
        driver.findElement(prec);

        //wszystkie tagi nad, ale na tym samym poziomie
        By precSib = By.xpath("//img/preceding-sibling::*");
        driver.findElement(precSib);

        //chcemy wyświetlic to i to
        By divAndlinks = By.xpath("//a | //div");
        driver.findElement(divAndlinks);

        //chcemy myświetlic cos co spełnia dwa warunki
        By andOp = By.xpath("//input[@name='fname' and @id='fname']");
        driver.findElement(andOp);

        //or - albo to albo to
        By orOp = By.xpath("//input[@name='fname' or @id='fame']");
        driver.findElement(orOp);






    }
}
