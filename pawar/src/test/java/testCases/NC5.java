package testCases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.NewCustomer;

public class NC5 extends BaseClass {

	@Test
	public void verifyadress() throws IOException {
		NewCustomer nc = new NewCustomer(driver);
		nc.newcustomerbutton();

		driver.findElement(By.xpath("//tbody/tr[7]/td[2]/textarea[1]")).click();
		driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//tbody/tr[8]/td[2]/input[1]")).click();
		
		if (driver.getPageSource().contains("Address Field must not be blank")) {
			logger.info("Test Pased");
			Assert.assertTrue(true);
		} else {
			logger.info("Test Failed");
			Assert.assertTrue(false);
			captureScreen(driver, "nc5");
		}

	}

}
