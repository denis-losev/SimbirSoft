package org.simbir_soft.framework.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.simbir_soft.framework.managers.DriverManager;
import org.simbir_soft.framework.managers.PageManager;

import java.time.Duration;

public class BasePage {

    protected DriverManager driverManager = DriverManager.getDriverManager();
    protected WebDriverWait wait = new WebDriverWait(driverManager.getDriver(), Duration.ofSeconds(10), Duration.ofMillis(1000));

    protected PageManager pageManager = PageManager.getPageManager();

    @FindBy(xpath = "//button[contains(text(), 'Home')]")
    WebElement homeBtn;

    public BasePage() {
        PageFactory.initElements(driverManager.getDriver(), this);
    }

    @Step("Нажатие на кнопку 'Home'")
    protected BasePage clickHomeBtn() {
        homeBtn.click();
        return this;
    }
}
