package elements;

import helpers.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.StartPage;

// Класс "Ссылка"
public class Link extends BaseElement {


    // Конструктор
    public Link(WebElement webElement) {
        super(webElement);
    }

    // Нажатие на ссылку
    public void click() {
        // Ожидание кликабельности ссылки
        WaitHelper.clickabilityOfElement(webElement);
        webElement.click();
    }

    // Нажатие на ссылку после перезагрузки страницы
    public void click(WebDriver driver) {
        // Ожидание кликабельности ссылки
        WaitHelper.ignoringExceptionClickabilityOfElement(webElement, driver);
        webElement.click();
    }

    // Наведение курсора мыши на ссылку
    public void focusOnLink() {
        ActionHelper.moveToElement(webElement);
    }

    // Наведение на ссылку после перезагрузки страницы
    public void focusOnLink(WebDriver driver) {
        WaitHelper.ignoringExceptionClickabilityOfElement(webElement, driver);
        ActionHelper.moveToElement(webElement);
    }

    // Открытие ссылки в новом окне
    public void openInNewWindow() {
        // Получение URL ссылки
        String URL = this.getURL();
        // Создание нового окна и переключение на него
        SwitchHelper.switchToNewWindow();
        // Максимизация размеров окна
        WindowHelper.maximizeWindow();
        // Переход по ссылке в новом окне
        NavigationHelper.navigateTo(URL);
    }

    // Получение URL ссылки
    public String getURL() {
        return webElement.getAttribute("href");
    }

    // Получение текста ссылки
    public String getText() {
        return webElement.getText();
    }
}