package com.cg.webdriverdemo1;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
public class WebDriverDemo {
	public static void main(String[] args) {
		try {
			  System.setProperty("webdriver.chrome.driver",
					  "D:\\SatishTrainingData\\TrainingsTopicsWise\\SeleniumAndWebDriver\\ChromeDriver\\chromedriver.exe" );
			
			  WebDriver driver = new ChromeDriver();
			  driver.get("http://www.google.com");
	
			 WebElement searchField = driver.findElement(By.id("lst-ib"));
			 searchField.sendKeys("pluralsight"); 
			 searchField.submit();
			
			  WebElement imagesLink = driver.findElements(By.linkText("Images")).get(0);
			  imagesLink.click();
			 
			 WebElement imageElement =driver.findElements(By.cssSelector("a[class = rg_l]")).get(0);
			 
			 WebElement imageLink = imageElement.findElements(By.tagName("img")).get(0);
			 imageLink.click();
			 
/*
			String nodeURL = "http://10.102.52.238:4444/wd/hub";
			
			//System.setProperty("webdriver.chrome.driver","D:\\SatishTrainingData\\TrainingsTopicsWise\\SeleniumAndWebDriver\\ChromeDriver\\chromedriver.exe");
			//DesiredCapabilities capability = DesiredCapabilities.chrome();
			
			DesiredCapabilities capability = DesiredCapabilities.firefox();
			capability.setBrowserName("firefox");
			capability.setPlatform(Platform.WINDOWS);
			System.out.println(capability);
			WebDriver driver = new RemoteWebDriver(new URL(nodeURL), capability);
			driver.get("http://www.google.com");
			WebElement searchField = driver.findElement(By.id("lst-ib"));
			searchField.sendKeys("pluralsight");
			searchField.submit();
			
			//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Images")));
			
			WebElement imagesLink = driver.findElements(By.linkText("Images")).get(0);
			imagesLink.click();
			
			WebElement imageElement = driver.findElements(By.cssSelector("a[class = rg_l]")).get(0);
			WebElement imageLink = imageElement.findElements(By.tagName("img")).get(0);
			imageLink.click();*/
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
