package com.nopcommerce.demo.pages;

import com.aventstack.extentreports.Status;
import com.nopcommerce.demo.customlisteners.CustomListeners;
import com.nopcommerce.demo.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;


public class RegisterPage extends Utility {

    public RegisterPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//h1[contains(text(),'Register')]")
    WebElement registerText;
    @FindBy(xpath = "//input[@id='gender-female']")
    WebElement femaleRadioButton;
    @FindBy(xpath = "//input[@id='FirstName']")
    WebElement firstNameField;
    @FindBy(xpath = "//input[@id='LastName']")
    WebElement lastNameField;
    @FindBy(xpath ="//select[@name='DateOfBirthDay']")
    WebElement day;
    @FindBy(xpath = "//select[@name='DateOfBirthMonth']")
    WebElement month;
    @FindBy(xpath ="//select[@name='DateOfBirthYear']")
    WebElement year;
    @FindBy(xpath = "//input[@id='Email']")
    WebElement emailField;
    @FindBy(xpath = "//input[@id='Password']")
    WebElement passwordField;
    @FindBy(xpath = "//input[@id='ConfirmPassword']")
    WebElement confirmPasswordField;
    @FindBy(xpath = "//button[@id='register-button']")
    WebElement registerButton;
    @FindBy(xpath = "//span[@id='FirstName-error']")
    WebElement firstnameErrorMessage;
    @FindBy(xpath = "//span[@id='LastName-error']")
    WebElement lastNameErrorMessage;
    @FindBy(xpath = "//span[@id='Email-error']")
    WebElement emailErrorMessage;
    @FindBy(xpath = "//span[@id='Password-error']")
    WebElement passwordErrorMessage;
    @FindBy(xpath = "//span[@id='ConfirmPassword-error']")
    WebElement confirmPasswordErrorMessage;
    @FindBy(xpath = "//div[contains(text(),'Your registration completed')]")
    WebElement registrationCompleteText;


    public String geRegisterText() {
        CustomListeners.test.log(Status.PASS,"Navigate to register page and verify navigated page welcome text " + registerText.toString() + "<br>");
        return registerText.getText();
    }
    public void clickOnFemaleRadioButton(){
        CustomListeners.test.log(Status.PASS,"Clicking female Radio Button : " + femaleRadioButton.toString() + "<br>");
        clickOnElement(femaleRadioButton);
    }
    public void enterFirstName(String firstName) {
        CustomListeners.test.log(Status.PASS,"Entering first name : " + firstName + " to first name field : " + firstNameField.toString() + "<br>");
        sendTextToElement(firstNameField, firstName);
    }

    public void enterLastName(String lastName) {
        CustomListeners.test.log(Status.PASS,"Entering last name : " + lastName + " to last name field : " + lastNameField.toString() + "<br>");
        sendTextToElement(lastNameField, lastName);
    }
    public void selectDay(String day1) {
        CustomListeners.test.log(Status.PASS,"Selecting day : " + day.toString() + "<br>");
        selectByValueFromDropDown(day, day1);
    }
    public void selectMonth(String month1) {
        CustomListeners.test.log(Status.PASS,"Selecting Month : " + month.toString() + "<br>");
        selectByValueFromDropDown(month, month1);
    }
    public void selectYear(String year1) {
        CustomListeners.test.log(Status.PASS,"Selecting Year : " + year.toString() + "<br>");
        selectByValueFromDropDown(year, year1);
    }

    public void enterEmail(String userName) {
        CustomListeners.test.log(Status.PASS,"Entering email address : " + userName + " to email field : " + emailField.toString() + "<br>");
        sendTextToElement(emailField, userName);
    }

    public void enterPassword(String password) {
        CustomListeners.test.log(Status.PASS,"Entering password : " + password + " to password field : " + passwordField.toString() + "<br>");
        sendTextToElement(passwordField, password);
    }

    public void enterConfirmPassword(String confirmPassword) {
        CustomListeners.test.log(Status.PASS,"Entering confirm password : " + confirmPassword + " to confirm password field : " + confirmPasswordField.toString() + "<br>");
        sendTextToElement(confirmPasswordField, confirmPassword);
    }

    public void clickOnRegisterButton() {
        CustomListeners.test.log(Status.PASS,"Clicking on register button " + registerButton.toString() + "<br>");
        clickOnElement(registerButton);
    }

    public String getFirstNameErrorMessage() {
        CustomListeners.test.log(Status.PASS,"Getting empty firstname field error message " + firstnameErrorMessage.toString() + "<br>");
        return firstnameErrorMessage.getText();

    }

    public String getLastNameErrorMessage() {
        CustomListeners.test.log(Status.PASS,"Getting empty lastname field error message " + lastNameErrorMessage.toString() + "<br>");
        return lastNameErrorMessage.getText();
    }
    public String getEmailErrorMessage() {
        CustomListeners.test.log(Status.PASS,"Getting empty email field error message " + emailErrorMessage.toString() + "<br>");
        return emailErrorMessage.getText();
    }

    public String getPasswordErrorMessage() {
        CustomListeners.test.log(Status.PASS,"Getting empty password field error message " + passwordErrorMessage.toString() + "<br>");
        return passwordErrorMessage.getText();
    }

    public String getConfirmPasswordErrorMessage() {
        CustomListeners.test.log(Status.PASS,"Getting empty confirm password field error message " + confirmPasswordErrorMessage.toString() + "<br>");
        return confirmPasswordErrorMessage.getText();
    }
    public String getRegistrationCompleteText() {
        CustomListeners.test.log(Status.PASS,"Getting registration completed message " + registrationCompleteText.toString() + "<br>");
        return registrationCompleteText.getText();
    }


}
