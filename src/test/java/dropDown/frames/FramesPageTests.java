package dropDown.frames;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FramesPageTests extends BaseTests {

    @Test
    public void checkFrameText(){
        var framePage = homePage.clickFrames();
        framePage.navigateToNestedFramesLink();

        String leftFrameText = framePage.switchToLeftFrame();

        String bottomFrameText = framePage.switchToBottomFrame();

        Assert.assertEquals(leftFrameText,"LEFT","Left frame text incorrect");
        Assert.assertEquals(bottomFrameText,"BOTTOM","BOTTOM frame text incorrect");

    }
}
