package pages.laptops;

        import elements.Accordeon;
        import elements.Label;
        import org.apache.logging.log4j.LogManager;
        import org.apache.logging.log4j.Logger;
        import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.WebElement;
        import org.openqa.selenium.support.FindBy;
        import org.openqa.selenium.support.PageFactory;
        import pages.BasePage;


public class LaptopsProductPage extends BasePage {
    // Логгер
    private Logger logger = LogManager.getLogger(LaptopsProductPage.class);

    @FindBy(xpath = "//button[@class='button-ui button-ui_white product-characteristics__expand']")
    private WebElement accordeonСharacteristics;

    @FindBy(xpath = "//div[@class='product-characteristics__spec-title'][contains(text(),' Объем оперативной памяти ')]/following-sibling::div[@class='product-characteristics__spec-value']")
    private WebElement labelRam;

    @FindBy(xpath = "//div[@class='product-card-description__title']")
    private WebElement labelСharacteristicsHeader;

    // Конструктор класса
    public LaptopsProductPage(WebDriver driver) {
        // Вызов родительского конструктора
        super(driver);
        // Инициализация веб элементов
        PageFactory.initElements(driver, this);
    }

    public Accordeon accordeonСharacteristics() {
        return new Accordeon(accordeonСharacteristics);
    }

    public Label labelRam() {
        return new Label(labelRam);
    }

    public Label labelСharacteristicsHeader() {
        return new Label(labelСharacteristicsHeader);
    }
}
