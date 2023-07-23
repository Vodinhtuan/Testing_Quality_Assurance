package Common.Constant;

import Common.Common.Utilities;
import org.openqa.selenium.WebDriver;

public class Constant {
    public static WebDriver WEBDRIVER;
    public static final String THE_INTERNET_URL = "https://the-internet.herokuapp.com/";
    // Set the path for the download folder on your computer
    public static final String DOWNLOAD_LOCATION = Utilities.getProjectPath() + "\\Downloads";
    public static final String CHROME_DRIVER_LOCATION = Utilities.getProjectPath() + "\\Executables\\chromedriver_v114.exe";
}
