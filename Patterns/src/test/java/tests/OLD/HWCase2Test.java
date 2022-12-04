package tests.OLD;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import tests.Listener;
import tests.WebDriverFactory;

import java.time.Duration;
import java.util.List;

// clean test -Dtest=HWCase2Test#appliancesTest -Dbrowser=chrome -Dparams=--start-maximized -DpageLoadStrategy=EAGER
public class HWCase2Test {
    protected static WebDriver driver;
    private Logger logger = LogManager.getLogger(HWCase2Test.class);


    // Чтение передаваемого параметра browser (-Dbrowser)
    String browser = System.getProperty("browser", "chrome");
    String params = System.getProperty("params", "");
    String pageLoadStrategy = System.getProperty("loadstrategy", "NORMAL");

    @BeforeEach
    public void setUp() {
        logger.info("env = " + browser);
        driver = WebDriverFactory.getDriver(browser.toLowerCase(), params.toLowerCase(), pageLoadStrategy.toUpperCase());
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
        logger.info("Драйвер стартовал!");
    }

    @Test
    public void appliancesTest() {
        Listener listener = new Listener();
        WebDriver eventFiringWebDriver = new EventFiringDecorator<>(listener).decorate(driver);

        eventFiringWebDriver.get("https://www.dns-shop.ru/");
        logger.info("Открыта страница dns-shop.ru - https://www.dns-shop.ru/");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        By cityXpath = By.xpath("//span[contains(text(),'Всё верно')]");
        wait.until(ExpectedConditions.elementToBeClickable(cityXpath));
        WebElement cityButton = eventFiringWebDriver.findElement(cityXpath);
        new Actions(eventFiringWebDriver)
                .scrollToElement(cityButton)
                .perform();
        cityButton.click();
        logger.info("Нажата кнопка подтверждения города");


        wait.until(ExpectedConditions.not(ExpectedConditions.visibilityOfElementLocated(cityXpath)));

        By appliancesXpath = By.xpath("//div[@class='menu-desktop']//a[contains(text(),'Бытовая техника')]");
        new WebDriverWait(driver, Duration.ofSeconds(15)).ignoring(StaleElementReferenceException.class).until(ExpectedConditions.elementToBeClickable(appliancesXpath));
        WebElement appliancesButton = eventFiringWebDriver.findElement(appliancesXpath);
        new Actions(eventFiringWebDriver)
                .moveToElement(appliancesButton)
                .perform();
        logger.info("Курсор наведен на Бытовая техника");


        new Actions(eventFiringWebDriver)
                .scrollToElement(appliancesButton)
                .perform();


        By appliancesCategoriesXpath = By.xpath("//div[@class='menu-desktop__submenu menu-desktop__submenu_top']//a[@class='ui-link menu-desktop__first-level']");
        wait.until(ExpectedConditions.visibilityOfElementLocated(appliancesCategoriesXpath));
        List<WebElement> categoriesAppliances = eventFiringWebDriver.findElements(appliancesCategoriesXpath);
        new Actions(eventFiringWebDriver)
                .scrollToElement(appliancesButton)
                .perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(appliancesCategoriesXpath));
        String appliancesCategoriesText="";
        for (WebElement element : categoriesAppliances) {
            appliancesCategoriesText+=element.getText();
        }
        logger.info("Категории: " + appliancesCategoriesText);
        Assertions.assertEquals("Встраиваемая техникаТехника для кухниТехника для дома", appliancesCategoriesText,  "Подкатегории первого уровня бытовой техники ошибочны");
        logger.info("Подкатегории первого уровня бытовой техники в норме");


        By appliancesСookingXpath = By.xpath("//div[@class='menu-desktop__second-level-wrap']//a[contains(text(),'Плиты и печи')]");
        wait.until(ExpectedConditions.visibilityOfElementLocated(appliancesСookingXpath));
        WebElement appliancesStoveButton = eventFiringWebDriver.findElement(appliancesСookingXpath);
        new Actions(eventFiringWebDriver)
                .scrollToElement(appliancesButton)
                .perform();
        wait.until(ExpectedConditions.elementToBeClickable(appliancesStoveButton));
        new Actions(eventFiringWebDriver)
                .moveToElement(appliancesStoveButton)
                .perform();
        logger.info("Курсор наведен на Плиты и печи");

        By subCategoriesKitchenAppliancesXpath = By.xpath("//div[@class='menu-desktop__second-level-wrap']//a[contains(text(),'Плиты и печи')]//a[@class='ui-link menu-desktop__popup-link']");
        wait.until(ExpectedConditions.visibilityOfElementLocated(subCategoriesKitchenAppliancesXpath));
        List<WebElement> subCategoriesKitchenAppliances = eventFiringWebDriver.findElements(subCategoriesKitchenAppliancesXpath);
        Assertions.assertTrue(subCategoriesKitchenAppliances.size()>5);
        logger.info("Количество подкатегорий Плиты и печи: " + subCategoriesKitchenAppliances.size() + ", и это таки больше 5");

        new Actions(eventFiringWebDriver)
                .moveToElement(appliancesButton)
                .perform();
        wait.until(ExpectedConditions.elementToBeClickable(appliancesStoveButton));
        appliancesStoveButton.click();
        logger.info("Нажата кнопка Плиты и печи");


        By eStoveXpath = By.xpath("//div[@class='subcategory__item-container ']//span[contains(text(),'Плиты электрические')]");
        wait.until(ExpectedConditions.visibilityOfElementLocated(eStoveXpath));
        WebElement eStoveButton = eventFiringWebDriver.findElement(eStoveXpath);
        new Actions(eventFiringWebDriver)
                .moveToElement(eStoveButton)
                .perform();
        eStoveButton.click();
        logger.info("Нажата кнопка Плиты электрические");


        By eStoveCountXpath = By.xpath("//span[@class='products-count']");
        wait.until(ExpectedConditions.visibilityOfElementLocated(eStoveCountXpath));
        WebElement eStoveCount = eventFiringWebDriver.findElement(eStoveCountXpath);
        String eStoveCountText = eStoveCount.getText();
        int stoveCount = Integer.parseInt(eStoveCountText.replaceAll("[^0-9]", ""));
        Assertions.assertTrue(stoveCount>100);
        logger.info("Количество электических печей: " + stoveCount + ", и это больше 100");

    }

    @AfterEach
    public void setDown() {
        if(driver != null) {
            driver.quit();
            logger.info("Драйвер остановлен!");
        }
    }
}