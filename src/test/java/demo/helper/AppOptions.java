package demo.helper;

import java.io.File;
import io.appium.java_client.android.options.UiAutomator2Options;

public class AppOptions {
	UiAutomator2Options options;

	public void initOptions(String appName) {
		switch (appName) {
		case "app1": {
			System.out.println("-------- Started: Api Demo Apk ----------");
			ClassLoader classLoader = getClass().getClassLoader();
			File file = new File(classLoader.getResource("builds/ApiDemos-debug.apk").getFile());
			String apkPath = file.getAbsolutePath();

			options = new UiAutomator2Options();
			options
				.setPlatformName("Android")
				.setPlatformVersion("8.1")
				.setAutomationName("UiAutomator2")
				.setDeviceName("emulator-5554")
				.setAppPackage("io.appium.android.apis")
				.setAppActivity(".ApiDemos")
				.setApp(apkPath) // Optional, Drag n Drop can also be used
				.setNoReset(true); // Will not install app if its already present
		};break;

		case "app2": {
			System.out.println("-------- Started: Saucelab Demo Apk ----------");

			ClassLoader classLoader = getClass().getClassLoader();
			File file = new File(classLoader.getResource("builds/Android-MyDemoAppRN.1.3.0.build-244.apk").getFile());
			String apkPath = file.getAbsolutePath();

			options = new UiAutomator2Options();
			options
				.setPlatformName("Android")
				.setPlatformVersion("8.1")
				.setAutomationName("UiAutomator2")
				.setDeviceName("emulator-5554")
				.setAppPackage("com.saucelabs.mydemoapp.rn")
				.setAppActivity(".MainActivity");
				// .setApp(apkPath) // Optional, Drag n Drop can also be used
				// .setNoReset(true); // Will not install app if its already present

		};break;

		}
	}
	
	
	public UiAutomator2Options getOptions(String appName){
		initOptions(appName);
		return options;
	}
}
