package stepdefs;

import base.TestBase;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;
import pages.HotelBookingForm;
import pages.LoginPage;

public class HotelBookingStepDef extends TestBase {

	LoginPage loginPage;
	HotelBookingForm bookingPage;
	
	@Given("^Launch the application browser$")
	public void launch_the_application_browser() throws Throwable {
	    TestBase.initialize();
	}

	@When("^Open the web page login in the browser$")
	public void open_the_web_page_login_in_the_browser() throws Throwable {
		driver.get(prop.getProperty("url"));
	}
	
	@Then("^Verify login page heading as Hotel Booking Application using xpath$")
	public void verify_login_page_heading_as_Hotel_Booking_Application_using_xpath() throws Throwable {
		loginPage= new LoginPage();
	    String loginHeader = loginPage.getApplicationHeader();
	    Assert.assertEquals("Hotel Booking Application", loginHeader); 
	    System.out.println("Application Header Name is:" +loginHeader);
	}

	@Then("^Enter UserName and Ensure that displays the error message Please enter UserName upon clicking on the Login button without entering any data in the text box$")
	public void enter_UserName_and_Ensure_that_displays_the_error_message_Please_enter_UserName_upon_clicking_on_the_Login_button_without_entering_any_data_in_the_text_box() throws Throwable {
		 loginPage.Login();
		 String userErrMessage = loginPage.getUserErrMsg();
		 Assert.assertEquals("* Please enter userName.", userErrMessage);
		 System.out.println("Error Message without enter User Name is:" +userErrMessage);
		 
		 //Enter Valid Username
		 loginPage.Username(prop.getProperty("username"));
		 loginPage.Login();
	}

	@Then("^Enter Password and Ensure that displays the error message Please enter Password upon clicking on the Login button without entering any data in the text box$")
	public void enter_Password_and_Ensure_that_displays_the_error_message_Please_enter_Password_upon_clicking_on_the_Login_button_without_entering_any_data_in_the_text_box() throws Throwable {
		String pwdErrMessage = loginPage.getPwdErrMsg();
		Assert.assertEquals("* Please enter password.", pwdErrMessage);
		System.out.println("Error Message without enter Password is:" +pwdErrMessage);
		
		//Enter Valid Password
		loginPage.Password(prop.getProperty("password"));
		loginPage.Login();
	}

	@Then("^Verify the user successfully logged in to Hotel Booking$")
	public void verify_the_user_successfully_logged_in_to_Hotel_Booking() throws Throwable {
	    System.out.println("User successfully logged into " +driver.getTitle());
	   
	}

	@Given("^User navigated to Hotel Booking$")
	public void user_navigated_to_Hotel_Booking() throws Throwable {
	    System.out.println("User Navigated to Booking page is:" +driver.getTitle());
	}

	@When("^user is in Personal details section$")
	public void user_is_in_Personal_details_section() throws Throwable {
		bookingPage = new HotelBookingForm();
		System.out.println("User is in Personal details Section");
	}

	@Then("^Enter First Name Ensure that the alert box displays the message Please fill the First Name upon clicking on the button Confirm Booking without entering any data in the text box$")
	public void enter_First_Name_Ensure_that_the_alert_box_displays_the_message_Please_fill_the_First_Name_upon_clicking_on_the_button_Confirm_Booking_without_entering_any_data_in_the_text_box() throws Throwable {
		bookingPage.ConfirmBtn();
		bookingPage.Alert();
		bookingPage.Firstname();
			 }
	
	@Then("^Enter Last Name Ensure that the alert box displays the message Please fill the Last Name upon clicking on the button Confirm Booking without entering any data in the text box$")
	public void enter_Last_Name_Ensure_that_the_alert_box_displays_the_message_Please_fill_the_Last_Name_upon_clicking_on_the_button_Confirm_Booking_without_entering_any_data_in_the_text_box() throws Throwable {
		bookingPage.ConfirmBtn();
		bookingPage.Alert();
		bookingPage.Lastname();
	}

	@Then("^Enter Email Ensure that the alert box displays the message Plese fill the Email upon wrong email format entered in the text box$")
	public void enter_Email_Ensure_that_the_alert_box_displays_the_message_Plese_fill_the_Email_upon_wrong_email_format_entered_in_the_text_box() throws Throwable {
		bookingPage.ConfirmBtn();
		bookingPage.Alert();
		bookingPage.Email();
	}

	@Then("^Enter mobile no Ensure that the alert box displays the message Please fill the Mobile No upon clicking on the button Confirm Booking without entering any data in the text box$")
	public void enter_mobile_no_Ensure_that_the_alert_box_displays_the_message_Please_fill_the_Mobile_No_upon_clicking_on_the_button_Confirm_Booking_without_entering_any_data_in_the_text_box() throws Throwable {
		bookingPage.ConfirmBtn();
		bookingPage.Alert();
		bookingPage.Phone_invalid();
		bookingPage.ConfirmBtn();
		bookingPage.Alert();
	}
	
	@Then("^Ensure that the alert box displays the message Please enter valid Contact no upon clicking on the button Confirm Booking on entering wrong data that doesnot start with either (\\d+) (\\d+) or (\\d+) and doesnot have (\\d+) digits in the text box$")
	public void ensure_that_the_alert_box_displays_the_message_Please_enter_valid_Contact_no_upon_clicking_on_the_button_Confirm_Booking_on_entering_wrong_data_that_doesnot_start_with_either_or_and_doesnot_have_digits_in_the_text_box(int arg1, int arg2, int arg3, int arg4) throws Throwable {
		bookingPage.ConfirmBtn();
		bookingPage.Alert();
		bookingPage.Phone_valid();
	}

	@Then("^Enter address details validation for address$")
	public void enter_address_details_validation_for_address() throws Throwable {
		bookingPage.ConfirmBtn();
		bookingPage.Alert();
		bookingPage.Address();
	}

	@Then("^Select Number of people staying at the Hotel Ensure that the alert box displays the message Number of people attending upon clicking on the button Confirm Booking without entering any data in the box$")
	public void select_Number_of_people_staying_at_the_Hotel_Ensure_that_the_alert_box_displays_the_message_Number_of_people_attending_upon_clicking_on_the_button_Confirm_Booking_without_entering_any_data_in_the_box() throws Throwable {
		bookingPage.ConfirmBtn();
		bookingPage.Alert();
		bookingPage.Persons();
	}

	@Then("^Select City Ensure that alert box display the message Please select city upon clicking on the button Confirm Booking without selecting any city$")
	public void select_City_Ensure_that_alert_box_display_the_message_Please_select_city_upon_clicking_on_the_button_Confirm_Booking_without_selecting_any_city() throws Throwable {
		bookingPage.ConfirmBtn();
		bookingPage.Alert();
		bookingPage.City();
	}

	@Then("^Select State Ensure that alert box display the message Please select state upon clicking on the button Confirm Booking without selecting any state$")
	public void select_State_Ensure_that_alert_box_display_the_message_Please_select_state_upon_clicking_on_the_button_Confirm_Booking_without_selecting_any_state() throws Throwable {
		bookingPage.ConfirmBtn();
		bookingPage.Alert();
		bookingPage.State();
	}

	@Then("^Enter Card Holder Name Ensure that the alert box displays the message Please fill the Card holder name upon clicking on the button Confirm Booking without entering any data in the text box$")
	public void enter_Card_Holder_Name_Ensure_that_the_alert_box_displays_the_message_Please_fill_the_Card_holder_name_upon_clicking_on_the_button_Confirm_Booking_without_entering_any_data_in_the_text_box() throws Throwable {
		bookingPage.ConfirmBtn();
		bookingPage.Alert();
		bookingPage.CardHolderName();
	}

	@Then("^Enter Debit card Number Ensure that the alert box displays the message Please fill the Debit card Number upon clicking on the button Confirm Booking without entering any data in the text box$")
	public void enter_Debit_card_Number_Ensure_that_the_alert_box_displays_the_message_Please_fill_the_Debit_card_Number_upon_clicking_on_the_button_Confirm_Booking_without_entering_any_data_in_the_text_box() throws Throwable {
		bookingPage.ConfirmBtn();
		bookingPage.Alert();
		bookingPage.Debit();
		bookingPage.CVV();
	}

	@Then("^Enter Card expiration month Ensure that the alert box displays the message Please fill expiration month upon clicking on the button Confirm Booking without entering any data in the text box$")
	public void enter_Card_expiration_month_Ensure_that_the_alert_box_displays_the_message_Please_fill_expiration_month_upon_clicking_on_the_button_Confirm_Booking_without_entering_any_data_in_the_text_box() throws Throwable {
		bookingPage.ConfirmBtn();
		bookingPage.Alert();
		bookingPage.ExpirationMonth();
	}

	@Then("^Enter Card expiration year Ensure that the alert box displays the message Please fill expiration year upon clicking on the button Confirm Booking without entering any data in the text box$")
	public void enter_Card_expiration_year_Ensure_that_the_alert_box_displays_the_message_Please_fill_expiration_year_upon_clicking_on_the_button_Confirm_Booking_without_entering_any_data_in_the_text_box() throws Throwable {
		bookingPage.ConfirmBtn();
		bookingPage.Alert();
		bookingPage.ExpirationYear();
	}

	@Then("^Click on Confirm Booking button Ensure that it navigates to success page which displays the message Booking Completed$")
	public void click_on_Confirm_Booking_button_Ensure_that_it_navigates_to_success_page_which_displays_the_message_Booking_Completed() throws Throwable {
		bookingPage.ConfirmBtn();
	}
	

	@Then("^SuccessMessage is displayed$")
	public void successmessage_is_displayed() throws Throwable {
		String msgSuccess = bookingPage.MsgSuccess();
	    Assert.assertEquals("Booking Completed!",msgSuccess);
	    TestBase.Close();
	}

	

	
}
