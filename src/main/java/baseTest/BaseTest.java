package baseTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BaseTest 
{
	
	public static WebDriver driver;
	public static Properties pro;

	public BaseTest() throws IOException
	{
		pro=new Properties();
		InputStream fis=new FileInputStream("C:\\Users\\Lenovo\\eclipse-workspace\\.metadata\\EntrataProject\\src\\main\\java\\configProperties\\ConfigProperties");
		pro.load(fis);
	}
	
	@BeforeMethod
	public void activateBrowser() throws InterruptedException
	{
		String br=pro.getProperty("browser");
		
		if(br.equalsIgnoreCase("chrome"))
		{
		    driver=new ChromeDriver();
		}
		
		else if(br.equalsIgnoreCase("firefox"))
		{
			driver=new FirefoxDriver();
		}
		
		else if(br.equalsIgnoreCase("edge"))
		{
			driver=new EdgeDriver();
		}
		driver.get(pro.getProperty("url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
		driver.manage().deleteAllCookies();
		driver.findElement(By.xpath("//button[text()='Accept Cookies']")).click();
	}
	
	@AfterMethod
	public void closeBrowser()
	{
		driver.quit();
	}
	
	
}
