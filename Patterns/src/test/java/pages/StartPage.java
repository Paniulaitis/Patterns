package pages;

import elements.Button;
import elements.Link;
import elements.Block;
import elements.ListWebElements;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

// Стартовая страница сайта DNS
public class StartPage extends BasePage {
    // Логгер
    private Logger logger = LogManager.getLogger(StartPage.class);
    // URL страницы
    private final String URL = "https://www.dns-shop.ru/";

    // ***** Веб элементы *****
    // Кнопка "Всё верно" на всплывашке
    @FindBy(xpath = "(//span[text()=\"Всё верно\"]/parent::button)[1]")
    private WebElement buttonYes;
    //
    @FindBy(xpath = "//div[@class='v-confirm-city']")
    private WebElement blockYes;

    @FindBy(xpath = "//div[@class='menu-desktop__submenu menu-desktop__submenu_top']")
    private WebElement blockSubmenu;
    //
    @FindBy(xpath = "(//a[contains(text(), \"ПК, ноутбуки, периферия\")])[1]")
    private WebElement linkPCLaptopsPeripherals;
    //
    @FindBy(xpath = "(//a[@class='ui-link menu-desktop__second-level'][contains(text(), 'Ноутбуки')])")
    private WebElement linkLaptops;
    //
    @FindBy(xpath = "//div[@class='menu-desktop']//a[contains(text(),'Бытовая техника')]")
    private WebElement linkAppliances;

    @FindBy(xpath = "//div[@class='menu-desktop__submenu menu-desktop__submenu_top']//a[@class='ui-link menu-desktop__first-level']")
    private List<WebElement> listAppliancesFirsLvl;

    @FindBy(xpath = "//a[@class='ui-link menu-desktop__second-level'][contains(text(),'Приготовление напитков')]//a")
    private List<WebElement> listCookingDrinks;

    @FindBy(xpath = "//div[@class='menu-desktop__second-level-wrap']//a[contains(text(),'Плиты и печи')]")
    private WebElement linkStoveAndOvens;

    @FindBy(xpath = "//div[@class='menu-desktop__second-level-wrap']//a[contains(text(),'Приготовление напитков')]")
    private WebElement linkCookingDrinks;

    @FindBy(xpath = "//a[@class='ui-link menu-desktop__second-level'][contains(text(),'Приготовление напитков')]/span[@class='menu-desktop__popup']")
    private WebElement blockCookingDrinksSecondLvl;

    // Конструктор класса
    public StartPage(WebDriver driver) {
        // Вызов родительского конструктора
        super(driver);

        // Инициализация веб элементов
        PageFactory.initElements(driver, this);
    }

    // Получение URL страницы
    public String getURL() {
        return this.URL;
    }

    // Открытие страницы
    public void openPage() {
        driver.get(this.URL);
        logger.info("Открыта страница https://www.dns-shop.ru/");
    }

    // ***** Получение обернутых веб элементов *****

    public Button buttonYes() {
        return new Button(buttonYes);
    }

    public Block blockSubmenu() {
        return new Block(blockSubmenu);
    }

    public Link linkPCLaptopsPeripherals() {
        return new Link(linkPCLaptopsPeripherals);
    }

    public Link linkLaptops() {
        return new Link(linkLaptops);
    }

    public Link linkAppliances() {
        return new Link(linkAppliances);
    }

    public Block blockYes() {return new Block(blockYes);}

    public ListWebElements listAppliancesFirsLvl() {return new ListWebElements(listAppliancesFirsLvl);}

    public ListWebElements listCookingDrinks() {return new ListWebElements(listCookingDrinks);}

    public Link linkCookingDrinks() {return new Link(linkCookingDrinks);}

    public Link linkStoveAndOvens() {return new Link(linkStoveAndOvens);}

    public Block blockCookingDrinksSecondLvl() {
        return new Block(blockCookingDrinksSecondLvl);
    }
}