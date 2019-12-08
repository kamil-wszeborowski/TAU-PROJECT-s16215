package pl.edu.pjatk.tau.labfive.selenium_digital_toys_inc;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.fail;

public class WholeProcessOnWebTest {

    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    @Before
    public void setUp() throws Exception {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("window-size=1920,1080"); //"window-size=800,480"
        DesiredCapabilities cap = DesiredCapabilities.chrome();
        cap.setCapability(ChromeOptions.CAPABILITY, options);

        driver = new ChromeDriver(cap);
        baseUrl = "https://www.katalon.com/";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void testValidationOfForm() throws Exception {
        driver.get("http://localhost:8080/");
        driver.findElement(By.linkText("Sign Up")).click();
        driver.findElement(By.name("fullName")).click();
        driver.findElement(By.name("fullName")).clear();
        driver.findElement(By.name("fullName")).sendKeys("Kamil Wszeborowski");
        driver.findElement(By.name("email")).clear();
        driver.findElement(By.name("email")).sendKeys("kwszeborowski@wp.pl");
        driver.findElement(By.name("password")).clear();
        driver.findElement(By.name("password")).sendKeys("12345678QWE");
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='The password is required and cannot be empty.'])[1]/following::button[1]")).click();
        driver.findElement(By.linkText("Details")).click();
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='$ 125.95'])[1]/following::button[1]")).click();
        driver.findElement(By.linkText("Continue Shopping")).click();
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='$ 125.95'])[2]/following::a[1]")).click();
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='$ 125.95'])[1]/following::button[1]")).click();
        driver.findElement(By.linkText("Checkout")).click();
        driver.findElement(By.id("line1")).click();
        driver.findElement(By.id("line1")).clear();
        driver.findElement(By.id("line1")).sendKeys("Muchowskiego 4/3");
        driver.findElement(By.id("city")).click();
        driver.findElement(By.id("city")).clear();
        driver.findElement(By.id("city")).sendKeys("Gdynia");
        driver.findElement(By.id("state")).click();
        new Select(driver.findElement(By.id("state"))).selectByVisibleText("California");
        driver.findElement(By.id("state")).click();
        driver.findElement(By.id("zip")).click();
        driver.findElement(By.id("zip")).clear();
        driver.findElement(By.id("zip")).sendKeys("111111");
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Your zip is required.'])[1]/following::button[1]")).click();
        driver.findElement(By.id("nameOnCard")).click();
        driver.findElement(By.id("nameOnCard")).clear();
        driver.findElement(By.id("nameOnCard")).sendKeys("Master Card");
        driver.findElement(By.id("cardNumber")).clear();
        driver.findElement(By.id("cardNumber")).sendKeys("2345 1234 1234 1234");
        driver.findElement(By.id("expirationMonthYear")).clear();
        driver.findElement(By.id("expirationMonthYear")).sendKeys("23/1999");
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Credit Card Number'])[1]/following::button[1]")).click();
        driver.findElement(By.linkText("Place Order")).click();
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }

    private boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    private boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    private String closeAlertAndGetItsText() {
        try {
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            if (acceptNextAlert) {
                alert.accept();
            } else {
                alert.dismiss();
            }
            return alertText;
        } finally {
            acceptNextAlert = true;
        }
    }
}

