package pageObject;


import org.openqa.selenium.WebDriver;

import java.util.Random;

public class Page <T extends Page>{

    protected WebDriver webDriver;

    protected Page(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    protected String getSaltString() {
        String SALTCHARS = "abcdefghijklmnopqrstuvwxyz";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 10) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr;
    }
    //    explicit waits can be added
}

