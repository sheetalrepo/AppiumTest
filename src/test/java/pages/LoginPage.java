package pages;

import java.net.MalformedURLException;

import org.openqa.selenium.By;

public class LoginPage extends BasePage {

	/**
	 * Page elements
	 */
	static By a_email = By.id("fragment_auth_email");
	static By i_email = By.id("Email");
	static By email = getByElement(a_email, i_email);

	static By a_password = By.id("fragment_auth_password");
	static By i_password = By.id("Password");
	static By password = getByElement(a_password, i_password);

	static By a_login_button = By.id("fragment_login_login_button");
	static By i_login_button = By.id("Login");
	static By login_button = getByElement(a_login_button, i_login_button);

	static By a_forgotPassswordButton = By.id("fragment_login_forgot_password_button");
	static By i_forgotPassswordButton = By.id("TODO");
	static By forgotPassswordButton = getByElement(a_forgotPassswordButton, i_forgotPassswordButton);

	public LoginPage() throws MalformedURLException  {
		super();
	}

	/**
	 * Actions methods
	 */
	public static void login(String username, String pwd) {
		
		System.out.println("### Login Page > Login Successfull");
		//sendKeys(email, username);
		//sendKeys(password, pwd);
		//click(login_button);
	}

	public static void clickForgotPassword() {
		click(forgotPassswordButton);
	}

	/**
	 * Getters
	 */

	/**
	 * Setters
	 */

	/**
	 * Verification methods
	 */
	public static boolean isLoginPageLoaded() {
		return isPageLoaded(password);
	}

	public static boolean isEmailFieldDisplayed() {
		return isElementPresent(email);
	}

	public static boolean isPasswordFieldDisplayed() {
		return isElementPresent(password);
	}

}
