import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CustomerLoginPage extends BasePage {

    private By yourName = By.id("userSelect");
    private By loginBtn = By.xpath("/html/body/div/div/div[2]/div/form/button");

    public CustomerLoginPage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public void loginBtnClick() {
        getDriver().findElement(loginBtn).click();
    }

    public void selectYourName() {
        Select selectYourName=new Select((WebElement) yourName);
        selectYourName.getFirstSelectedOption();
    }

}
