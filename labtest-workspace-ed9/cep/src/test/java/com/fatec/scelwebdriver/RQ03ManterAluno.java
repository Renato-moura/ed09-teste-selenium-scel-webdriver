package com.fatec.scelwebdriver;
import org.junit.jupiter.api.Test;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import java.util.*;


public class RQ03ManterAluno {
	private WebDriver driver;
	private Map<String, Object> vars;
	JavascriptExecutor js;

	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "browserDriver/chromedriver.exe");
		  driver = new ChromeDriver();
		//js = (JavascriptExecutor) driver;
		//vars = new HashMap<String, Object>();
	}
	
	//@After
	public void tearDown() {
		driver.quit();
	}
	
	@Test
	public void ct03cadastrosucesso () {
		    driver.get("https://ts-scel.herokuapp.com/login");
		    driver.manage().window().setSize(new Dimension(1366, 724));
		    driver.findElement(By.name("username")).click();
		    driver.findElement(By.name("username")).sendKeys(" jose");
		    driver.findElement(By.name("password")).click();
		    driver.findElement(By.name("password")).sendKeys(" 123");
		    driver.findElement(By.cssSelector("button")).click();
		    espera();
		    driver.findElement(By.linkText("Alunos")).click();
		    driver.findElement(By.id("ra")).sendKeys("1235");
		    driver.findElement(By.id("nome")).sendKeys("Edson");
		    driver.findElement(By.id("email")).sendKeys("123@123.com");
		    driver.findElement(By.id("cep")).sendKeys("12345678");
		    driver.findElement(By.cssSelector(".row > .row")).click();
		    driver.findElement(By.cssSelector(".btn:nth-child(1)")).click();
		    espera();
		    driver.findElement(By.linkText("Editar")).click();
		    driver.findElement(By.id("ra")).sendKeys("1236");
		    driver.findElement(By.id("nome")).sendKeys("Renato");
		    driver.findElement(By.id("email")).sendKeys("123@123.com");
		    driver.findElement(By.id("cep")).sendKeys("12345678");
		    driver.findElement(By.cssSelector(".row > .row")).click();
		    driver.findElement(By.cssSelector(".btn:nth-child(1)")).click();
		    driver.findElement(By.linkText("Excluir")).click();
		  }

	public void espera() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}