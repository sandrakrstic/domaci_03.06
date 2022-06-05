import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class RequestTest {

    private WebDriver driver;
    private WebDriverWait driverWait;
    private HomePage homePage;
    private BankManagerPage bankManagerPage;
    private CustomerLoginPage customerLoginPage;
    private CustomerAcountPage customerAcountPage;
    private OpenAccountPage openAccountPage;

    @BeforeClass
    public void beforeClass(){
        System.setProperty("webdriver.chrome.driver", "D:\\Sandra\\kurs_qa\\hromdriver\\chromedriver_win32\\chromedriver.exe");
         driver=new ChromeDriver();
         driver.manage().window().maximize();
         driverWait = new WebDriverWait(driver, Duration.ofSeconds(20));
         homePage = new HomePage(driver,driverWait);
         bankManagerPage = new BankManagerPage(driver, driverWait);
         customerLoginPage = new CustomerLoginPage(driver,driverWait);
         customerAcountPage = new CustomerAcountPage(driver,driverWait);
         openAccountPage = new OpenAccountPage(driver, driverWait);
         driver.navigate().to("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");

    }

    @Test
    public void loginAsBankManager(){
        homePage.bankManagerLoginClick();
        String expectedTitle="XYZ Bank";
        Assert.assertEquals(driver.getTitle(),expectedTitle);
    }

    @Test
    public void addCustomer() {
        bankManagerPage.addCustomerClick();
        bankManagerPage.createAddCustomer("Sandra", "Krstic","21000");
        bankManagerPage.clickAddCustomerBtn();
        Assert.assertNotEquals(bankManagerPage.getAlertText(), null);

    }

    @Test
    public void createAccountForCustomer() {
     bankManagerPage.clickOpenAccount();
     openAccountPage.selectCustomer();
     openAccountPage.selectCurrency();
     openAccountPage.processBtnClick();
     Assert.assertNotEquals(openAccountPage.getAlertText(), null);
    }

    @Test
    public void enterLoginAsCustomer() {
        homePage.customerLoginClick();
        String expectedTitle="XYZ Bank";
        Assert.assertEquals(driver.getTitle(),expectedTitle);
    }

    @Test
    public void createAccountAsCustomer() {
        customerLoginPage.selectYourName();
        customerLoginPage.loginBtnClick();
        Assert.assertTrue(customerAcountPage.isLogoutBtnDisplayed());
    }

    @Test
    public void successfulDepositForCustomer() {
        customerAcountPage.enterDeposit();
        Assert.assertTrue(customerAcountPage.isDepositSuccessfulMessageDisplayed());
    }

    @Test
    public void successfulWithdrawlForCustomer(){
        customerAcountPage.enterWithdrawlamount();
        Assert.assertTrue(customerAcountPage.isTransactionSuccessfulMessageDisplayed());
    }

    @Test
    public void customerLogout(){
        customerAcountPage.customerLogout();
        String expectedTitle="XYZ Bank";
        Assert.assertEquals(driver.getTitle(),expectedTitle);
    }

    @AfterClass
    public void afterClass() {
        driver.close();
    }

}
