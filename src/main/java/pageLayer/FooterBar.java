package pageLayer;

import java.io.IOException;

import org.openqa.selenium.interactions.Actions;

import baseTest.BaseTest;

public class FooterBar extends BaseTest{

	public FooterBar() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public String FooterBar="//div[@class='footer-social-grid']";
	
	public String webAccessebility="//a[@title='Entrata Inc. Web Accessibility Statement']";
	public String insta="//a[@title='Entrata Inc. Instagram Page']";
	public String faceBook="//a[@title='Entrata Inc. Facebook Page']";
	public String twitter="//a[@title='Entrata Inc. Twitter Page']";
	public String linkeDin="//a[@title='Entrata Inc. Linkedin Page']";
	public String youTube="//a[@title='Entrata Inc. Youtube Page']";
	
	public void scrollByAmount(int x, int y)
	{
		Actions act=new Actions(driver);
		act.scrollByAmount(x, y);
	}
	
}
