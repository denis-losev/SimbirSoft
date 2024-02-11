package org.simbir_soft.tests;

import org.simbir_soft.tests.base.BaseTests;
import org.testng.annotations.Test;

import java.io.IOException;

import static helpers.Attacher.attachFileToReport;
import static helpers.FibonacciCounter.getFibonacciByActualDay;

public class TransactionsTest extends BaseTests {

    private final String amount = Integer.toString(getFibonacciByActualDay() + 1);

    @Test(description = "Тест транзакций")
    public void testTransactions() throws IOException, InterruptedException {
        app.getMainLoginPage()
                .clickCustomerLoginBtn()
                .loginUser("Harry Potter")
                .clickDepositBtn()
                .fillInput(amount)
                .clickConfirmDepositBtn(amount)
                .clickWithdrawlBtn()
                .fillInput(amount)
                .clickConfirmWithdrawlBtn("0")
                .clickTransactionsBtn()
                .checkTable(2)
                .exportTableToCsv("transactions");
        attachFileToReport("src/test/export", "transactions.csv");
    }
}
