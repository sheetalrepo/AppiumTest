package demo.helper;

import java.io.File;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

public class AppServer {

	static AppiumDriverLocalService server;
	
	static void setInstance() {
		String nodeJSMainPath = "C:\\Users\\cmash\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js";
		String nodeExePath = "C:\\Program Files\\nodejs\\node.exe";
		String logFilePath = "C:\\Users\\cmash\\Documents\\Papi\\Repo\\AppiumTest\\src\\test\\resources\\logs\\log2.txt";

		AppiumServiceBuilder builder = new AppiumServiceBuilder();
		builder
			.withAppiumJS(new File(nodeJSMainPath))
			.usingDriverExecutable(new File(nodeExePath)).usingPort(4723)
			.withArgument(GeneralServerFlag.LOCAL_TIMEZONE)
			.withLogFile(new File(logFilePath))
			.withIPAddress("127.0.0.1"); // wd/hub will not come in Appium 2

		server = AppiumDriverLocalService.buildService(builder);
	}

	static AppiumDriverLocalService getInstance() {
		if (server == null) {
			setInstance();
		}
		return server;
	}

	public static void startAppiumServer() {
		getInstance().start();
		System.out.println("---------- Starting Appium Server Programmatically ----------");
		System.out.println("URL: " + server.getUrl());
		System.out.println("is Server Running: " + server.isRunning());
	}

	public static void stopAppiumServer() {
		if (server != null) {
			getInstance().stop();
		}
		System.out.println("---- Stopped Appium Server----");
	}

}
