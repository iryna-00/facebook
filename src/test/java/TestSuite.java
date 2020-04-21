import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObject.HomePage;
import pageObject.LoginHelp;

@Listeners(listener.Listener.class)
public class TestSuite extends TestBase {

    @Parameters({"email", "pwd", "correctName"})
    @Test(description = "facebook successful login")
    public void testCaseSuccessfulLogin(String email, String pwd, String correctName){
        Assert.assertEquals(webDriver.getTitle(), "Facebook - Log In or Sign Up");
        HomePage homePage = loginSignUpPage.correctLogin(email, pwd);
        new WebDriverWait(webDriver, 20).until(webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
        homePage.setName();
        Assert.assertEquals(homePage.profileName, correctName);
        homePage.clickMenu();
        homePage.clickLogout();
    }
    @Parameters({"incorrectEmail", "incorrectPassword"})
    @Test(description = "facebook login failed")
    public void testCaseIncorrectLogin(String incorrectEmail, String incorrectPassword){
        Assert.assertEquals(webDriver.getTitle(), "Facebook - Log In or Sign Up");
        LoginHelp loginHelp = loginSignUpPage.incorrectLogin(incorrectEmail, incorrectPassword);
        new WebDriverWait(webDriver, 20).until(webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
        Assert.assertEquals(webDriver.getTitle(), "Log into Facebook | Facebook");
    }

    @Parameters({"firstName", "lastName", "emailRegistration", "pwdRegistration"})
    @Test(description = "facebook successful registration")
    public void testCaseSuccessfulRegistration(String firstName, String lastName, String emailRegistration, String pwdRegistration){
        Assert.assertEquals(webDriver.getTitle(), "Facebook - Log In or Sign Up");
        HomePage homePage = loginSignUpPage.correctRegistration(firstName, lastName, emailRegistration, pwdRegistration);
        new WebDriverWait(webDriver, 20).until(webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));

    }
}
