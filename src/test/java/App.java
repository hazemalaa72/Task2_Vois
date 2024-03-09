import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class App {
    public static void main(String[] args) {}
    WebDriver driver =null;
    Home home;
    Seats seats;
    MakePayment makePayment;
    JavascriptExecutor js;
    SoftAssert soft;
    @BeforeTest
    public void OpenBrowser() throws InterruptedException {

        System.setProperty("webdriver.chrome.driver","C:\\Users\\Hazem Alaa Mostafa\\IdeaProjects\\Task1\\src\\Browsers\\chromedriver.exe");
        driver =new ChromeDriver();
        driver.navigate().to("https://www.ksrtc.in/oprs-web/#");
        driver.manage().window().maximize();
        home =new Home(driver);
        seats=new Seats(driver);
        makePayment=new MakePayment(driver);
        js = (JavascriptExecutor) driver;
        soft=new SoftAssert();
    }
    @Test
    public void ValidTask2() throws InterruptedException {
        Thread.sleep(6000);
        home.routeEle().click();
        home.arrivalEle().click();
        home.searchforBusEle().click();
        seats.selectSeatEle().click();
        Thread.sleep(5000);
        js.executeScript("arguments[0].scrollIntoView();", makePayment.customerDetailsEle());
        makePayment.customerDetailsEle().click();
        Thread.sleep(5000);
        makePayment.mobileNoEle().sendKeys("6789125987");
        makePayment.emailEle().sendKeys("hazemalaa@gmail.com");
        makePayment.chooseSeatEle().click();
        makePayment.nameEle().sendKeys("Hazem");
        makePayment.ageEle().sendKeys("24");
        Select drpGender = new Select(makePayment.genderEle());
        Select drpConcession = new Select(makePayment.concessionEle());
        drpGender.selectByVisibleText("MALE");
        drpConcession.selectByVisibleText("GENERAL PUBLIC");
        makePayment.agreeOnTermsEle().click();
        makePayment.makePaymentEle().click();
        String actualvalue="https://www.ksrtc.in/oprs-web/avail/services.do";
        String expectedvalue=driver.getCurrentUrl();
        soft.assertEquals(actualvalue,expectedvalue,"Valid Task Assertion");





    }
    @Test
    public void InValidTask2() throws InterruptedException {
        Thread.sleep(6000);
        home.routeEle().click();
        home.arrivalEle().click();
        home.searchforBusEle().click();
        seats.selectSeatEle().click();
        makePayment.customerDetailsEle().click();
        Thread.sleep(5000);
        makePayment.mobileNoEle().sendKeys("6789125987");
        makePayment.emailEle().sendKeys("hazemalaa@gmail.com");
        makePayment.chooseSeatEle().click();
        makePayment.agreeOnTermsEle().click();
        makePayment.makePaymentEle().click();




    }
    @AfterTest
    public void CloseBrowser() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();

    }
}
