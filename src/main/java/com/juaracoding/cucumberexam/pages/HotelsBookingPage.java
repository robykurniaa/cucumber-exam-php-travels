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

	//--------Find Hotel-------------
	@FindBy(css = "#fadein > span > span > span.select2-search.select2-search--dropdown > input")
	WebElement inputCountry;
	
	@FindBy(id = "select2-hotels_city-container")
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
	
	@FindBy(xpath = "//*[@id=\"fadein\"]/section[2]/div/div[2]/div/div/div/div[1]/div/div[6]/div")
	WebElement scrollDownToHotel;
	
	@FindBy(xpath = "//*[@id=\"availability\"]/div[2]/div[2]/div[2]/div/div[2]/form/div/div[4]/div/div/button")
	WebElement bookNowHotel;
	
	@FindBy(css = "#availability > div.single-content-item.padding-top-40px.padding-bottom-30px.rooms > div:nth-child(1) > div.card-body > div > div.col-md-9 > form > div > div.col-md-3.booked_53 > div > div > button")
	WebElement btnBookNowHotel;
	
	public void goToMenuHotels() {
		btnHotels.click();
	}

	public void selectHotel(String cityHotel) {
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", scrollDownToHotel);
		scrollDownToHotel.click();
		
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", bookNowHotel);
		tools.waitFiveSec();
		Actions act = new Actions(driver);
		act.doubleClick(bookNowHotel).perform();
		bookNowHotel.click();
		/*
		clickCountry.click();
		tools.tunggu();
		inputCountry.sendKeys(cityHotel);
		tools.tunggu();
		inputCountry.sendKeys(Keys.RETURN);
		
		checkIn.sendKeys(Keys.TAB);

		checkOut.sendKeys(Keys.TAB);
		
		*/
		
		
	}

	/*
	public void selectChildAge(int pilih) {
		childAge.click();
		List<Keys> listState = new ArrayList<Keys>();
		for (int i = 0; i < pilih; i++) {
			listState.add(Keys.DOWN);
		}
		listState.add(Keys.ENTER);
		CharSequence[] cs = listState.toArray(new CharSequence[listState.size()]);
		Actions keyDown = new Actions(driver);
		keyDown.sendKeys(Keys.chord(cs)).perform();
	}

	public void selectNationality(int pilih) {
		nationality.click();
		List<Keys> listState = new ArrayList<Keys>();
		for (int i = 0; i < pilih; i++) {
			listState.add(Keys.DOWN);
		}
		listState.add(Keys.ENTER);
		CharSequence[] cs = listState.toArray(new CharSequence[listState.size()]);
		Actions keyDown = new Actions(driver);
		keyDown.sendKeys(Keys.chord(cs)).perform();
	}

	public void selectTravellers() {
		travellers.click();
		btnIncreaseChilds.click();
		selectChildAge(3);
		selectNationality(6);
	}
	
	

	public void inputHotelsBooking() {
		selectCity("Singapore");
		selectCheckIn("30 June 2022");
		selectCheckOut("31 June 2022");
		selectTravellers();
		btnSearch.click();
	}

	
	public String getTitleHotelsBookingPage() {
		return driver.getTitle();
	}
*/
	
}
