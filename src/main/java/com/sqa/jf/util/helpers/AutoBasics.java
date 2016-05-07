/**
 * File Name: AutoBasics.java<br>
 * Nepton, Jean-francois<br>
 * Java Boot Camp Exercise<br>
 * Instructor: Jean-francois Nepton<br>
 * Created: May 2, 2016
 */
package com.sqa.jf.util.helpers;

import java.io.*;
import java.util.*;

import org.apache.commons.io.*;
import org.apache.log4j.*;
import org.openqa.selenium.*;

import com.sqa.jf.util.helpers.exceptions.*;

/**
 * AutoBasics //ADDD (description of class)
 * <p>
 * //ADDD (description of core fields)
 * <p>
 * //ADDD (description of core methods)
 *
 * @author Nepton, Jean-francois
 * @version 1.0.0
 * @since 1.0
 */
public class AutoBasics {

	private static WebDriver driver;

	public static void deleteCookies(WebDriver driver) {
		Set<Cookie> cookies = driver.manage().getCookies();
		for (Cookie cookie : cookies) {
			System.out.println(cookie.getName() + " : " + cookie.getValue());
		}
		// driver.manage().deleteAllCookies();
	}

	/**
	 * @return
	 */
	public static Logger getLogger() {
		return Logger.getLogger(AutoBasics.class);
	}

	public static boolean isElementPresent(By locator)
			throws AutoBasicsNotInitializedException {
		if (driver == null) {
			throw new AutoBasicsNotInitializedException();
		}
		try {
			driver.findElement(locator);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public static boolean isElementPresent(WebDriver driver, By locator) {
		try {
			AutoBasics.driver = driver;
			driver.findElement(locator);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public static boolean toTakeScreenshot(WebDriver driver,
			String fileLocation) {
		return toTakeScreenshot(driver, fileLocation, true);
	}

	public static boolean toTakeScreenshot(WebDriver driver,
			String fileLocation, boolean shouldTakeScreenshot) {
		if (shouldTakeScreenshot) {
			try {
				File file = ((TakesScreenshot) driver)
						.getScreenshotAs(OutputType.FILE);
				FileUtils.copyFile(file, new File(fileLocation));
				AutoBasics.getLogger()
						.info("Screenshot was successfully captured to "
								+ fileLocation);
			} catch (WebDriverException e) {
				AutoBasics.getLogger().warn(
						"Screenshot was not captured do to Driver issue.");
				return false;
			} catch (IOException e) {
				AutoBasics.getLogger().warn(
						"Screenshot was not captured do to IO Exception.");
				return false;
			}
			return true;
		} else {
			AutoBasics.getLogger().info(
					"Screenshot was not captured because pass boolean value was false.");
			return false;
		}
	}

	public AutoBasics(WebDriver driver) {
		AutoBasics.driver = driver;
	}
}
