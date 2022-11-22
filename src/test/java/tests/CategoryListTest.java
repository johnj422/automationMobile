package tests;

import org.springframework.context.annotation.Description;
import org.testng.annotations.*;
import screens.DashBoardScreen;
import screens.MapScreen;
import screens.MenuScreen;
import util.tests.BaseMobileTest;
import org.tinylog.Logger;
import static org.hamcrest.Matchers.*;

public class CategoryListTest extends BaseMobileTest {

    /**
     * Validate Map Screen Navigation.
     */
    @Description(value = "Category List Test")
    @Test
    public void navigateToMapScreen() {
        Logger.info("Start Navigation to Map Screen");
        DashBoardScreen dashBoard = loadDashBoardScreen();
        MapScreen map = dashBoard.goToMapScreen();

        checkThat("Map button is displayed", dashBoard.mapButtonIsDisplayed(), is(true));
        checkThat("Validate Category Button is displayed", map.categoryIsDisplayed(), is(true));
        Logger.info("Taping category button");
        map.clickCategoryButton();
        checkThat("Validate CategoryList has elements", map.checkCategoryContainerSize(), not(0));
        checkThat("Validate Hotels category is displayed", map.isHotelsIncluded(), is(true));
        Logger.info("Category List Test completed");
    }

    @Test
    public void privacyAndPolicyTest(){
        Logger.info("Starting privacy and policy");
        DashBoardScreen dashBoard = loadDashBoardScreen();
        MenuScreen menu = dashBoard.goToMenuScreen();
    }
}
