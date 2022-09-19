import WebConfig.WebDriverConfig;
import org.openqa.selenium.WebDriver;

public class main {
    public static void main(String[] args) {
        WebDriver driver = WebDriverConfig.getDriver("CHROME_DRIVER");
        driver.get("https://www.allegro.pl/");


    }
}
