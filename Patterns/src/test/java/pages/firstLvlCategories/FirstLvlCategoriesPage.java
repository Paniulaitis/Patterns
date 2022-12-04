package pages.firstLvlCategories;

import elements.Label;
import elements.Link;
import elements.ListWebElements;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.BasePage;

import java.util.List;


public class FirstLvlCategoriesPage extends BasePage {
    // Логгер
    private Logger logger = LogManager.getLogger(FirstLvlCategoriesPage.class);

    @FindBy(xpath = "//span[contains(text(),'Техника для кухни')]")
    private WebElement linkAppliancesKitchen;


    @FindBy(xpath = "//h1[@class='subcategory__page-title']")
    private WebElement labelAppliancesKitchen;

    @FindBy(xpath = "//a[@class='button-ui button-ui_white configurator-links-block__links-link']")
    private WebElement linkAssembleYourKitchen;

    @FindBy(xpath = "//div[@class='subcategory__item-container ']//span[contains(text(),'Плиты электрические')]")
    private WebElement linkEStove;

    @FindBy(xpath = "//div[@class='subcategory__item-container ']/a")
    private List<WebElement> listSubcategoryItemContainer;


    // Конструктор класса
    public FirstLvlCategoriesPage(WebDriver driver) {
        // Вызов родительского конструктора
        super(driver);
        // Инициализация веб элементов
        PageFactory.initElements(driver, this);
    }

    public Link linkAppliancesKitchen() {
        return new Link(linkAppliancesKitchen);
    }

    public Label labelAppliances() {return new Label(labelAppliancesKitchen);}

    public Link linkAssembleYourKitchen() {
        return new Link(linkAssembleYourKitchen);
    }

    public Link linkEStove() {
        return new Link(linkEStove);
    }

    public ListWebElements listSubcategoryItemContainer() {
        return new ListWebElements(listSubcategoryItemContainer);
    }
}