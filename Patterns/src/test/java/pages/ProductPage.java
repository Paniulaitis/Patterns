package pages;

import elements.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage extends BasePage{
    // ***** Веб элементы *****
    @FindBy(xpath = "//span[@class='products-count']")
    private WebElement labelProductsCount;

    @FindBy(xpath = "//span[contains(text(), \"Сортировка:\")]/following::a")
    private WebElement accordeonSort;

    // Конструктор класса
    public ProductPage(WebDriver driver) {
        // Вызов родительского конструктора
        super(driver);
        // Инициализация веб элементов
        PageFactory.initElements(driver, this);
    }


    // ***** Получение обернутых веб элементов *****

    public Label labelProductsCount() {
        return new Label(labelProductsCount);
    }

    public Accordeon accordeonSort() {
        return new Accordeon(accordeonSort);
    }

}
