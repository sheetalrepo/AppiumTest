package helper;

import java.io.File;
import org.openqa.selenium.remote.DesiredCapabilities;
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


public enum DriverRepo {

	ANDROID_PIXEL_4_API27_APP {
		public DesiredCapabilities getDesiredCapabilities() {
			
			//DesiredCapabilities capabilities = DesiredCapabilities.android();
			DesiredCapabilities capabilities = new DesiredCapabilities();
			capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
			capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "8.1");
			
			capabilities.setCapability("appPackage", "io.appium.android.apis");
			capabilities.setCapability("appActivity", "io.appium.android.apis.ApiDemos");

			capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554"); 
			//capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel 4 API 27"); //Both will work
			capabilities.setCapability("appium-version", "1.22.3"); //Start Appium server and it will display
			
			ClassLoader classLoader = getClass().getClassLoader();
			File file = new File(classLoader.getResource("builds/ApiDemos-debug.apk").getFile());
			capabilities.setCapability(MobileCapabilityType.APP, file.getAbsolutePath());

			return capabilities;
		}
	},
	
	ANDROID_NEXUS_5_API24_APP {
		public DesiredCapabilities getDesiredCapabilities() {
			DesiredCapabilities capabilities = new DesiredCapabilities();
			capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
			capabilities.setCapability("appPackage", "io.appium.android.apis"); 
			capabilities.setCapability("appActivity", "io.appium.android.apis.ApiDemos");
			capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
			capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Nexus 5 API 24"); 
			capabilities.setCapability("appium-version", "1.22.3"); 
			capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "7.0"); 
			ClassLoader classLoader = getClass().getClassLoader();
			File file = new File(classLoader.getResource("builds/ApiDemos-debug.apk").getFile());
			capabilities.setCapability(MobileCapabilityType.APP, file.getAbsolutePath());
			return capabilities;
		}
	},

	
	ANDROID_NEXUS_5_API24_CHROME {
		public DesiredCapabilities getDesiredCapabilities() {
			DesiredCapabilities capabilities = new DesiredCapabilities();
			capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
			capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
			capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "chrome");
			//capabilities.setCapability("chromeOptions", ImmutableMap.of("w3c", false));
			return capabilities;
		}

	}
	
	
	;

	DesiredCapabilities capabilities;

	DriverRepo(DesiredCapabilities dc) {
		this.capabilities = dc;
	}

	DriverRepo() {
		// default constructor
	}

	public DesiredCapabilities getDesiredCapabilities() {
		return capabilities;
	}

}
