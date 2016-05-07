/**
 * File Name: TC105.java<br>
 * Nepton, Jean-francois<br>
 * Java Boot Camp Exercise<br>
 * Instructor: Jean-francois Nepton<br>
 * Created: May 2, 2016
 */
package com.sqa.jf.adactin;

import java.net.*;
import java.util.*;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.firefox.*;
import org.openqa.selenium.ie.*;
import org.openqa.selenium.remote.*;
import org.testng.*;
import org.testng.annotations.*;

/**
 * TC105 //ADDD (description of class)
 * <p>
 * //ADDD (description of core fields)
 * <p>
 * //ADDD (description of core methods)
 *
 * @author Nepton, Jean-francois
 * @version 1.0.0
 * @since 1.0
 */
public class TC101 {

	public static final String ACCESS_KEY = "YOUR_ACCESS_KEY";

	public static final String SL_USERNAME = "YOUR_USERNAME";

	public static final String URL = "http://" + SL_USERNAME + ":" + ACCESS_KEY
			+ "@ondemand.saucelabs.com:80/wd/hub";

	private static String baseURL = "http://adactin.com/HotelAppBuild2";

	private static WebDriver driver;

	@Test
	public void sauceLabsTest() throws Exception {
		DesiredCapabilities caps = DesiredCapabilities.chrome();
		caps.setCapability("platform", "Windows XP");
		caps.setCapability("version", "43.0");
		WebDriver driver = new RemoteWebDriver(new URL(URL), caps);
		/**
		 * Goes to Sauce Lab's guinea-pig page and prints title
		 */
		driver.get("https://saucelabs.com/test/guinea-pig");
		System.out.println("title of page is: " + driver.getTitle());
		driver.quit();
	}

	@BeforeClass(groups = { "chrome" })
	public void setUpChrome() {
		System.setProperty("webdriver.chrome.driver",
				"drivers/chromedriver.exe");
		this.driver = new ChromeDriver();
		this.driver.get(this.baseURL);
	}

	@BeforeClass(groups = { "firefox" })
	public void setUpFirefox() {
		this.driver = new FirefoxDriver();
		this.driver.get(this.baseURL);
		Properties props = System.getProperties();
		for (Object prop : props.keySet()) {
			System.out
					.println(prop + " := " + props.getProperty((String) prop));
		}
	}

	@BeforeClass(groups = { "ie" })
	public void setUpIE() {
		System.setProperty("webdriver.ie.driver", "drivers/ie.exe");
		this.driver = new InternetExplorerDriver();
		this.driver.get(this.baseURL);
	}

	@Test(groups = { "firefox", "chrome", "ie" })
	public void testLogin() {
		Assert.assertTrue(new LoginPage(this.driver).enterUsername("SQABCMar21")
				.enterPassword("sqaadmin2016").login().hasWelcomeMsg());
	}
}
