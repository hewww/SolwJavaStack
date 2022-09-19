import WebConfig.WebDriverConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AllegroTests {

    WebDriver driver;

    @BeforeClass
    public void initalize() {
        driver = WebDriverConfig.getDriver("CHROME_DRIVER");
        driver.get("https://www.allegro.pl/");
    }

    @Test
    public void checkVisibleOfSearchBar(){

        //Given
        WebElement searchBar = driver.findElement(By.xpath());
        searchBar.click();
        Assert.assertTrue(searchBar.isSelected());


    }

    @Test
    public void checkURL(){
        Assert.assertEquals("https://allegro.pl/",driver.getCurrentUrl());

    }

    @AfterTest
    public void clean(){
        driver.manage().deleteAllCookies();
        driver.close();
    }



}
