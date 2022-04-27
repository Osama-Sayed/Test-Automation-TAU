package hover;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class HoverTests extends BaseTests {
    @Test
    public  void testHoverUser1(){
        SoftAssert softAssert = new SoftAssert();
        var hoversPage = homePage.clickHovers();
        var caption = hoversPage.hoverOverFigure(1);
        softAssert.assertTrue(caption.isCaptionDisplayed(),"Caption not Displayed");
        softAssert.assertEquals(caption.getTitle(),"name: user1","Caption title incorrect");
        //Assert.assertEquals(caption.getLink(),"https://the-internet.herokuapp.com/users/1","Caption Link incorrect");
        softAssert.assertEquals(caption.getLinkText(),"View profile","Caption Link Text incorrect");
        softAssert.assertTrue(caption.getLink().endsWith("/users/1"),"Caption Link incorrect");
        softAssert.assertAll();
    }
}
