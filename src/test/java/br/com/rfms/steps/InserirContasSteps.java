package br.com.rfms.steps;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;

public class InserirContasSteps {
	
	private WebDriver driver;
	
	@Dado("^que estou acessando a aplicação$")
	public void que_estou_acessando_a_aplicação() throws Throwable {
		System.setProperty("webdriver.gecko.driver", "/home/webdrivers/geckodriver-v0.18.0-linux64/geckodriver");
		driver = new FirefoxDriver();
		driver.get("http://srbarriga.herokuapp.com");
	}

	@Quando("^informo o usuário \"([^\"]*)\"$")
	public void informo_o_usuário(String arg1) throws Throwable {
	    driver.findElement(By.id("email")).sendKeys(arg1);
	}

	@Quando("^a senha \"([^\"]*)\"$")
	public void a_senha(String arg1) throws Throwable {
		driver.findElement(By.name("senha")).sendKeys(arg1);
	}

	@Quando("^seleciono entrar$")
	public void seleciono_entrar() throws Throwable {
		driver.findElement(By.tagName("button")).click();
	}

	@Então("^visualizo a página inicial$")
	public void visualizo_a_página_inicial() throws Throwable {
		String texto = driver.findElement(By.xpath("/html/body/div[@class='alert alert-success']")).getText();
		Assert.assertEquals (texto.contains("Bem vindo"), true);
	}

	@Quando("^seleciono Contas$")
	public void seleciono_Contas() throws Throwable {
		driver.findElement(By.linkText("Contas")).click();
	}

	@Quando("^seleciono Adicionar$")
	public void seleciono_Adicionar() throws Throwable {
		driver.findElement(By.linkText("Adicionar")).click();
	}

	@Quando("^informo a conta \"([^\"]*)\"$")
	public void informo_a_conta(String arg1) throws Throwable {
		driver.findElement(By.id("nome")).sendKeys(arg1);
	}

	@Quando("^seleciono Salvar$")
	public void seleciono_Salvar() throws Throwable {
		driver.findElement(By.xpath("/html/body/div[2]/form/div[2]/button")).click();
	}
	
	@Então("^recebo a mensagem \"(.*)\"$")
	public void receboAMensagem(String arg1) throws Throwable {
		String texto = driver.findElement(By.xpath("//div[starts-with(@class, 'alert alert-')]")).getText();
		Assert.assertEquals (arg1, texto);
	}

	@Então("^a conta é inserida com sucesso$")
	public void a_conta_é_inserida_com_sucesso() throws Throwable {
		String texto = driver.findElement(By.xpath("/html/body/div[@class='alert alert-success']")).getText();
		Assert.assertEquals(texto.contains("Conta adicionada com sucesso!"), true);
	}
	
	@Então("^sou notificar que o nome da conta é obrigatório$")
	public void sou_notificar_que_o_nome_da_conta_é_obrigatório() throws Throwable {
		String texto = driver.findElement(By.  xpath("/html/body/div[@class='alert alert-danger']")).getText();
		Assert.assertEquals(texto.contains("Informe o nome da conta"), true);
	}

	@Então("^sou notificado que já existe uma conta com esse nome$")
	public void sou_notificado_que_já_existe_uma_conta_com_esse_nome() throws Throwable {
		String texto = driver.findElement(By.  xpath("/html/body/div[@class='alert alert-danger']")).getText();
		Assert.assertEquals(true, texto.contains("Já existe uma conta com esse nome!"));
	}
	
	@After(order=1)
	public void screenshot(Scenario cenario) {
		File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd HH:mm:ss");
		Date date = new Date();
		String formattedDate = dateFormat.format(date);
		try {
			FileUtils.copyFile(file, new File("target/screenshots/"+formattedDate+cenario.getId()+".png"));
			System.out.println("[TESTING] cenario.getId() = "+ cenario.getId());
			System.out.println("[TESTING] cenario.getName() = "+ cenario.getName());
			System.out.println("[TESTING] cenario.getStatus() = "+ cenario.getStatus());
			System.out.println("[TESTING] cenario.getClass() = "+ cenario.getClass());
			System.out.println("[TESTING] cenario.getSourceTagNames() = "+ cenario.getSourceTagNames());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@After(order=0)
	public void fechoONavegador() throws Throwable {
	    driver.close();
	}
}