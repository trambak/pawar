package testCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.NewCustomer;

public class NC3 extends BaseClass{

	@Test
	public void numeric() throws InterruptedException, IOException {
		NewCustomer nc = new NewCustomer(driver);
		nc.newcustomerbutton();
		
		driver.findElement(By.xpath("//tbody/tr[4]/td[2]/input[1]")).sendKeys("name@$");
		Thread.sleep(1000);		
		if(driver.getPageSource().contains("Special characters are not allowed"))
		{
			logger.info("Correct output");
			Assert.assertTrue(true);
		}
		else
		{
			logger.info("incorrect output");
			Assert.assertTrue(false);
			captureScreen(driver, "NC3");
		}

	}

}
