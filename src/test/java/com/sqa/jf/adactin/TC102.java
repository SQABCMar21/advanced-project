/**
 * File Name: TC105.java<br>
 * Nepton, Jean-francois<br>
 * Java Boot Camp Exercise<br>
 * Instructor: Jean-francois Nepton<br>
 * Created: May 2, 2016
 */
package com.sqa.jf.adactin;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.*;
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
public class TC102 {

	private static String baseURL = "http://adactin.com/HotelAppBuild2";

	private static WebDriver driver;

	@BeforeClass
	public void setUp() {
		this.driver = new FirefoxDriver();
		this.driver.get(this.baseURL);
	}

	@Test
	public void testCheckInOut() {
		System.out.println("Test");
		SearchPage searchPage =
				new LoginPage(driver).enterUsername("SQABCMar21")
						.enterPassword("sqaadmin2016").login();
		searchPage =
				searchPage.chooseLocation("Sydney").chooseHotel("Hotel Creek")
						.chooseRoomType("Standard").chooseNumOfRooms("1 - One");
	}
}
