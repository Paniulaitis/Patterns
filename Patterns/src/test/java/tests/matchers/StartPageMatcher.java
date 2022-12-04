package tests.matchers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebElement;
import pages.StartPage;
import pages.firstLvlCategories.FirstLvlCategoriesPage;
import tests.kitchenAppliances.matchers.FirstLvlCategoriesPageMatcher;

public class StartPageMatcher {
    private Logger logger = LogManager.getLogger(StartPageMatcher.class);
    StartPage page;

    // Конструктор
    public StartPageMatcher(StartPage page) {
        this.page = page;
    }

    // Проверка / Утверждение (Матчер)

    public void listAppliancesFirsLvl(String expected) {

        String actualAppliancesCategoriesText="";
        for (WebElement element : page.listAppliancesFirsLvl().getListWebElements()) {
            actualAppliancesCategoriesText+=element.getText();
        }
        logger.info("Категории: " + actualAppliancesCategoriesText);

        Assertions.assertEquals(expected, actualAppliancesCategoriesText,  "Подкатегории первого уровня бытовой техники ошибочны");
        logger.info("Подкатегории первого уровня бытовой техники в норме");
    }

    public void listCookingDrinks(int expected) {

        int actual = page.listCookingDrinks().getListWebElements().size();
        Assertions.assertTrue(actual>expected, "Количество подкатегорий Приготовление напитков не больше "+ expected);
        logger.info("Количество подкатегорий Приготовление напитков: " + actual + ", и это таки больше 5");
    }
}
