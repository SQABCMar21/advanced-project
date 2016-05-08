/**
 * File Name: AdactinData.java<br>
 * Nepton, Jean-francois<br>
 * Java Boot Camp Exercise<br>
 * Instructor: Jean-francois Nepton<br>
 * Created: May 7, 2016
 */
package com.sqa.jf.adactin;

import org.testng.annotations.*;

/**
 * AdactinData //ADDD (description of class)
 * <p>
 * //ADDD (description of core fields)
 * <p>
 * //ADDD (description of core methods)
 *
 * @author Nepton, Jean-francois
 * @version 1.0.0
 * @since 1.0
 */
public class AdactinData {

	@DataProvider
	public static Object[][] tc110Data() {
		return new Object[][] {
				{ "Paris", "Hotel Creek", "Deluxe", "9", "02/06/2018", "2", "4",
						3, "AUD $ 8775" },
				{ "Sydney", "Hotel Creek", "Standard", "1", "01/06/2016", "4",
						"2", 2, "AUD $ 250" },
				{ "Sydney", "Hotel Creek", "Standard", "1", "01/06/2017", "4",
						"2", 5, "AUD $ 625" } };
	}
}
