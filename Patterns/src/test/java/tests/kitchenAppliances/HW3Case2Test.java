package tests.kitchenAppliances;

import helpers.WaitHelper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;
import pages.ProductPage;
import pages.StartPage;
import pages.firstLvlCategories.FirstLvlCategoriesPage;
import tests.BaseTest;
import tests.matchers.ProductPageMatcher;
import tests.matchers.StartPageMatcher;

public class HW3Case2Test extends BaseTest {

    private Logger logger = LogManager.getLogger(HW3Case2Test.class);

    @Test
    public void dnsTest() {
        // 1. Arrange

        // 2. Act
        StartPage startPage = getStartPagePage();

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
    public StartPage getStartPagePage() {

        // ***** Стартовая страница сайта DNS *****
        StartPage startPage = new StartPage(driver);

        startPage.openPage();

        //startPage.buttonYes().click();

        startPage.blockYes().hide();

        startPage.linkAppliances().focusOnLink();

        startPage.linkCookingDrinks().focusOnLink();

        WaitHelper.clickabilityOfElement(startPage.blockCookingDrinksSecondLvl().getWebElement());

        return new StartPage(driver);
    }

    public ProductPage getProductPage() {

        StartPage startPage = new StartPage(driver);

        startPage.linkStoveAndOvens().focusOnLink();

        startPage.linkStoveAndOvens().click();

        FirstLvlCategoriesPage stoveAndOvenPage = new FirstLvlCategoriesPage(driver);

        stoveAndOvenPage.linkEStove().click();

        ProductPage productPage = new ProductPage(driver);

        WaitHelper.visibilityOfElement(productPage.labelProductsCount().getWebElement());

        return new ProductPage(driver);
    }
}