package helper;

import java.io.File;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;

/*
 * author: sheetal
 * https://wiki.saucelabs.com/display/DOCS/Platform+Configurator#/
 * 
 * qa.properties
 * osdevice=ANDROID_PIXEL_4_API27_APP
 */

/*
 * platformName : Android
 * platformVersion : 8.1, Emulator settings will show platform version (Edit Emulator Device)
 * 
 * appPackage: adb shell dumpsys window windows | grep mFocusedApp
 * appActivity: same as above
 * 
 * deviceName: emulator-5554, adb devices
 * appium-version : 1.22.3, Start Appium server and it will display
 * app: Can be download directly in emulators or better pass from project
 */

public enum DriverRepo_v8 {

	ANDROID_PIXEL_4_API27_APP {
		public UiAutomator2Options getUiAutomator2Options() {
			UiAutomator2Options options = new UiAutomator2Options();
			options.setDeviceName("emulator-5554")
			.setPlatformVersion("8.1")
			.setAppPackage("io.appium.android.apis")
			.setAppActivity(".ApiDemos");
			
			// ClassLoader classLoader = getClass().getClassLoader();
			// File file = new
			// File(classLoader.getResource("builds/ApiDemos-debug.apk").getFile());
			// capabilities.setCapability(MobileCapabilityType.APP, file.getAbsolutePath());

			return options;
		}
	},
	ANDROID_NEXUS_5_API24_APP {
		public UiAutomator2Options getUiAutomator2Options() {
			UiAutomator2Options options = new UiAutomator2Options();
			options.setDeviceName("emulator-5554")
			.setPlatformVersion("8.1")
			.setAppPackage("io.appium.android.apis")
			.setAppActivity(".ApiDemos");
			
			// ClassLoader classLoader = getClass().getClassLoader();
			// File file = new
			// File(classLoader.getResource("builds/ApiDemos-debug.apk").getFile());
			// capabilities.setCapability(MobileCapabilityType.APP, file.getAbsolutePath());

			return options;
		}
	};

	UiAutomator2Options options;

	DriverRepo_v8(UiAutomator2Options options) {
		this.options = options;
	}

	DriverRepo_v8() {
		// default constructor
	}

	public UiAutomator2Options getUiAutomator2Options() {
		return options;
	}

}
