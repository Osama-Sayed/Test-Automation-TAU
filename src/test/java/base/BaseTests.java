package base;

import com.google.common.io.Files;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.HomePage;
import utils.WindowManager;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class BaseTests {
   private WebDriver driver;
   protected HomePage homePage;

    @BeforeClass
    public void serUp(){
        System.setProperty("webdriver.chrome.driver","resources/chromedriver.exe");
        driver = new ChromeDriver();
        //driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        goHome();
        homePage = new HomePage(driver);


       /* List<WebElement> links = driver.findElements(By.tagName("a"));
        System.out.println(links.size());
        WebElement inputLink = driver.findElement(By.xpath("//a[@href=\"/inputs\"]"));*/


        /*
        WebElement shiftingContentLink = driver.findElement(By.linkText("Shifting Content"));
        shiftingContentLink.click();

 //       driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        WebElement menuElementLink = driver.findElement(By.linkText("Example 1: Menu Element"));
        menuElementLink.click();

        //     driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);


        List<WebElement> meuaItems = driver.findElements(By.tagName("li"));
        System.out.println(meuaItems.size());
        System.out.println(driver.getTitle());

         */
    }

    @BeforeMethod
    public void goHome(){
        driver.get("https://the-internet.herokuapp.com/");
        driver.manage().window().maximize();

    }

    @AfterClass
    public void tearDown(){

        driver.quit();
    }

    public WindowManager getWindowManager(){
        return new WindowManager(driver);
    }

    @AfterMethod
    public void takeScreenShot(){
        var camera = (TakesScreenshot)driver;
        File screenshot = camera.getScreenshotAs(OutputType.FILE);
        try {
            Files.move(screenshot, new File("resources/screenshots/test.png"));
        }catch (IOException e){
            e.printStackTrace();

        }
    }

    @AfterMethod
    public void recordFailure(ITestResult result){
        if(ITestResult.FAILURE == result.getStatus()) {
            var camera = (TakesScreenshot) driver;
            File screenshot = camera.getScreenshotAs(OutputType.FILE);
            try {
                Files.move(screenshot, new File("resources/screenshots/"+result.getName()+".png"));
            } catch (IOException e) {
                e.printStackTrace();

            }
        }
    }


    public static void main(String args[]){
        BaseTests test = new BaseTests();
        test.serUp();
        test.tearDown();
    }


}
