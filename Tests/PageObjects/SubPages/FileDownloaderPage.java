package PageObjects.SubPages;

import Common.Common.Utilities;
import Common.Constant.Constant;
import PageObjects.MainPage.HomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.time.Instant;
import java.util.List;

public class FileDownloaderPage extends HomePage {
    // Locators
    private final By txtPageTitle = By.xpath("//div[@id='content']//h3");
    private final By linkDownloadAbleFiles = By.xpath("//a[contains(@href,'download/')]");

    // Elements
    protected WebElement getTxtPageTitle() {
        return Constant.WEBDRIVER.findElement(txtPageTitle);
    }
    protected List<WebElement> getLinkDownloadAbleFiles() {
        return Constant.WEBDRIVER.findElements(linkDownloadAbleFiles);
    }

    // Methods
    public String getPageTitle() {
        return this.getTxtPageTitle().getText();
    }

    public Integer getTotalDownloadAbleFilesNumber() {
        return this.getLinkDownloadAbleFiles().size();
    }

    public String getFileDownloadName(int index) {
        String fullName = this.getLinkDownloadAbleFiles().get(index).getText();
        String[] nameArray = this.getLinkDownloadAbleFiles().get(index).getText().split("\\.");
        String extensionName = nameArray[nameArray.length - 1];
        return fullName.replace("." + extensionName, "");
    }

    public String getFileDownloadExtension(int index) {
        String[] nameArray = this.getLinkDownloadAbleFiles().get(index).getText().split("\\.");
        return nameArray[nameArray.length - 1];
    }

    public void downloadFile(int index) {
        this.getLinkDownloadAbleFiles().get(index).click();
    }

    public void waitUntilFileIsDownloaded(int timeOut) {
        boolean isDownloaded;
        long startTime = Instant.now().toEpochMilli();
        long waitTime = startTime + timeOut;
        while (Instant.now().toEpochMilli() < waitTime)
        {
            isDownloaded = Utilities.isDownloadProgressCompleted();
            if (isDownloaded)
                break;
        }
    }

}
