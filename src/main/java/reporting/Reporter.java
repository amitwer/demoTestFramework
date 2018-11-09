package reporting;

import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Reporter {

    @Step("{s}")
    public static void log(String s){

    }


    public static void addScreenShot(WebDriver driver, String label) {
        if (driver instanceof TakesScreenshot){
            takeScreenShort((TakesScreenshot)driver,label);
        }

    }
    @Attachment(value = "Screenshot {label}", type = "image/png")
    public static byte[] takeScreenShort(TakesScreenshot driver, String label) {
        return  driver.getScreenshotAs(OutputType.BYTES);
    }
}
