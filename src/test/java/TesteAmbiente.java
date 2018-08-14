import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TesteAmbiente {
 public static void main(String[] args) {
	System.setProperty("webdriver.gecko.driver", "/home/webdrivers/geckodriver-v0.18.0-linux64/geckodriver");
	WebDriver driver = new FirefoxDriver();
	driver.get("http://srbarriga.herokuapp.com");
	
}
}
