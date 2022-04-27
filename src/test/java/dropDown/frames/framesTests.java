package dropDown.frames;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;

public class framesTests extends BaseTests {

    @Test
    public void testWysiwyg(){
        var editorPage = homePage.clickWysiwygEditor();
        editorPage.clearTextArea();
        String text1="Hello ";
        String text2="World";
        editorPage.setTextArea(text1);
        editorPage.decreaseIndention();
        editorPage.setTextArea(text2);

        Assert.assertEquals(editorPage.getTextFromEditor(),text1+text2,"Text form editor incorrect");

    }
}
