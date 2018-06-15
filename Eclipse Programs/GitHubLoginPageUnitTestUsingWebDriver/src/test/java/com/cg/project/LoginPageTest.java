package com.cg.project;
import com.cg.project.beans.LoginPage;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
public class LoginPageTest{
	
	
	static WebDriver driver;
	private LoginPage loginPage;
	
	@BeforeClass
	public static void setUpDriverEnv(){
		System.setProperty("webdriver.chrome.driver", "D:\\SatishTrainingData\\TrainingsTopicsWise\\SeleniumAndWebDriver\\ChromeDriver\\chromedriver.exe");
		driver= new ChromeDriver();
		driver.manage().window().maximize();
	}
	
	@Before
	public void setUpTestEnv() {
		driver.get("https://github.com/login");
		loginPage= new LoginPage();
		PageFactory.initElements(driver, loginPage);
	}
	
	
	@Test
	public void testForBlankUserNameAndPassword(){	
		loginPage.setUsername("");
		loginPage.setPassword("");
		loginPage.clickSubmitButton();
		String actualErrorMessage=driver.findElement(By.xpath("//div[@class='container']")).getText();	
		System.out.println("error Message :- "+actualErrorMessage);
		String expectedErrorMessage="Incorrect username or password.";
		Assert.assertEquals(expectedErrorMessage, actualErrorMessage);
	}
	
@Test
	public void testForInValidUserName(){
		
		loginPage.setUsername(getInvalidUserName());
		loginPage.setPassword(getValidPassword());
		loginPage.clickSubmitButton();
		String expectedErrorMessage="Incorrect username or password.";
		String actualErrorMessage=driver.findElement(By.xpath("//div[@class='container']")).getText();	
		System.out.println("error Message :- "+actualErrorMessage);
		Assert.assertEquals(expectedErrorMessage, actualErrorMessage);
	}

	@Test
	public void testForInValidPassword(){
		loginPage.setUsername(getValidUserName());
		loginPage.setPassword(getInvalidPassword());
		loginPage.clickSubmitButton();
		String actualErrorMessage=driver.findElement(By.xpath("//div[@class='container']")).getText();	
		System.out.println("error Message :- "+actualErrorMessage);
		String expectedErrorMessage="Incorrect username or password.";
		Assert.assertEquals(expectedErrorMessage, actualErrorMessage);
	}
	
	@Test
	public void testForInValidUserNameAndPassword(){
		loginPage.setUsername(getInvalidUserName());
		loginPage.setPassword(getInvalidPassword());
		loginPage.clickSubmitButton();
		String actualErrorMessage=driver.findElement(By.xpath("//div[@class='container']")).getText();	
		
		String expectedErrorMessage="Incorrect username or password.";
		Assert.assertEquals(expectedErrorMessage, actualErrorMessage);
	}
	
	
	@Test
	public void testForValidUserNameAndPassword(){
		loginPage.setUsername(getValidUserName());
		loginPage.setPassword(getValidPassword());
		loginPage.clickSubmitButton();
		String actualHostName =driver.findElement(By.xpath("//meta[@name='hostname']")).getAttribute("content");	
		String actualUserName=driver.findElement(By.xpath("//meta[@name='user-login']")).getAttribute("content");
		HostAndUserDetails expectedUserDetails = new HostAndUserDetails("github.com", "satishmahajan11");
		HostAndUserDetails actualUserDetails = new HostAndUserDetails(actualHostName, actualUserName);
		Assert.assertEquals(expectedUserDetails, actualUserDetails);
	}
	@After
	public void tearDownTestEnv(){
		loginPage= null;
	}
	@AfterClass
	public static void tearDownDriverEnv(){
		driver.close();
	}
	
	private String getInvalidUserName() {
		return "satishmahajan";
	}
	
	private String getValidUserName() {
		return "satish.a.mahajan@capgemini.com";
	}
	
	private String getInvalidPassword() {
		return "Temp12234";
	}
	
	private String getValidPassword() {
		return "Temp@1234";
	}
}
