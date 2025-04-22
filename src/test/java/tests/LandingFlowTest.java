package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.DashboardPage;
import pages.LandingPage;

public class LandingFlowTest extends BaseTest{
    LandingPage landingPage;
    DashboardPage dashboardPage;
    @BeforeMethod
    public void initializeBrowser(){
        if(landingPage == null){
            landingPage = new LandingPage();
        }
        if (dashboardPage == null){
            dashboardPage = new DashboardPage();
        }
    }

    @Test(priority = 0, description = "TC-001 Verify user is able to install new build & navigate to landing page")
    public void verifyAppInstallation(){
        Assert.assertTrue(landingPage.isCreateNewWalletButtonDisplayed(),"Verify Create New Wallet button visibility");
    }

    @Test(priority = 1,description = "TC-002 Verify user is able to navigate to 'Create Passcode' screen by clicking 'Create New Wallet' button")
    public void verifyNavigationToCreatePasscodeScreen(){
        landingPage.click_Button_CreateNewWallet();
        Assert.assertTrue(landingPage.isCreatePasscodeTitleDisplayed(),"Check Visibility of Create Passcode screen");
    }

    @Test(priority = 3,description = "TC-003 Verify user is able to navigate to 'Confirm Passcode' screen by filling 6 digit passcode")
    public void verifyNavigationToConfirmPasscodeScreen(){
        landingPage.create_Passcode();
        Assert.assertTrue(landingPage.isConfirmPasscodeTitleDisplayed(),"Check Visibility of Confirm Passcode screen");
    }

    @Test(priority = 4,description = "TC-004 Verify user is able to navigate to 'Enable Notification' setting screen by confirming passcode")
    public void verifyNavigationToEnableNotificationScreen(){
        landingPage.create_Passcode();
        landingPage.dennyBiometricLogin();
       Assert.assertTrue(landingPage.isSkippNotificationDisplayed(),"Check Visibility of Enable Notification setting screen");
    }

    @Test(priority = 5,description = "TC-005 Verify user is able to create wallet successfully after skipping Notification setting")
    public void verifyNavigationToWelcomeScreen(){
        landingPage.skipNotificationsSetting();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(landingPage.isWalletReadyConfirmationMessageDisplayed(),"Check visibility of wallet ready message");
        softAssert.assertTrue(landingPage.isBuyCryptoButtonDisplayed(),"Check visibility of Buy Crypto Button");
        softAssert.assertTrue(landingPage.isDepositCryptoButtonDisplayed(),"Check visibility of Deposit Crypto Button");
        softAssert.assertAll();
    }

    @Test(priority = 6,description = "TC-006 Verify user is able to navigate to user dashboard screen after successfully completion of all actions")
    public void verifyNavigationDashboardScreen(){
        landingPage.clickButton_SkipIWillDoLater();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(dashboardPage.getWalletName(),"Main Wallet 1","Check wallet name");
        softAssert.assertTrue(dashboardPage.isBalanceSectionDisplayed(),"Check visibility of Balance label");
        softAssert.assertAll();
    }


}
