package baseClasses;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base1 {
	
static WebDriver driver;

static ExtentHtmlReporter htmlReporter;

static ExtentReports reports;
static ExtentTest test;
	
	//Initializations
	public static WebDriver getDriver(String browser) {
		
		if(driver == null) {
			
			if(browser.equals("chrome")) {
				
				WebDriverManager.chromedriver().setup();
				
		//		System.setProperty("webdriver.chrome.driver", "D:\\Velocity\\Batch 18th June 2022\\chromedriver.exe");
				driver = new ChromeDriver();
			}else if(browser.equals("firefox")) {
				
				WebDriverManager.firefoxdriver().setup();
				
			//	System.setProperty("webdriver.gecko.driver", "D:\\Velocity\\Batch 18th June 2022\\geckodriver.exe");
				driver = new FirefoxDriver();
			}

				driver.get("https://www.flipkart.com/");

			
			driver.manage().window().maximize();
			
			
			
			
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		}
		
		return driver;
	}
	
	
	public static void unloadDriver() {
		driver = null;
	}
	
	
	public static ExtentHtmlReporter getHtmlReporter() {
		if(htmlReporter == null) {
			htmlReporter = new ExtentHtmlReporter("ExtentReports.html");	
		}
		return htmlReporter;
	}
	
	public static ExtentReports getReports() {
		if(reports == null) {
			reports = new ExtentReports();
			reports.attachReporter(htmlReporter);
		}
		return reports;
	}
	
	public static ExtentTest getExtentTest(String testName) {	
		return reports.createTest(testName);
	}
	
	
	

}
