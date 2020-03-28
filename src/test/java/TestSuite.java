import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObject.HomePage;

@Listeners(listener.Listener.class)
public class TestSuite extends TestBase {

    @Parameters({"email", "pwd"})
    @Test(description = "facebook login page example")
    public void testCaseLogin(String email, String pwd){
        Assert.assertEquals(webDriver.getTitle(), "Facebook - Log In or Sign Up");
        HomePage homePage = loginSignUpPage.correctLogin(email, pwd);
        homePage.clickLink();

    }
}
