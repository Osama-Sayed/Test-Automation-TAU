package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class ForgotPassword {
    WebDriver driver;
    By emailField = By.id("email");
    By retrievePasswordButton = By.id("form_submit");

    public ForgotPassword(WebDriver driver)
    {
        this.driver=driver;
    }

    public void setEmail(String email){
        driver.findElement(emailField).sendKeys(email);
    }

    public void clickRetrievePasswordButton(){
        driver.findElement(retrievePasswordButton).click();
    }

    public String getResult(){
        return driver.findElement(By.tagName("h1")).getText();
    }

}
