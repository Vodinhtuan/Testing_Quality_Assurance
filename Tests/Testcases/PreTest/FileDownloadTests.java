package Testcases.PreTest;

import Common.Common.Utilities;
import Common.Constant.Constant;
import PageObjects.MainPage.HomePage;
import PageObjects.SubPages.FileDownloaderPage;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.logging.Level;

public class FileDownloadTests {

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("Pre-condition");

        // Initialize Chrome Driver (assuming you want to use FireFox, it will initialize FireFox Driver)
        System.setProperty("webdriver.chrome.driver", Constant.CHROME_DRIVER_LOCATION);

        HashMap<String, Object> chromePrefs = new HashMap<>();
        // Move the default folder of the download to your folder
        chromePrefs.put("download.default_directory", Constant.DOWNLOAD_LOCATION);
         /* When you click to download a file, a popup will usually appear on the screen asking where you want to save that file.
         when set to false, it won't ask anymore */
        chromePrefs.put("download.prompt_for_download", false);
         /* Sometimes when downloading unsafe files, the OS will ask if you want to keep this file or not...,
         All such cases will normally break the automation testing process, so this command is used to turn off the above message.*/
        chromePrefs.put("safebrowsing.enabled", true);
        // Similar to the options above, they are all messages in the chrome option.
        chromePrefs.put("profile.default_content_settings.popups", 0);

        // Enable Development mode to see data
        LoggingPreferences logPrefs = new LoggingPreferences();
        logPrefs.enable(LogType.PERFORMANCE, Level.ALL);

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.setExperimentalOption("prefs", chromePrefs);
        options.setCapability("goog:loggingPrefs", logPrefs);

        Constant.WEBDRIVER = new ChromeDriver(options);
        Constant.WEBDRIVER.manage().window().maximize();
    }

    @AfterMethod
    public void afterMethod() {
        /* The rule in automation testing when creating something, it must be deleted to avoid memory overflow,
         turn off the website after the test is over */
        System.out.println("Post-condition");
        Constant.WEBDRIVER.quit();
    }

    @Test
    public void TC01() {
        System.out.println("TC01 - Verify that user is able to navigate to File Downloader page");
        HomePage homePage = new HomePage();
        homePage.open();

        FileDownloaderPage fileDownloaderPage = homePage.navigateToFileDownloadPage();

        String actualPageTitle = fileDownloaderPage.getPageTitle();
        String expectedPageTitle = "File Downloader";

        Assert.assertEquals(actualPageTitle, expectedPageTitle, "Page Title should display as expected");
    }

    @Test
    public void TC02() {
        System.out.println("TC02 - Verify that total download-able files are 25");
        HomePage homePage = new HomePage();
        homePage.open();

        FileDownloaderPage fileDownloaderPage = homePage.navigateToFileDownloadPage();

        Integer actualNumber = fileDownloaderPage.getTotalDownloadAbleFilesNumber();
        Integer expectedNumber = 25;    // There can only be a maximum of 25 download links on the page

        Assert.assertEquals(actualNumber, expectedNumber, "Total download-able files should be 25");
    }

    @Test
    public void TC03() {
        System.out.println("TC03 - Verify that the file has been downloaded successfully with correct file name.");
        HomePage homePage = new HomePage();
        homePage.open();

        FileDownloaderPage fileDownloaderPage = homePage.navigateToFileDownloadPage();

        // Get the number of downloadable files and assign it to a variable
        Integer totalDownloadAbleFilesNumber = fileDownloaderPage.getTotalDownloadAbleFilesNumber();

        /* Take a random number between 1 and totalDownloadAbleFilesNumber (number of downloadable files) and
         assign it to the randomIndex variable.*/
        int randomIndex = Utilities.getRandomNumberInRange(1, totalDownloadAbleFilesNumber);

        /* Get the file extension at randomIndex from the fileDownloaderPage page and assign it
        to the fileDownloadExtension variable.*/
        String fileDownloadName = fileDownloaderPage.getFileDownloadName(randomIndex);
        String fileDownloadExtension = fileDownloaderPage.getFileDownloadExtension(randomIndex);

        // Download the file at randomIndex from the fileDownloaderPage page.
        fileDownloaderPage.downloadFile(randomIndex);

        // Wait until the file is downloaded within 10,000 milliseconds (10 seconds). or you can change the time that you want
        fileDownloaderPage.waitUntilFileIsDownloaded(10000);

        /* Use the isFileDownloaded method from the Utilities class to check if the file was downloaded successfully.
         If the download is successful, the assertTrue method of the Assert class will confirm this.*/
        Assert.assertTrue(Utilities.isFileDownloaded(Constant.DOWNLOAD_LOCATION, fileDownloadName, fileDownloadExtension));
    }
}
