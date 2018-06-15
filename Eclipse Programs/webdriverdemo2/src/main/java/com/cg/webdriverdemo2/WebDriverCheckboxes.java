package com.cg.webdriverdemo2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
public class WebDriverCheckboxes {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "D:\\Users\\amajhi\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("\\DIN56003454\\ADM Tools\\seleniumhqData\\webdriverdemo2\\src\\main\\webpages\\CheckboxTest.html");

		By element = By.id("lettuceCheckbox");
		

		WebElement checkbox = driver.findElement(element);
		
		Thread.sleep(2000);
		
		checkbox.click();
		
		if(checkbox.isSelected()) {
			System.out.println("Value of checkBox :- "+checkbox.getAttribute("value") );
		}
	}	

}
