package forgotPassword;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ForgotPassword;

public class ForgotPasswordTest extends BaseTests {

    @Test
    public void testSuccessfulForgotPassword(){
       ForgotPassword forgotPassword = homePage.clickForgotPassword();
       forgotPassword.setEmail("tau.example.com");
       forgotPassword.clickRetrievePasswordButton();
        Assert.assertEquals(forgotPassword.getResult(),"Internal Server Error","Error Page");
    }
}
