package demo;

import java.io.File;
import io.appium.java_client.android.options.UiAutomator2Options;

public class A0_UIAutomator2 {

	public UiAutomator2Options getApiDemoApkOptions() {
		System.out.println("-------- Started: Api Demo Apk ----------");
		ClassLoader classLoader = getClass().getClassLoader();
		File file = new File(classLoader.getResource("builds/ApiDemos-debug.apk").getFile());
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
			.setNoReset(true); // Will not install app if its already present

		return options;
	}

	public UiAutomator2Options getSauceLabApkOptions() {
		System.out.println("-------- Started: Saucelab Demo Apk ----------");

		ClassLoader classLoader = getClass().getClassLoader();
		File file = new File(classLoader.getResource("builds/Android-MyDemoAppRN.1.3.0.build-244.apk").getFile());
		String apkPath = file.getAbsolutePath();

		UiAutomator2Options options = new UiAutomator2Options();
		options
			.setPlatformName("Android")
			.setPlatformVersion("8.1")

			.setAutomationName("UiAutomator2")
			.setDeviceName("emulator-5554")
			
			.setAppPackage("com.saucelabs.mydemoapp.rn")
			.setAppActivity(".MainActivity");

			//.setApp(apkPath) // Optional, Drag n Drop can also be used
			//.setNoReset(true); // Will not install app if its already present

		return options;
	}

}
