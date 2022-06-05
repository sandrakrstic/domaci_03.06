import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CustomerAcountPage extends BasePage{

    private By depositBtn = By.xpath("/html/body/div/div/div[2]/div/div[3]/button[2]");
    private By withdrawlBtn = By.xpath("/html/body/div/div/div[2]/div/div[3]/button[3]");
    private By logoutBtn = By.xpath("/html/body/div/div/div[1]/button[2]");
    private By submitDepositBtn = By.xpath("/html/body/div/div/div[2]/div/div[4]/div/form/button");
    private By amountToBeDeposit = By.xpath("/html/body/div/div/div[2]/div/div[4]/div/form/div/input");
    private By amountToBeWithdrawl = By.xpath("/html/body/div/div/div[2]/div/div[4]/div/form/div/input");
    private By submitWithdrawlBtn = By.xpath("/html/body/div/div/div[2]/div/div[4]/div/form/button");
    private By depositSuccessfulMessage = By.xpath("/html/body/div/div/div[2]/div/div[4]/div/span");
    private By transactionSuccessfulMessage = By.xpath("/html/body/div/div/div[2]/div/div[4]/div/span");

    public CustomerAcountPage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public void enterLogoutBtn (){
        getDriver().findElement(logoutBtn).click();
    }

    public void enterDeposit(){
        getDriver().findElement(depositBtn).click();
        getDriver().findElement(amountToBeDeposit).sendKeys("20");
        getDriver().findElement(submitDepositBtn).click();

    }

    public void enterWithdrawlBtn() {
        getDriver().findElement(withdrawlBtn).click();
    }

    public void enterWithdrawlamount(){
       enterWithdrawlBtn();
       getDriver().findElement(amountToBeWithdrawl).sendKeys("30");
       getDriver().findElement(submitWithdrawlBtn).click();
    }
   public boolean isLogoutBtnDisplayed() {
        return getDriver().findElement(logoutBtn).isDisplayed();
   }

   public boolean isDepositSuccessfulMessageDisplayed() {
        return getDriver().findElement(depositSuccessfulMessage).isDisplayed();
   }

   public boolean isTransactionSuccessfulMessageDisplayed(){
        return getDriver().findElement(transactionSuccessfulMessage).isDisplayed();
   }

   public void customerLogout(){
        getDriver().findElement(logoutBtn).click();
   }
}
