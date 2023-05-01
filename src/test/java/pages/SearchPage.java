package pages;

import java.net.MalformedURLException;

import org.openqa.selenium.By;

public class SearchPage extends BasePage {

	/**
	 * Page elements
	 */
	static By a_email = By.id("fragment_auth_email");
	static By i_email = By.id("Email");
	static By email = getByElement(a_email, i_email);


	public SearchPage() throws MalformedURLException  {
		super();
	}

	/**
	 * Actions methods
	 */
	public static void searchKeyword(String keyword) {
		System.out.println("Searching given keyword ");
	}


}
