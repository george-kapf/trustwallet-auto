package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DashboardPage extends BasePage{

    @FindBy(xpath = "//android.widget.TextView[@resource-id='topBarWalletName']")
    private WebElement label_walletName;

    @FindBy(xpath = "//android.widget.TextView[@resource-id='mainBalance']")
    private WebElement label_MainBalance;

    public String getWalletName(){
        return getValueFromElement(label_walletName);
    }

    public boolean isBalanceSectionDisplayed(){
        return  isElementVisible(label_MainBalance);
    }
}
