package PageObjects.MainPage;

import Common.Constant.Constant;
import PageObjects.SubPages.FileDownloaderPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class HomePage {
    // Locators
    private final By linkFileDownload = By.xpath("//li/a[text()='File Download']");

    // Elements
    protected WebElement getLinkFileDownload() {
        return Constant.WEBDRIVER.findElement(linkFileDownload);
    }

    // Methods
    public HomePage open() {
        Constant.WEBDRIVER.navigate().to(Constant.THE_INTERNET_URL);
        return this;
    }

    public FileDownloaderPage navigateToFileDownloadPage() {
        this.getLinkFileDownload().click();

        return new FileDownloaderPage();
    }
}
