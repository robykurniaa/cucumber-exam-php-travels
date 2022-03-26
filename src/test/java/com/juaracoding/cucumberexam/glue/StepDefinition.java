package com.juaracoding.cucumberexam.glue;

import static org.junit.Assert.assertEquals;

import org.junit.AfterClass;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import com.juaracoding.cucumberexam.config.AutomationFrameworkConfig;
import com.juaracoding.cucumberexam.drivers.DriverSingleton;
import com.juaracoding.cucumberexam.pages.FlightsBookingPage;
import com.juaracoding.cucumberexam.pages.HotelsBookingPage;
import com.juaracoding.cucumberexam.pages.LoginPage;
import com.juaracoding.cucumberexam.utils.ConfigurationProperties;
import com.juaracoding.cucumberexam.utils.Constants;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.spring.CucumberContextConfiguration;

@CucumberContextConfiguration
@ContextConfiguration(classes = AutomationFrameworkConfig.class)
public class StepDefinition {

	private WebDriver driver;
	private LoginPage loginPage;
	private HotelsBookingPage hotelsBookingPage;
	private FlightsBookingPage flightsBookingPage;

	@Autowired
	ConfigurationProperties configurationProperties;

	@Before
	public void initializeObjects() {
		DriverSingleton.getInstance(configurationProperties.getBrowser());
		loginPage = new LoginPage();
		hotelsBookingPage = new HotelsBookingPage();
		flightsBookingPage = new FlightsBookingPage();
	}

	@AfterClass
	public void closeBrowser() {
		driver.quit();
	}

	@Given("Customer mengakses url")
	public void customer_mengakses_url() {
		driver = DriverSingleton.getDriver();
		driver.get(Constants.URL);
	}

	@When("Customer klik login button")
	public void customer_klik_login_button() {
		loginPage.submitLogin(configurationProperties.getEmail(), configurationProperties.getPassword());
	}

	@Then("Customer berhasil login")
	public void customer_berhasil_login() {
		// refresh
		driver.navigate().refresh();
		tunggu();
		assertEquals(configurationProperties.getTextWelcome(), loginPage.getTextWelcome());
	}

	@When("Customer klik menu Hotels")
	public void customer_klik_menu_hotels() {
		hotelsBookingPage.goToMenuHotels();
	}

	@And("Customer mengisi data pilihan hotels")
	public void customer_mengisi_data_hotels_booking() {
		hotelsBookingPage.inputHotelsBooking();
		tunggu();
	}

	@Then("Customer ditampilkan pilihan hotels")
	public void customer_ditampilkan_pilihan_hotels() {
		assertEquals(configurationProperties.getTitleHotelsBooking(), hotelsBookingPage.getTitleHotelsBookingPage());
	}

//	@When("Customer klik menu Flights")
//	public void customer_klik_menu_flights() {
//		flightsBookingPage.goToMenuFlights();
//	}
//
//	@And("Customer mengisi data flights booking")
//	public void customer_mengisi_data_flights_booking() {
//		flightsBookingPage.inputFlightsBooking();
//		tunggu();
//	}
//
//	@Then("Customer ditampilkan pilihan flights")
//	public void customer_ditampilkan_pilihan_flights() {
//		assertEquals(configurationProperties.getTitleFlightsBooking(), flightsBookingPage.getTitleFlightsBookingPage());
//	}

	public static void tunggu() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
