package contextMenu;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ContextMenuTest extends BaseTests {

    @Test
    public void contextAlertCheck(){
        var contextMenuPage = homePage.clickContextMenu();

        contextMenuPage.clickOnBox();
        String alertResult = contextMenuPage.alert_textResult();
        contextMenuPage.alert_accept();
        Assert.assertEquals(alertResult,"You selected a context menu","Alert Text Incorrect");
    }
}
