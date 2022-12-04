package tests.laptops.matchers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import pages.laptops.LaptopsProductPage;
import tests.OLD.HWCase3Test;

public class LaptopProductPageMatcher {
    private Logger logger = LogManager.getLogger(LaptopProductPageMatcher.class);

    LaptopsProductPage page;

    // Конструктор
    public LaptopProductPageMatcher(LaptopsProductPage page) {
        this.page = page;
    }

    // Проверка / Утверждение (Матчер)
    public void pageManufacturerEquals(String expected) {
        Assertions.assertTrue(page.labelСharacteristicsHeader().getText().contains(expected),"Заголовок характеристик не соответствет ожидаемому");
        logger.info("Заголовок характеристик соответствет ожидаемому");
    }

    public void pageRamEquals(String expected) {
        Assertions.assertEquals(expected, page.labelRam().getText(),  "Объем RAM не соответствет ожидаемому");
        logger.info("Объем RAM соответствет ожидаемому");
    }
    public void pageTitleEquals(String expected) {
        String actual = page.getPageTitle();
        Assertions.assertTrue(actual.contains(expected), "Ошибка! Заголовок страницы не соответствует ожидаемому!");
        logger.info("Заголовок страницы соответствует ожидаемому");
    }
}