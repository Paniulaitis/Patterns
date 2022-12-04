package pages;

import helpers.JavaScriptHelper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class ScreenshotMaker {
    private Logger logger = LogManager.getLogger(Screenshot.class);
    String months[] = {"Янв", "Фев", "Мар", "Апр", "Май", "Июн", "Июл", "Авг", "Сен",
            "Окт", "Ноя", "Дек"};
    String pathName = "";
    public void TakeScreenshot(WebDriver driver)
    {
        GregorianCalendar gCalendar = new GregorianCalendar();
        pathName = "temp\\" + months[gCalendar.get(Calendar.MONTH)]+ " " + gCalendar.get(Calendar.DATE) + " " +
                gCalendar.get(Calendar.HOUR) + "-" + gCalendar.get(Calendar.MINUTE) + "-" + gCalendar.get(Calendar.SECOND) + ".png";

        Long positionY = JavaScriptHelper.getPositionY();
        try {
            Screenshot screenshot = new AShot()
                    .shootingStrategy(ShootingStrategies.viewportPasting(100))
                    .takeScreenshot(driver);
            ImageIO.write(screenshot.getImage(), "png", new File(pathName));
            logger.info("Скриншот сохранен в файле " + pathName);
        } catch (IOException e) {
            e.printStackTrace();
        }

        JavaScriptHelper.scroll(0L, positionY);
    }
}
