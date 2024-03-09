import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Seats {
    WebDriver driver;

    public Seats(WebDriver driver) {
        this.driver = driver;


    }
    public WebElement selectSeatEle() {

        return driver.findElement(By.cssSelector("div[class=\"select-service\"]>input[id=\"SrvcSelectBtnForward0\"]"));


    }
}
