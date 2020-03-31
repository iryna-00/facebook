package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends Page {
    public HomePage (WebDriver webDriver){
        super(webDriver);
    }

    @FindBy(className = "_1vp5")
    private WebElement homeMenu;
    public String profileName = "";
    public String setName (){
        profileName = homeMenu.getText();
        return profileName;
    }

    @FindBy(id = "userNavigationLabel")
    private WebElement navigationMenu;
    public void clickMenu(){
        navigationMenu.click();
    }

    @FindBy(className = "_54nh")
    private WebElement logoutButton;
    public void clickLogout(){
        logoutButton.click();
    }

}
