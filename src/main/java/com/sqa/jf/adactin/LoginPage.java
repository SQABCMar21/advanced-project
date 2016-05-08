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

	/**
	 * @return
	 */
	public static SearchPage logInToAdactin(String username, String password) {
		LoginPage loginPage = new LoginPage();
		loginPage.getDriver().get(loginPage.getBaseURL());
		return loginPage.enterUsername(username).enterPassword(password)
				.login();
	}

	@FindBy(id = "login")
	private WebElement loginBtn;

	@FindBy(id = "password")
	private WebElement passwordFld;

	@FindBy(id = "username")
	private WebElement usernameFld;

	@FindBy(how = How.CSS, using = "td.welcome_menu")
	private WebElement welcomeElement;

	public LoginPage() {
		super();
		PageFactory.initElements(getDriver(), this);
	}

	public LoginPage(WebDriver driver) {
		super(driver, getBaseURL());
		PageFactory.initElements(getDriver(), this);
	}

	private LoginPage enterPassword(String password) {
		this.passwordFld.sendKeys(password);
		return this;
	}

	private LoginPage enterUsername(String username) {
		this.usernameFld.sendKeys(username);
		return this;
	}

	private SearchPage login() {
		this.loginBtn.click();
		return new SearchPage(getDriver());
	}
}
