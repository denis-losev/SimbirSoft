package org.simbir_soft.framework.managers;

import java.time.Duration;

import static org.simbir_soft.framework.utils.PropConstants.IMPLICITLY_WAIT;
import static org.simbir_soft.framework.utils.PropConstants.PAGE_LOAD_TIMEOUT;

public class InitManager {

    private static final TestPropManager props = TestPropManager.getTestPropManager();

    private static DriverManager driverManager = DriverManager.getDriverManager();

    public static void initFramework() {
        driverManager.getDriver().manage().timeouts()
                .implicitlyWait(Duration.ofSeconds(Integer.parseInt(props.getProperty(IMPLICITLY_WAIT))));
        driverManager.getDriver().manage().timeouts()
                .pageLoadTimeout(Duration.ofSeconds(Integer.parseInt(props.getProperty(PAGE_LOAD_TIMEOUT))));

    }

    public static void quitFramework() {
        driverManager.quitDriver();
    }
}
