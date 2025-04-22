package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LandingPage extends BasePage{

    @FindBy(xpath = "//android.view.View[@resource-id='CreateNewWalletButton']")
    private WebElement button_CreateNewWallet;

    @FindBy(id = "")
    private WebElement button_IAlreadyHaveAWallet;

    @FindBy(xpath = "//android.widget.TextView[@text='Create passcode']")
    private WebElement screenTitle_CreatePasscode;

    @FindBy(xpath = "//android.widget.TextView[@text='Confirm passcode']")
    private WebElement screenTitle_ConfirmPasscode;

    private WebElement getNumButton(String number){
        return driver.findElement(By.xpath("//android.widget.TextView[@text='"+number+"']"));
    }

    @FindBy(xpath = "//android.widget.TextView[@text='Deny']/following-sibling::android.widget.Button")
    private WebElement button_Deny;

    @FindBy(xpath = "//android.widget.TextView[@text='Deny']/following-sibling::android.widget.Button")
    private WebElement button_Confirm;

    @FindBy(xpath = "//android.widget.TextView[@resource-id='secondaryAction']")
    private WebElement button_SkipNotification;

    @FindBy(xpath = "//android.widget.TextView[@text=\"Skip, I'll do it later\"]")
    private  WebElement button_Skip_I_Will_Do_Later;

    @FindBy(xpath = "//android.widget.TextView[@text='Brilliant, your wallet is ready!']")
    private WebElement confirmationMessage_WalletReady;

    @FindBy(xpath = "//android.widget.TextView[@resource-id='buttonTitle' and @text='Buy Crypto']")
    private  WebElement button_BuyCrypto;

    @FindBy(xpath = "//android.widget.TextView[@resource-id='buttonTitle' and @text='Deposit Crypto']")
    private  WebElement button_DepositCrypto;

    public void click_Button_CreateNewWallet(){
        clickOnElement(button_CreateNewWallet);
    }

    public boolean isCreateNewWalletButtonDisplayed(){
        return isElementVisible(button_CreateNewWallet);
    }

    public void click_Button_IAlreadyHaveAWallet(){
        clickOnElement(button_IAlreadyHaveAWallet);
    }

    public boolean isCreatePasscodeTitleDisplayed(){
        return isElementVisible(screenTitle_CreatePasscode);
    }

    public boolean isConfirmPasscodeTitleDisplayed(){
        return isElementVisible(screenTitle_ConfirmPasscode);
    }

  public void create_Passcode(){
        clickOnElement(getNumButton("1"));
        clickOnElement(getNumButton("2"));
        clickOnElement(getNumButton("3"));
        clickOnElement(getNumButton("4"));
        clickOnElement(getNumButton("5"));
        clickOnElement(getNumButton("6"));
  }

  public void dennyBiometricLogin(){
        clickOnElement(button_Deny);
  }

    public void skipNotificationsSetting(){
        clickOnElement(button_SkipNotification);
    }

    public boolean isSkippNotificationDisplayed(){
        return isElementVisible(button_SkipNotification);
    }

    public boolean isWalletReadyConfirmationMessageDisplayed(){
        waitForTimeout(5);
        return isElementVisible(confirmationMessage_WalletReady);
    }

    public boolean isBuyCryptoButtonDisplayed(){
        return isElementVisible(button_BuyCrypto);
    }

    public boolean isDepositCryptoButtonDisplayed(){
        return isElementVisible(button_DepositCrypto);
    }

    public void clickButton_SkipIWillDoLater(){
        waitForTimeout(2);
        clickOnElement(button_Skip_I_Will_Do_Later);
    }



}
