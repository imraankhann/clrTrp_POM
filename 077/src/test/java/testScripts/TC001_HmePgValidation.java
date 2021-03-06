package testScripts;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageLib.HomePgLib;
import pageLib.SearchResultsPg;
import testBase.TestBase;
import utill.CommonUtill;

public class TC001_HmePgValidation extends TestBase {
	
	HomePgLib hmePg;
	SearchResultsPg srchRsltsPg;
	CommonUtill commonutil;
	
	@BeforeClass
	public void setup(){
		init();
	}
	
//	@Test
//	public void isReturnOnVisible(){
//		hmePg=new HomePgLib(driver);
//		commontutil.implicitWait(3000);
//		hmePg.selectRoundTrpRadioBtn();
//		commontutil.implicitWait(2000);
//	
//		Assert.assertTrue(hmePg.isReturnOnVisible());
//
//	}
	
	
	@Test
	
	public void HmePgNegativeValidation(){
		String expectedTxt="You missed this";
		hmePg=new HomePgLib(driver);
		commonutil.implicitWait(3000);
		hmePg.clckSrchFlights();
		Assert.assertEquals(hmePg.getValidationMsgIfFieldNotSelected(), expectedTxt);
		
		
	}
	
	@Test
	public void HmPgPositiveValidation() throws InterruptedException{
		hmePg=new HomePgLib(driver);
		srchRsltsPg=new SearchResultsPg(driver);
		String expectedTxt="	Bangalore   ⇄  Delhi";
		commonutil.implicitWait(3000);
		hmePg.selectRoundTrpRadioBtn();
		commonutil.implicitWait(2000);
		hmePg.passDeparture("Bangalore");
		commonutil.implicitWait(3000);
		hmePg.passArrival("Delhi");
		commonutil.implicitWait(3000);
		hmePg.clickDepartOn();
		hmePg.selectDepartDtInDatePicker("4");
		commonutil.implicitWait(3000);
		hmePg.selectReturnDtInDatePicker("6");
		commonutil.implicitWait(3000);
		hmePg.clckSrchFlights();
		Assert.assertEquals(srchRsltsPg.getResultTextFromResultPg(), expectedTxt);
		
		
	}

	
	
	
	@AfterClass
	public void closeBrowser(){
		driver.close();
		driver.quit();

	}
		
	}
	
	


