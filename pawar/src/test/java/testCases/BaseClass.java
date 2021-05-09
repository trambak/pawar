package testCases;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pageObjects.NewCustomer;

public class BaseClass {
	public static WebDriver driver;
	public String username = "mngr321249";
	public String password = "EpUrYha";
	public String url = "http://www.demo.guru99.com/V4/";
	public static Logger logger;
	public String chromepath = "C:\\\\Users\\\\Vighnaharta\\\\Testing\\\\pawar\\\\Drivers\\\\chromedriver.exe";
	public String firefoxpath = "C:\\\\Users\\\\Vighnaharta\\\\Testing\\\\pawar\\\\Drivers\\\\geckodriver.exe";
	public String iepath = "C:\\\\Users\\\\Vighnaharta\\\\Testing\\\\pawar\\\\Drivers\\\\IEdriverServer.exe";

	@BeforeMethod
	public void setup() {

		System.setProperty("webdriver.chrome.driver", chromepath);
		driver = new ChromeDriver();

		driver.get(url);
		driver.manage().window().maximize();

		logger = Logger.getLogger("Url Operning");
		PropertyConfigurator.configure("log4j.properties");
		NewCustomer nc = new NewCustomer(driver);
		nc.sendusername(username);

		nc.sendpassword(password);

		nc.loginbutton();

		if (driver.getTitle().equals("Guru99 Bank Manager HomePage")) {
			Assert.assertTrue(true);
			logger.info("Login Success");
		} else {
			Assert.assertTrue(false);
			logger.info("Login unsuccessful");
		}
	}

	@AfterMethod
	public void teardown() {
		driver.close();
	}

	public void captureScreen(WebDriver driver, String tname) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "/Screenshots/" + tname + ".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot taken");
	}

	
}
