package com.cg.test;
import static org.junit.Assert.assertEquals;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import com.cg.beans.RegisterPage;
public class RegisterPageTest {
	static WebDriver driver;
	private RegisterPage registerPage;
	@BeforeClass
	public static void setUpDriverEnv() {
		System.setProperty("webdriver.chrome.driver","D:\\chromedriver.exe");	
		driver= new ChromeDriver();
		driver.manage().window().maximize();
	}
	@Before
	public void setUptestEnv() {
		driver.get("https://github.com/join");
		registerPage=new RegisterPage();
		PageFactory.initElements(driver, registerPage);
	}
	/*@Test
	public void testForAllBlankFields() {
		registerPage.setUsername("");
		registerPage.setEmailId("");
		registerPage.setPassword("");
		registerPage.clickSubmitButton();
		String actualErrorMessage=driver.findElement(By.xpath("//*[@id='signup-form']/div")).getText();
		String message="There were problems creating your account.";
		//System.out.println(actualErrorMessage);
		assertEquals(actualErrorMessage, message);
	}*/
	@Test
	public void testForExistingUsername() {
		registerPage.setUsername("sbasavoj");
		registerPage.setEmailId("");
		registerPage.setPassword("asd");
		registerPage.clickSubmitButton();
		String actualErrorMessage=driver.findElement(By.xpath("//*[@id='signup-form']/auto-check[1]/dl/dd[2]")).getText();
		String message="Login is already taken";
		System.out.println(actualErrorMessage);
		assertEquals(actualErrorMessage, message);
		String actualErrorMessage1=driver.findElement(By.xpath("//*[@id='signup-form']/auto-check[3]/dl/dd[2]")).getText();
		String message1="Password is too short (minimum is 7 characters) and needs at least one number";
		System.out.println(actualErrorMessage1);
		assertEquals(actualErrorMessage1, message1);
	}
	/*@Test
	public void testForWrongEmail() {
		registerPage.setUsername("sbasavoj");
		registerPage.setEmailId("asedc");
		registerPage.setPassword("");
		registerPage.clickSubmitButton();
		String actualErrorMessage=driver.findElement(By.xpath("//*[@id='signup-form']/auto-check[2]/dl/dd[2]")).getText();
		String message="Email is invalid or already taken";
		System.out.println(actualErrorMessage);
		assertEquals(actualErrorMessage, message);
	}*/
	/*@Test
	public void testForWrongEmail() {
		registerPage.setUsername("sbasavoj");
		registerPage.setEmailId("asd");
		registerPage.setPassword("qwe");
		registerPage.clickSubmitButton();
		String actualErrorMessage=driver.findElement(By.xpath("//*[@id='signup-form']/auto-check[3]/dl/dd[2]")).getText();
		String message="Password is too short (minimum is 7 characters) and needs at least one number";
		System.out.println(actualErrorMessage);
		assertEquals(actualErrorMessage, message);
	}*/
	@AfterClass
	public static void tearDownDriverEnv() {
		driver.close();
		driver=null;
	}
	@After
	public  void tearDownTestEnv(){
		registerPage=null;
	}
}