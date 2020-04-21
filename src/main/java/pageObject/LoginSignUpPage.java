package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class LoginSignUpPage extends Page {
    public LoginSignUpPage (WebDriver webDriver){
        super(webDriver);
    }

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

    @FindBy(id = "u_0_m")
    private WebElement firstNameField;

    @FindBy(id = "u_0_o")
    private WebElement lastNameField;

    @FindBy(id = "u_0_r")
    private WebElement mobileOrEmailField;

    @FindBy(id = "u_0_w")
    private WebElement newPassField;

    @FindBy(id = "month")
    private WebElement selectBirthMonth;

    @FindBy(id = "day")
    private WebElement selectBirthDay;

    @FindBy(id = "year")
    private WebElement selectBirthYear;

    @FindBy(id = "u_0_6")
    private WebElement selectSexFemale;

    @FindBy(id = "u_0_7")
    private WebElement selectSexMale;

    @FindBy(id = "u_0_8")
    private WebElement selectSexCustom;

    @FindBy(id = "u_0_13")
    private WebElement SignUpButton;




    public HomePage correctLogin (String email, String pwd){
        emailField.sendKeys(email);
        passField.sendKeys(pwd);
        loginButton.click();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return PageFactory.initElements(webDriver, HomePage.class);
    }

    public LoginHelp incorrectLogin (String incorrectEmail, String incorrectPassword){
        emailField.sendKeys(incorrectEmail);
        passField.sendKeys(incorrectPassword);
        loginButton.click();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return PageFactory.initElements(webDriver, LoginHelp.class);
    }

    public HomePage correctRegistration (String firstName, String lastName, String emailRegistration, String pwdRegistration){
        firstNameField.sendKeys(firstName);
        lastNameField.sendKeys(lastName);
        mobileOrEmailField.sendKeys(getSaltString()+emailRegistration);
        newPassField.sendKeys(pwdRegistration);
        return PageFactory.initElements(webDriver, HomePage.class);
        //need to finish
    }
}
