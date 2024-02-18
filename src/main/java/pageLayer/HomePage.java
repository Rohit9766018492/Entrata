package pageLayer;

import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import baseTest.BaseTest;

public class HomePage extends BaseTest{
	
	public HomePage() throws IOException {
		super();
		
	}

	public String EntrataLogo="//a[@title='Entrata Home Page']";
	public String product="//div[text()='Products']";
	public String Solution="//div[text()='Solutions']";
	public String Resources="//a[text()='Resources']";
	public String Base_Camp="//a[text()='Base Camp']";
	public String Watch_Demo="//a[text()='Watch Demo']";
	public String Sign_In="//a[text()='Sign In']";
	public String registerNow="(//div[text()='Register Now'])[1]";
	
	// To Verify element is present or not on web page
	public boolean isElementPresent(String xpath)
	{
		return driver.findElement(By.xpath(xpath)).isDisplayed();
	}
	
	//click on element
	public void clickOnElement(String xpath)
	{
		driver.findElement(By.xpath(xpath)).click();
	}
	
	public void waitForElementAppear(String xpath, int maxTime) throws InterruptedException
	{
		int i = 0;
		while(i<maxTime)
		{
			isElementPresent(xpath);
			driver.wait(1000);
			i++;
		}
	}
	
	public void waitForElement(String xpath, int maxtime)
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(maxtime));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
	}
	
	public void switchToNeWWindow()
	{
		String mainWindowId=driver.getWindowHandle();
		System.out.println("Main window id ----> " +mainWindowId);
		Set<String> allWindowId=driver.getWindowHandles();
		
		for(String childWindow:allWindowId)
		{
			System.out.println("Child Window Id ---> "+childWindow);
			
			
			if(!(mainWindowId.equalsIgnoreCase(childWindow)))
			{
				driver.switchTo().window(childWindow);
				System.out.println("----- Switch to child Window ------");
			}
		}
	}
	
	public void switchToMainWindow()
	{
		String mainWindowId=driver.getWindowHandle();
		
		driver.switchTo().window(mainWindowId);
	}

}
