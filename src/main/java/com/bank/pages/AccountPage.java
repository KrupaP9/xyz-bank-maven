package com.bank.pages;

import com.bank.utility.Utility;
import org.openqa.selenium.By;

public class AccountPage extends Utility {
    By logoutButton = By.xpath("//button[@class='btn logout']");
    By depositButton = By.xpath("//button[@ng-click='deposit()']");
    By withdrawalButton = By.xpath("//button[@ng-click='withdrawl()']");
    By amountInput = By.xpath("//input[@placeholder='amount']");
    By depositAfterAmount = By.xpath("//button[@type='submit']");
    By successMessage = By.xpath("//span[@ng-show='message']");
    By withdrawButton = By.xpath("//button[text()='Withdraw']");
    public String getLogoutText(){
        return getTextFromElement(logoutButton);
    }
    public void clickLogout(){
        clickOnElement(logoutButton);
    }
    public void clickOnDeposit(){
        clickOnElement(depositButton);
    }
    public void clickOnWithdrawalButton(){
        clickOnElement(withdrawalButton);
    }
    public void sendAmountToInputBox(String userInputAmount){
        sendTextToElement(amountInput,userInputAmount);
    }
    public void clickOnDepositAfterAmount(){
        clickOnElement(depositAfterAmount);
    }
    public String getTextFromSuccessMessage(){
        return getTextFromElement(successMessage);
    }
    public void clickOnWithdrawButton(){
        clickOnElement(withdrawButton);
    }
}
