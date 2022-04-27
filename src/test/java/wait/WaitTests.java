package wait;

import base.BaseTests;
import org.checkerframework.checker.units.qual.A;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WaitTests extends BaseTests {

    @Test
    public void testWaitUntilHidden(){
        var loadingPage = homePage.clickDynamicLoading().clickDynamicLoadingExample1();
        loadingPage.clickStart();
        Assert.assertEquals(loadingPage.getLoadedText(),"Hello World!","Loaded Text Incorrect");
    }
}
