import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Home {
    WebDriver driver;

    public Home(WebDriver driver) {
        this.driver = driver;


    }

    public WebElement routeEle() {

        return driver.findElement(By.cssSelector("a[onclick=\"populateSearch('1467469338690', 'Chikkamagaluru', '1467467616730', 'Bengaluru');\"]"));

    }

    public WebElement arrivalEle() {

        return driver.findElement(By.linkText("13"));

    }

    public WebElement searchforBusEle() {

        return driver.findElement(By.className("btn-booking"));


    }
}
