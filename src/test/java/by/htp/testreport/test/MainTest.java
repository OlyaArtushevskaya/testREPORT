package by.htp.testreport.test;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;
import by.htp.testreport.pageobject.MailBoxPage;
import by.htp.testreport.pageobject.MainPage;
import by.htp.testreport.pageobject.WriteLetterPage;

public class MainTest extends BaseTest {

	private static final Logger LOG = Logger.getLogger(MainTest.class);

	@Test
	public void doMain() {
		LOG.warn("start 'navigate'");
		MainPage mainPage = navigate(MainPage.URL);
		LOG.info("finish 'navigate'");

		LOG.warn("start 'login'");
		LOG.info("enter: tathtp@mail.ru Klopik123");
		mainPage.login("tathtp@mail.ru", "Klopik123");
		LOG.info("finish 'login'");

		LOG.warn("start 'writeLetter'");
		MailBoxPage mailBoxPage = new MailBoxPage(driver);
		mailBoxPage.navigate();
		mailBoxPage.writeLetter();
		LOG.info("finish 'writeLetter'");

		LOG.warn("start 'sendLetter'");
		WriteLetterPage writeLetterPage = new WriteLetterPage(driver);
		writeLetterPage.sendLetter("tathtp@mail.ru", "Test letter from O.Artushevskaya", "Hello! :)");
		LOG.info("finish 'sendLetter'");

		LOG.warn("start 'letterWasSent'");
		mailBoxPage.letterWasSent("Test letter from O.Artushevskaya");
		LOG.info("It's good! The letter was sent!!");
		LOG.info("finish 'letterWasSent'");

		closeBrowser();
	}

}
