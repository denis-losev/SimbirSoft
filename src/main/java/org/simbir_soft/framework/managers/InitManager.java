package org.simbir_soft.framework.managers;

import java.util.concurrent.TimeUnit;

import static org.simbir_soft.framework.utils.PropConstants.IMPLICITLY_WAIT;
import static org.simbir_soft.framework.utils.PropConstants.PAGE_LOAD_TIMEOUT;

public class InitManager {

    private static final TestPropManager props = TestPropManager.getTestPropManager();

    private static DriverManager driverManager = DriverManager.getDriverManager();

    public static void initFramework() {
        driverManager.getDriver().manage().timeouts()
                .implicitlyWait(Integer.parseInt(props.getProperty(IMPLICITLY_WAIT)), TimeUnit.SECONDS);
        driverManager.getDriver().manage().timeouts()
                .pageLoadTimeout(Integer.parseInt(props.getProperty(PAGE_LOAD_TIMEOUT)), TimeUnit.SECONDS);

    }

    public static void quitFramework() {
        driverManager.quitDriver();
    }
}
