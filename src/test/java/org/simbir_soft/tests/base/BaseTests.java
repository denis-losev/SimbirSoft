package org.simbir_soft.tests.base;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.simbir_soft.framework.managers.DriverManager;
import org.simbir_soft.framework.managers.InitManager;
import org.simbir_soft.framework.managers.PageManager;
import org.simbir_soft.framework.managers.TestPropManager;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import static org.simbir_soft.framework.utils.PropConstants.BASE_URL;

public class BaseTests {

    private final TestPropManager testPropManager = TestPropManager.getTestPropManager();
    protected PageManager app = PageManager.getPageManager();
    protected WebDriverWait wait;

    @BeforeClass
    public void startWebDriver() {
        InitManager.initFramework();
    }

    @BeforeMethod
    public void beforeMethod() {
        DriverManager.getDriverManager().getDriver().get(testPropManager.getProperty(BASE_URL));
    }

    @AfterClass
    public void closeWebDriver() {
        InitManager.quitFramework();
    }
}
