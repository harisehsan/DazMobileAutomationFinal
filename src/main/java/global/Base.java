package global;

import com.sun.javafx.scene.traversal.Direction;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;
import java.time.LocalDate;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static io.appium.java_client.touch.offset.PointOption.point;
import static java.time.Duration.ofSeconds;


public class Base {

    public AppiumDriver driver;
    public WebDriver webDriver;

    public Base(AppiumDriver<WebElement> driver) {
        this.driver = driver;
    }

    public Base(WebDriver webDriver) {
        this.webDriver = webDriver;
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

    public void waitForElementToClickable(WebElement id, int sec) {
        WebDriverWait wait = new WebDriverWait(driver, sec);
        wait.until(ExpectedConditions.elementToBeClickable(id)).isEnabled();
    }

    public void waitForElementToDisAppear(By id, int time) {
        WebDriverWait wait = new WebDriverWait(driver, time);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(id));
    }

    public void waitForElementsToAppear(List<WebElement> id) {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOfAllElements(id));
    }

    public void waitForElementToAppear(By id, int sec) {
        WebDriverWait wait = new WebDriverWait(driver, sec);
        wait.until(ExpectedConditions.presenceOfElementLocated(id));
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

    public void swiptToBottom() {   // Perform little bit Down Scroll on Current Screen
//        try {
//            PointOption pointOption = new PointOption();
//            Dimension dim = driver.manage().window().getSize();
//            int height = dim.getHeight();
//            int width = dim.getWidth();
//            int x = width / 2;
//            int top_y = (int) (height * 0.80);
//            int bottom_y = (int) (height * 0.787);
//            System.out.println("These are the coordinates =======>>>>>>> :" + x + "  " + top_y + " " + bottom_y);
//            TouchAction ts = new TouchAction(driver);
//            ts.press(pointOption.withCoordinates(x, (top_y))).moveTo(pointOption.withCoordinates(x, (bottom_y))).release().perform();
//            TouchActions action = new TouchActions(driver);
////            action.scroll(744, 300);
//            action.perform();
//        } catch (Exception ex) {
//            System.out.println(ex.getMessage());
//        }
        swipeScreenSmall(Direction.UP);
    }


    public void swipeScreenSmall(Direction dir) {
        System.out.println("swipeScreenSmall(): dir: '" + dir + "'"); // always log your actions

        // Animation default time:
        //  - Android: 300 ms
        //  - iOS: 200 ms
        // final value depends on your app and could be greater
        final int ANIMATION_TIME = 200; // ms

        final int PRESS_TIME = 200; // ms

        PointOption pointOptionStart, pointOptionEnd;

        // init screen variables
        Dimension dims = driver.manage().window().getSize();

        // init start point = center of screen
//        pointOptionStart = PointOption.point(dims.width / 2, (int) (dims.height * 0.700));
        pointOptionStart = PointOption.point(dims.width / 2, dims.height / 2);

        // reduce swipe move into multiplier times comparing to swipeScreen move
        int mult = 10; // multiplie
        System.out.println(" Dimentions are here ::::::::: >>>>>>>>>>>>>>>>>>>>>> " + dims);
        System.out.println(" Actual Width is here ::::::::: >>>>>>>>>>>>>>>>>>>>>> " + dims.width);
        System.out.println(" Width after division is here ::::::::: >>>>>>>>>>>>>>>>>>>>>> " + dims.width / 2);
        System.out.println(" Actual hight is here ::::::::: >>>>>>>>>>>>>>>>>>>>>> " + dims.height);
        System.out.println(" Height after division is here ::::::::: >>>>>>>>>>>>>>>>>>>>>> " + dims.height / 2);
        System.out.println(" Pointer starts here ::::::::: >>>>>>>>>>>>>>>>>>>>>> " + (dims.width / 5));
        System.out.println(" Pointer End here ::::::::: >>>>>>>>>>>>>>>>>>>>>> " + (int) ((dims.height / 2) + (dims.height / 0.980) / mult));
        switch (dir) {
            case DOWN: // center of footer
                pointOptionEnd = PointOption.point(dims.width / 2, (int) ((dims.height / 2) + (dims.height / 0.980) / 3));
                break;
            case UP: // center of header
                pointOptionEnd = PointOption.point(dims.width / 2, (int) ((dims.height / 2) - (dims.height / 0.800) / mult));
                break;
            case LEFT: // center of left side
                pointOptionEnd = PointOption.point((dims.width / 2) - (dims.width / 2) / mult, dims.height / 2);
                break;
            case RIGHT: // center of right side
                pointOptionEnd = PointOption.point((dims.width / 2) + (dims.width / 2) / mult, dims.height / 2);
                break;
            default:
                throw new IllegalArgumentException("swipeScreenSmall(): dir: '" + dir.toString() + "' NOT supported");
        }
        // execute swipe using TouchAction
        try {
            new TouchAction(driver)

                    .press(pointOptionStart)
                    // a bit more reliable when we add small wait
                    .waitAction(WaitOptions.waitOptions(Duration.ofMillis(PRESS_TIME)))
                    .moveTo(pointOptionEnd)
                    .release().perform();
        } catch (Exception e) {
            System.err.println("swipeScreenSmall(): TouchAction FAILED\n" + e.getMessage());
            return;
        }

        // always allow swipe action to complete
        try {
            Thread.sleep(ANIMATION_TIME);
        } catch (InterruptedException e) {
            // ignore
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
        new WebDriverWait(driver, 160)
                .until(ExpectedConditions.presenceOfElementLocated(by));
    }

    protected void waitUntilAbsentOfElement(WebElement ele) {
        new WebDriverWait(driver, 30)
                .until(ExpectedConditions.invisibilityOfAllElements(ele));
    }

    protected boolean waitUntilPresentOfElementByWithoutException(By by) {
        try {
            new WebDriverWait(driver, 100)
                    .until(ExpectedConditions.presenceOfElementLocated(by));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    protected boolean waitForElementByWithoutExceptionUntillTimeReach(By element, int time) {
        try {
            new WebDriverWait(driver, time)
                    .until(ExpectedConditions.presenceOfElementLocated(element)).isDisplayed();
            return true;
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return false;
        }
    }

    public boolean isExist(List<WebElement> id) {
        return id.size() > 0;
    }

    public boolean waitWithoutException(WebElement id) {
        try {
            new WebDriverWait(driver, 60)
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
        if (Name.length() > 20)
            Name = Name.substring(0, 20);
        return driver.findElement(By.xpath("//*[contains(@contentDescription,'" + Name + "')] | //*[contains(@content-desc,'" + Name + "')]"));
    }

    protected void waitUntilPresentOfElementByString(String Name) {
        if (Name.length() > 20)
            Name = Name.substring(0, 20);
        new WebDriverWait(driver, 120)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@contentDescription,'" + Name + "')] | //*[contains(@content-desc,'" + Name + "')]")));
    }

    protected void waitUntilPresentOfElementByText(String Name) {
        new WebDriverWait(driver, 120)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text= '" + Name + "']")));
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
        return (driver.findElements(By.xpath("//*[contains(@contentDescription,'" + Name + "')] | //*[contains(@content-desc,'" + Name + "')]")).size() > 0);
    }

    protected void swipeBetweenTwoItems(WebElement ele1, WebElement ele2) {
        TouchAction touchAction = new TouchAction(driver);
        touchAction.press(new PointOption().withCoordinates(ele1.getLocation().getX(), ele1.getLocation().getY())).waitAction(new WaitOptions().withDuration(Duration.ofMillis(656))).moveTo(new PointOption().withCoordinates(ele2.getLocation().getX(), ele2.getLocation().getY())).release().perform();
    }

    protected WebElement findElementByExactString(String Name) {
        return driver.findElement(By.xpath("//*[@contentDescription='" + Name + "' or @content-desc='" + Name + "']"));
    }

    protected WebElement findElementByTextUsingExactString(String Name) {
        return driver.findElement(By.xpath("//*[@text='" + Name + "']"));
    }

    protected WebElement findElementByContentDescrpitionUsingContainString(String Name) {
        if (Name.length() > 20)
            Name = Name.substring(0, 20);
        return driver.findElement(By.xpath("//*[contains(@contentDescription,'" + Name + "')] | //*[contains(@content-desc,'" + Name + "')]"));
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
            new WebDriverWait(driver, 60)
                    .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@contentDescription,'" + Name + "')] | //*[contains(@content-desc,'" + Name + "')]")));
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    protected boolean waitWithoutExceptionByStringLessTime(String Name) {
        try {
            if (Name.length() > 25)
                Name = Name.substring(0, 25);
            new WebDriverWait(driver, 20)
                    .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@contentDescription,'" + Name + "')] | //*[contains(@content-desc,'" + Name + "')]")));
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    protected void pressEnterKey() {
        ((AndroidDriver) driver).pressKeyCode(66);
    }

    protected boolean waitWithoutExceptionWithIndex(List<WebElement> id, int index) {
        try {
            new WebDriverWait(driver, 11)
                    .until(ExpectedConditions.elementToBeClickable(id.get(index)));
            return true;
        } catch (Exception ex) {
            System.out.println("Required element is not available yet!");
            return false;
        }
    }

    protected boolean isExistByText(String Name) {
//        return (driver.findElements(By.xpath("//*[contains(@text, '')]")).size() > 0);
        return (driver.findElements(By.xpath("//*[contains(@content-desc, '" + Name + "') or contains(@text, '" + Name + "')]")).size() > 0);
    }

    protected boolean findElementsSizeByString(String Name) {
        return (driver.findElements(By.xpath("//*[contains(@contentDescription,'" + Name + "')] | //*[contains(@content-desc,'" + Name + "')]")).size() > 0);
    }

    protected boolean waitWithoutExceptionByText(String Name) {
        try {
            new WebDriverWait(driver, 50)
                    .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='" + Name + "']")));
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    //
    protected boolean containsTextIsExist(String Name) {
        if (Name.length() > 30)
            Name = Name.substring(0, 30);
        return (driver.findElements(By.xpath("//*[contains(@text,'" + Name + "')]")).size() > 0);
    }

    protected void swipeHorizontallyWithInElement(WebElement ele) {
        TouchAction touchAction = new TouchAction(driver);
        touchAction.press(new PointOption().withCoordinates(ele.getSize().width - 5, (ele.getLocation().getY() + ele.getSize().height) / 2)).waitAction(new WaitOptions().withDuration(Duration.ofMillis(656))).moveTo(new PointOption().withCoordinates(ele.getLocation().getX() + 5, (ele.getLocation().getY() + ele.getSize().height) / 2)).release().perform();
    }

    public boolean waitWithoutExceptionForElements(List<WebElement> id) {
        try {
            new WebDriverWait(driver, 100)
                    .until(ExpectedConditions.elementToBeClickable(id.get(0)));
            return true;
        } catch (Exception ex) {
            System.out.println("Required element is not available yet!");
            return true;
        }
    }

    protected boolean waitWithoutExceptionForElementsLessTime(List<WebElement> id) {
        try {
            new WebDriverWait(driver, 30)
                    .until(ExpectedConditions.elementToBeClickable(id.get(0)));
            return true;
        } catch (Exception ex) {
            System.out.println("Required element is not available yet!");
            return true;
        }
    }

    protected boolean waitForElementsLessTime(List<WebElement> id) {
        try {
            new WebDriverWait(driver, 30)
                    .until(ExpectedConditions.elementToBeClickable(id.get(0)));
            return true;
        } catch (Exception ex) {
            System.out.println("Required element is not available yet!");
            return false;
        }
    }

    protected WebElement findElementByTextUsingContainsString(String Name) {
        return driver.findElement(By.xpath("//*[contains(@text,'" + Name + "')]"));
    }

    protected boolean waitWithoutExceptionByTextContains(String Name) {
        try {
            if (Name.length() > 10)
                Name = Name.substring(0, 10);
            new WebDriverWait(driver, 160)
                    .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@text,'" + Name + "')]")));
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    protected boolean waitWithoutExceptionByTextContainsLessTime(String Name) {
        try {
            if (Name.length() > 15)
                Name = Name.substring(0, 15);
            new WebDriverWait(driver, 30)
                    .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@text,'" + Name + "')]")));
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    protected boolean isExistByCompleteString(String Name) {
        return (driver.findElements(By.xpath("//*[@contentDescription='" + Name + "' or @content-desc='" + Name + "']")).size() > 0);
    }

    protected void swipeHorizontallyToZeroWithInElement(WebElement ele) {
        TouchAction touchAction = new TouchAction(driver);
        touchAction.press(new PointOption().withCoordinates(ele.getLocation().getX(), (ele.getLocation().getY()))).waitAction(new WaitOptions().withDuration(Duration.ofMillis(656))).moveTo(new PointOption().withCoordinates(0, (ele.getLocation().getY()))).release().perform();
    }

    protected void swipeHorizontallyToZeroWithInElementbyText(String Name) {
        TouchAction touchAction = new TouchAction(driver);
        touchAction.press(new PointOption().withCoordinates(findElementByTextUsingContainsString(Name).getLocation().getX(), (findElementByTextUsingContainsString(Name).getLocation().getY()))).waitAction(new WaitOptions().withDuration(Duration.ofMillis(656))).moveTo(new PointOption().withCoordinates(0, (findElementByTextUsingContainsString(Name).getLocation().getY()))).release().perform();
    }

    protected boolean waitWithoutExceptionForElementsResult(List<WebElement> id) {
        try {
            new WebDriverWait(driver, 150)
                    .until(ExpectedConditions.elementToBeClickable(id.get(0)));
            return true;
        } catch (Exception ex) {
            System.out.println("Required element is not available yet!");
            return false;
        }
    }

    protected String[] currentDateSplit() {
        LocalDate date = LocalDate.now();
        String[] dateArray;
        dateArray = date.toString().split("-");
        return dateArray;
    }

    protected WebElement findElementByIdAndText(String id, String text) {
        return driver.findElement(By.xpath("//*[contains(@resource-id,'" + id + "') and contains(@text,'" + text + "')]"));
    }

    protected WebElement findElementByClassAndText(String className, String text) {
        return driver.findElement(By.xpath("//*[@text and @class='" + className + "' and contains(text(), '" + text + "')]"));
    }

    protected boolean isExistByIdAndText(String id, String text) {
        return driver.findElements(By.xpath("//*[@resource-id='" + id + "' and @text='" + text + "']")).size() > 0;
    }

    protected int convertToIntFromString(String text)
    {
        return (Integer.parseInt(text.replaceAll("\\D+","")));
    }
}