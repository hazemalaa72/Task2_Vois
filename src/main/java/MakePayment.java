import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MakePayment {
    WebDriver driver;

    public MakePayment(WebDriver driver) {
        this.driver = driver;


    }

    public WebElement customerDetailsEle() {

        return driver.findElement(By.cssSelector("a[href=\"#Forwardprofile\"]"));
    }
    public WebElement mobileNoEle() {

        return driver.findElement(By.cssSelector("input[name=\"mobileNo\"]"));


    }
    public WebElement emailEle() {

        return driver.findElement(By.cssSelector("input[name=\"email\"]"));
    }
    public WebElement agreeOnTermsEle() {

        return driver.findElement(By.id("termsChk"));
    }
    public WebElement chooseSeatEle() {

        return driver.findElement(By.id("Forward32"));
    }
    public WebElement makePaymentEle() {

        return driver.findElement(By.id("PgBtn"));
    }
}