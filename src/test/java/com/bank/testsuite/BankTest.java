package com.bank.testsuite;

import com.bank.pages.*;
import com.bank.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BankTest extends BaseTest {
    HomePage homePage = new HomePage();
    BankManagerLoginPage bankManagerLoginPage = new BankManagerLoginPage();
    AddCustomerPage addCustomerPage = new AddCustomerPage();
    OpenAccountPage openAccountPage = new OpenAccountPage();
    CustomersPage customersPage = new CustomersPage();
    CustomerLoginPage customerLoginPage = new CustomerLoginPage();
    AccountPage accountPage = new AccountPage();

    @Test
    public void bankManagerShouldAddCustomerSuccessfully() {
        //click On "Bank Manager Login" Tab
        homePage.clickOnBankManagerLoginButton();
        //	click On "Add Customer" Tab
        bankManagerLoginPage.clickOnAddCustomerButton();
        //	enter FirstName
        addCustomerPage.sendFirstName("Hermoine");
        //	enter LastName
        addCustomerPage.sendLastName("Granger");
        //	enter PostCode
        addCustomerPage.sendPostCode("E89897");
        //	click On "Add Customer" Button
        addCustomerPage.clickAddCustomerButton();
        //	popup display
        //	verify message "Customer added successfully"
        Assert.assertTrue(addCustomerPage.getTextFromCustomerAddedPopUp().contains("Customer added successfully"), "customer added successfully message not displayed");
        //	click on "ok" button on popup.
        addCustomerPage.clickOKOnAlert();
    }

    @Test
    public void bankManagerShouldOpenAccountSuccessfully() {
        //click On "Bank Manager Login" Tab
        homePage.clickOnBankManagerLoginButton();
        //	click On "Open Account" Tab
        bankManagerLoginPage.clickOpenAccountButton();
        //	Search customer that created in first test
        openAccountPage.selectCustomerNameByVisibleText("Hermoine Granger");
        //	Select currency "Pound"
        openAccountPage.selectCurrencyFromDropDown("Pound");
        //	click on "process" button
        openAccountPage.clickOnProcessButton();
        //	popup displayed
        //	verify message "Account created successfully"
        Assert.assertTrue(openAccountPage.getTextFromAccountCreatedSuccessfullyPopup().contains("Account created successfully"), "Popup not displayed");
        //	click on "ok" button on popup.
        openAccountPage.clickOKOnPopup();
    }
@Test
    public void customerShouldLoginAndLogoutSuceessfully() throws InterruptedException {
        //click on "Customer Login" Tab
        homePage.clickCustomerLoginButton();
        //	search customer that you created.
        customersPage.selectYourName("Hermoine Granger");
        Thread.sleep(1000);
        //	click on "Login" Button
        customersPage.clickOnLogin();
        //	verify "Logout" Tab displayed.
        Assert.assertEquals(accountPage.getLogoutText(), "Logout", "Logout text not displayed");
        //	click on "Logout"
        accountPage.clickLogout();
        //	verify "Your Name" text displayed.
        Assert.assertTrue(customersPage.getYourNameText().contains("Your Name"), "Your Name not displayed");

    }
@Test
    public void customerShouldDepositMoneySuccessfully() {
        //click on "Customer Login" Tab
        homePage.clickCustomerLoginButton();
        //	search customer that you created.
        customersPage.selectYourName("Hermoine Granger");
        //	click on "Login" Button
        customersPage.clickOnLogin();
        //	click on "Deposit" Tab
        accountPage.clickOnDeposit();
        //	Enter amount 100
        accountPage.sendAmountToInputBox("100");
        //	click on "Deposit" Button
        accountPage.clickOnDepositAfterAmount();
        //	verify message "Deposit Successful"
        Assert.assertEquals(accountPage.getTextFromSuccessMessage(), "Deposit Successful", "Deposit successful message not displayed");
    }
@Test
    public void customerShouldWithdrawMoneySuccessfully() {
        //click on "Customer Login" Tab
        homePage.clickCustomerLoginButton();
        //	search customer that you created.
        customersPage.selectYourName("Hermoine Granger");
        //	click on "Login" Button
        customersPage.clickOnLogin();
        //	click on "Withdrawl" Tab
        accountPage.clickOnWithdrawalButton();
        //	Enter amount 50
        accountPage.sendAmountToInputBox("50");
        //	click on "Withdraw" Button
        accountPage.clickOnWithdrawButton();
        //	verify message "Transaction Successful"
        Assert.assertEquals(accountPage.getTextFromSuccessMessage(),"Transaction successful","Transaction Successful message not displayed");
    }
}
