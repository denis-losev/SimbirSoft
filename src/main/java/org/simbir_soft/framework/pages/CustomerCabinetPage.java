package org.simbir_soft.framework.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.assertj.core.api.Assertions.assertThat;

public class CustomerCabinetPage extends BasePage{

    @FindBy(xpath = "//button[contains(text(),'Transactions')]")
    WebElement transactionsBtn;
    @FindBy(xpath = "//button[contains(text(),'Deposit')]")
    WebElement depositBtn;
    @FindBy(xpath = "(//button[contains(text(),'Deposit')])[2]")
    WebElement confirmDepositBtn;
    @FindBy(xpath = "//button[contains(text(),'Withdrawl')]")
    WebElement withdrawlBtn;
    @FindBy(xpath = "(//button[contains(text(),'Withdraw')])[2]")
    WebElement confirmWithdrawlBtn;
    @FindBy(xpath = "//input[@placeholder='amount']")
    WebElement inputField;
    @FindBy(xpath = "(//div[@ng-hide='noAccount'])[1]/strong[2]")
    WebElement balanceValue;
    @FindBy(xpath = "(//label[contains(text(),'Amount to be Withdrawn :')])")
    WebElement withdrawLabel;
    @FindBy(xpath = "(//label[contains(text(),'Amount to be Deposited :')])")
    WebElement depositLabel;
    @FindBy(xpath = "//span[@class='error ng-binding' and contains(text(),'Deposit Successful')]")
    WebElement operationDepositSuccessful;

    @FindBy(xpath = "//span[@class='error ng-binding' and contains(text(),'Transaction successful')]")
    WebElement operationTransactionSuccessful;

    @Step("Клик по кнопке 'Deposit'")
    public CustomerCabinetPage clickDepositBtn() {
        depositBtn.click();
        wait.until(ExpectedConditions.visibilityOf(depositLabel));
        return this;
    }

    @Step("Клик по кнопке 'Withdrawl'")
    public CustomerCabinetPage clickWithdrawlBtn() {
        withdrawlBtn.click();
        wait.until(ExpectedConditions.visibilityOf(withdrawLabel));
        return this;
    }

    @Step("Клик по кнопке 'Transactions'")
    public TransactionsPage clickTransactionsBtn() throws InterruptedException {
        Thread.sleep(1000);
        transactionsBtn.click();
        return pageManager.getTransactionsPage();
    }

    @Step("Клик по кнопке подтверждения депозита")
    public CustomerCabinetPage clickConfirmDepositBtn(String balanceExpected) throws InterruptedException {
        Thread.sleep(1000);
        confirmDepositBtn.click();
        wait.until(ExpectedConditions.visibilityOf(operationDepositSuccessful));
        checkBalanceValue(balanceExpected);
        return this;
    }

    @Step("Клик по кнопке подтверждения списания")
    public CustomerCabinetPage clickConfirmWithdrawlBtn(String balanceExpected) throws InterruptedException {
        Thread.sleep(1000);
        confirmWithdrawlBtn.click();
        wait.until(ExpectedConditions.visibilityOf(operationTransactionSuccessful));
        checkBalanceValue(balanceExpected);
        return this;
    }

    @Step("Ввод в поле суммы: {n}")
    public CustomerCabinetPage fillInput(String n) {
        inputField.sendKeys(n);
        return this;
    }

    @Step("Проверка изменения баланса на значение: {balanceExpected}")
    public void checkBalanceValue(String balanceExpected) {
        assertThat(balanceValue.getText())
                .as("Значение баланса '%s' не совпадает с '%s'", balanceValue.getText(), balanceExpected)
                .isEqualTo(balanceExpected);
    }
}
