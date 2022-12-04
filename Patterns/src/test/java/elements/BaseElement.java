package elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.EventFiringDecorator;
import tests.Listener;

import java.util.List;

public class BaseElement {
    // Веб элемент
    protected WebElement webElement;

    // Конструктор класса
    public BaseElement(WebElement webElement) {
        this.webElement = webElement;
    }

    // Получение оборачиваемого веб элемента
    // Получив оборачиваемый веб элемент, можно вызвать его методы
    // Например, getText()
    public WebElement getWebElement() {
        return webElement;
    }
}