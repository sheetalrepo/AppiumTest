package demo;

import java.io.File;
import io.appium.java_client.android.options.UiAutomator2Options;

/*
 * As per Java-client 8
 * Appium 2
 * 
 */
public class A0_UiAutomator2Options {

	public UiAutomator2Options getApiDemoApkOptions() {
		System.out.println("-------- Started: Api Demo Apk ----------");
		ClassLoader classLoader = getClass().getClassLoader();
		File file = new File(classLoader.getResource("builds/A_ApiDemos-debug.apk").getFile());
		String apkPath = file.getAbsolutePath();

		UiAutomator2Options options = new UiAutomator2Options();
		options
			.setPlatformName("Android")
			.setPlatformVersion("8.1")

			.setAutomationName("UiAutomator2")
			.setDeviceName("emulator-5554")
			
			.setAppPackage("io.appium.android.apis")
			.setAppActivity(".ApiDemos")

			.setApp(apkPath) // Optional, Drag n Drop can also be used
			.setNoReset(false); // true: Will not install app if its already present

		return options;
	}

	public UiAutomator2Options getSauceLabApkOptions() {
		System.out.println("-------- Started: Saucelab Demo Apk ----------");

		ClassLoader classLoader = getClass().getClassLoader();
		File file = new File(classLoader.getResource("builds/B_Android-NativeDemoApp-0.4.0.apk").getFile());
		String apkPath = file.getAbsolutePath();

		UiAutomator2Options options = new UiAutomator2Options();
		options
			.setPlatformName("Android")
			.setPlatformVersion("8.1")
			.setAutomationName("UiAutomator2")
			.setDeviceName("emulator-5554")
			.setAppPackage("com.saucelabs.mydemoapp.rn")
			.setAppActivity(".MainActivity")
			.setApp(apkPath) // Optional, Drag n Drop can also be used
			.setNoReset(false); // true: Will not install app if its already present
		return options;
	}

	
	public UiAutomator2Options getWebdriverIOApkOptions() {
		System.out.println("-------- Started: WebDriverIO Demo Apk ----------");

		ClassLoader classLoader = getClass().getClassLoader();
		File file = new File(classLoader.getResource("builds/C_Android-MyDemoAppRN.1.3.0.build-244.apk").getFile());
		String apkPath = file.getAbsolutePath();

		UiAutomator2Options options = new UiAutomator2Options();
		options
			.setPlatformName("Android")
			.setPlatformVersion("8.1")
			.setAutomationName("UiAutomator2")
			.setDeviceName("emulator-5554")
			.setAppPackage("com.wdiodemoapp")
			.setAppActivity(".MainActivity")
			.setApp(apkPath) // Optional, Drag n Drop can also be used
			.setNoReset(false); //true: Will not install app if its already present
		return options;
	}
	
	
	
	public UiAutomator2Options getChromeOptions() {
		System.out.println("-------- Started: Chrome Browser ----------");

		UiAutomator2Options options = new UiAutomator2Options();
		options
			.setPlatformName("Android")
			.setPlatformVersion("8.1")
			.setAutomationName("UiAutomator2")
			.setDeviceName("emulator-5554")
			.noReset()
			.withBrowserName("Chrome");
		return options;
	}
}
