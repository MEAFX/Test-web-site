package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class temp_mail_org {
	
	public temp_mail_org(WebDriver driver) {
		PageFactory.initElements(driver, this);
        this.driver = driver;
    }
	
	public WebDriver driver;
    private String mail;
    
    @FindBy(id = "mail")
    private WebElement emailAddres;
    
    public void setMail_addr(String mail)
    {
      this.mail = mail;
    }
	
	public String getMail_addr()
    {
		mail = emailAddres.getText();
		System.out.println("mail from temp-mail.org "+mail);
		return this.mail;
    } 

}
