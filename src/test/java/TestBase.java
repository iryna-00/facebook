import consts.Constants;
import driver.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import pageObject.LoginSignUpPage;

import java.util.Random;

public class TestBase {

    protected WebDriver webDriver;
    protected LoginSignUpPage loginSignUpPage;

    @Parameters({"browserName"})
    @BeforeMethod(alwaysRun = true)

    public void setup(String browserName) {
        WebDriverFactory.initDriver(browserName);
        webDriver = WebDriverFactory.getDriver();
        navigateTo(Constants.Application.BASE_URL);
        WebDriverWait wait = new WebDriverWait(webDriver, 20);
        loginSignUpPage = PageFactory.initElements(webDriver, LoginSignUpPage.class);
    }


    protected void navigateTo(String URL){
        webDriver.get(URL);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(){
        WebDriverFactory.quitDriver();
    }


}
