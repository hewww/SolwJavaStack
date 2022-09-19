import WebConfig.WebDriverConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;

public class AllegroTests {

    WebDriver driver;

    @BeforeMethod
    public void initalize() {
        driver = WebDriverConfig.getDriver("CHROME_DRIVER");
        driver.get("https://www.allegro.pl/");
    }

    @Test
    public void checkVisibleOfSearchBar(){

        //*[@id="opbox-gdpr-consents-modal"]/div/div[2]/div/div[2]/button[1]

        //Given
        WebElement accept = driver.findElement(By.xpath("//*[@id='opbox-gdpr-consents-modal']/div/div[2]/div/div[2]/button[1]"));
        accept.click();
        WebElement searchBar = driver.findElement(By.xpath("/html/body/div[3]/div/div/div/div/div/div/div[3]/header/div/div/div/div/form/input"));

        searchBar.click();
        searchBar.sendKeys("ABCDEGSADDASDASDASAS");



    }

    @Test
    public void checkURL(){
        Assert.assertEquals("https://allegro.pl/",driver.getCurrentUrl());

    }

    @AfterMethod
    public void clean(){
        driver.manage().deleteAllCookies();
        driver.close();
    }



}
