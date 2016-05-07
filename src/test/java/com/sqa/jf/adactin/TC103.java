package com.sqa.jf.adactin;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.*;
import org.testng.annotations.*;

import com.sqa.jf.util.helpers.*;

public class TC103 {

	@Test(enabled = false)
	public void cookiesPractice() {
		WebDriver driver = new FirefoxDriver();
		driver.get("http://msn.com");
		AutoBasics.deleteCookies(driver);
	}

	@Test
	public void mavenPropsPractice() {
		System.out.println("Practice with Properties");
		System.out.println("Username:" + System.getProperty("username"));
		System.out.println("Password:" + System.getProperty("password"));
	}

	@Test(enabled = false)
	public void screenshotPractice() {
		boolean shouldTakeSC = true;
		WebDriver driver = new FirefoxDriver();
		driver.get("http://mtv.com");
		AutoBasics.toTakeScreenshot(driver, "logs/captures/screenshot1.png",
				false);
		driver.get("http://msn.com");
		AutoBasics.toTakeScreenshot(driver, "logs/captures/screenshot2.png",
				true);
		driver.get("http://yahoo.com");
		AutoBasics.toTakeScreenshot(driver, "logs/captures/screenshot3.png");
	}

	@Test(enabled = false)
	public void ternaryPractice() {
		int largeCup = 89;
		int smallCup = 67;
		System.out.print("The small cup ");
		if (smallCup > 70) {
			System.out.println("is hot!");
		} else {
			System.out.println("is cold...");
		}
		// Create same snippet using ternary operator with large cup.
		String message = "";
		// Ternary operator
		message = largeCup > 70 ? " is hot!" : "is cold...";
		// Print Message
		System.out.println("The large cup " + message);
	}
}
