package com.Test;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import static java.lang.Double.parseDouble;
import static java.lang.Thread.sleep;
import static org.testng.Assert.assertTrue;

public class HomePage extends Utils {

    LoadProp props = new LoadProp();
    public void enterText(By by, String text) {

        driver.findElement(by).sendKeys(text);

    }

    @BeforeMethod

    public void OpenBrowser() {


        System.setProperty("webdriver.chrome.driver", "src\\main\\java\\Resources\\BrowserDriver\\chromedriver.exe");

        // open the browser
        driver = new ChromeDriver();
        // maximise the briwser window screen
        driver.manage().window().fullscreen();
        //set implicity wait for driver object
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        //driver.get("https://demo.nopcommerce.com/");
        driver.get(props.getProperty("url"));


    }

    @AfterMethod
    public void closeBrowser() {
        driver.quit();
    }

    @org.testng.annotations.Test

    public void registerSuccessfully() throws InterruptedException {

        //click on register button
        clickElement(By.xpath("//a[@class='ico-register']"));
        //enter first name
        enterText(By.id("FirstName"), props.getProperty("Firstname"));
        //enter lastname
        enterText(By.xpath("// input[@name= 'LastName']"), props.getProperty("Lastname"));

        //Dropdown

        selectByVisibleText(By.name("DateOfBirthDay"), props.getProperty("Day"));

        //Month drop box select
        selectByValue(By.name("DateOfBirthMonth"), props.getProperty("Month"));

        //Birth year drop box select
        selectByIndex(By.name("DateOfBirthYear"), Integer.parseInt(props.getProperty("i")));

        //enter email
        Random randomGenerator = new Random();
        int randomInt = randomGenerator.nextInt(100000);
        //email random
        enterText(By.name("Email"), "testtest" + randomInt + "@gmail.com");
        //password random
        enterText(By.xpath("//input[@id=\"Password\"]"),props.getProperty("password"));
        enterText(By.xpath("//input[@id=\"ConfirmPassword\"]"),props.getProperty("cpassword"));

        // get Ragister
        clickElement(By.xpath("//input[@value= \"Register\" ]"));
        getText(By.xpath("//div[@class=\"result\" ]"));

    }

    @org.testng.annotations.Test

    public void userShouldBeEmailToAFriend() {

// o
        //click on login
        clickElement(By.xpath("//a[@class=\"ico-login\"]"));
        // enter email
        enterText(By.name("Email"), "testtest1@test.com");
        //password
        enterText(By.xpath("//input[@id=\"Password\"]"), "abcd1234");

        clickElement(By.xpath("//input[@class=\"button-1 login-button\"]"));

        //click on mac product
        clickElement(By.linkText("Apple MacBook Pro 13-inch"));
        //Email to friend
        clickElement(By.xpath("//div[@ class=\"email-a-friend\" ]"));
        //Enter a friend email
        enterText(By.id(("FriendEmail")), "arpi.shah09@gmial.com");
        //enter a personal email
        enterText((By.xpath("//textarea[@id=\"PersonalMessage\" ]")), "Good deal I think please have a  look");
        clickElement(By.xpath("//input [@ value=\"Send email\" ]"));


    }

    @org.testng.annotations.Test

    public void electronic() {


        // click on Electronics
        clickElement(By.linkText("Electronics"));
        // Click in Camera&photo in Electonics drop box
        clickElement(By.linkText("Camera & photo"));
    }

    @org.testng.annotations.Test

    public void useShouldBeAbleToClickOnJewelry () throws InterruptedException {
        // click on Jewelry
        clickElement(By.linkText("Jewelry"));
        //select jwelry 7000-30000
        clickElement(By.xpath("//a[contains(@href,'700-3000')]"));
        // get expected result and actual result
        String actualM2 = driver.findElement(By.xpath("//span[@class=\"price actual-price\"]")).getText();
        String expectedM2 = "$700.00 - $3,000.00";
        String s[] = expectedM2.split("-");
        String s4 = s[1].replaceAll(" ", "").replace("$", "").replace(",", "");
        String s3 = s[0].replace("$", "");
        //Convert String to Double
        //Converting Actual value to double
        double A2 = parseDouble(actualM2.replace("$", "").replace(",", ""));
        assertTrue(A2 > 700 && A2 < 3000);
    }

    @Test

    public void userShouldBeAbleToAddBooksToTheCartSuccessfully () throws InterruptedException {
        //Click in book
        clickElement(By.linkText("Books"));
        clickElement(By.xpath("//input[@type=\"button\" and contains(@onclick, '37/1/1') ]"));
        //sleep(2000);
        clickElement(By.xpath("//input[@type=\"button\" and contains(@onclick, '38/1') ]"));
        //sleep(7000);
        clickElement(By.className("cart-label"));
        // actual is should expected
        String actual = driver.findElement(By.xpath("//span[@class =\"sku-number\" and contains( text(),\"FR_451_RB\")] ")).getText();
        String expected = "FR_451_RB";

        Assert.assertArrayEquals(new String[]{actual}, new String[]{expected});

        String actual1 = driver.findElement(By.xpath("//span[@class =\"sku-number\" and contains( text(),\"FIRST_PRP\")] ")).getText();
        String expected1 = "FIRST_PRP";

        Assert.assertArrayEquals(new String[]{actual1}, new String[]{expected1});




    }
















}