package keys;

import base.BaseTests;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

public class keysTests extends BaseTests {
    @Test
    public void testBackSpace(){
        var keyPage = homePage.clickKeypresses();
        keyPage.enterText("A"+ Keys.BACK_SPACE);
        Assert.assertEquals(keyPage.getResult(),"You entered: BACK_SPACE","Text Incorrect");
    }

    @Test
    public void testPi(){
        var keyPage =homePage.clickKeypresses();
        keyPage.enterPi();
    }
}
