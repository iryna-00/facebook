package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginSignUpPage extends Page {
    @FindBy(id = "email")
    private WebElement emailField;

    @FindBy(id = "pass")
    private WebElement passField;

    @FindBy(id = "u_0_4")
    private WebElement LoginButton;


    public LoginSignUpPage (WebDriver webDriver){
        super(webDriver);
    }



}
