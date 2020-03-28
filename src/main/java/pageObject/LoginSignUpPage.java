package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class LoginSignUpPage extends Page {
    @FindBy(className = "fb_logo img sp_3UHi6Z3AUhD sx_6c0194")
    private WebElement logo;

    @FindBy(id = "email")
    private WebElement emailField;

    @FindBy(id = "pass")
    private WebElement passField;

    @FindBy(xpath = "//*[@id = 'u_0_b']")
    private WebElement loginButton;

    @FindBy(linkText = "Forgot account?")
    private WebElement passwordReset;


    public LoginSignUpPage (WebDriver webDriver){
        super(webDriver);
    }

    public HomePage correctLogin (String email, String pwd){
        emailField.sendKeys(email);
        passField.sendKeys(pwd);
        loginButton.click();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return PageFactory.initElements(webDriver, HomePage.class);
    }



}
