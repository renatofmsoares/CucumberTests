package br.com.rfms.runners;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
	features = "src/test/resources/features/inserir_conta.feature",
	glue = "br.com.rfms.steps",
	tags = {"~@ignore"},
	plugin = "pretty",
	monochrome = true,
	snippets = SnippetType.CAMELCASE,
	dryRun = false,
	strict = true)
public class RunnerTest {
	@BeforeClass
	public static void reset() {
		System.setProperty("webdriver.gecko.driver", "/home/webdrivers/geckodriver-v0.18.0-linux64/geckodriver");
		WebDriver driver = new FirefoxDriver();
		driver.get("http://srbarriga.herokuapp.com");
		driver.findElement(By.id("email")).sendKeys("renatof.m.soares@gmail.com");
		driver.findElement(By.name("senha")).sendKeys("srbarriga");
		driver.findElement(By.tagName("button")).click();
		driver.findElement(By.linkText("reset")).click();
		driver.quit();
	}
	
}
