package by.htp.testreport.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage extends BasePage {

	public static final String URL = "https://mail.ru/";

	@FindBy(id = "mailbox__login")
	private WebElement loginField;

	@FindBy(id = "mailbox__password")
	private WebElement passField;

	@FindBy(id = "mailbox__auth__button")
	private WebElement submit;

	public MainPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public MailBoxPage login(String login, String pass) {
		loginField.sendKeys(login);
		passField.sendKeys(pass);
		submit.click();
		return new MailBoxPage(driver);
	}

}
