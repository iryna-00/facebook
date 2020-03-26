import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

@Listeners(listener.Listener.class)
public class TestSuite extends TestBase {

    @Test(description = "facebook login page example")
    public void testCaseExample(){
        Assert.assertEquals(webDriver.getTitle(), "Facebook - Log In or Sign Up");

    }
}
