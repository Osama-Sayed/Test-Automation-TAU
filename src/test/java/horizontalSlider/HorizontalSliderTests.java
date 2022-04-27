package horizontalSlider;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HorizontalSliderPage;

public class HorizontalSliderTests extends BaseTests {

    @Test
    public void horizontalSliderToValueOf4(){
        var horizontalSliderPage = homePage.clickHorizontalSliderPage();
        String sliderValue = horizontalSliderPage.reachSpecificRange(4);
        Assert.assertEquals(sliderValue,"4","Slider value incorrect");
    }
}
