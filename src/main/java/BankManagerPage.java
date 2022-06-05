import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BankManagerPage extends BasePage {

     private By addCustomer = By.xpath("/html/body/div/div/div[2]/div/div[1]/button[1]");
     private By firstName = By.xpath("/html/body/div/div/div[2]/div/div[2]/div/div/form/div[1]/input");
     private By lastname = By.xpath("/html/body/div/div/div[2]/div/div[2]/div/div/form/div[2]/input");
     private By postCode = By.xpath("/html/body/div/div/div[2]/div/div[2]/div/div/form/div[3]/input");
     private By addCustomerBtn = By.xpath("/html/body/div/div/div[2]/div/div[2]/div/div/form/button");
     private By openAccount = By.xpath("/html/body/div/div/div[2]/div/div[1]/button[2]");


    public BankManagerPage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public void addCustomerClick() {
        getDriver().findElement(addCustomer).click();
    }

   public void enterFirstName(String firstname) {
        getDriver().findElement(this.firstName).sendKeys(firstname);
   }
   public void enterLastName(String lastName) {
        getDriver().findElement(this.lastname).sendKeys(lastName);
   }
   public void enterPostCode(String postCode) {
        getDriver().findElement(this.postCode).sendKeys(postCode);
   }

   public void createAddCustomer(String firstName, String lastName, String postCode){
        enterFirstName(firstName);
        enterLastName(lastName);
        enterPostCode(postCode);
   }
   public void clickAddCustomerBtn(){
        getDriver().findElement(addCustomerBtn).click();
   }

   public void clickOpenAccount(){
        getDriver().findElement(this.openAccount).click();
   }

   public String getAlertText() {
        return this.getDriver().switchTo().alert().getText();
   }


}
