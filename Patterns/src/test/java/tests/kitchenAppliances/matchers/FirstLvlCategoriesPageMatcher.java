package tests.kitchenAppliances.matchers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import pages.firstLvlCategories.FirstLvlCategoriesPage;


public class FirstLvlCategoriesPageMatcher {
    private Logger logger = LogManager.getLogger(FirstLvlCategoriesPageMatcher.class);

    FirstLvlCategoriesPage page;

    // Конструктор
    public FirstLvlCategoriesPageMatcher(FirstLvlCategoriesPage page) {
        this.page = page;
    }

    // Проверка / Утверждение (Матчер)

    public void labelAppliancesEquals(String expected) {
        String actual = page.labelAppliances().getText();
        Assertions.assertEquals(expected, actual,  "Заголовок Бытовая техника не найден!");
        logger.info("Заголовок Бытовая техника присутствует");
    }
}