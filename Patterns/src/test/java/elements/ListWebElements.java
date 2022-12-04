package elements;

import org.openqa.selenium.WebElement;

import java.util.List;

public class ListWebElements {

    protected List<WebElement> listWebElements;

    public ListWebElements(List<WebElement> listWebElements) {
        this.listWebElements = listWebElements;
    }

    public List<WebElement> getListWebElements() {
        return listWebElements;
    }
}
