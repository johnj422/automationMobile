package tests;

import org.springframework.context.annotation.Description;
import org.testng.Assert;
import org.testng.annotations.*;
import screens.DashBoardScreen;
import screens.MapScreen;
import util.tests.BaseMobileTest;
import org.tinylog.Logger;
import static org.hamcrest.Matchers.*;

public class NavigationTest extends BaseMobileTest {

    /**
     * Validate Map Screen Navigation.
     */
    @Description(value = "Map screen Navigation test")
    @Test()
    public void navigateToMapScreen() {
        Logger.info("Start Navigation to Map Screen");
        DashBoardScreen dashBoard = loadDashBoardScreen();
        MapScreen map = dashBoard.goToMapScreen();


        checkThat("Show List Button is displayed", map.showListIsDisplayed(), is(true));

        Logger.info("Validate Category Button");
        Assert.assertTrue(map.categoryIsDisplayed(), "Category not displayed");

        Logger.info("Validate Filter Button");
        Assert.assertTrue(map.filterIsDisplayed(), "Filter not displayed");
    }

}
