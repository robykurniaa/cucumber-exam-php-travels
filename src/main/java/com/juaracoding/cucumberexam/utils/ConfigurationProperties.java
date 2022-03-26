package com.juaracoding.cucumberexam.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("framework.properties")
public class ConfigurationProperties {

	@Value("${browser}")
	private String browser;

	@Value("${email}")
	private String email;

	@Value("${password}")
	private String password;

	@Value("${user}")
	private String userName;

	@Value("${textWelcome}")
	private String textWelcome;

	@Value("${titleHotelsBooking}")
	private String titleHotelsBooking;

	@Value("${titleFlightsBooking}")
	private String titleFlightsBooking;

	public String getBrowser() {
		return browser;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public String getUserName() {
		return userName;
	}

	public String getTextWelcome() {
		return textWelcome;
	}

	public String getTitleHotelsBooking() {
		return titleHotelsBooking;
	}

	public String getTitleFlightsBooking() {
		return titleFlightsBooking;
	}

}
