package testCases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.NewCustomer;

public class NC2 extends BaseClass {
	@Test
	public void name() throws IOException {
		NewCustomer nc = new NewCustomer(driver);
		nc.newcustomerbutton();

		driver.findElement(By.xpath("//tbody/tr[4]/td[2]/input[1]")).sendKeys("1234");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		if (driver.getPageSource().contains("Numbers are not allowed")) {
			logger.info("Correct output");
			Assert.assertTrue(true);
		}
		else
		{
			logger.info("incorrect output");
			Assert.assertTrue(false);
			captureScreen(driver, "NC2");
		}

	}

}
