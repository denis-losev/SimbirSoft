package org.simbir_soft.framework.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CustomerLoginPage extends BasePage{

    @FindBy(xpath = "//select[@id='userSelect']")
    WebElement userSelectDropdown;

    @FindBy(xpath = "//button[contains(text(),'Login')]")
    WebElement loginBtn;

    @FindBy(xpath = " //option[@ng-repeat='cust in Customers']")
    List<WebElement> customersList;

    @Step("Вход в аккаунт '{userName}'")
    public CustomerCabinetPage loginUser(String userName) {
        userSelectDropdown.click();
        selectCustomerByText(userName).click();
        loginBtn.click();
        return pageManager.getCustomerCabinetPage();
    }

    @Step("Поиск достусного аккаунта '{text}'")
    public WebElement selectCustomerByText(String text) {
        return customersList.stream().filter(s -> s.getText().equals(text)).findFirst().orElse(null);
    }
}
