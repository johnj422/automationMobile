package screens;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.HowToUseLocators;
import org.tinylog.Logger;
import util.screens.BaseScreen;

import static io.appium.java_client.pagefactory.LocatorGroupStrategy.ALL_POSSIBLE;

/**
 * DashBoard screen.
 *
 * @author Hans.Marquez
 */
public class DashBoardScreen extends BaseScreen {

    /**
     * Constructor method.
     *
     * @param driver : AndroidDriver
     * @author Hans.Marquez
     */
    public DashBoardScreen(AndroidDriver<AndroidElement> driver) {
        super(driver);
    }

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceIdMatches(\".*android:id/button2\")")
    private AndroidElement dismissPreferenceUpdateButton;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"dismiss-icon\")")
    private AndroidElement dismissWelcome;

    @HowToUseLocators(androidAutomation = ALL_POSSIBLE)
    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.ImageView\").descriptionContains(\"Map\")")
    private AndroidElement mapButton;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceIdMatches(\"com.disney.wdpro.dlr:id/tab_icon\").descriptionContains(\"More\")")
    private AndroidElement menuButton;

    public void tapingInitialButtons() {
        Logger.info("Taping dismissWelcome");
        if (this.isElementAvailable(dismissWelcome, 25)){
            click(dismissWelcome);
        }
        Logger.info("Taping dismissPreferenceUpdate");
        if (this.isElementAvailable(dismissPreferenceUpdateButton, 25)){
            click(dismissPreferenceUpdateButton);
        }
    }

    /**
     * @author Hans.Marquez
     * Navigate to Login Screen from DashBoard Screen.
     */
    public MapScreen goToMapScreen() {

        tapingInitialButtons();

        Logger.info("Taping mapButton");
        if (this.isElementAvailable(mapButton)){
            click(mapButton);
        }
        return new MapScreen(driver);
    }

    public boolean mapButtonIsDisplayed() {
        return isElementAvailable(mapButton);
    }

    public MenuScreen goToMenuScreen(){

        tapingInitialButtons();

        Logger.info("Taping menuButton");
        if (this.isElementAvailable(menuButton)){
            click(menuButton);
        }
        return new MenuScreen(driver);
    }
}
