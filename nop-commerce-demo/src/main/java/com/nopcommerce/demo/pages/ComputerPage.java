package com.nopcommerce.demo.pages;

import com.aventstack.extentreports.Status;
import com.nopcommerce.demo.customlisteners.CustomListeners;
import com.nopcommerce.demo.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class ComputerPage extends Utility {

   //By loginLink = By.linkText("Log in");
    //By registerLink = By.linkText("Register");

    //Alt+insert to add constructor
    public ComputerPage() {
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//h2[@class='title']/a[@href='/desktops']")
    WebElement desktopLink;
    @FindBy(xpath = "//h1[contains(text(),'Desktop')]")
    WebElement deskTopText;
    @FindBy(xpath = "//h1[contains(text(),'Computers')]")
    WebElement computerText;
    @FindBy(xpath = "//h2[@class='title']/a[@href='/notebooks']")
    WebElement notebooksLink;
    @FindBy(xpath = "//h2[@class='title']/a[@href='/software']")
    WebElement softwareLink;

    public String getComputerNavigationText() {
        //Reporter.log("Navigate to computer page and verify navigated page welcome text " + computerText.toString() + "<br>"); for testNG report
        CustomListeners.test.log(Status.PASS, "Navigate to computer page and verify navigated page welcome text "+computerText.toString()+"<br>");
        return computerText.getText();

    }
    public String getDesktopNavigationText() {
       CustomListeners.test.log(Status.PASS,"Navigate to Desktop page and verify navigated page welcome text " + deskTopText.toString() + "<br>");
        return deskTopText.getText();
    }

    public void clickOnDesktop() {
        CustomListeners.test.log(Status.PASS,"Click on desktop option "+desktopLink.toString()+"<br>");
        mouseHoverToElementAndClick(desktopLink);
            }
    public void clickOnNotebooks() {
        CustomListeners.test.log(Status.PASS,"Click on desktop option "+notebooksLink.toString()+"<br>");
        mouseHoverToElementAndClick(notebooksLink);
    }
    public void clickOnSoftware() {
        CustomListeners.test.log(Status.PASS,"Click on desktop option "+softwareLink.toString()+"<br>");
        mouseHoverToElementAndClick(softwareLink);
    }
}
