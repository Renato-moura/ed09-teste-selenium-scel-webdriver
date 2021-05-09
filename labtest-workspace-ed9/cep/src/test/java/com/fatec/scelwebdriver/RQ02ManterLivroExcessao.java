package com.fatec.scelwebdriver;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import java.util.*;


public class RQ02ManterLivroExcessao {
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
	public void ct02cadastrofalhas () {

		driver.get("https://ts-scel.herokuapp.com/login");
		driver.manage().window().setSize(new Dimension(1366, 724));
		driver.findElement(By.name("username")).click();
		driver.findElement(By.name("username")).sendKeys("jose");
		driver.findElement(By.name("password")).click();
		driver.findElement(By.name("password")).sendKeys("123");
		driver.findElement(By.cssSelector("button")).click();
		espera();
	
	//------------------------------------------------------------//
	// seta valores validos
		
		driver.findElement(By.linkText("Livros")).click();
		driver.findElement(By.id("isbn")).click();
		driver.findElement(By.id("isbn")).click();
		driver.findElement(By.id("isbn")).sendKeys("1239");
		driver.findElement(By.id("autor")).click();
		driver.findElement(By.id("autor")).sendKeys("Renato");
		driver.findElement(By.id("titulo")).click();
		driver.findElement(By.id("titulo")).sendKeys("Ed09 Selenium");
				
	// testa isbn	
		
		driver.findElement(By.id("isbn")).clear();
		driver.findElement(By.id("isbn")).click();
		driver.findElement(By.id("isbn")).sendKeys("123");
		driver.findElement(By.cssSelector(".btn:nth-child(1)")).click();
	    driver.findElement(By.cssSelector(".col-md-4")).click();
	    assertEquals("ISBN deve ter 4 caracteres", (driver.findElement(By.cssSelector(".text-danger:nth-child(3)")).getText()));
	    driver.findElement(By.id("isbn")).clear();
	    driver.findElement(By.id("isbn")).click();
		driver.findElement(By.id("isbn")).sendKeys("12345");
		driver.findElement(By.cssSelector(".btn:nth-child(1)")).click();
	    driver.findElement(By.cssSelector(".col-md-4")).click();
	    assertEquals("ISBN deve ter 4 caracteres", (driver.findElement(By.cssSelector(".text-danger:nth-child(3)")).getText()));		
	    driver.findElement(By.id("isbn")).clear();
	    driver.findElement(By.id("isbn")).click();
		driver.findElement(By.id("isbn")).sendKeys("1239"); // volta valor valido
	//------------------------------------------------------------//	
	// testa autor
		driver.findElement(By.id("autor")).clear();
		driver.findElement(By.id("autor")).click();
		driver.findElement(By.id("autor")).sendKeys("012345678901234567890123456789012345678901234567890");
		driver.findElement(By.cssSelector(".btn:nth-child(1)")).click();
		driver.findElement(By.cssSelector(".row:nth-child(3) > .form-group")).click();
		assertEquals("Autor deve ter entre 1 e 50 caracteres", driver.findElement(By.cssSelector(".text-danger:nth-child(3)")).getText());
		driver.findElement(By.id("autor")).clear();
		driver.findElement(By.id("autor")).sendKeys("Renato");
	//---------------------------------------------------------------//
	
	// testa titulo
		driver.findElement(By.id("titulo")).clear();
		driver.findElement(By.id("titulo")).sendKeys("012345678901234567890123456789012345678901234567890");
		driver.findElement(By.cssSelector(".btn:nth-child(1)")).click();
		driver.findElement(By.cssSelector(".row:nth-child(3) > .form-group")).click();
		assertEquals("Titulo deve ter entre 1 e 50 caracteres", driver.findElement(By.cssSelector(".text-danger:nth-child(3)")).getText());
		driver.findElement(By.id("titulo")).clear();
		driver.findElement(By.cssSelector(".btn:nth-child(1)")).click();
		driver.findElement(By.cssSelector(".row:nth-child(3) > .form-group")).click();
		assertEquals("Titulo deve ter entre 1 e 50 caracteres", driver.findElement(By.cssSelector(".text-danger:nth-child(3)")).getText());
		
		//driver.findElement(By.cssSelector(".btn:nth-child(1)")).click();
		espera();
	

	}


	public void espera() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
