package Entrata;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import baseTest.BaseTest;
import pageLayer.FooterBar;
import pageLayer.HomePage;
import pageLayer.ProductsPage;
import pageLayer.RegisterNowPage;

public class TestClass extends BaseTest{
	
	private HomePage page=new HomePage();
	private RegisterNowPage register=new RegisterNowPage();
	private ProductsPage prod=new ProductsPage();
	private FooterBar bar=new FooterBar();

	public TestClass() throws IOException {
		super();
		
	}
	
	@Test(priority=1)
	public void TestVerifyEnrtataLogo()
	{
		Assert.assertTrue(page.isElementPresent(page.EntrataLogo), "Logo is  not visible");
	}
	
	@Test(priority=2)
	public void testVerifyAllOptionVisibleInHeaderBar()
	{
		Assert.assertTrue(page.isElementPresent(page.product), "Product option is not visible");
		Assert.assertTrue(page.isElementPresent(page.Solution), "Solution option is not visible");
		Assert.assertTrue(page.isElementPresent(page.Base_Camp), "Base camp option is not visible");
		Assert.assertTrue(page.isElementPresent(page.Resources), "Resources option is not visible");
		Assert.assertTrue(page.isElementPresent(page.Watch_Demo), "Watch Demo option is not visible");
		Assert.assertTrue(page.isElementPresent(page.Sign_In), "Sign in option is not visible");

	}
	
	@Test(priority=3)
	public void testVerifyBaseCampFuctionality() 
	{
		page.waitForElement(page.Base_Camp, 5);
		page.clickOnElement(page.Base_Camp);
		page.switchToNeWWindow();
		page.waitForElement(page.registerNow, 10);
		page.clickOnElement(page.registerNow);
		register.scrollPageWhileElementNotAppear(register.cancel);
		page.waitForElement(register.cancel, 10);

		String [] allField= {register.firstName,register.lastName,register.email,register.mobile,register.title,register.company,register.next,register.cancel,register.checkBoxRegistered};
		
		for(String s: allField)
		{
			Assert.assertTrue(page.isElementPresent(s), "Element "+s+" is not visible");
		}
		Assert.assertTrue(register.isElementEnabled(register.checkBoxRegistered), "Element is not enabled");
		page.clickOnElement(register.checkBoxRegistered);
		register.scrollPageWhileElementNotAppear(register.cancel);
		Assert.assertTrue(page.isElementPresent(register.ErrorMassage), "Enter your personal information here is not visible");

	}
	
	@Test(priority=4)
	public void testVerifyPorductElements() throws IOException 
	{
		prod.showOptionOfElement(prod.solution);
		Assert.assertTrue(page.isElementPresent(prod.multiFamily), "Multi Family option is not visible");
		Assert.assertTrue(page.isElementPresent(prod.student), "Student option is not visible");
		Assert.assertTrue(page.isElementPresent(prod.military), "Military option is not visible");
		Assert.assertTrue(page.isElementPresent(prod.affordable), "Affordable option is not visible");
		Assert.assertTrue(page.isElementPresent(prod.commercial), "commercial option is not visible");
		Assert.assertTrue(page.isElementPresent(prod.homebody), "Homebody option is not visible");
		prod.showOptionOfElement(page.product);
		Assert.assertTrue(page.isElementPresent(prod.propertyManagement), "Property Management option is not visible");
		Assert.assertTrue(page.isElementPresent(prod.marketing), "Marketing option is not visible");
		Assert.assertTrue(page.isElementPresent(prod.utilities), "Utilities option is not visible");
		Assert.assertTrue(page.isElementPresent(prod.accounting), "Accounting option is not visible");
		prod.clickGeneralAccount();
		Assert.assertTrue(page.isElementPresent(prod.accountPage), "Account page is not open");
	}
	
	@Test(priority=5)
	public void testVerifyBottomBar()
	{
		register.scrollPageWhileElementNotAppear(bar.webAccessebility);
		bar.scrollByAmount(100, 1000);
		Assert.assertTrue(page.isElementPresent(bar.faceBook), "facebook option is not visible");
		Assert.assertTrue(page.isElementPresent(bar.insta), "Insta option is not visible");
		Assert.assertTrue(page.isElementPresent(bar.youTube), "YouTube option is not visible");
		Assert.assertTrue(page.isElementPresent(bar.linkeDin), "Linkedin option is not visible");
		Assert.assertTrue(page.isElementPresent(bar.twitter), "Twitter option is not visible");
		page.waitForElement(bar.insta, 10);
//		page.clickOnElement("//a[@title='Entrata Inc. Instagram Page']");

	}

}
