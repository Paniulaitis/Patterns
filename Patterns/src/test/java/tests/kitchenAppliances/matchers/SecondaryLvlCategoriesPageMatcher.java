package tests.kitchenAppliances.matchers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import pages.firstLvlCategories.FirstLvlCategoriesPage;;

public class SecondaryLvlCategoriesPageMatcher {
    private Logger logger = LogManager.getLogger(SecondaryLvlCategoriesPageMatcher.class);

    FirstLvlCategoriesPage page;

    // Конструктор
    public SecondaryLvlCategoriesPageMatcher(FirstLvlCategoriesPage page) {
        this.page = page;
    }

    // Проверка / Утверждение (Матчер)
    public void labelAppliancesKitchenEquals(String expected) {
        String actual = page.labelAppliances().getText();
        Assertions.assertEquals(expected, actual,  "Техника для кухни отсутствует!");
        logger.info("Техника для кухни присутствует");
    }

    public void assemblyKitchenButton() {
        String actual = page.linkAssembleYourKitchen().getText();
        Assertions.assertEquals("Собрать свою кухню", actual,  "Собрать свою кухню отсутствует!");
        logger.info("Собрать свою кухню присутствует");
    }

    public void countCategories(int expected) {
        int actual = page.listSubcategoryItemContainer().getListWebElements().size();
        Assertions.assertTrue(actual>expected,  "Количество кухонных категорий не больше  " + expected);
        logger.info("Количество кухонных категорий: " + actual + " и это таки больше " + expected);
    }
}