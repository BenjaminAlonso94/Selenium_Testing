package challenge.ui.pages;

import challenge.ui.factory.DriverHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class Results extends DriverHelper {
    By resultsSelect = By.id("sort");
    By tbody = By.xpath("//tbody/tr");
    By priceSum = By.id("price-sum");

    String tbodyRows = "//tbody/tr[#]/td[4]";

    public void verifyResultSelectIsDisplayed() {
        verifyElementIsDisplayed(priceSum);
    }

    public void selectByPriceDecending() {
        selectData(resultsSelect, "desc");
    }

    public void verifyPriceIsSortDecending() {
        int coutBody = driver.findElements(tbody).size();
        int start = 0;
        int sumTotal = 0;
        for (int i = 1; i <= coutBody; i++) {
            String priceText = getText(By.xpath(tbodyRows.replaceAll("#", "" + i)));
            int temp = Integer.parseInt(priceText.replaceAll("[^0-9]", ""));
            if (start == 0) {
                start = temp;
            }
            if (temp > start) {
                Assert.fail("The table is not sort by Decending");
            }
            start = temp;
            sumTotal += temp;
        }
        Assert.assertEquals(sumTotal, Integer.parseInt(getText(priceSum).replaceAll("[^0-9]", "")));
    }

    public Results(WebDriver driver) {
        super(driver);
    }
}
