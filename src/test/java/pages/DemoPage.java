package pages;

import com.ibm.icu.impl.UResource;
import com.typesafe.config.Config;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import utilities.ConfigLoader;

import java.security.Key;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class DemoPage extends PageObject {
    private static Config conf = ConfigLoader.load();

    @FindBy(xpath = "//a[text()='Gmail']")
    private WebElement gmailButton;
    @FindBy(xpath = "//input[@name='q']")
    WebElement searchText;
    @FindBy(xpath = "(//h3[@class='LC20lb DKV0Md'])[1]")
    WebElement searchResult;
    @FindBy(xpath = "//div[@class='KxwPGc SSwjIe']/div/a")
    List<WebElement> menuList;

    public void navigateToUrl() {
        openUrl(conf.getString("demoUrl"));
        getDriver().manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        getDriver().manage().window().maximize();
    }

    public void verifyGmailButton() {
        Assert.assertTrue(withTimeoutOf(20, TimeUnit.SECONDS).waitFor(gmailButton).isDisplayed());
    }

    public void verifyGooleTitleOfGooglePage() {
        String title = getDriver().getTitle();
        Assert.assertEquals("Google", title);
    }

    public void searchText(String text) {
        withTimeoutOf(20, TimeUnit.SECONDS).waitFor(searchText).click();
        waitFor(searchText).sendKeys(text);
        waitFor(searchText).sendKeys(Keys.ENTER);
    }

    public void verifySearchResult(String expectedResult) {
        String actualResult = withTimeoutOf(30, TimeUnit.SECONDS).waitFor(searchResult).getText();
        Assert.assertEquals(expectedResult, actualResult);

    }

    public void verifyFooterMenuList() {
        List<String> actualMenuList = new ArrayList<>();
        String[] expectedList = {"About", "Advertising", "Business", "How Search works", "Privacy", "Terms"};
        for (WebElement list : menuList) {
            actualMenuList.add(list.getText());
        }
        for (int i = 0; i < expectedList.length; i++) {
            Assert.assertEquals(expectedList[i], actualMenuList.get(i));
        }
    }
}
