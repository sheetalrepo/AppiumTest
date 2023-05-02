
#Appium Installation Part

1. Install Java Maven
2. Install Appium
   Download zip file https://github.com/appium/appium-desktop/releases/tag/v1.22.3-4
   Unzip into Appium-Desktop folder 
   Create shortcut and open AppiumServerGUI
3. Install latest Android Studio via exe file https://developer.android.com/studio
   Give default values and click Next....sample MyApplication project will be created 
   
4. Download Appium Inspector zip file from https://github.com/appium/appium-inspector/releases
   Unzip into Appium-Inspector folder and create shortcut and open Appium Inspector
   
5. Env variable setup   
   ANDROID_HOME = C:\Users\cmash\AppData\Local\Android\Sdk           (AppData is hidden folder)
   
   Directly add into path:
   C:\Users\cmash\AppData\Local\Android\Sdk\build-tools
   C:\Users\cmash\AppData\Local\Android\Sdk\platform-tools
   C:\Users\cmash\AppData\Local\Android\Sdk\tools
   C:\Users\cmash\AppData\Local\Android\Sdk\platforms
 
6. Verify Setup
    java -version
    mvn -version
    adb devices or adb
    
7. Create Mobile Device
   Open Android Studio Workspace
   Go to > C:\Program Files\Android\Android Studio\bin
   Double click studio.sh window batch file
   Create studio.sh shortcut
   
   Go to Device Manager (top right)
   Select any device and create.... API number suggest Android version
   
8. Launch Emulator from created list
   "adb devices" command shd show newly started device
   		$ adb devices
		List of devices attached
		emulator-5554   device
   
   
9. Download sample apk file from Emulator Chrome and install it in mobile
   You may need to login into Google/Git repo and once file get downloaded it will ask for installation 
   URL: https://github.com/appium-boneyard/sample-code/blob/master/sample-code/apps/ApiDemos/bin/ApiDemos-debug.apk


10. How to set DesiredCapabilities properly
Open apk in Emulator and run following commands (both will give same results)
adb shell dumpsys window windows | grep mFocusedApp
adb shell dumpsys window windows | find "mFocusedApp"
mFocusedApp=AppWindowToken{83ca8c4 token=Token{886bb56 ActivityRecord{cbd8171 u0 io.appium.android.apis/.ApiDemos t17}}}
io.appium.android.apis
io.appium.android.apis.ApiDemos

To fetch platformVersion capabilities
adb shell getprop ro.build.version.release


11. Setup Appium Inspector
Remote Host = 127.0.0.1
Remote Port = 4723
Remote Path = /wd/hub

JSON:

{
  "platformName": "Android",
  "platformVersion": "8.1",
  "appPackage": "io.appium.android.apis",
  "appActivity": "io.appium.android.apis.ApiDemos",
  "deviceName": "emulator-5554"
}
   
   

12. Setup NodeJS
Require to start Appium from code other wise we can also use Appium server manually in local machine
https://nodejs.org/en/download   
Download exe and check checkbox "install all necessary tools"
C:\Program Files\nodejs\
node -v
v18.16.0








#Demo Topics:
1. Different Locators - ID, Xpath, Class Name etc
2. Tap

https://applitools.com/blog/whats-new-appium-java-client-8/

#Changes in Java-cleint 8
Java client suppport Selenium 4 and strictly compliant to W3C 
Duration class handles all time related things
1. MobileElement has been removed
2. DesiredCapability removed and now we have UiAutomator2Options 
3. "java-client" dependency already have "selenium-java".
   Just we need ti add "selenium-support" for ExpectedCondition and WebDriverWait
4. TouchActions Deprecated....Action introduced
5. MobileBy replaced with AppiumBy
6. LaunchApp, CloseApp, ResetApp Depricated










   
  
  
     