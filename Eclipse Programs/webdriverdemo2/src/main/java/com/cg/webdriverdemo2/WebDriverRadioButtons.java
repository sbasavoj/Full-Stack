package com.cg.webdriverdemo2;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverRadioButtons {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "D:\\Users\\amajhi\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("D:\\SatishTrainingData\\TrainingsTopicsWise\\SeleniumAndWebDriver\\webdriverdemo2\\src\\main\\webpages\\RadioButtonTest.html");
		By elements  = By.name("color");
		
		List<WebElement> radioButtons = driver.findElements(elements);
		
		WebElement radioBtn= radioButtons.get(1);
		
		radioBtn.click();
		
		for (WebElement radioButton : radioButtons) {
			if(radioButton.isSelected()) {
				System.out.println(radioButton.getAttribute("value"));
			}
		}

		Thread.sleep(3000);
		
		radioButtons.get(2).click();
		
		for (WebElement radioButton : radioButtons) {
			if(radioButton.isSelected()) {
				System.out.println(radioButton.getAttribute("value"));
			}
		}
	}

}
