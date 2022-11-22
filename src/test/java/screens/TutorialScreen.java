package screens;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.tinylog.Logger;
import util.screens.BaseScreen;


/**
 * Object of the first screen that appears when we open the application.
 *
 * @author Arley.Bolivar
 */
public class TutorialScreen extends BaseScreen {

    /**
     * Constructor method.
     *
     * @param driver the driver
     * @author Arley.Bolivar
     */
    public TutorialScreen(AndroidDriver<AndroidElement> driver) {
        super(driver);
    }


    @AndroidFindBy(uiAutomator = "new UiSelector().resourceIdMatches(\".*permission_primary_btn\")")
    private AndroidElement getStartedButton;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceIdMatches(\".*permission_primary_btn\")")
    private AndroidElement shareLocationButton;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceIdMatches(\".*android:id/button1\")")
    private AndroidElement allowLocationButton;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceIdMatches(\".*permission_allow_foreground_only_button\")")
    private AndroidElement allowButton;

    /**
     * @author Hans.Marquez
     * Start permissions process.
     */
    public void startPermissionsProcess() {
        click(getStartedButton);
    }

    /**
     * @author Hans.Marquez
     * Share Location permissions process.
     */
    public DashBoardScreen shareLocationPermissions() {
        Logger.info("Taping shareLocationButton");
        click(shareLocationButton);
        Logger.info("Taping allowLocationButton");
        click(allowLocationButton);
        Logger.info("Taping allowButton");
        click(allowButton);
        return new DashBoardScreen(driver);
    }
}
