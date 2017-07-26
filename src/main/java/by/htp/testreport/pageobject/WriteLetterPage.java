package by.htp.testreport.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WriteLetterPage extends BasePage {

	public static final String URL = "https://e.mail.ru/compose/";

	@FindBy(xpath = ".//textarea[@class='js-input compose__labels__input']")
	private WebElement letterAddressee;

	@FindBy(xpath = ".//input[@class='b-input']")
	private WebElement letterSubject;

	@FindBy(xpath = ".//tr[@class='mceFirst mceLast']//iframe")
	private WebElement frame;

	@FindBy(id = "tinymce")
	private WebElement letterText;

	@FindBy(xpath = "//div[@id='b-toolbar__right']//div[@data-name='send']")
	private WebElement sendButton;

	public WriteLetterPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public MailBoxPage sendLetter(String eMail, String subjectLetter, String textLetter) {
		letterAddressee.click();
		letterAddressee.sendKeys(eMail);

		letterSubject.sendKeys(subjectLetter);

		driver.switchTo().frame(frame);
		letterText.sendKeys(textLetter);
		driver.switchTo().defaultContent();

		sendButton.click();

		return new MailBoxPage(driver);
	}

}
