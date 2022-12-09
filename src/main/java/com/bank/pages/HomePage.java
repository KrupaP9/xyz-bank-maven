package com.bank.pages;

import com.bank.propertyreader.PropertyReader;
import com.bank.utility.Utility;
import org.openqa.selenium.By;

public class HomePage extends Utility {
    String baseUrl = PropertyReader.getInstance().getProperty("baseUrl");
    By bankManagerLogin = By.xpath("//button[contains(text(),'Bank Manager Login')]");

    By customerLoginButton = By.xpath("//button[@ng-click='customer()']");

    public void clickOnBankManagerLoginButton() {
        clickOnElement(bankManagerLogin);
    }

    public void clickCustomerLoginButton() {
        clickOnElement(customerLoginButton);
    }




    public void getbaseUrl() {
        driver.get(baseUrl);
    }

}
