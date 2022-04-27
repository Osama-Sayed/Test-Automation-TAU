package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ContextMenuPage {
    WebDriver driver;
    By box = By.id("hot-spot");


    public ContextMenuPage(WebDriver driver){
        this.driver = driver;
    }

    public void clickOnBox(){
        WebElement boxToClick = driver.findElement(box);
        Actions actions = new Actions(driver);
        actions.moveToElement(boxToClick).contextClick().perform();
    }

    public String alert_textResult(){
        //You selected a context menu
        return driver.switchTo().alert().getText();
    }

    public void alert_accept(){
        driver.switchTo().alert().accept();
    }

}
