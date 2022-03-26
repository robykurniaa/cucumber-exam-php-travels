package com.juaracoding.cucumberexam.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.juaracoding.cucumberexam.drivers.DriverSingleton;
import com.juaracoding.cucumberexam.utils.Tools;

public class HotelsBookingPage {
	WebDriver driver;
	private Tools tools;
	public HotelsBookingPage() {
		this.driver = DriverSingleton.getDriver();
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "#fadein > header > div.header-menu-wrapper.padding-right-100px.padding-left-100px > div > div > div > div > div.main-menu-content > nav > ul > li:nth-child(2) > a")
	WebElement btnHotels;

	@FindBy(css = ".select2-selection__arrow")
	WebElement country;
	
	@FindBy(id = ".select2-search")
	WebElement clickCountry;	
	

	@FindBy(id = "checkin")
	WebElement checkIn;

	@FindBy(id = "checkout")
	WebElement checkOut;

	@FindBy(css = "#hotels-search > div > div > div:nth-child(3) > div > div > div > a")
	WebElement travellers;

	@FindBy(css = "#hotels-search > div > div > div:nth-child(3) > div > div > div > div > div:nth-child(3) > div > div > div.qtyInc")
	WebElement btnIncreaseChilds;

	@FindBy(id = "ages1")
	WebElement childAge;

	@FindBy(id = "nationality")
	WebElement nationality;

	@FindBy(id = "submit")
	WebElement btnSearch;

	@FindBy(css = "#fadein > section.breadcrumb-area.bread-bg-7 > div > div > div > div > div > div > div > span > strong > h2")
	WebElement titleHotelsBooking;

	public void selectCountry() {
//		Actions act=new Actions(driver);
//		act.doubleClick(country).perform();
//		tunggu();
//		country.click();
//		country.sendKeys(Keys.chord(Keys.CONTROL + "a", "Singapore"));
//		country.sendKeys(Keys.RETURN);
		tools.tunggu();
		tools.scroll();
	}

//	public void selectCheckIn(String date) {
//		checkIn.sendKeys(Keys.chord(Keys.CONTROL + "a", date));
//		checkIn.sendKeys(date, Keys.ENTER);
//	}
//
//	public void selectCheckOut(String date) {
//		checkOut.sendKeys(Keys.chord(Keys.CONTROL + "a", date));
//		checkOut.sendKeys(date, Keys.ENTER);
//	}
//
//	public void selectChildAge(int pilih) {
//		childAge.click();
//		List<Keys> listState = new ArrayList<Keys>();
//		for (int i = 0; i < pilih; i++) {
//			listState.add(Keys.DOWN);
//		}
//		listState.add(Keys.ENTER);
//		CharSequence[] cs = listState.toArray(new CharSequence[listState.size()]);
//		Actions keyDown = new Actions(driver);
//		keyDown.sendKeys(Keys.chord(cs)).perform();
//	}
//
//	public void selectNationality(int pilih) {
//		nationality.click();
//		List<Keys> listState = new ArrayList<Keys>();
//		for (int i = 0; i < pilih; i++) {
//			listState.add(Keys.DOWN);
//		}
//		listState.add(Keys.ENTER);
//		CharSequence[] cs = listState.toArray(new CharSequence[listState.size()]);
//		Actions keyDown = new Actions(driver);
//		keyDown.sendKeys(Keys.chord(cs)).perform();
//	}
//
//	public void selectTravellers() {
//		travellers.click();
//		btnIncreaseChilds.click();
//		selectChildAge(3);
//		selectNationality(6);
//	}

	public void goToMenuHotels() {
		btnHotels.click();
	}

//	public void inputHotelsBooking() {
//		selectCity("Aceh");
////		selectCheckIn("30 March 2022");
////		selectCheckOut("31 March 2022");
////		selectTravellers();
//		btnSearch.click();
//	}

	public String getTitleHotelsBookingPage() {
		return driver.getTitle();
	}

	
}
