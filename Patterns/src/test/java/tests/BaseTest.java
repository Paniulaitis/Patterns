package tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;
import tests.OLD.HWCase3Test;

import java.time.Duration;

public class BaseTest {
    protected static WebDriver driver;

    protected static WebDriver eventFiringWebDriver;
    private Logger logger = LogManager.getLogger(BaseTest.class);


    // Чтение передаваемого параметра browser (-Dbrowser)
    String browser = System.getProperty("browser", "chrome");
    String params = System.getProperty("params", "");
    String pageLoadStrategy = System.getProperty("loadstrategy", "NORMAL");

    // Перед каждым тестом
    @BeforeEach
    public void setUp() {
        logger.info("env = " + browser);
        driver = WebDriverFactory.getDriver(browser.toLowerCase(), params.toLowerCase(), pageLoadStrategy.toUpperCase());
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
        logger.info("Драйвер стартовал!");

        Listener listener = new Listener();
        eventFiringWebDriver = new EventFiringDecorator<>(listener).decorate(driver);
    }

    // После каждого теста
    @AfterEach
    public void setDown() {
        // Если драйвер еще существует
        if(driver != null) {
            // Закрываем его
            driver.quit();
            logger.info("Драйвер остановлен!");
        }
    }
}