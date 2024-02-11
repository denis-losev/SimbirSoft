package org.simbir_soft.framework.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static helpers.TableToCsv.writeDataToCsv;
import static org.assertj.core.api.Assertions.assertThat;

public class TransactionsPage extends BasePage {

    @FindBy(xpath = "//table")
    WebElement transactionsTable;

    @Step("Проверка наличия таблицы на странице")
    public TransactionsPage checkTable(int numberOfEntries) {
        int transactionsCount = transactionsTable.findElements(By.xpath("//tbody//tr")).size();
        assertThat(transactionsCount)
                .as("Количество результатов в таблице: %d -> не совпадает с '%d'", transactionsCount, numberOfEntries)
                .isEqualTo(numberOfEntries);
        return this;
    }

    @Step("Экспорт таблицы в CSV-файл")
    public void exportTableToCsv(String fileName) {
        writeDataToCsv("src/test/export/"+fileName+".csv", transactionsTable);
    }
}
