package elements;

import helpers.JavaScriptHelper;
import org.openqa.selenium.WebElement;

import java.util.List;

// Класс "Блок"
public class Block extends BaseElement {

    // Конструктор
    public Block(WebElement webElement) {
        super(webElement);
    }

    // Скрытие блока
    public void hide() {
        JavaScriptHelper.displayNone(webElement);
    }

    public void block() {
        JavaScriptHelper.block(webElement);
    }
}