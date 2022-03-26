package com.juaracoding.cucumberexam.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.juaracoding.cucumberexam.drivers.DriverSingleton;

public class LoginPage {

	WebDriver driver;

	public LoginPage() {
		this.driver = DriverSingleton.getDriver();
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "email")
	WebElement inputEmail;

	@FindBy(name = "password")
	WebElement inputPassword;

	@FindBy(xpath = "//*[@id=\"fadein\"]/div[1]/div/div[2]/div[2]/div/form/div[3]/button")
	WebElement btnLogin;

	@FindBy(id = "cookie_stop")
	WebElement btnGotIt;

	@FindBy(className = "author__meta")
	WebElement textWelcome;

	public void submitLogin(String email, String password) {
		btnGotIt.click();
		inputEmail.sendKeys(email);
		inputPassword.sendKeys(password);
		btnLogin.click();
	}

	public String getTextWelcome() {
		return textWelcome.getText();
	}
}
