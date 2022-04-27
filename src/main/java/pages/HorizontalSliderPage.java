package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static java.lang.Integer.parseInt;

public class HorizontalSliderPage {

    WebDriver driver;
    private By rangeValueText = By.id("range");
    private By rangeBar = By.tagName("input");

    public HorizontalSliderPage(WebDriver driver){
        this.driver=driver;
    }

    public String reachSpecificRange(float index){
        WebElement  rangeValueTextValue = driver.findElement(rangeValueText);
        WebElement rangeBarValue = driver.findElement(rangeBar);
        while(Float.parseFloat(rangeValueTextValue.getText()) < 5){
            if(index == 0)
                break;

            rangeBarValue.sendKeys(Keys.ARROW_RIGHT);

            if(Float.parseFloat(rangeValueTextValue.getText())==index)
                break;
        }
        return rangeValueTextValue.getText();
    }
}
