package global.APP.getProperty;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class ScreenshotGetProperty {
    private Properties prop = new Properties();
    private final String filePath = "src\\test\\java\\global\\APP\\properties\\Screenshot.property";

    private void fileInputStream() throws IOException {
        prop.load(new FileInputStream(filePath));
    }

    private void fileOutputStream() throws IOException {
        prop.store(new FileOutputStream(filePath),null);
    }

    public int getScreenshotCount() throws IOException {
        fileInputStream();
        return Integer.parseInt(prop.getProperty("SCREENSHOT_COUNT"));
    }

    public void setScreenShotCount(String count) throws IOException {
        fileInputStream();
        prop.setProperty("SCREENSHOT_COUNT", count);
        fileOutputStream();
    }


    public String getUdid() throws IOException {
        fileInputStream();
        return prop.getProperty("UDID");
    }

    public void setUdid(String udid) throws IOException {
        fileInputStream();
        prop.setProperty("UDID", udid);
        fileOutputStream();
    }


}
