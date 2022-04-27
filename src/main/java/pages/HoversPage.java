package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class HoversPage {
    WebDriver driver;
    By figuerBox  = By.cssSelector(".figure img");
    By boxCaption = By.className("figcaption");
    public HoversPage(WebDriver driver)
    {
        this.driver = driver;
    }

    public FigureCaption hoverOverFigure(int index){
        WebElement figure = driver.findElements(figuerBox).get(index-1);
        System.out.println(figure.getSize());
        Actions actions = new Actions(driver);
        actions.moveToElement(figure).perform();


        return new FigureCaption(figure.findElement(boxCaption));
    }

    public class FigureCaption{
        WebElement caption;
        By header = By.tagName("h5");
        By link = By.tagName("a");
        public FigureCaption(WebElement caption){
            this.caption = caption;
        }

        public boolean isCaptionDisplayed(){
            return caption.isDisplayed();
        }

        public String getTitle(){
            return caption.findElement(header).getText();
        }
        public String getLink(){
            return caption.findElement(link).getAttribute("href");
        }
        public String getLinkText(){
            return caption.findElement(link).getText();
        }
    }
}
