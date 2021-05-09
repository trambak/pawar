package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewCustomer {
	WebDriver ldriver;
	
	public NewCustomer(WebDriver rdriver) {
		// TODO Auto-generated constructor stub
		PageFactory.initElements(rdriver, this);
	}

@FindBy(xpath = "//tbody/tr[1]/td[2]/input[1]")
WebElement username;

@FindBy(xpath = "//tbody/tr[2]/td[2]/input[1]")
WebElement password;

@FindBy(xpath = "//tbody/tr[3]/td[2]/input[1]")
WebElement loginbutton;

@FindBy(xpath = "//a[contains(text(),'New Customer')]")
WebElement newcustomerbtn;




public void sendusername(String uname)
{
	username.sendKeys(uname);
}

public void sendpassword(String pswd)
{
	password.sendKeys(pswd);
}

public void loginbutton()
{
	loginbutton.click();
}

public void newcustomerbutton()
{
	newcustomerbtn.click();
}

}
