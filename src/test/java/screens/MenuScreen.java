package screens;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.MobileBy;


import io.appium.java_client.pagefactory.AndroidFindBy;
import util.screens.BaseScreen;




public class MenuScreen extends BaseScreen {
    /**
     * Constructor method for standard screens object.
     *
     * @param driver : AndroidDriver
     * @author Arley.Bolivar, Hans.Marquez
     */
    public MenuScreen(AndroidDriver<AndroidElement> driver) {
        super(driver);
    }

    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.RelativeLayout\").descriptionContains(\"My Profile\")")
    private AndroidElement myProfileOption;
    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.RelativeLayout\").descriptionContains(\"Property Rules\")")
    private AndroidElement propertyRulesOption;
    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.RelativeLayout\").descriptionContains(\"Link to Account\")")
    private AndroidElement linkToAccountOption;
    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.RelativeLayout\").descriptionContains(\"Help\")")
    private AndroidElement helpOption;
    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.RelativeLayout\").descriptionContains(\"Privacy & Legal\")")
    private AndroidElement privacyAndLegalOption;
    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.TextView\").text(\"Privacy Policy\")")
    private AndroidElement privacyPolicyOption;
    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.TextView\").text(\"Terms of Use\")")
    private AndroidElement termsOfUseOption;
    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.TextView\").textContains(\"Supplemental Terms\")")
    private AndroidElement supplementalTermsOption;
    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.TextView\").text(\"Legal Notices\")")
    private AndroidElement legalNoticesOption;
    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.TextView\").text(\"Property Rules\")")
    private AndroidElement propertyRules2Option;
    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.TextView\").textContains(\"Electronic Communication\")")
    private AndroidElement electronicCommOption;

    public void swipeDown() {
        AndroidElement swipeDown = driver.findElement(
                MobileBy.AndroidUIAutomator(
                    "new UiScrollable(new UiSelector().scrollable(true)).flingToEnd(10)"));

    }
    public boolean isMyProfileVisible() {
        return isElementAvailable(myProfileOption);
    }
    public boolean isPropertyRulesVisible() {
        return isElementAvailable(propertyRulesOption);
    }
    public boolean isLinkToAccountVisible() {
        return isElementAvailable(linkToAccountOption);
    }
    public boolean isHelpVisible() {
        return isElementAvailable(helpOption);
    }
    public boolean isPrivacyAndLegaVisible() {
        return isElementAvailable(privacyAndLegalOption);
    }
    public void tapPrivacyAndLegal() {
        isElementAvailable(privacyAndLegalOption);
        click(privacyAndLegalOption);
    }
    public boolean isPrivacyPolicyVisible() {
        return isElementAvailable(privacyPolicyOption);
    }
    public boolean isTermsOfUseVisible() {
        return isElementAvailable(termsOfUseOption);
    }
    public boolean isSupplementalTermsVisible() {
        return isElementAvailable(supplementalTermsOption);
    }
    public boolean isLegalNoticesVisible() {
        return isElementAvailable(legalNoticesOption);
    }
    public boolean isPropertyRules2Visible() {
        return isElementAvailable(propertyRules2Option);
    }
    public boolean isElectronicCommVisible() {
        return isElementAvailable(electronicCommOption);
    }
}
