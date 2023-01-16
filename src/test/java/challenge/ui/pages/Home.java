package challenge.ui.pages;

import challenge.ui.factory.DriverHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Home extends DriverHelper {
    private By reportLink = By.xpath("//*[contains(text(),'Reports')]");

    public Home(WebDriver driver) {
        super(driver);
    }

    public void goToReports() {
        click(reportLink);
    }
}
