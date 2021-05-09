package com.fatec.scelwebdriver;
import org.junit.jupiter.api.Test;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.*;


public class RQ05ManterAlunoValidaCep {
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
	public void Logar() {
		driver.get("https://ts-scel.herokuapp.com/login");
		driver.manage().window().setSize(new Dimension(1366, 724));
		driver.findElement(By.name("username")).click();
		driver.findElement(By.name("username")).sendKeys(" jose");
		driver.findElement(By.name("password")).click();
		driver.findElement(By.name("password")).sendKeys(" 123");
		driver.findElement(By.cssSelector("button")).click();
	}

	@Test
	public void ct05fluxoinvalidocep () {

		driver.findElement(By.linkText("Alunos")).click();
		estrutura( 123, "nome", "renato@gmail.com", 0);
		assertEquals("CEP deve ter 8 caracteres", driver.findElement(By.cssSelector(".text-danger:nth-child(3)")).getText());	  

		espera();
		estrutura( 123, "nome", "renato@gmail.com", 1234567890);
		assertEquals("CEP deve ter 8 caracteres", driver.findElement(By.cssSelector(".text-danger:nth-child(3)")).getText());	  

	}

	public void estrutura( int ra, String nome, String email, int cep) {
		limpa();
		driver.findElement(By.id("ra")).sendKeys(Integer.toString(ra));
		driver.findElement(By.id("nome")).sendKeys(nome);
		driver.findElement(By.id("email")).sendKeys(email);
		driver.findElement(By.id("cep")).sendKeys(Integer.toString(cep));
		driver.findElement(By.cssSelector(".row:nth-child(3) > .form-group")).click();
	}


	public void limpa() {
		driver.findElement(By.id("ra")).clear();
		driver.findElement(By.id("nome")).clear();
		driver.findElement(By.id("email")).clear();
		driver.findElement(By.id("cep")).clear();
	}

	public void espera() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}