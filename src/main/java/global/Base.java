package global;

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
        WebDriverWait wait = new WebDriverWait(driver, 20);
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
            int bottom_y = (int) (height * 0.787);
//            System.out.println("These are the coordinates :" + x + "  " + top_y + " " + bottom_y);
            TouchAction ts = new TouchAction(driver);
            ts.press(pointOption.withCoordinates(x, (top_y))).moveTo(pointOption.withCoordinates(x, (bottom_y))).release().perform();
            TouchActions action = new TouchActions(driver);
//            action.scroll(744, 300);
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
        new WebDriverWait(driver, 120)
                .until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public boolean isExist(List<WebElement> id) {
        return id.size() > 0;
    }

    public boolean waitWithoutException(WebElement id) {
        try {
            new WebDriverWait(driver, 25)
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
        return driver.findElement(By.xpath("//*[@text='"+Name+"']"));
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
            new WebDriverWait(driver, 15)
                    .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@contentDescription,'" + Name + "')] | //*[contains(@content-desc,'" + Name + "')]")));
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    protected void pressEnterKey()
    {
        ((AndroidDriver)driver).pressKeyCode(66);
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
        return (driver.findElements(By.xpath("//*[@text='"+Name+"']")).size() > 0);
    }

    protected boolean findElementsSizeByString(String Name) {
        return (driver.findElements(By.xpath("//*[contains(@contentDescription,'" +Name+ "')] | //*[contains(@content-desc,'" +Name+ "')]")).size() > 0);
    }

    protected boolean waitWithoutExceptionByText(String Name) {
        try {
            new WebDriverWait(driver, 25)
                    .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='"+Name+"']")));
            return true;
        } catch (Exception ex) {
            return false;
        }
    }
//
    protected boolean containsTextIsExist(String Name) {
        if (Name.length() > 40)
            Name = Name.substring(0, 40);
        return (driver.findElements(By.xpath("//*[contains(@text,'" +Name+ "')]")).size() > 0);
    }

    protected void swipeHorizontallyWithInElement(WebElement ele) {
        TouchAction touchAction = new TouchAction(driver);
        touchAction.press(new PointOption().withCoordinates(ele.getSize().width-5, (ele.getLocation().getY()+ele.getSize().height)/2)).waitAction(new WaitOptions().withDuration(Duration.ofMillis(656))).moveTo(new PointOption().withCoordinates(ele.getLocation().getX()+5, (ele.getLocation().getY()+ele.getSize().height)/2)).release().perform();
    }
public boolean waitWithoutExceptionForElements(List <WebElement> id) {
    try {
        new WebDriverWait(driver, 25)
                .until(ExpectedConditions.elementToBeClickable(id.get(0)));
        return true;
    } catch (Exception ex) {
        System.out.println("Required element is not available yet!");
        return true;
    }
}
    protected WebElement findElementByTextUsingContainsString(String Name) {
        return driver.findElement(By.xpath("//*[contains(@text,'" +Name+ "')]"));
    }

    protected boolean waitWithoutExceptionByTextContains(String Name) {
        try {
            if (Name.length() > 10)
                Name = Name.substring(0, 10);
            new WebDriverWait(driver, 25)
                    .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@text,'" +Name+ "')]")));
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    protected boolean isExistByCompleteString(String Name) {
        return (driver.findElements(By.xpath("//*[@contentDescription='" + Name + "' or @content-desc='" + Name + "']")).size() > 0);
    }
}