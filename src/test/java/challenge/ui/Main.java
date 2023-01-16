package challenge.ui;

import challenge.ui.factory.InitTest;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class Main extends InitTest {

    @Test
    public void verifyInputAndSubmitButtonAreDisplayed() {
        home.goToReports();
        reports.verifyReportsLabelIsDisplayed();
        reports.findReport();
        results.verifyResultSelectIsDisplayed();
        results.selectByPriceDecending();
        results.verifyResultSelectIsDisplayed();
        results.verifyPriceIsSortDecending();
    }

    @AfterMethod
    public void tearDown() throws Exception {
        Thread.sleep(3000);
        driver.quit();
    }

    public void setImplicitWait(int time) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(time));
    }
}
