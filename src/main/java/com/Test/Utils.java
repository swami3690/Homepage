package com.Test;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.NoSuchElementException;
import java.util.Random;

import static java.util.concurrent.TimeUnit.SECONDS;


public class Utils<Static> extends BasePage {

    public void clickElement(By by) {

        driver.findElement(by).click();

    }

    public void enterText(By by, String text) {

        driver.findElement(by).sendKeys(text);

    }

    public String getText(By by) {
        String text = driver.findElement(by).getText();
        return text;

    }

    public void selectByVisibleText(By by, String text) {
        Select select = new Select(driver.findElement(by));
        select.selectByVisibleText(text);
    }


    public void selectByValue(By by, String value) {

        Select select = new Select(driver.findElement(by));
        select.selectByValue(value);
        select.getFirstSelectedOption();

    }

    public void selectByIndex(By by, int i) {

        WebElement mySelectElm = driver.findElement(by);
        Select mySelect = new Select(mySelectElm);
        mySelect.selectByIndex(i);

    }

    public void waitForClickable(By by, long time) {
        WebDriverWait wait = new WebDriverWait(driver, time);
        wait.until(ExpectedConditions.elementToBeClickable(by));
    }


    public void waitForElementVisible(By by, long time) {

        WebDriverWait wait = new WebDriverWait(driver, time);

        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));

    }

    public void waitForAlertPresent(long time) {

        WebDriverWait wait = new WebDriverWait(driver, time);

        wait.until(ExpectedConditions.alertIsPresent());


    }


    public void fluentWait() {
        Wait wait = new FluentWait(driver)
                .withTimeout(30, SECONDS)
                .pollingEvery(5, SECONDS)

                .ignoring(NoSuchElementException.class);
    }

    //Random email generator
    public String generateEmail(String startValue) {

        String email = startValue.concat(new Date().toString());
        return email;

    }

    //Random Date generator
    public static String randomDate() {
        DateFormat format = new SimpleDateFormat("ddmmyyHummss");
        return format.format(new Date());

    }

    //To get Attribute
    public static String getAttributeValue(By by, String text) {
        return driver.findElement(by).getAttribute(text);
    }

    //To get Css Value
    public static String getCssValue(By by, String value) {
        return driver.findElement(by).getCssValue(value);
    }

    // To wait
    public static void sleep(final long millis, By by) {
        System.out.println((String.format("sleeping %d ms", millis)));
        try {
            Thread.sleep(millis);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }

    // To extract text from element
    public String extractText(By by) {
        String text = driver.findElement(by).getText();
        return text;
    }


    public void randgenerate() {

        Random randomGenerator = new Random();
        int randomInt = randomGenerator.nextInt(1000);
    }

public static void Utils(WebDriver webdrive, String filewithpath, File srcFile)throws Exception{
        //conver web driver object to Takescreenshot

        TakesScreenshot screenshot = ((TakesScreenshot )webdrive);
        // call getscreenshort as method to create image file

        File SrcFile = screenshot.getScreenshotAs(OutputType.FILE);
        //move image file to new destination
        File DestiFile = new File(filewithpath);
        //copy file at destination

     FileUtils.registerNatives(srcFile ,DestiFile);


    }


       private static class FileUtils {
        public static void registerNatives(File srcFile, File destiFile) {
        }
    }
}




















