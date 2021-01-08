package pages;

import java.io.IOException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import base.ReadDetails;
import base.TestBase;

public class HotelBookingForm extends TestBase {
	
//----------------------Locators---------------------------------------

//----------------------Personal Details Section------------------------------	
	@FindBy(xpath="//th[contains(text(),'Personal')]") WebElement personalDetails;
	@FindBy(id="txtFirstName") WebElement txtFirstName;
	@FindBy(id="txtLastName") WebElement txtLastName;
	@FindBy(id="txtEmail") WebElement txtEmail;
	@FindBy(id="txtPhone") WebElement txtPhone;
	@FindBy(xpath="//textarea[@rows='5']") WebElement txtAddress;
	@FindBy(xpath="//select[@name='city']") WebElement drpCity;
	@FindBy(xpath="//select[@name='state']") WebElement drpState;
	@FindBy(xpath="//select[@name='persons']") WebElement drpPersons;
	@FindBy(id="rooms") WebElement roomsCount;
	
//-----------------------Payment Detail Section---------------------------------
	
	@FindBy(xpath="//th[contains(text(),'Payment')]") WebElement paymentDetails;
	
	@FindBy(id="txtCardholderName") WebElement txtCardholderName;
	@FindBy(id="txtDebit") WebElement txtDebit;
	@FindBy(id="txtCvv") WebElement txtCvv;
	@FindBy(id="txtMonth") WebElement txtMonth;
	@FindBy(id="txtYear") WebElement txtYear;
	
//----------------------Confirm Booking--------------------------------------------
	
	@FindBy(id="btnPayment") WebElement btnPayment;
	@FindBy(xpath="//h1[@align='center']") WebElement msgSuccess;
	
//------------------------Actions--------------------------------------------------
	
	ReadDetails ReadDetails = new ReadDetails();
//	public String fname;
	
	public HotelBookingForm()
	{
		PageFactory.initElements(driver, this);
	}
	
//	public void PersonalDetails() throws IOException
//	{
//		
//		//btnPayment.click();
//		fname= ReadDetails.readData("FirstName");
//		txtFirstName.sendKeys(fname);
//	}
	
	public void ConfirmBtn()
	{
		btnPayment.click();
	}
	
	public void Firstname() throws IOException
	{
		txtFirstName.sendKeys(ReadDetails.ReadDetails("FirstName"));
	}
	
	public void Lastname() throws IOException
	{
		txtLastName.sendKeys(ReadDetails.ReadDetails("LastName"));
	}
	
	public void Email() throws IOException
	{
		txtEmail.sendKeys(ReadDetails.ReadDetails("Email"));
	}
	public void Phone_invalid() throws IOException
	{
		txtPhone.sendKeys("9");
		
	}
	public void Phone_valid() throws IOException, InterruptedException
	{
		txtPhone.clear();
		Thread.sleep(1000);
		txtPhone.sendKeys("874563210");
	}
	public void Address() throws IOException
	{
		txtAddress.sendKeys(ReadDetails.ReadDetails("Address"));
	}
	public void City() throws IOException
	{
		Select drpcity=new Select(drpCity);
		drpcity.selectByValue("Chennai");
	}
	public void State() throws IOException
	{
		Select drpstate=new Select(drpState);
		drpstate.selectByValue("Karnataka");
	}
	public void Persons() throws IOException
	{
		Select drppersons=new Select(drpPersons);
		drppersons.selectByIndex(2);
	}
	public void CardHolderName() throws IOException
	{
		txtCardholderName.sendKeys(ReadDetails.ReadDetails("CardHolderName"));
	}
	public void Debit() throws IOException
	{
		txtDebit.sendKeys("1234123412341234");
	}
	public void CVV() throws IOException
	{
		txtCvv.sendKeys("123");
	}
	public void ExpirationMonth() throws IOException
	{
		txtMonth.sendKeys(ReadDetails.ReadDetails("ExpirationMonth"));
	}
	public void ExpirationYear() throws IOException
	{
		txtYear.sendKeys("2023");
	}
	public void Alert()
	{
		Alert alert =driver.switchTo().alert();
	    System.out.println(alert.getText());
	    alert.accept();
	}
	public String MsgSuccess()
	{
		return msgSuccess.getText();
	}
	
	

	

}
