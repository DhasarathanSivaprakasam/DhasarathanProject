package org.stepdef;

import org.base.BaseClass;
import org.loc.LoginPojo;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Facebook extends BaseClass{

	LoginPojo l=new LoginPojo();

	@Given("To launch the browser")
	public void to_launch_the_browser() {
		browserLaunch();
		windowMaximize();
		urlLaunch("https://www.facebook.com/");
	}

	@When("Send a valid username")
	public void send_a_valid_username() {
		l=new LoginPojo();
		sendKeys(l.getTxtEmail(), "9944926084");
	}

	@When("Send a invalid Password")
	public void send_a_invalid_Password() {
		l=new LoginPojo();
		sendKeys(l.getTxtPass(), "Dhasarathan");
	}

	@When("Click the login button")
	public void click_the_login_button() {
		l=new LoginPojo();
		btnClick(l.getLoginBtn());
	}

	@Then("Close the browser")
	public void close_the_browser() {
		//close();
	}


}
