package org.simbir_soft.framework.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MainLoginPage extends BasePage{

    @FindBy(xpath = "//button[contains(text(),'Customer Login')]")
    WebElement customerLoginBtn;

    @Step("Клик по кнопке 'Customer Login'")
    public CustomerLoginPage clickCustomerLoginBtn() {
        wait.until(ExpectedConditions.elementToBeClickable(customerLoginBtn));
        customerLoginBtn.click();
        return pageManager.getCustomerLoginPage();
    }
}
