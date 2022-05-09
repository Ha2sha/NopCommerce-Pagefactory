package com.nopcommerce.demo.pages;

import com.aventstack.extentreports.Status;
import com.nopcommerce.demo.customlisteners.CustomListeners;
import com.nopcommerce.demo.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends Utility {

   //By loginLink = By.linkText("Log in");
    //By registerLink = By.linkText("Register");

    //Alt+insert to add constructor
    public HomePage() {
        PageFactory.initElements(driver,this);
    }

    @FindBy(linkText = "Log in")
    WebElement loginLink;

    @FindBy(linkText = "Register")
    WebElement registerLink;

    @FindBy(xpath = "//img[@alt='nopCommerce demo store']")
    WebElement nopCommerceLogo;

    @FindBy(xpath = "//a[@class='ico-logout']")
    WebElement logoutLink;

    @FindBy(linkText = "My account")
    WebElement myAccountLink;

    @FindBy(xpath = "//ul[@class='top-menu notmobile']//a[normalize-space()='Computers']")
    WebElement computerTab;

    @FindBy(xpath = "//ul[@class='top-menu notmobile']//a[normalize-space()='Electronics']")
    WebElement electronicsTab;

    @FindBy(xpath = "//ul[@class='top-menu notmobile']//a[normalize-space()='Apparel']")
    WebElement apparelTab;

    @FindBy(xpath = "//ul[@class='top-menu notmobile']//a[normalize-space()='Digital downloads']")
    WebElement digitalDownloadsTab;

    @FindBy(xpath = "//ul[@class='top-menu notmobile']//a[normalize-space()='Books']")
    WebElement booksTab;

    @FindBy(xpath = "//ul[@class='top-menu notmobile']//a[normalize-space()='Jewelry']")
    WebElement jewelryTab;

    @FindBy(xpath = "//ul[@class='top-menu notmobile']//a[normalize-space()='Gift Cards']")
    WebElement giftCardsTab;

    public void clickOnLoginLink() {
        CustomListeners.test.log(Status.PASS,"Clicking on login link"+loginLink.toString()+"<br>");
        clickOnElement(loginLink);
    }

    public void clickOnRegisterLink() {
        CustomListeners.test.log(Status.PASS,"Clicking on register link"+registerLink.toString()+"<br>");
        clickOnElement(registerLink);
    }
    public void clickOnComputerLink() {
        CustomListeners.test.log(Status.PASS,"Clicking on computer link"+computerTab.toString()+"<br>");
        clickOnElement(computerTab);
    }

    public void clickOnElectronicsLink() {
        CustomListeners.test.log(Status.PASS,"Clicking on electronics link"+electronicsTab.toString()+"<br>");
        clickOnElement(electronicsTab);
    }

    public void clickOnApparelLink() {
        CustomListeners.test.log(Status.PASS,"Clicking on apparel link"+apparelTab.toString()+"<br>");
        clickOnElement(apparelTab);
    }
    public void clickOnDigitalDownloadsLink() {
        CustomListeners.test.log(Status.PASS,"Clicking on Digital Downloads link"+digitalDownloadsTab.toString()+"<br>");
        clickOnElement(digitalDownloadsTab);
    }

    public void clickOnBooksLink() {
        CustomListeners.test.log(Status.PASS,"Clicking on Books link"+booksTab.toString()+"<br>");
        clickOnElement(booksTab);
    }
    public void clickOnJewelryLink() {
        CustomListeners.test.log(Status.PASS,"Clicking on Jewelry link"+jewelryTab.toString()+"<br>");
        clickOnElement(jewelryTab);
    }
    public void clickOnGiftCardsLink() {
        CustomListeners.test.log(Status.PASS,"Clicking on Giftcards link"+giftCardsTab.toString()+"<br>");
        clickOnElement(giftCardsTab);
    }

    public boolean checkNopCommerceLogoVisibility(){
        CustomListeners.test.log(Status.PASS,"Verifying nopComm Logo is displayed"+nopCommerceLogo.toString()+"<br>");
        return verifyThatElementIsDisplayed(nopCommerceLogo);
    }
    public boolean checkLogoutLinkIsDisplayed(){
        CustomListeners.test.log(Status.PASS,"Checking logout link is displayed"+logoutLink.toString()+"<br>");
        return verifyThatElementIsDisplayed(logoutLink);
    }

    public void clickOnLogoutLink(){
        CustomListeners.test.log(Status.PASS,"Click on logout link "+logoutLink.toString()+"<br>");
        clickOnElement(logoutLink);
    }

    public boolean checkMyAccountLinkIsDisplayed(){
        CustomListeners.test.log(Status.PASS,"Checking My Account link is displayed"+myAccountLink.toString()+"<br>");
        return verifyThatElementIsDisplayed(myAccountLink);
    }
}
