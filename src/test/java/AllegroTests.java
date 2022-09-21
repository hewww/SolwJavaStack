import WebConfig.WebDriverConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;
import java.time.LocalTime;
import java.util.concurrent.TimeUnit;

public class AllegroTests {

    WebDriver driver;

    @BeforeMethod
    public void initalize() {
        driver = WebDriverConfig.getDriver("CHROME_DRIVER");
        driver.manage().window().maximize();
        driver.get("https://www.allegro.pl/");


    }

    @Test
    public void check() throws InterruptedException {

        WebElement accept = driver.findElement(By.xpath("//*[@id='opbox-gdpr-consents-modal']/div/div[2]/div/div[2]/button[1]"));
        accept.click();
        WebElement searchBar = driver.findElement(By.xpath("//input[@data-role='search-input']"));

        searchBar.click();
        searchBar.sendKeys("PlayStation 5");
        Thread.sleep(9000);
        String jp = "PlayStation 5";


        WebDriverWait waitson = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement element2 = driver.findElement(By.xpath("//*[@id='suggestions-listbox']//span"));
        waitson.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='suggestions-listbox']//span")));



        String kk = element2.getAttribute("innerHTML");


       System.out.println(kk);
      /*  WebDriverWait waittt = new WebDriverWait(driver, Duration.ofSeconds(5));
        waittt.until(ExpectedConditions.textToBePresentInElement(element2,jp));


        System.out.println(element2.getText());*/


    }

    @Test
    public void checkVisibleOfSearchBar(){


        //Given
        WebElement accept = driver.findElement(By.xpath("//*[@id='opbox-gdpr-consents-modal']/div/div[2]/div/div[2]/button[1]"));
        accept.click();
        WebElement searchBar = driver.findElement(By.xpath("//input[@data-role='search-input']"));



        searchBar.click();
        searchBar.sendKeys("PlayStation 5");



    }

    @Test
    public void checkSuggestList(){

        WebElement accept = driver.findElement(By.xpath("//*[@id='opbox-gdpr-consents-modal']/div/div[2]/div/div[2]/button[1]"));
        accept.click();

        WebElement searchBar = driver.findElement(By.xpath("//input[@data-role='search-input']"));
        searchBar.click();
        searchBar.sendKeys("PlayStation 5");

        WebElement list = driver.findElement(By.xpath("//a[@data-role = 'suggestion']"));

        WebDriverWait waiter = new WebDriverWait(driver , Duration.ofSeconds(5));
        waiter.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@data-role = 'suggestion']")));

        Assert.assertTrue(list.isDisplayed());

    }

    @AfterMethod
    public void clean(){
        driver.manage().deleteAllCookies();
        driver.close();
    }



}
