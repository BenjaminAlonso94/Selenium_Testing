package challenge.ui.pages;

import challenge.ui.factory.DriverHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Reports extends DriverHelper {
    private By reportsLabel = By.xpath("//h1[contains(text(),'Reports')]");
    private By dateFrom = By.id("fromDate");
    private By dateTo = By.id("toDate");
    private By selectReport = By.id("selectedReport");

    private By fullReport = By.cssSelector("input[value='full']");
    private By viewReport = By.xpath("//div[5]//button[contains(text(),'View report')]");

    public Reports(WebDriver driver) {
        super(driver);
    }

    public void verifyReportsLabelIsDisplayed() {
        verifyElementIsDisplayed(reportsLabel);
    }

    public void findReport() {
        String pattern = "MM-dd-yyyy";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_MONTH, +2);
        String dateFromText = simpleDateFormat.format(cal.getTime().getTime());
        cal.add(Calendar.DAY_OF_MONTH, +3);
        String dateToText = simpleDateFormat.format(cal.getTime().getTime());

        sendKeys(dateFrom, dateFromText);
        sendKeys(dateTo, dateToText);
        selectData(selectReport, "prices");
        click(fullReport);
        click(viewReport);
    }
}
