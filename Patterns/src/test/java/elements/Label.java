package elements;

import helpers.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import pages.StartPage;

public class Label extends BaseElement {
    // Конструктор
    public Label(WebElement webElement) {
        super(webElement);
    }

    // Наведение курсора мыши
    public void focusOnLabel() {
        ActionHelper.moveToElement(webElement);
    }

    // Получение текста
    public String getText() {
        WaitHelper.visibilityOfElement(webElement);
        return webElement.getText();
    }
}
