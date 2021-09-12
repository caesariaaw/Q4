package test;



import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.http.util.Asserts;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.server.handler.SendKeys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;



import org.junit.Assert;

public class cermatiRegister {
	public static String browser;
	static WebDriver driver;

	public static void main(String[] args) {
		cermatiRegister test = new cermatiRegister();
		test.setBrowser("Firefox");
		test.setBrowserConfig();
		test.getTitle();
		test.Register();

	}

	public void setBrowser(String browser) {
		this.browser = browser;

	}

	public void setBrowserConfig() {
		String projectLocation = System.getProperty("user.dir");

		if (browser.contains("Chrome")) {
			System.setProperty("webdriver.chrome.driver", projectLocation + "\\lib\\driver\\chromedriver.exe");
			driver = new ChromeDriver();
		}

		if (browser.contains("Firefox")) {
			System.setProperty("webdriver.gecko.driver", projectLocation + "\\lib\\driver\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
	}

	@Test

	public void getTitle() {
		String url = "https://www.cermati.com/gabung";
		driver.manage().window().maximize();
		driver.get(url);
		String title = driver.getTitle();
		String Str = new String(title);
		System.out.println(title);

		System.out.print("String Length :");
		System.out.println(Str.length());

		
	}

	@Test
	public void Register() {
		
		System.out.println("========Register Page========");
		
		String rand1 = RandomStringUtils.randomNumeric(3);
		String rand2 = RandomStringUtils.randomAlphabetic(5);
		String rand3 = RandomStringUtils.randomNumeric(8);
		
		WebElement inputEmail = driver.findElement(By.id("email"));
		inputEmail.sendKeys("email"+rand1+"@mailnesia.com");
		String emailText = inputEmail.getAttribute("value");
		System.out.println("You just entered email : " + emailText);

		WebElement inputPass = driver.findElement(By.id("password"));
		inputPass.sendKeys("email"+rand1);
		String passText = inputPass.getAttribute("value");
		System.out.println("You just entered password : " + passText);

		
		WebElement inputConfPass = driver.findElement(By.id("confirm-password"));
		inputConfPass.sendKeys(passText);
		String passConfText = inputPass.getAttribute("value");
		System.out.println("You just entered conf password : " + passConfText);
		
		WebElement inputFirstName = driver.findElement(By.id("first-name"));
		inputFirstName.sendKeys("email"+rand2);
		String firstNameText = inputFirstName.getAttribute("value");
		System.out.println("You just entered first name : " + firstNameText);
		
		WebElement inputLastName = driver.findElement(By.id("last-name"));
		inputLastName.sendKeys("mailnet");
		String lastNameText = inputLastName.getAttribute("value");
		System.out.println("You just entered last name : " + lastNameText);

		WebElement inputCity = driver.findElement(By.id("residence-city"));
		inputCity.sendKeys("KOTA JAKARTA SELATAN");
		inputCity.sendKeys(Keys.ENTER);
		
		String cityText = inputCity.getAttribute("value");
		System.out.println("You just entered city : " + cityText);
		
		
		WebElement inputPhone = driver.findElement(By.id("mobile-phone"));
		inputPhone.sendKeys("0812"+rand3);
		String phoneText = inputPhone.getAttribute("value");
		System.out.println("You just entered phone number : " + phoneText);
		inputPhone.sendKeys(Keys.ENTER);
		inputCity.sendKeys(Keys.ENTER);
		
		
		WebElement buttonRegister = driver.findElement(By.xpath("//button[@class='btn btn-full btn-submit btn-track']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", buttonRegister);
		
	
		try {
			Thread.sleep(10000);
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
			String actUrlLogin = driver.getCurrentUrl();
		String expUrlLogin = "https://www.cermati.com/";
		
		if (actUrlLogin.equals(expUrlLogin)) {
			System.out.println("Successfully login");
		}else {
			System.out.println("Failed to login");
		}

		driver.quit();

	}

}
