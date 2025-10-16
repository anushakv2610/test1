package jenkin.jenkinss;



	import java.io.FileInputStream;
	import java.io.IOException;

	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.testng.Assert;
	import org.testng.annotations.AfterMethod;
	import org.testng.annotations.BeforeMethod;
	import org.testng.annotations.DataProvider;
	import org.testng.annotations.Test;

	

	public class LoginTest {
		WebDriver driver;
		LoginPage loginP;
		@BeforeMethod
		void setup() {
			driver=new ChromeDriver();
			loginP=new LoginPage(driver);
			driver.manage().window().maximize();
			driver.get("https://www.saucedemo.com/");	
		}
		@Test
		void validLogin() {
			loginP.login("standard_user", "secret_sauce");
			String backpack =driver.findElement(By.xpath("//div[.='Sauce Labs Backpack']")).getText();
			Assert.assertEquals(backpack,"Sauce Labs Backpack");
		}
		@Test
		void invalidloginwitoutun() {
			loginP.enterPass("anu");
			loginP.loginBtnClick();
			Assert.assertEquals(loginP.getError(),"Epic sadface: Username is required");
		}
		
		@Test(dataProvider = "data")
		void loginTest(String user,String pass) {
			loginP.login(user, pass);
			String prdname = driver.findElement(By.xpath("//div[.='Sauce Labs Backpack']")).getText();
			Assert.assertEquals(prdname, "Sauce Labs Backpack");
		}
		@AfterMethod
		void tearDown() {
			driver.quit();
		}

	}


