package testCases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.EditCustomer;

public class EC2 extends BaseClass {
	@Test
	public void editcust() throws IOException {

		EditCustomer ec = new EditCustomer(driver);
		ec.editcustomerbutton();

		driver.findElement(By.xpath("/html/body/div[2]/table/tbody/tr/td/table/tbody/tr[6]/td[2]/input")).sendKeys("name123");;
//		driver.findElement(By.xpath("/html/body/div[2]/table/tbody/tr/td/table/tbody/tr[11]/td[2]/input[1]")).click();
		driver.manage().timeouts().implicitlyWait(5000,TimeUnit.NANOSECONDS);
		if (driver.getPageSource().contains("Characters are not allowed")) {
			logger.info("Correct output");
			Assert.assertTrue(true);
		} else {
			logger.info("incorrect output");
			Assert.assertTrue(false);
			captureScreen(driver, "EC1");
		}

	}
}
