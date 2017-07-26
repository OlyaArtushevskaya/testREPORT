package by.htp.testreport.pageobject;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class MailBoxPage extends BasePage {

	public static final String URL = "https://e.mail.ru/messages/inbox/";

	@FindBy(xpath = ".//a[@class='b-toolbar__btn js-shortcut']")
	private WebElement writeLetterButton;

	@FindBy(xpath = ".//a[@href='/messages/inbox/']")
	private WebElement inbox;

	@FindBy(xpath = ".//a[@data-subject='Test letter from O.Artushevskaya']")
	private WebElement letterWasSent;

	public MailBoxPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public void navigate() {
		driver.get(URL);
	}

	public WriteLetterPage writeLetter() {
		writeLetterButton.click();
		return new WriteLetterPage(driver);
	}

	public void letterWasSent(String subjectLetter) {
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		inbox.click();
		Assert.assertTrue(letterWasSent.getText().contains(subjectLetter));
	}

}
