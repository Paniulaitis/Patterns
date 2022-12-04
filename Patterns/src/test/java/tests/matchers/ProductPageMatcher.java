package tests.matchers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import pages.ProductPage;

public class ProductPageMatcher {
    private Logger logger = LogManager.getLogger(ProductPageMatcher.class);
    ProductPage page;

    // Конструктор
    public ProductPageMatcher(ProductPage page) {
        this.page = page;
    }

    // Проверка / Утверждение (Матчер)

    public void productsCount(int expected) {
        String countText = page.labelProductsCount().getText();
        int actualCount = Integer.parseInt(countText.replaceAll("[^0-9]", ""));
        Assertions.assertTrue(actualCount>expected,  "Количество продукта не больше ожидаемых " + expected);
        logger.info("Количество продукта: " + actualCount + " и это больше ожидаемых " + expected);
    }
}
