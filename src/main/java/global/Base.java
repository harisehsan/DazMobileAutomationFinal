package global;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;
import java.util.List;
import java.util.Random;
import java.util.Set;

import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static io.appium.java_client.touch.offset.PointOption.point;
import static java.time.Duration.ofSeconds;


public class Base {

    public AppiumDriver driver;

    public Base(AppiumDriver<WebElement> driver) {
        this.driver = driver;
    }

    public boolean isAndroid() {
        return driver instanceof AndroidDriver;
    }


//    public boolean isIOS() {
//        return driver instanceof IOSDriver;
//    }

    public void hideKeyboard() {

        if (isAndroid()) {
            driver.hideKeyboard();
//        } else if (isIOS()){
//            IOSDriver iosDriver = (IOSDriver) driver;
//            iosDriver.hideKeyboard(HideKeyboardStrategy.PRESS_KEY, "Done");
        }
    }

    public void waitForPageToLoad(WebElement id) {
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.elementToBeClickable(id));
    }

    public void waitForElementToClickable(WebElement id) {
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.elementToBeClickable(id));
    }

    public void waitForElementToDisAppear(String id) {
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id(id)));
    }

    public void waitForElementsToAppear(List<WebElement> id) {
        WebDriverWait wait = new WebDriverWait(driver, 11);
        wait.until(ExpectedConditions.visibilityOfAllElements(id));
    }

    public WebElement waitForElement(WebElement arg) {
        waitForPageToLoad(arg);
        WebElement el = arg;
        return el;
    }

    public boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }

    }

    public void swipeLeftUntilTextExists(String expected) {
        do {
            swipeLeft();
        } while (!driver.getPageSource().contains(expected));
    }

    public void swipeRight() {
        Dimension size = driver.manage().window().getSize();
        int startx = (int) (size.width * 0.9);
        int endx = (int) (size.width * 0.20);
        int starty = size.height / 2;
        new TouchAction(driver).press(point(startx, starty))
                .waitAction(waitOptions(ofSeconds(2)))
                .moveTo(point(endx, starty)).release().perform();
    }

    public void swipeLeft() {
        Dimension size = driver.manage().window().getSize();
        int startx = (int) (size.width * 0.8);
        int endx = (int) (size.width * 0.20);
        int starty = size.height / 2;
        new TouchAction(driver).press(point(startx, starty))
                .waitAction(waitOptions(ofSeconds(2)))
                .moveTo(point(endx, starty)).release();
    }

    public void swiptToBottom() {
        try {
            PointOption pointOption = new PointOption();
            Dimension dim = driver.manage().window().getSize();
            int height = dim.getHeight();
            int width = dim.getWidth();
            int x = width / 2;
            int top_y = (int) (height * 0.80);
            int bottom_y = (int) (height * 0.20);
            System.out.println("coordinates :" + x + "  " + top_y + " " + bottom_y);
            TouchAction ts = new TouchAction(driver);
            ts.press(pointOption.withCoordinates(x, top_y)).moveTo(pointOption.withCoordinates(x, bottom_y)).release().perform();
            TouchActions action = new TouchActions(driver);
            action.scroll(744, 1968);
            action.perform();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    /**
     * method to set the context to required view.
     *
     * @param context view to be set
     */
    public void setContext(String context) {
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Set<String> contextNames = driver.getContextHandles();
        for (String contextName : contextNames) {
            System.out.println(contextName); //prints out something like NATIVE_APP \n WEBVIEW_1
        }
        driver.context((String) contextNames.toArray()[1]); // set context to WEBVIEW_1

        //logger.info("Current context" + driver.getContext());
    }

    public void clickBackButton() {
        driver.navigate().back(); //Closes keyboard
//        driver.navigate().back(); //Comes out of edit mode
    }

    protected void waitUntilPresentOfElementBy(By by) {
        new WebDriverWait(driver, 30)
                .until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public boolean isExist(List<WebElement> id) {
        return id.size() > 0;
    }

    public boolean waitWithoutException(WebElement id) {
        try {
            new WebDriverWait(driver, 10)
                    .until(ExpectedConditions.elementToBeClickable(id));
            return true;
        } catch (Exception ex) {
            System.out.println("Required element is not available yet!");
            return false;
        }
    }

    protected int randomNumberGenerator(int bound) {
        Random rand = new Random();
        return rand.nextInt(bound);
    }

    protected void clickMultipleTries(List<WebElement> ele, int tries) {
        int i = 0;
        while (isExist(ele) && i < tries) {
            try {
                ele.get(0).click();
                i++;
            } catch (Exception ex) {
                System.out.println("Exception: " + ex.getMessage());
            }
        }
    }

    protected void scrollDownMultipleTries(int tries) {
        int i = 0;
        while (i < tries) {
            try {
                swiptToBottom();
                i++;
            } catch (Exception ex) {
                System.out.println("Exception: " + ex.getMessage());
                break;
            }
        }
    }

    protected WebElement findElementByString(String Name) {
        if (Name.length() > 25)
            Name = Name.substring(0, 25);
        return driver.findElement(By.xpath("//*[contains(@contentDescription,'" + Name + "')]"));
    }

    protected void waitUntilPresentOfElementByString(String Name) {
        if (Name.length() > 25)
            Name = Name.substring(0, 25);
        new WebDriverWait(driver, 50)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@contentDescription,'" + Name + "')]")));
    }

    protected String getTextWithoutException(WebElement ele) {
        try {
            return ele.getText();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return "";
        }
    }

    protected boolean isExistByString(String Name) {
        if (Name.length() > 20)
            Name = Name.substring(0, 20);
        return (driver.findElements(By.xpath("//*[contains(@contentDescription,'" + Name + "')]")).size() > 0);
    }

    protected void cartItemSwipeOptions() {
        TouchAction touchAction = new TouchAction(driver);
        touchAction.press(new PointOption().withCoordinates(722, 629)).waitAction(new WaitOptions().withDuration(Duration.ofMillis(656))).moveTo(new PointOption().withCoordinates(-200, 637)).release().perform();
    }

    protected WebElement findElementByExactString(String Name) {
        if (Name.length() > 20)
            Name = Name.substring(0, 20);
        return driver.findElement(By.xpath("//*[@contentDescription='" + Name + "']"));
    }

    protected void clickElementMultipleTriesUsingString(String Name, int tries) {
        for (int i = 0; i < tries; i++) {
            try {
                driver.findElement(By.xpath("//*[@contentDescription='" + Name + "' or @content-desc='" + Name + "']")).click();
            } catch (Exception ex) {
                continue;
            }
        }
    }

    protected boolean waitWithoutExceptionByString(String Name) {
        try {
            if (Name.length() > 25)
                Name = Name.substring(0, 25);
            new WebDriverWait(driver, 10)
                    .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@contentDescription,'" + Name + "')]")));
            return true;
        } catch (Exception ex) {
            return false;
        }
    }
}
