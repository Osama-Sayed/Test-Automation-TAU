package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AlertPage {
    WebDriver driver;
    private By triggerAlertButton = By.xpath("//button[text()=\"Click for JS Alert\"] ");
    private By triggerConformButton = By.xpath("//button[text()=\"Click for JS Confirm\"] ");
    private By triggerPromptButton = By.xpath("//button[text()=\"Click for JS Prompt\"] ");

    private By results = By.id("result");

    public AlertPage(WebDriver driver){
        this.driver = driver;
    }

    public void triggerAlert(){
        driver.findElement(triggerAlertButton).click();
    }

    public void triggerConform(){
        driver.findElement(triggerConformButton).click();
    }

    public void triggerPrompt(){
        driver.findElement(triggerPromptButton).click();
    }

    public void alert_ClickToAccept(){
        driver.switchTo().alert().accept();
    }

    public void alert_ClickToDismiss(){
        driver.switchTo().alert().dismiss();
    }

    public void alert_setInput(String input){
        driver.switchTo().alert().sendKeys(input);
    }
    public String alert_getText(){
        return  driver.switchTo().alert().getText();
    }

    public String getResults(){

        return driver.findElement(results).getText();
    }


}
