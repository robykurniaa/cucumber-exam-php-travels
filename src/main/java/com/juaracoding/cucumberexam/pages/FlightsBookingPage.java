package com.juaracoding.cucumberexam.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.juaracoding.cucumberexam.drivers.DriverSingleton;

public class FlightsBookingPage {
	WebDriver driver;

	public FlightsBookingPage() {
		this.driver = DriverSingleton.getDriver();
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "#fadein > header > div.header-menu-wrapper.padding-right-100px.padding-left-100px > div > div > div > div > div.main-menu-content > nav > ul > li:nth-child(3) > a")
	WebElement btnFlights;

	@FindBy(id = "round-trip")
	WebElement radioBtnRoundTrip;

	@FindBy(id = "flight_type")
	WebElement flightType;

	@FindBy(id = "autocomplete")
	WebElement flyingFrom;

	@FindBy(id = "autocomplete2")
	WebElement toDestination;

	@FindBy(id = "departure")
	WebElement departureDate;

	@FindBy(id = "return")
	WebElement returnDate;

	@FindBy(css = "#onereturn > div.col-lg-1.pr-0 > div > div > div > a")
	WebElement passengers;

	@FindBy(css = "#onereturn > div.col-lg-1.pr-0 > div > div > div > div > div.dropdown-item.child_qty > div > div > div.qtyInc")
	WebElement increaseChilds;

	@FindBy(css = "#onereturn > div.col-lg-1.pr-0 > div > div > div > div > div.dropdown-item.infant_qty > div > div > div.qtyInc")
	WebElement increaseInfants;

	@FindBy(id = "flights-search")
	WebElement btnSearch;

	@FindBy(css = "#fadein > section.breadcrumb-area.bread-bg-flights > div > div > div > div:nth-child(2) > div > ul > li > a")
	WebElement titleFlightsBooking;

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
		increaseChilds.click();
		increaseInfants.click();
	}

	public void goToMenuFlights() {
		btnFlights.click();
	}

	public void inputFlightsBooking() {
		radioBtnRoundTrip.click();
		selectFlightType(2);
		selectFlyingFrom("CGK");
		selectToDestination("BTJ");
		selectDepartureDate("30 March 2022");
		selectReturnDate("31 March 2022");
		selectPassengers();
		btnSearch.click();
	}

	public String getTitleFlightsBookingPage() {
		return driver.getTitle();
	}

}
