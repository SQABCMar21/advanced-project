/**
 * File Name: LoginPage.java<br>
 * Nepton, Jean-francois<br>
 * Java Boot Camp Exercise<br>
 * Instructor: Jean-francois Nepton<br>
 * Created: May 2, 2016
 */
package com.sqa.jf.adactin;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;

/**
 * LoginPage //ADDD (description of class)
 * <p>
 * //ADDD (description of core fields)
 * <p>
 * //ADDD (description of core methods)
 *
 * @author Nepton, Jean-francois
 * @version 1.0.0
 * @since 1.0
 */
public class LoginPage extends DefaultPage {

	@FindBy(id = "login")
	private WebElement loginBtn;

	@FindBy(id = "password")
	private WebElement passwordFld;

	@FindBy(id = "username")
	private WebElement usernameFld;

	@FindBy(how = How.CSS, using = "td.welcome_menu")
	private WebElement welcomeElement;

	public LoginPage() {
		PageFactory.initElements(getDriver(), this);
	}

	public LoginPage(WebDriver driver) {
		super(driver, getBaseURL());
		PageFactory.initElements(getDriver(), this);
	}

	public LoginPage enterPassword(String password) {
		this.passwordFld.sendKeys(password);
		return this;
	}

	public LoginPage enterUsername(String username) {
		this.usernameFld.sendKeys(username);
		return this;
	}

	public SearchPage login() {
		this.loginBtn.click();
		return new SearchPage(getDriver());
	}
}
