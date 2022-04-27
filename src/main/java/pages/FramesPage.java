package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FramesPage {
    WebDriver driver;
    private By nestedFramesLink = By.linkText("Nested Frames");
    private By bodyText = By.tagName("body");
    private String topFrame = "frame-top";
    private String leftFrame = "frame-left";
    private String  bottomFrame = "frame-bottom";

    public FramesPage(WebDriver driver){
        this.driver = driver;
    }

    public void navigateToNestedFramesLink(){
        driver.findElement(nestedFramesLink).click();
    }

    public void switchToTopFrame(){
        // switchToMainFrame();
        driver.switchTo().frame(topFrame);
    }

    public String switchToLeftFrame(){
       // switchToMainFrame();
        switchToTopFrame();
        driver.switchTo().frame(leftFrame);
        String result = getFrameText();
        switchToMainFrame();
        switchToMainFrame();
        return result;
    }

    public String switchToBottomFrame(){
        driver.switchTo().frame(bottomFrame);
        String result =  getFrameText();
        switchToMainFrame();
        return result;
    }

    private void switchToMainFrame(){
        driver.switchTo().parentFrame();
    }

    private String getFrameText(){
        return driver.findElement(bodyText).getText();
    }

}
