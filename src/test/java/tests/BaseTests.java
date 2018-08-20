package tests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import tests.MailView;

public class BaseTests {

	public static WebDriver driver;
	public String mail;
	String Url;

	
	@BeforeClass
	public static void setup() {

		System.setProperty("webdriver.chrome.driver","src\\test\\resources\\geckodriver\\Chrome\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("disable-infobars");
		options.addArguments("start-maximized");

		driver = new ChromeDriver(options);
		
		driver.get("http://stage.izzi.co.il/");
	}
	
	@Test
	public void dreamTest(){
	
		WebDriverWait load_page=new WebDriverWait(driver, 20);		
		load_page.until(ExpectedConditions.visibilityOfElementLocated(By.className("register-nav")));
		System.out.println("Site open");
		//registration
		driver.findElement(By.className("register-nav")).click();
		
		
		driver.findElement(By.id("signupform-email")).sendKeys(MailView.addres);
		driver.findElement(By.id("shop-name")).sendKeys("TestShop");
		driver.findElement(By.id("signupform-password")).sendKeys("123456");
		driver.findElement(By.id("shop-url")).sendKeys("https://rozetka.com.ua/");
		driver.findElement(By.className("submit-form-store")).click();
		List<WebElement> error = driver.findElements(By.className("has-error"));
		//System.out.println(error.size());
		if (error.size() > 0){
			System.out.println("Incorrect input value on 1st step");
		}
		else {
			
		}
		
		WebDriverWait step2=new WebDriverWait(driver, 20);		
		step2.until(ExpectedConditions.visibilityOfElementLocated(By.id("step_two")));
		System.out.println("Second step registration store open!");
		
		//step2
		driver.findElement(By.id("signupform-name")).sendKeys("TestUser");
		driver.findElement(By.className("submit-form-store")).click();
		
		List<WebElement> error_step2 = driver.findElements(By.className("has-error"));
		//System.out.println(error.size());
		if (error_step2.size() > 0){
			System.out.println("Incorrect input value on 2nd step");
		}
		else {
			
		}
		
		WebDriverWait success=new WebDriverWait(driver, 20);		
		success.until(ExpectedConditions.visibilityOfElementLocated(By.id("w0-success-0")));
		System.out.println("Store Register");
		System.out.println("Mail = " +MailView.addres);
		System.out.println("User = TestUser");
		System.out.println("Pass = 123456789");
		
		//check login
		driver.get("http://adv-stage.izzi.co.il/user/login");
		driver.findElement(By.id("loginform-email")).sendKeys(MailView.addres);
		driver.findElement(By.id("loginform-password")).sendKeys("123456");
		List<WebElement> error_login = driver.findElements(By.className("has-error"));
		//System.out.println(error.size());
		if (error_login.size() > 0){
			System.out.println("Login advertizer error!!!");
		}
		else {
			
			driver.findElement(By.className("btn-primary")).click();
			
		}
		WebDriverWait success_adv=new WebDriverWait(driver, 20);		
		success_adv.until(ExpectedConditions.visibilityOfElementLocated(By.id("notifications")));
		System.out.println("Advertiser login!!!");
		
	}
	
	@AfterTest
	 
	public void afterTest() {
		driver.close();
	}

}
