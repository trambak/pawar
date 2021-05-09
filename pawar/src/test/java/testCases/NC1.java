package testCases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.NewCustomer;

public class NC1 extends BaseClass {

	@Test
	public void verifyname() throws IOException {

		NewCustomer nc = new NewCustomer(driver);
		nc.newcustomerbutton();

		driver.findElement(By.xpath("//tbody/tr[4]/td[2]/input[1]")).click();
		driver.findElement(By.xpath("//tbody/tr[14]/td[2]/input[1]")).click();
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.NANOSECONDS);

		if (driver.getPageSource().contains("Customer name must not be blank")) {
			logger.info("Correct output");
			Assert.assertTrue(true);
		} else {
			logger.info("incorrect output");
			Assert.assertTrue(false);
			captureScreen(driver, "NC1");
		}

	}

	@Test
	public void name() throws IOException {
		NewCustomer nc = new NewCustomer(driver);
		nc.newcustomerbutton();

		driver.findElement(By.xpath("//tbody/tr[4]/td[2]/input[1]")).sendKeys("1234");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		if (driver.getPageSource().contains("Numbers are not allowed")) {
			logger.info("Correct output");
			Assert.assertTrue(true);
		} else {
			logger.info("incorrect output");
			Assert.assertTrue(false);
			captureScreen(driver, "NC2");
		}

	}

	@Test
	public void numeric() throws InterruptedException, IOException {
		NewCustomer nc = new NewCustomer(driver);
		nc.newcustomerbutton();

		driver.findElement(By.xpath("//tbody/tr[4]/td[2]/input[1]")).sendKeys("name@$");
		Thread.sleep(1000);
		if (driver.getPageSource().contains("Special characters are not allowed")) {
			logger.info("Correct output");
			Assert.assertTrue(true);
		} else {
			logger.info("incorrect output");
			Assert.assertTrue(false);
			captureScreen(driver, "NC3");
		}

	}

	@Test
	public void numeric1() throws InterruptedException, IOException {
		NewCustomer nc = new NewCustomer(driver);
		nc.newcustomerbutton();

		driver.findElement(By.xpath("//tbody/tr[4]/td[2]/input[1]")).sendKeys("    anc");
		Thread.sleep(2000);
		if (driver.getPageSource().contains("First character can not have space")) {
			logger.info("Correct output");
			Assert.assertTrue(true);
		} else {
			logger.info("incorrect output");
			Assert.assertTrue(false);
			captureScreen(driver, "NC4");
		}

	}

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

	@Test
	public void verifyadress1() throws IOException {
		NewCustomer nc = new NewCustomer(driver);
		nc.newcustomerbutton();

		driver.findElement(By.xpath("//tbody/tr[7]/td[2]/textarea[1]")).sendKeys("   abc");
		driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//tbody/tr[8]/td[2]/input[1]")).click();

		if (driver.getPageSource().contains("First character can not have space")) {
			logger.info("Test Pased");
			Assert.assertTrue(true);
		} else {
			logger.info("Test Failed");
			Assert.assertTrue(false);
			captureScreen(driver, "nc5");
		}

	}

}
