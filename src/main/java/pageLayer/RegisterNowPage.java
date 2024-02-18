package pageLayer;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import baseTest.BaseTest;

public class RegisterNowPage extends BaseTest {

	public RegisterNowPage() throws IOException {
		super();
		
	}
	
	public String firstName="//span[text()='First Name']";
	public String lastName="//span[text()='Last Name']";

	public String company="//span[text()='Company']";
	public String title="//span[text()='Title']";
	public String email="//span[text()='Email Address']";
	public String mobile="//span[text()='Mobile']";
	public String cancel="//button[text()='Cancel']";
	public String next="//button[text()='Next']";
	public String checkBoxRegistered="//input[@id='adminRegSelected_0']";
	public String ErrorMassage="//h2[text()='Enter your personal information below']";
	
	public void scrollPageWhileElementNotAppear(String xpath) 
	{
		WebElement element=driver.findElement(By.xpath(xpath));
		Actions act=new Actions(driver);
		act.scrollToElement(element);
		act.scrollByAmount(0, 100);
	
	}
	
	public boolean isElementEnabled(String xpath)
	{
		return driver.findElement(By.xpath(xpath)).isEnabled();
	}
	


}
