import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.Executor;

public class OpenAccountPage extends BasePage {

     private By customer = By.xpath("//*[@id=\"userSelect\"]");
     private By currency = By.xpath("//*[@id=\"currency\"]");
     private By processBtn= By.xpath("/html/body/div/div/div[2]/div/div[2]/div/div/form/button");


  //   private By logoutManagerBtn = By.xpath("/html/body/div/div/div[1]/button[2]");

    public OpenAccountPage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public void processBtnClick(){
        getDriver().findElement(processBtn).click();
    }

    public void selectCustomer() {
        Select selectCustomer = new Select((WebElement) customer);
        selectCustomer.selectByValue("sandra krstic");
    }

    public void selectCurrency() {
        Select selectCurrency = new Select((WebElement) currency);
        List <WebElement> allCurrencies = selectCurrency.getOptions();
        WebElement firstSelectedOption = selectCurrency.getFirstSelectedOption();
    }

    public String getAlertText() {
        return this.getDriver().switchTo().alert().getText();
    }
}
   // public void logoutManagerBtnClick(){
     //   getDriver().findElement(logoutManagerBtn).click();

  //  }

