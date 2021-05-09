package testCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.NewCustomer;

public class NC4 extends BaseClass {
	@Test
	public void numeric() throws InterruptedException, IOException {
		NewCustomer nc = new NewCustomer(driver);
		nc.newcustomerbutton();

		driver.findElement(By.xpath("//tbody/tr[4]/td[2]/input[1]")).sendKeys("    anc");
		Thread.sleep(2000);
		if(	driver.getPageSource().contains("First character can not have space"))
		{
			logger.info("Correct output");
			Assert.assertTrue(true);
		}
		else
		{
			logger.info("incorrect output");
			Assert.assertTrue(false);
			captureScreen(driver, "NC4");
		}

	}
}
