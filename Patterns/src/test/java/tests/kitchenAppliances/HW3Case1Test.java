package tests.kitchenAppliances;

import helpers.JavaScriptHelper;
import helpers.WaitHelper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.StartPage;
import pages.firstLvlCategories.FirstLvlCategoriesPage;
import pages.laptops.LaptopsPage;
import pages.laptops.LaptopsProductPage;
import tests.BaseTest;
import tests.OLD.HWCase2Test;
import tests.kitchenAppliances.matchers.FirstLvlCategoriesPageMatcher;
import tests.kitchenAppliances.matchers.SecondaryLvlCategoriesPageMatcher;
import tests.laptops.matchers.LaptopProductPageMatcher;

import java.time.Duration;


public class HW3Case1Test extends BaseTest {

    private Logger logger = LogManager.getLogger(HW3Case1Test.class);

    @Test
    public void dnsTest() {
        // 1. Arrange

        // 2. Act
        FirstLvlCategoriesPage firstLvlCategoriesPage = getFirstLvlCategoriesPage();


        // 3. Assert
        // Проверка заголовка открытой страницы
        FirstLvlCategoriesPageMatcher firstLvlCategoriesPageMatcher = new FirstLvlCategoriesPageMatcher(firstLvlCategoriesPage);
        String appliancesExpected = "Бытовая техника";
        firstLvlCategoriesPageMatcher.labelAppliancesEquals(appliancesExpected);

        // 2. Act
        FirstLvlCategoriesPage secondaryPage = getSecondaryPage();

        // 3. Assert
        // Проверка заголовка открытой страницы
        SecondaryLvlCategoriesPageMatcher secondaryLvlCategoriesPageMatcher = new SecondaryLvlCategoriesPageMatcher(secondaryPage);

        String appliancesKitchenExpected = "Техника для кухни";
        secondaryLvlCategoriesPageMatcher.labelAppliancesKitchenEquals(appliancesKitchenExpected);

        int expectedCount = 5;
        secondaryLvlCategoriesPageMatcher.countCategories(expectedCount);

        secondaryLvlCategoriesPageMatcher.assemblyKitchenButton();


    }

    // Получение заголовка страницы с продуктом
    public FirstLvlCategoriesPage getFirstLvlCategoriesPage() {

        // ***** Стартовая страница сайта DNS *****
        StartPage startPage = new StartPage(eventFiringWebDriver);
        // Открыть страницу https://www.dns-shop.ru/
        startPage.openPage();
        //
        //startPage.buttonYes().click();

        startPage.blockYes().hide();

        startPage.linkAppliances().click();

        return new FirstLvlCategoriesPage(driver);
    }

    public FirstLvlCategoriesPage getSecondaryPage() {

        FirstLvlCategoriesPage appliancesPage = new FirstLvlCategoriesPage(driver);

        appliancesPage.linkAppliancesKitchen().click();

        return new FirstLvlCategoriesPage(driver);
    }
}