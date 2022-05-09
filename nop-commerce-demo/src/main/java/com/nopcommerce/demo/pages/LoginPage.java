package com.nopcommerce.demo.pages;

import com.aventstack.extentreports.Status;
import com.nopcommerce.demo.customlisteners.CustomListeners;
import com.nopcommerce.demo.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPage extends Utility {

    public LoginPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//h1[contains(text(),'Welcome, Please Sign In!')]")
    WebElement welcomeText;

    @FindBy(id = "Email")
    WebElement emailField;
    @FindBy(name = "Password")
    WebElement passwordField;

    @FindBy(xpath = "//button[contains(text(),'Log in')]")
    WebElement loginButton;

    @FindBy(xpath = "//div[@class='message-error validation-summary-errors']")
    WebElement errorMessage;

    public String getWelcomeText() {
        CustomListeners.test.log(Status.PASS,"Getting Welcome Text"+welcomeText.toString()+"<br>");
        return getTextFromElement(welcomeText);
    }

    public void enterEmailId(String email) {
        CustomListeners.test.log(Status.PASS,"Entering email"+emailField.toString()+"<br>");
        sendTextToElement(emailField, email);
    }

    public void enterPassword(String password) {
        CustomListeners.test.log(Status.PASS,"Entering password"+passwordField.toString()+"<br>");
        sendTextToElement(passwordField, password);
    }

    public void clickOnLoginButton() {
        CustomListeners.test.log(Status.PASS,"Click on login button"+loginButton.toString()+"<br>");
        clickOnElement(loginButton);
    }

    public String getErrorMessage() {
        CustomListeners.test.log(Status.PASS,"Get text from error msg"+errorMessage.toString()+"<br>");
        return getTextFromElement(errorMessage);
    }




}
