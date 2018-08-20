package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.temp_mail_org;


public class MailView {
	
	public static WebDriver driver;
	public static temp_mail_org temp_mail_org; 
	public static String addres; 
	
	@BeforeClass
	public static void setup() {
		System.setProperty("webdriver.chrome.driver","src\\test\\resources\\geckodriver\\Chrome\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("disable-infobars");
		options.addArguments("start-maximized");
		
		driver = new ChromeDriver(options);
		temp_mail_org = new temp_mail_org(driver);
		driver.get("https://temp-mail.org/ru/");
	}
		
	@Test
	public void getMail(){
		String mail_addr = driver.findElement(By.cssSelector("#mail")).getAttribute("value");
		addres = mail_addr;
	}
	public String addres()
    {
      return this.addres;
    }
	
	@AfterTest
	 
	public void afterTest() {
		driver.close();
	}
	
}
