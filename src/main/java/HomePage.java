import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage{

    private By customerLogin = By.xpath("/html/body/div/div/div[2]/div/div[1]/div[1]/button");
    private By bankManagerLogin = By.xpath("/html/body/div/div/div[2]/div/div[1]/div[2]/button");


    public HomePage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public void customerLoginClick () {
        getDriver().findElement(customerLogin).click();
    }

    public void bankManagerLoginClick () {
        getDriver().findElement(bankManagerLogin).click();
    }
}
