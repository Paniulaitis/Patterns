package tests.kitchenAppliances;

import helpers.ActionHelper;
import helpers.WaitHelper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import pages.ProductPage;
import pages.ScreenshotMaker;
import pages.StartPage;
import pages.firstLvlCategories.FirstLvlCategoriesPage;
import tests.BaseTest;
import tests.matchers.ProductPageMatcher;
import tests.matchers.StartPageMatcher;

import java.util.function.Consumer;
import java.util.regex.Pattern;

public class HW3Case2Test extends BaseTest {

    private Actions action;

    private Logger logger = LogManager.getLogger(HW3Case2Test.class);

    ScreenshotMaker screenshotMaker = new ScreenshotMaker();

    @Test
    public void dnsTest() {
        // 1. Arrange

        // 2. Act
        StartPage startPage = getStartPage();

        // 3. Assert
        StartPageMatcher startPageMatcher = new StartPageMatcher(startPage);

        String appliancesExpected = "Встраиваемая техникаТехника для кухниТехника для дома";
        startPageMatcher.listAppliancesFirsLvl(appliancesExpected);

        int countExpected = 5;
        startPageMatcher.listCookingDrinks(countExpected);




        // 2. Act
        ProductPage productPage = getProductPage();

        // 3. Assert
        ProductPageMatcher pageMatcher = new ProductPageMatcher(productPage);

        countExpected = 100;
        pageMatcher.productsCount(countExpected);
    }

    // Получение заголовка страницы с продуктом
    public StartPage getStartPage() {

        // ***** Стартовая страница сайта DNS *****
        StartPage startPage = new StartPage(eventFiringWebDriver);

        startPage.openPage();

        screenshotMaker.TakeScreenshot(driver);

        //startPage.buttonYes().click();
        //startPage.linkAppliances().focusOnLink(driver);
        //Так тесты проходит быстрее, но можно и заменить
        startPage.blockYes().hide();

        startPage.linkAppliances().focusOnLink();
        screenshotMaker.TakeScreenshot(driver);

        startPage.linkCookingDrinks().focusOnLink();
        screenshotMaker.TakeScreenshot(driver);

        startPage.linkAppliances().focusOnLink();
        startPage.linkCookingDrinks().focusOnLink();

        WaitHelper.clickabilityOfElement(startPage.blockCookingDrinksSecondLvl().getWebElement());


        return new StartPage(eventFiringWebDriver);
    }

    public ProductPage getProductPage() {

        StartPage startPage = new StartPage(eventFiringWebDriver);

        startPage.linkStoveAndOvens().focusOnLink();
        screenshotMaker.TakeScreenshot(driver);

        startPage.linkAppliances().focusOnLink();
        startPage.linkStoveAndOvens().click();
        screenshotMaker.TakeScreenshot(driver);

        FirstLvlCategoriesPage stoveAndOvenPage = new FirstLvlCategoriesPage(driver);

        stoveAndOvenPage.linkEStove().click();

        ProductPage productPage = new ProductPage(driver);
        WaitHelper.visibilityOfElement(productPage.labelProductsCount().getWebElement());
        screenshotMaker.TakeScreenshot(driver);

        return new ProductPage(eventFiringWebDriver);
    }
}