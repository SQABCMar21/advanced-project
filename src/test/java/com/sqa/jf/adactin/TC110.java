package com.sqa.jf.adactin;

import java.text.*;

import org.testng.*;
import org.testng.annotations.*;

public class TC110 {

	private static String baseURL = "http://adactin.com/HotelAppBuild2";

	private DefaultPage searchPage;

	private SelectPage selectPage;

	@Test(dataProviderClass = AdactinData.class, dataProvider = "tc110Data")
	public void checkCorrectPrice(String location, String hotel,
			String roomType, String numRooms, String checkIn,
			String adultsInRoom, String childrenInRoom, int days,
			String expectedResults) throws ParseException {
		System.out.println("Test");
		this.searchPage.getDriver().get(baseURL + "/SearchHotel.php");
		String checkOut = SearchPage.changeDate(checkIn, days);
		this.selectPage = SearchPage.selectSearchHotelOptions(
				(SearchPage) this.searchPage, location, hotel, roomType,
				numRooms, checkIn, adultsInRoom, childrenInRoom, checkOut);
		Assert.assertEquals(this.selectPage.totalPrice1.getAttribute("value"),
				expectedResults);
	}

	@BeforeClass
	public void setUp() {
		this.searchPage.setBaseURL(baseURL);
		this.searchPage =
				LoginPage.logInToAdactin("SQABCMar21", "sqaadmin2016");
	}
}
