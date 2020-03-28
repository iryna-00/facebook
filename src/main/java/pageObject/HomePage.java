package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends Page {
    public HomePage (WebDriver webDriver){
        super(webDriver);
    }

    @FindBy(className = "_2s25")
    private WebElement homeMenu;
    public String menuText = homeMenu.getText();



}
