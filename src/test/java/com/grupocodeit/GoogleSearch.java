package com.grupocodeit;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleSearch {
	
	//Preparar la instancia del web driver
		private WebDriver driver;

	@Before
	public void setUp() throws Exception {
		//asignar web driver a nuestro proyecto
		System.setProperty("webdriver.chrome.driver", "./src/test/chromedriver/chromedriver.exe"); 
		
		//istancia de la clase
		driver = new ChromeDriver();
		
		//maximizar la ventana del navegador
		driver.manage().window().maximize();
		
		//abrir la pagina web
		driver.get("https://www.google.com.sv/");
	}

	@After
	public void tearDown() throws Exception {
		//cerrar el navegador
		driver.quit();
	}
	
	String resultadoActual="";
	String resultadoEsperado="El Crumer - Buscar con Google";

	@Test
	public void test() {
		driver.findElement(By.name("q")).sendKeys("El Crumer");
		driver.findElement(By.name("q")).submit();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		resultadoActual = driver.getTitle();
		
		if(resultadoActual.equals(resultadoEsperado)) {
			System.out.println("Exito");
		}else {
			System.out.println("Fallido");
		}
	}

}
