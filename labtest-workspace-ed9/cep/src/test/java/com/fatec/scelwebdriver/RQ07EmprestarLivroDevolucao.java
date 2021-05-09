package com.fatec.scelwebdriver;


import org.junit.jupiter.api.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import java.util.*;
class RQ07EmprestarLivroDevolucao {

	  private WebDriver driver;
	  private Map<String, Object> vars;
	  JavascriptExecutor js;
	  @Before
	  public void setUp() {
	    driver = new ChromeDriver();
	    js = (JavascriptExecutor) driver;
	    vars = new HashMap<String, Object>();
	  }
	  @After
	  public void tearDown() {
	    driver.quit();
	  }
	  
	  
	  @Test
	  public void ct6emprestimovalido() {
	    driver.get("https://ts-scel.herokuapp.com/login");
	    driver.manage().window().setSize(new Dimension(1366, 724));
	    driver.findElement(By.name("username")).click();
	    driver.findElement(By.name("username")).sendKeys(" jose");
	    driver.findElement(By.name("password")).click();
	    driver.findElement(By.name("password")).sendKeys(" 123");
	    driver.findElement(By.cssSelector("button")).click();
	    espera();
	    
	    driver.findElement(By.linkText("Emprestimo")).click();
	    driver.findElement(By.id("ra")).click();
	    driver.findElement(By.id("ra")).sendKeys("1239");
	    driver.findElement(By.id("isbn")).click();
	    driver.findElement(By.id("isbn")).sendKeys("2121");
	    driver.findElement(By.cssSelector(".btn:nth-child(1)")).click();
	    driver.findElement(By.cssSelector(".panel-title")).click();
	    assertThat(driver.findElement(By.cssSelector(".panel-title")).getText(), is("Lista de Emprestimo"));
	  }
	  
	  public void espera() {
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

}
