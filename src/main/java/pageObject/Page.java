package pageObject;


import org.openqa.selenium.WebDriver;

public class Page <T extends Page>{

    protected WebDriver webDriver;

    protected Page(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

//    explicit waits can be added
}

