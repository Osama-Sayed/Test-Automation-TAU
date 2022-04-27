package alerts;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AlertsTests extends BaseTests {
    @Test
    public void testAcceptAlert() {
        var alertsPage = homePage.clickJavaScriptAlerts();
        alertsPage.triggerAlert();
        alertsPage.alert_ClickToAccept();
        Assert.assertEquals(alertsPage.getResults(),"You successfully clicked an alert","Result Text incorrect");
    }

    @Test
    public void testGetTextFromAlert(){
        var alertPage = homePage.clickJavaScriptAlerts();
        alertPage.triggerConform();
        String text = alertPage.alert_getText();
        alertPage.alert_ClickToDismiss();
        Assert.assertEquals(alertPage.getResults(),"You clicked: Cancel","Result Text incorrect");
    }

    @Test
    public void testSetInputInAlert(){
        var alertPage = homePage.clickJavaScriptAlerts();
        String input = "TAU rocks!";
        alertPage.triggerPrompt();
        alertPage.alert_setInput(input);
        alertPage.alert_ClickToAccept();
        Assert.assertEquals(alertPage.getResults(),"You entered: "+input,"Result Text incorrect");

    }
}
