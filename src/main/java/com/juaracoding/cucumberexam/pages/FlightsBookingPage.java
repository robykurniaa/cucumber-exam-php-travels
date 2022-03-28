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

public class FlightsBookingPage {
	WebDriver driver;

	private Tools tools;
	public FlightsBookingPage() {
		this.driver = DriverSingleton.getDriver();
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "#fadein > header > div.header-menu-wrapper.padding-right-100px.padding-left-100px > div > div > div > div > div.main-menu-content > nav > ul > li:nth-child(3) > a")
	WebElement flightsBtn;
	
	@FindBy(id = "autocomplete2")
	WebElement toDestination;
	
	@FindBy(id = "departure")
	WebElement departureDate;
	
	@FindBy(id = "return")
	WebElement returnDate;
	
	@FindBy(css = "#onereturn > div.col-lg-1.pr-0 > div > div > div > a")
	WebElement passengers;

	@FindBy(id = "flights-search")
	WebElement btnSearch;
	
	@FindBy(css = "#data > ul > li.mix.all.batikair.oneway_0 > div > form > div > div.col-md-2 > div > button")
	WebElement bookNowBtn;
	
	@FindBy(id = "round-trip")
	WebElement radioBtnRoundTrip;

	@FindBy(id = "flight_type")
	WebElement flightType;

	@FindBy(id = "autocomplete")
	WebElement flyingFrom;
	
	@FindBy(css = "#onereturn > div.col-lg-1.pr-0 > div > div > div > div > div.dropdown-item.child_qty > div > div > div.qtyInc")
	WebElement increaseChilds;

	@FindBy(css = "#onereturn > div.col-lg-1.pr-0 > div > div > div > div > div.dropdown-item.infant_qty > div > div > div.qtyInc")
	WebElement increaseInfants;

	@FindBy(css = "#fadein > div.booking_data > form > section > div > div > div.col-lg-8 > div.form-box.payment-received-wrap.mb-2 > div.card-body > div:nth-child(1) > div.card-body > div:nth-child(1) > div.col-md-2 > select")
	List <WebElement> titleTravellers;
	
	@FindBy(name = "firstname_1")
	WebElement firstNameTraveleers;
	
	@FindBy(name = "lastname_1")
	WebElement lastNameTraveleers;
	
	public void goToMenuFlights() {
		flightsBtn.click();
	}

	public void selectFlyingFrom(String subject) {
		flyingFrom.sendKeys(subject);
		flyingFrom.sendKeys(Keys.RETURN);
	}

	public void selectToDestination(String subject) {
		toDestination.sendKeys(subject);
		toDestination.sendKeys(Keys.RETURN);
	}

	public void selectDepartureDate(String date) {
		departureDate.sendKeys(Keys.chord(Keys.CONTROL + "a", date));
		departureDate.sendKeys(date, Keys.ENTER);
	}

	public void selectReturnDate(String date) {
		returnDate.sendKeys(Keys.chord(Keys.CONTROL + "a", date));
		returnDate.sendKeys(date, Keys.ENTER);
	}

	public void selectFlightType(int pilih) {
		flightType.click();
		List<Keys> listState = new ArrayList<Keys>();
		for (int i = 0; i < pilih; i++) {
			listState.add(Keys.DOWN);
		}
		listState.add(Keys.ENTER);
		CharSequence[] cs = listState.toArray(new CharSequence[listState.size()]);
		Actions keyDown = new Actions(driver);
		keyDown.sendKeys(Keys.chord(cs)).perform();
	}
	

	public void selectPassengers() {
		passengers.click();
	}
	
	
	public void informationTravellers() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", firstNameTraveleers);
		firstNameTraveleers.sendKeys("dadang");
		lastNameTraveleers.sendKeys("dudung");
		titleTravellers.get(2).click();

	}
	
	public String getTitleFlightsBookingPage() {
		return driver.getTitle();
	}
	
	public void input() {
		radioBtnRoundTrip.click();
		selectFlightType(2);
		selectFlyingFrom("CGK");
		selectToDestination("BTJ");
		selectDepartureDate("27 June 2022");
		selectReturnDate("28 June 2022");
		selectPassengers();
		btnSearch.click();
		bookNowBtn.click(); 
	}

}
