package com.cg.beans;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
public class RegisterPage {
	@FindBy(id="user_login")
	WebElement username;
	@FindBy(id="user_email")
	WebElement emailId;
	@FindBy(id="user_password")
	WebElement password;
	@FindBy(id="signup_button")
	WebElement button;
	public RegisterPage() {}
	public WebElement getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username.sendKeys(username);
	}
	public WebElement getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId.sendKeys(emailId);
	}
	public WebElement getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password.sendKeys(password);
	}
	public void clickSubmitButton() {
		button.submit();
	}
}
