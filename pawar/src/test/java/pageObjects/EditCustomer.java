package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditCustomer {WebDriver ldriver;

public EditCustomer(WebDriver rdriver) {
	// TODO Auto-generated constructor stub
	PageFactory.initElements(rdriver, this);
}



@FindBy(xpath = "/html/body/div[3]/div/ul/li[3]/a")
WebElement editcustomerbtn;






public void editcustomerbutton()
{
editcustomerbtn.click();
}

}
