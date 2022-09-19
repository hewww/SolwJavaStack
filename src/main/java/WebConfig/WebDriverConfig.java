package WebConfig;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverConfig {

    public static WebDriver getDriver(final String driver) {
        System.setProperty("webdriver.chrome.driver","C:\\Selenium-driver\\Chrome\\chromedriver.exe");
        return new ChromeDriver();
    }

}
