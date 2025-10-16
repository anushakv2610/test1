package jenkin.jenkinss;


	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;

	public class LoginPage {
		WebDriver driver;
		public LoginPage(WebDriver driver) {
			this.driver=driver;
			PageFactory.initElements(driver,this);
		}
		@FindBy(id="user-name")
		WebElement userName;
		@FindBy(id="password")
		WebElement password;
		@FindBy(id="login-button")
		WebElement lgnButton;
		@FindBy(xpath = "//h3[@data-test='error']")
		WebElement errorMsg;
		public void enterUN(String user) {
			userName.sendKeys(user);
		}
		public void enterPass(String Pass) {
			password.sendKeys(Pass);
		}
		public void loginBtnClick() {
			lgnButton.click();
		}
		public void login(String user,String Pass) {
			userName.sendKeys(user);
			password.sendKeys(Pass);
			lgnButton.click();
			
		}
		public String getError() {
			return errorMsg.getText();
		}
		public String getTitle() {
			return driver.getTitle();
		}

	}


