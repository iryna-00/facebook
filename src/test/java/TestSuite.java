import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObject.HomePage;

@Listeners(listener.Listener.class)
public class TestSuite extends TestBase {

    @Parameters({"email", "pwd"})
    @Test(description = "facebook login page example")
    public void testCaseSuccessfulLogin(String email, String pwd){
        Assert.assertEquals(webDriver.getTitle(), "Facebook - Log In or Sign Up");
        HomePage homePage = loginSignUpPage.correctLogin(email, pwd);
        new WebDriverWait(webDriver, 20).until(webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
        Assert.assertEquals(homePage.menuText, "Home");
    }
}
