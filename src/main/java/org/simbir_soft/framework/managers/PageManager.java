package org.simbir_soft.framework.managers;

import org.simbir_soft.framework.pages.CustomerCabinetPage;
import org.simbir_soft.framework.pages.CustomerLoginPage;
import org.simbir_soft.framework.pages.MainLoginPage;
import org.simbir_soft.framework.pages.TransactionsPage;

public class PageManager {

    private static PageManager INSTANCE = null;

    private MainLoginPage mainLoginPage;
    private CustomerLoginPage customerLoginPage;
    private CustomerCabinetPage customerCabinetPage;
    private TransactionsPage transactionsPage;

    private PageManager() {
    }

    public static PageManager getPageManager() {
        if (INSTANCE == null) {
            INSTANCE = new PageManager();
        }
        return INSTANCE;
    }

    public MainLoginPage getMainLoginPage() {
        if (mainLoginPage == null) {
            mainLoginPage = new MainLoginPage();
        }
        return mainLoginPage;
    }

    public CustomerLoginPage getCustomerLoginPage() {
        if (customerLoginPage == null) {
            customerLoginPage = new CustomerLoginPage();
        }
        return customerLoginPage;
    }

    public CustomerCabinetPage getCustomerCabinetPage() {
        if (customerCabinetPage == null) {
            customerCabinetPage = new CustomerCabinetPage();
        }
        return customerCabinetPage;
    }

    public TransactionsPage getTransactionsPage() {
        if (transactionsPage == null) {
            transactionsPage = new TransactionsPage();
        }
        return transactionsPage;
    }
}
