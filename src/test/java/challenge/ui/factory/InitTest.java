package challenge.ui.factory;

import challenge.ui.pages.Home;
import challenge.ui.pages.Reports;
import challenge.ui.pages.Results;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.io.File;

import static java.util.concurrent.TimeUnit.SECONDS;

public class InitTest {
    public WebDriver driver;
    public Home home;
    public Reports reports;
    public Results results;

    @BeforeTest
    @Parameters({"browser"})
    public void setup(String browser) {
        if (browser.equalsIgnoreCase("firefox")) {
            String driverPath = System.getProperty("user.dir")
                    + File.separator + "src"
                    + File.separator + "main"
                    + File.separator + "resources"
                    + File.separator + "driver" + File.separator + "geckodriver.exe";
            System.setProperty("webdriver.firefox.driver", driverPath);
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("chrome")) {
            String driverPath = System.getProperty("user.dir")
                    + File.separator + "src"
                    + File.separator + "main"
                    + File.separator + "resources"
                    + File.separator + "driver" + File.separator + "chromedriver.exe";
            System.setProperty("webdriver.chrome.driver", driverPath);
            driver = new ChromeDriver();
        } else {
            Assert.fail("The driver is not correct");
        }
        driver.manage().timeouts().pageLoadTimeout(100, SECONDS);
        launchApp();
        initPages();
    }

    private void launchApp() {
        driver.manage().window().maximize();
        driver.get("C:\\Users\\benjamin.alonso\\Downloads\\site2\\index.html");
    }

    public void initPages() {
        home = new Home(driver);
        reports = new Reports(driver);
        results = new Results(driver);
    }
}
