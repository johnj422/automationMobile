package tests;

import org.springframework.context.annotation.Description;
import org.testng.annotations.*;
import screens.DashBoardScreen;
import screens.MapScreen;
import screens.MenuScreen;
import util.tests.BaseMobileTest;
import org.tinylog.Logger;
import static org.hamcrest.Matchers.*;

public class NavigationTest extends BaseMobileTest {

    /**
     * Validate Map Screen Navigation.
     */
    @Description(value = "Category List Test")
    @Test(priority = 0)
    public void navigateToCategoryList() {
        Logger.info("Navigating to Category List");
        DashBoardScreen dashBoard = loadDashBoardScreen();
        MapScreen map = dashBoard.goToMapScreen();

        checkThat("Map button is displayed", dashBoard.mapButtonIsDisplayed(), is(true));
        checkThat("Category Button is displayed", map.categoryIsDisplayed(), is(true));
        Logger.info("Taping category button");
        map.clickCategoryButton();
        checkThat("CategoryList has elements", map.checkCategoryContainerSize(), not(0));
        checkThat("Hotels category is displayed", map.isHotelsIncluded(), is(true));
        Logger.info("Category List Test completed");
    }

    @Description(value = "Privacy & Legal Test")
    @Test(priority = 1)
    public void navigateToPrivacyAndLegal(){
        Logger.info("Navigating to Privacy & Legal");
        DashBoardScreen dashBoard = loadDashBoardScreen();
        MenuScreen menu = dashBoard.goToMenuScreen();
        Logger.info("Swiping down");
        menu.swipeDown();
        checkThat("My Profile option is available", menu.isMyProfileVisible(), is(true));
        checkThat("Property Rules option is available", menu.isPropertyRulesVisible(), is(true));
        checkThat("Link to Account option is available", menu.isLinkToAccountVisible(), is(true));
        checkThat("Help option is available", menu.isHelpVisible(), is(true));
        checkThat("Privacy & Legal option is available", menu.isPrivacyAndLegaVisible(), is(true));
        Logger.info("Taping Privacy & Legal");
        menu.tapPrivacyAndLegal();
        checkThat("Privacy Policy is available", menu.isPrivacyPolicyVisible(), is(true));
        checkThat("Terms of use is available", menu.isTermsOfUseVisible(), is(true));
        checkThat("Supplemental Terms and Conditions is available", menu.isSupplementalTermsVisible(), is(true));
        checkThat("Legal Notices is available", menu.isLegalNoticesVisible(), is(true));
        checkThat("Property Rules is available", menu.isPropertyRules2Visible(), is(true));
        checkThat("Electronic Communication Disclosure is available", menu.isElectronicCommVisible(), is(true));
        Logger.info("Privacy & Legal Test completed");
    }

    @Description(value = "Add Plans Option")
    @Test(priority = 2)
    public void navigateToAddPlans(){
        Logger.info("Navigating to Add Plans");
        DashBoardScreen dashBoard = loadDashBoardScreen();
        Logger.info("Taping Add Plans Option");
        dashBoard.goToAddPlans();
        checkThat("Reserve Dinning Option is available", dashBoard.isReserveOptionVisible(), is(true));
        Logger.info("Add Plans Option Test completed");
    }
}
