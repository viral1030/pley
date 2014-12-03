package com.pley.Init;

import java.awt.AWTException;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.logging.Logger;

import org.openqa.selenium.Platform;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.pley.Indexpage.PleySignupIndexPage;

import com.pley.Verification.verifyElement;

/**
 * Selenium class Initialization
 * 
 * 
 */

// @Listeners(ATUReportsListener.class)
public class SeleniumInit implements ILoggerStatus {

	/* Minimum requirement for test configuration */

	protected String testUrl; // Test url
	protected String seleniumHub; // Selenium hub IP
	protected String seleniumHubPort; // Selenium hub port
	protected String targetBrowser; // Target browser
	protected static String test_data_folder_path = null;
	protected static String email_init;
	protected static String email_count;
	protected static String istabverification;
	protected static String check_TC;
	protected static String invalide_validate_email;
	protected static String validate_email;
	protected static String validate_pass;

	String userName = "";
	String password = "";
	// screen-shot folder
	protected static String screenshot_folder_path = null;
	public static String currentTest; // current running test

	protected static Logger logger = Logger.getLogger("testing");

	protected WebDriver driver;

	Common common = new Common(driver);

	/* Page's declaration */
	protected PleySignupIndexPage pleySignup;

	// protected DashboardPage dashboardPage;
	// protected TestData testdata;

	// protected RegisteredPage registeredPage;
	// And many more ...

	/**
	 * Fetches suite-configuration from XML suite file.
	 * 
	 * @param testContext
	 */
	@BeforeTest(alwaysRun = true)
	public void fetchSuiteConfiguration(ITestContext testContext) {

		System.out
				.println("-------------------------------------------------------in fetch config");
		email_init = testContext.getCurrentXmlTest().getParameter("email");
		email_count = testContext.getCurrentXmlTest()
				.getParameter("emailcount");
		istabverification = testContext.getCurrentXmlTest().getParameter(
				"FC_with_tab_Verification");
		check_TC = testContext.getCurrentXmlTest().getParameter(
				"verify_FC_final_msg_on_specific_data");
		invalide_validate_email = testContext.getCurrentXmlTest().getParameter(
				"Check_invalid_emails_validation");
		validate_email = testContext.getCurrentXmlTest().getParameter(
				"Check_valid_emails");
		validate_pass = testContext.getCurrentXmlTest().getParameter(
				"invalide_password_varification");

		System.out.println("tab verification " + istabverification);

		System.out.println("email from xml in init : " + email_init);
		testUrl = testContext.getCurrentXmlTest().getParameter("selenium.url");

		System.out.println("======" + testUrl + "=========");

		seleniumHub = testContext.getCurrentXmlTest().getParameter(
				"selenium.host");

		seleniumHubPort = testContext.getCurrentXmlTest().getParameter(
				"selenium.port");

		targetBrowser = testContext.getCurrentXmlTest().getParameter(
				"selenium.browser");

	}

	// new code====

	/**
	 * WebDriver initialization
	 * 
	 * @return WebDriver object
	 * @throws IOException
	 * @throws InterruptedException
	 * @throws AWTException
	 */

	@BeforeMethod(alwaysRun = true)
	public void setUp(Method method) throws IOException, InterruptedException,
			AWTException {

		/*
		 * Runtime runtime = Runtime.getRuntime(); runtime.exec(
		 * "java -jar V:\\testing\\selenium-java-2.40.0\\selenium-2.40.0\\selenium-server-standalone-2.33.0.jar -role hub"
		 * );
		 * System.out.println("==================Server started================="
		 * ); Thread.sleep(2000);
		 * 
		 * 
		 * Runtime runtime2 = Runtime.getRuntime(); runtime2.exec(
		 * "java -jar V:\\testing\\selenium-java-2.40.0\\selenium-2.40.0\\selenium-server-standalone-2.33.0.jar -role node -port 5554"
		 * ); System.out.println(
		 * "=======================Node started====================");
		 * Thread.sleep(2000);
		 */
		currentTest = method.getName(); // get Name of current test.

		URL remote_grid = new URL("http://" + seleniumHub + ":"
				+ seleniumHubPort + "/wd/hub");

		System.out.println(remote_grid);

		String SCREENSHOT_FOLDER_NAME = "screenshots";
		String TESTDATA_FOLDER_NAME = "test_data";

		test_data_folder_path = new File(TESTDATA_FOLDER_NAME)
				.getAbsolutePath();

		screenshot_folder_path = new File(SCREENSHOT_FOLDER_NAME)
				.getAbsolutePath();

		DesiredCapabilities capability = null;
		if (targetBrowser == null || targetBrowser.contains("firefox")) {

			System.out.println("hi");
			FirefoxProfile profile = new FirefoxProfile();

			// Proxy proxy = new Proxy();
			// proxy.setNoProxy("ipms.ppadb.co.bw");

			profile.setPreference("dom.max_chrome_script_run_time", "999");
			profile.setPreference("dom.max_script_run_time", "999");
			profile.setPreference("browser.download.folderList", 2);
			profile.setPreference("browser.download.useDownloadDir", true);
			profile.setPreference("browser.download.manager.showWhenStarting",
					false);
			profile.setEnableNativeEvents(true);
			profile.setPreference("network.http.use-cache", false);
			// profile.setEnableNativeEvents(true);

			/*
			 * profile.setProxyPreferences(proxy);
			 */
			/*
			 * File file = new
			 * File("C:/Users/Viral/Downloads/firebug-1.8.4.xpi");
			 * 
			 * profile.addExtension(file);
			 * profile.setPreference("extensions.firebug.currentVersion",
			 * "1.8.4"); // Avoid startup screen
			 */

			capability = DesiredCapabilities.firefox();
			capability.setJavascriptEnabled(true);
			capability.setCapability(FirefoxDriver.PROFILE, profile);

			System.out.println("abc");
			driver = new RemoteWebDriver(remote_grid, capability);
			System.out.println("abc");
			System.out.println("=========firefox browser===========");

		} else if (targetBrowser.contains("ie8")) {

			capability = DesiredCapabilities.internetExplorer();
			capability.setPlatform(Platform.ANY);
			capability.setBrowserName("internet explorer");
			// capability.setVersion("8.0");
			capability
					.setCapability(
							InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,
							true);
			capability.setCapability(
					CapabilityType.ForSeleniumServer.ENSURING_CLEAN_SESSION,
					true);
			capability.setJavascriptEnabled(true);
		} else if (targetBrowser.contains("chrome")) {

			System.out
					.println("chrome Driver================================================");
			capability = DesiredCapabilities.chrome();
			capability.setBrowserName("chrome");
			capability.setJavascriptEnabled(true);
			capability
					.setCapability("webdriver.chrome.driver",
							"E:\\Projects\\credible\\credible\\credible\\lib\\chromedriver.exe");
			System.setProperty("webdriver.chrome.driver",
					"E:\\Projects\\credible\\credible\\credible\\lib\\chromedriver.exe");
			capability.setPlatform(Platform.ANY);
			// System.setProperty("webdriver.chrome.driver","lib/chromedriver.exe");

			// File chromedriver = new File("lib/chromedriver.exe");
			// System.out.println("Chrome Driver : "+chromedriver.getAbsolutePath());

			// chromedriver.getAbsolutePath());

			capability.setBrowserName("chrome");
			capability.setJavascriptEnabled(true);

			// driver = new ChromeDriver(capability);
			driver = new RemoteWebDriver(remote_grid, capability);
		} else if (targetBrowser.contains("ie11")) {
			capability = DesiredCapabilities.internetExplorer();
			System.setProperty("webdriver.ie.driver",
					"E:\\Testing_framework\\pley\\lib\\IEDriverServer.exe");

			capability.setBrowserName("internet explorer");

			capability
					.setCapability(
							InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,
							true);
			capability.setCapability(
					CapabilityType.ForSeleniumServer.ENSURING_CLEAN_SESSION,
					true);
			capability.setBrowserName("internet explorer");
			
			capability.setJavascriptEnabled(true);
			
			//driver=new InternetExplorerDriver(capability);
			
			driver = new RemoteWebDriver(remote_grid, capability);
		} else if (targetBrowser.contains("safari")) {

			/*File safariplugin = new File("lib/WebDriver-2.safariextz");
			System.out.println("safari driver : "
					+ safariplugin.getAbsolutePath());
			System.setProperty("webdriver.safari.driver",
					safariplugin.getAbsolutePath());*/
			// driver = new SafariDriver();
			// SafariDriver profile = new SafariDriver();
			// SafariOptions options = new SafariOptions();
			// Add an extra extension
			// options.addExtensions(new
			// File("/Ankit/Projects/credible/SafariDriver.safariextz"));

			capability = DesiredCapabilities.safari();

			capability.setBrowserName("safari");
			capability.setJavascriptEnabled(true);
			// capability.setBrowserName("safari");
			capability.setPlatform(org.openqa.selenium.Platform.ANY);
			capability.setVersion("7.0.6");
			// capability.setCapability(SafariDriver,
			// profile);
			// this.driver = new SafariDriver(capability);

		}
		//driver = new RemoteWebDriver(remote_grid, capability);

		driver.manage().window().maximize();

		driver.get(testUrl);
		/*
		 * geturlThread urlthread1 = new geturlThread(driver);
		 * urlthread1.start();
		 * 
		 * geturlThread urlthread2 = new geturlThread(driver);
		 * urlthread2.start();
		 */

		// driver.get(testUrl);

		pleySignup = new PleySignupIndexPage(driver);

		// dashboardPage = new DashboardPage(driver);
		// testdata = new TestData();
	}

	/**
	 * After Method
	 * 
	 * @param testResult
	 */
	@AfterMethod(alwaysRun = true)
	public void tearDown(ITestResult testResult) {
		try {

			String testName = testResult.getName();

			if (!testResult.isSuccess()) {

				/* Print test result to Jenkins Console */
				System.out.println();
				System.out.println("TEST FAILED - " + testName);
				System.out.println();
				System.out.println("ERROR MESSAGE: "
						+ testResult.getThrowable());
				System.out.println("\n");
				Reporter.setCurrentTestResult(testResult);

				/* Make a screenshot for test that failed */
				String screenshotName = common.getCurrentTimeStampString()
						+ testName;
				Reporter.log("<br>" + ""
						+ " <b>Please look to the screenshot - </b>");
				common.makeScreenshot(driver, screenshotName);

			} else {
				System.out.println("TEST PASSED - " + testName + "\n"); // Print
																		// test
																		// result
																		// to
																		// Jenkins
																		// Console

			}

			driver.manage().deleteAllCookies();
			driver.quit();

		} catch (Throwable throwable) {
			System.out.println("message from tear down"
					+ throwable.getMessage());
		}
	}

	/**
	 * Log given message to Reporter output.
	 * 
	 * @param msg
	 *            Message/Log to be reported.
	 */
	public static void logMessage(String msg) {
		Reporter.log(msg + "<br/>");
	}

	public static void log(String msg, final int logger_status) {

		switch (logger_status) {

		case ILoggerStatus.NORMAL:
			Reporter.log("<br>" + msg + "</br>");
			break;

		case ILoggerStatus.ITALIC:
			log("<i>" + msg + "</i>");
			break;

		case ILoggerStatus.STRONG:
			Reporter.log("<strong>" + msg + "</br>");
			break;
		}
	}

	public static void logStatus(final int test_status) {

		switch (test_status) {

		case ITestStatus.PASSED:
			log("<font color=238E23>--Passed</font>");
			break;

		case ITestStatus.FAILED:
			log("<font color=#FF0000>--Failed</font>");
			break;

		case ITestStatus.SKIPPED:
			log("<font color=#FFFF00>--Skipped</font>");
			break;

		default:
			break;
		}

	}

	/**
	 * Log given message to Reporter output.
	 * 
	 * @param msg
	 *            Message/Log to be reported.
	 */
	public static void log(String msg) {
		System.out
				.println("-----------------------------------------------typed in log"
						+ msg);
		Reporter.log(msg);
	}

}
