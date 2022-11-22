package util.tests;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.tinylog.Logger;
import screens.DashBoardScreen;
import screens.TutorialScreen;
import util.ConfigCapabilities;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matcher;


import java.net.MalformedURLException;
import java.net.URL;

import static java.lang.String.format;

/**
 * Base class for Test classes.
 *
 * @author helberth.bolivar
 */
public abstract class BaseMobileTest {

    protected TutorialScreen tutorialScreen;
    public static AndroidDriver<AndroidElement> driver;

    public void setUpStartApp() {
        tutorialScreen = new TutorialScreen(getDriver());
    }

    /**
     * SetUp before to run suite of test.
     *
     * @author Arley.Bolivar
     */
    @BeforeMethod(alwaysRun = true)
    public void environmentSetUp() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        ConfigCapabilities.deviceSetUp(capabilities);
        ConfigCapabilities.applicationSetUp(capabilities);
        try {
            driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        } catch (MalformedURLException exception) {
            exception.printStackTrace();
        }
        setUpStartApp();
    }

    /**
     * Close the application after completing the test.
     *
     * @author Arley.Bolivar
     */
    @AfterMethod(alwaysRun = true)
    public void mobileApplicationEnd() {
        driver.quit();
    }

    /**
     * return the driver.
     *
     * @return driver
     * @author Arley.Bolivar
     */
    public AndroidDriver<AndroidElement> getDriver() {
        return driver;
    }

    /**
     * return SignUpOrLogInScreen after close the alerts.
     *
     * @return SignUpOrLogInScreen
     * @author Arley.Bolivar
     */
    protected DashBoardScreen loadDashBoardScreen() {
        tutorialScreen.startPermissionsProcess();
        return tutorialScreen.shareLocationPermissions();
    }

    /**
     * Takes the description of the assertion and matches the actualValue against the expectedValue
     * @param description String expressed in the assertion
     * @param actualValue Received value from the assertion
     * @param expectedValue Expected value to match with the actualValue
     * @param <T> Type of value to match
     */
    protected <T> void checkThat(String description, T actualValue, Matcher<? super T> expectedValue){
        Logger.info(format("Checking that " + description.toLowerCase() + " [Expectation: %s]", expectedValue));
        try{
            MatcherAssert.assertThat(actualValue, expectedValue);
        } catch (AssertionError e){
            Logger.error(format("Assertion Error: [%s]", e.getMessage().replaceAll("\n", "")));
        }
    }

}
