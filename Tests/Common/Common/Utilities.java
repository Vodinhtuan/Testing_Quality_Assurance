package Common.Common;

import Common.Constant.Constant;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;

import java.io.File;
import java.util.List;
import java.util.Random;

@Slf4j
public class Utilities {
    public static String getProjectPath() {
        return System.getProperty("user.dir");
    }

    public static int getRandomNumberInRange(int min, int max) {
        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }

    public static LogEntry getLogFromTrafficLog(String searchString) {
        List<LogEntry> logs = Constant.WEBDRIVER.manage().logs().get(LogType.PERFORMANCE).getAll();
        LogEntry log = null;
        for (int i = logs.size() - 1; i >= 0; i--) {
            try {
                String msg = logs.get(i).getMessage();
                if (msg.contains(searchString)) {
                    log = logs.get(i);
                    break;
                }
            } catch (Exception e) {
                // ignore exception
            }
        }
        return log;
    }

    public static boolean isDownloadProgressCompleted() {
        log.info("waitForFileToBeDownloaded");
        boolean isCompleted = false;
        try {
            LogEntry log = getLogFromTrafficLog("Page.downloadProgress");
            GsonBuilder builder = new GsonBuilder();
            JsonObject message = builder.create().fromJson(log.getMessage(), JsonObject.class);
            JsonObject params = message.getAsJsonObject("message").getAsJsonObject("params");
            String downloadState = params.get("state").getAsString();
            isCompleted = downloadState.equals("completed");
        } catch (Exception ignored) {}

        return isCompleted;
    }

    public static boolean isFileDownloaded(String folderName, String expectedFileName, String fileExtension) {
        File[] listOfFiles;
        String fileName;
        boolean fileDownloaded = false;
        listOfFiles = new File(folderName).listFiles();
        if (listOfFiles != null) {
            for (File file : listOfFiles)
            {
                fileName = file.getName().toLowerCase();

                // condition 1 - till the time file is completely downloaded extension will be crdownload
                // Condition 2 - Current File name contains expected Text
                // Condition 3 - Current File name contains expected extension
                if (!fileName.contains("crdownload") &&   fileName.contains(expectedFileName.toLowerCase()) && fileName.contains(fileExtension.toLowerCase()))
                {
                    fileDownloaded = true;
                    file.delete();
                    break;
                }
            }
        }

        // File Not Found
        return fileDownloaded;
    }

}
