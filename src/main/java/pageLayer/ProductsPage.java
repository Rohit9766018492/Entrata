package pageLayer;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import baseTest.BaseTest;

public class ProductsPage extends BaseTest{

	
	public ProductsPage() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}


	public String propertyManagement="//a[text()='Property Management']";
	public String marketing="//a[text()='Marketing & Leasing']";
	public String accounting="//a[text()='Accounting']";
	public String utilities="//a[text()='Utilities']";
	public String solution="//div[text()='Solutions']";
	public String multiFamily="//a[text()='Multifamily']";
	public String student="//a[text()='Student']";
	public String affordable="//a[text()='Affordable']";
	public String military="//a[text()='Military']";
	public String commercial="//a[text()='Commercial']";
	public String homebody="//a[text()='Homebody']";
	public String accountPage="//p[text()='Handle all property accounting and financial reporting with the power of Entrata’s operating system.']";
	private String GeneralAccount="//a[text()='General Accounting']";
	
	
	public void showOptionOfElement(String xpath)
	{
		WebElement element=driver.findElement(By.xpath(xpath));
		Actions act=new Actions(driver);
		act.moveToElement(element).build().perform();
	}
	
	public boolean isGeneralAccountPageOpen() throws IOException
	{
		return new HomePage().isElementPresent(accountPage);
	}

	public void clickGeneralAccount() throws IOException
	{
		new HomePage().clickOnElement(GeneralAccount);
	}

}
