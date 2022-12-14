package tests.laptops;

import helpers.JavaScriptHelper;
import helpers.WaitHelper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import pages.*;
import pages.laptops.LaptopsPage;
import pages.laptops.LaptopsProductPage;
import tests.BaseTest;
import tests.laptops.matchers.LaptopProductPageMatcher;


public class HW3Case3Test extends BaseTest {

    ScreenshotMaker screenshotMaker = new ScreenshotMaker();

    @Test
    public void dnsTest() {
        // 1. Arrange
        String company = "ASUS"; // производитель
        String ram = "32 ГБ"; // объем ОП

        // 2. Act
        LaptopsProductPage laptopsProductPage = getProductPage(company, ram);

        // 3. Assert
        // Проверка заголовка открытой страницы
        LaptopProductPageMatcher laptopProductPageMatcher = new LaptopProductPageMatcher(laptopsProductPage);
        laptopProductPageMatcher.pageTitleEquals(company);
        laptopProductPageMatcher.pageManufacturerEquals(company);//название не соответствует названию на предыдущей странице, так что тут company
        laptopProductPageMatcher.pageRamEquals(ram);
    }

    // Получение заголовка страницы с продуктом
    public LaptopsProductPage getProductPage(String company, String ram) {

        // ***** Стартовая страница сайта DNS *****
        StartPage startPage = new StartPage(eventFiringWebDriver);
        // Открыть страницу https://www.dns-shop.ru/
        startPage.openPage();
        screenshotMaker.TakeScreenshot(driver);
        // Наведение курсора мыши на ссылку "ПК, ноутбуки, периферия"
        startPage.linkPCLaptopsPeripherals().focusOnLink();
        screenshotMaker.TakeScreenshot(driver);
        // Нажатие на ссылку "Ноутбуки"
        startPage.linkLaptops().click();
        screenshotMaker.TakeScreenshot(driver);


        // ***** Страница "Ноутбуки" *****
        LaptopsPage laptopsPage = new LaptopsPage(eventFiringWebDriver);
        //Скрыть блок страницы
        laptopsPage.blockHeader().hide();
        screenshotMaker.TakeScreenshot(driver);
        // Прокрутка страницы вниз
        JavaScriptHelper.scrollBy(0, 600);
        // Установка фильтра "Производитель"
        laptopsPage.checkboxCompany(company).setChecked(true);
        // Прокрутка страницы вниз
        JavaScriptHelper.scrollBy(0, 400);
        // Отображение фильтра "Объем оперативной памяти"
        laptopsPage.accordeonRAM().show();
        // Прокрутка страницы вниз
        JavaScriptHelper.scrollBy(0, 400);
        // Установка фильтра "Объем оперативной памяти"
        laptopsPage.checkboxRAM(ram).setChecked(true);
        // Прокрутка страницы вниз
        JavaScriptHelper.scrollBy(0, 600);
        // Нажатие на кнопку "Применить"
        laptopsPage.buttonApply().click();
        screenshotMaker.TakeScreenshot(driver);
        // Прокрутка страницы вверх
        JavaScriptHelper.scrollBy(0, -2000);
        // Отображение сортировки
        laptopsPage.accordeonSort().show();
        // Установка сортировки "Сначала дорогие"
        String type = "Сначала дорогие";
        laptopsPage.radiobuttonSort(type).setSelected(true);
        // Ожидание
        WaitHelper.firstProductMustBe(By.xpath("//div[@class='catalog-products view-simple']//div[1]"), "ASUS");
        screenshotMaker.TakeScreenshot(driver);
        // Нажатие на ссылку первого продукта в списке
        laptopsPage.linkFirstProduct().openInNewWindow();
        screenshotMaker.TakeScreenshot(driver);

        // ***** Страница "Продукт. Ноутбуки" *****
        LaptopsProductPage laptopsProductPage = new LaptopsProductPage(driver);
        //Открыть характеристики
        laptopsProductPage.accordeonСharacteristics().show();
        screenshotMaker.TakeScreenshot(driver);
        // ***** Страница "Продукт. Ноутбуки" *****
        return new LaptopsProductPage(eventFiringWebDriver);
    }
}