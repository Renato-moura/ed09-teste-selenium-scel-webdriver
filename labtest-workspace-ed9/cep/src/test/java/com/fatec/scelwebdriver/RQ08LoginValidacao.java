package com.fatec.scelwebdriver;
// Generated by Selenium IDE
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNot.not;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import java.util.*;
import java.net.MalformedURLException;
import java.net.URL;
public class RQ08LoginValidacao {
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
  public void ct_testa_login() {
    driver.get("https://ts-scel.herokuapp.com/login");
    driver.manage().window().setSize(new Dimension(1366, 724));
    estrutura("jose", "1234"); // testa senha errada
   
    espera();
    estrutura("jose", "12"); //testa senha errada2
  
    espera();
    estrutura("jose", " "); //testa senha branco
    
    espera();
    estrutura("josee", "123"); //testa nome errado
    
    espera();
    estrutura(" ", "123"); // testa nome branco


  }
  
  
  public void estrutura (String nome, String senha) {
	  	limpaCampos();
	    driver.findElement(By.name("username")).sendKeys(nome);
	    driver.findElement(By.name("password")).sendKeys(senha);
	    driver.findElement(By.cssSelector("button")).click();
	    driver.findElement(By.cssSelector("html")).click();
	    assertThat(driver.findElement(By.cssSelector("body > div")).getText(), is("Invalid username and password."));
	  
  }
	public void limpaCampos() {
		driver.findElement(By.name("username")).clear();
		driver.findElement(By.name("passowrd")).clear();
	}
	public void espera() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
