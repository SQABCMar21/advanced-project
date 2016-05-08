/**
 * File Name: TC105.java<br>
 * Nepton, Jean-francois<br>
 * Java Boot Camp Exercise<br>
 * Instructor: Jean-francois Nepton<br>
 * Created: May 2, 2016
 */
package com.sqa.jf.adactin;

import java.text.*;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.*;
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
public class TC102 {

	private static String baseURL = "http://adactin.com/HotelAppBuild2";

	private static WebDriver driver;

	@DataProvider
	public static Object[][] tc102data() {
		return new Object[][] {
				{ "SQABCMar21", "sqaadmin2016", "Paris", "Hotel Creek",
						"Deluxe", "9", "02/06/2018", "2", "4", true },
				{ "SQABCMar21", "sqaadmin2016", "Sydney", "Hotel Creek",
						"Standard", "1", "01/06/2016", "4", "2", true },
				{ "SQABCMar21", "sqaadmin2016", "Sydney", "Hotel Creek",
						"Standard", "1", "01/06/2014", "4", "2", false } };
	}

	public DefaultPage currentPage = new DefaultPage(driver, baseURL);

	public SearchPage searchPage;

	@BeforeClass
	public void setUp() {
		this.driver = new FirefoxDriver();
		this.driver.get(this.baseURL);
		this.currentPage = new DefaultPage(driver, baseURL);
	}

	@Test(dataProvider = "tc102data")
	public void testCheckInOut(String username, String password,
			String location, String hotel, String roomType, String numRooms,
			String checkIn, String adultsInRoom, String childrenInRoom,
			boolean expectedResults) throws ParseException {
		boolean actualResults;
		System.out.println("TC-102");
		// Eval CheckOut Date:
		String checkOut = DefaultPage.changeDate(checkIn, 7);
		System.out.println("Check-in: " + checkIn + "Check-out: " + checkOut);
		// Login:
		if (this.searchPage == null) {
			this.searchPage = LoginPage.logInToAdactin(username, password);
		} else {
			this.searchPage.getDriver()
					.get(DefaultPage.getBaseURL() + "/SearchHotel.php");
		}
		System.out.println("Enter Information: ");
		// Enter Information
		SearchPage.selectSearchHotelOptions(this.searchPage, location, hotel,
				roomType, numRooms, checkIn, adultsInRoom, childrenInRoom,
				checkOut);
		// Checkout if actual is same as expected results
		actualResults = !this.searchPage.hasCheckInErrorMessage();
		Assert.assertEquals(actualResults, expectedResults);
	}
}
