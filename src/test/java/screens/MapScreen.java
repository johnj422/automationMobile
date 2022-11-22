package screens;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.HowToUseLocators;
import util.screens.BaseScreen;
import java.util.List;

import static io.appium.java_client.pagefactory.LocatorGroupStrategy.ALL_POSSIBLE;

/**
 * Map screen.
 *
 * @author Hans.Marquez
 */
public class MapScreen extends BaseScreen {

    /**
     * Constructor method.
     *
     * @param driver the driver
     * @author Hans.Marquez
     */
    public MapScreen(AndroidDriver<AndroidElement> driver) {
        super(driver);
    }

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceIdMatches(\".*categoryTitle\")")
    private AndroidElement categoryList;
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceIdMatches(\".*facilityTypeTitle\")")
    private List<AndroidElement> categoryListContainer;

    @AndroidFindBy(uiAutomator = "UiSelector().resourceIdMatches(\".*facilityTypeTitle\").text(\"Hotels\")")
    private AndroidElement hotelsIncluded;

    @HowToUseLocators(androidAutomation = ALL_POSSIBLE)
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceIdMatches(\".*filterTitle.*\")")
    @AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"Filter\")")
    private AndroidElement filterButton;

    @HowToUseLocators(androidAutomation = ALL_POSSIBLE)
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceIdMatches(\".*toggleTitle.*\")")
    @AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"Show List\")")
    private AndroidElement showListButton;

    /**
     * @author Hans.Marquez
     * return true if Category List element is displayed in screen, otherwise false.
     */

    public boolean categoryIsDisplayed() {
        return isElementAvailable(categoryList);
    }

    /**
     * Checks if the Category Button is displayed at the top bar, if so, taps the Category option
     * @author John Arango
     */
    public void tapCategoryButton(){
        if(categoryIsDisplayed()){
            click((categoryList));
        }
    }

    /**
     * Checks the Category List
     * @return The amount of items included in the list
     * @author John Arango
     */
    public int checkCategoryContainerSize(){
        return categoryListContainer.size();
    }

    /**
     * @return True if the Category Hotels is available, otherwise returns false
     * @author John Arango
     */
    public boolean isHotelsIncluded() {
        return isElementAvailable(hotelsIncluded);
    }

}
