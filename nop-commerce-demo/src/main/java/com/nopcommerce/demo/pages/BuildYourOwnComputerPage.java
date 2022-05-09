package com.nopcommerce.demo.pages;

import com.aventstack.extentreports.Status;
import com.nopcommerce.demo.customlisteners.CustomListeners;
import com.nopcommerce.demo.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class BuildYourOwnComputerPage extends Utility {

    //Alt+insert to add constructor
    public BuildYourOwnComputerPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//h1[normalize-space()='Build your own computer']")
    WebElement buildYourOwnComputerPageTxt;

    @FindBy(xpath = "//select[@id='product_attribute_1']")
    WebElement processorDropDown;

    @FindBy(xpath = "//select[@id='product_attribute_2']")
    WebElement ramDropDown;

    @FindBy(xpath = "//input[@id='product_attribute_3_6']")
    WebElement hddRadio;

    @FindBy(id = "product_attribute_input_4")
    WebElement osRadio;

    @FindBy(id = "product_attribute_input_5")
    WebElement softwareCheckBoxes;

    @FindBy(id = "add-to-cart-button-1")
    WebElement addToCartBtn;

    @FindBy(xpath = "//div[@id='bar-notification']/div/p")
    WebElement productHasBeenAddedMsg;

    public void buildConfigurationFromList(String processor, String ram, String hdd, String os, String software){
        selectByVisibleTextFromDropDown(processorDropDown, processor);
        selectByVisibleTextFromDropDown(ramDropDown, ram);
        clickOnElement(hddRadio);
        clickOnElement(osRadio);
        clickOnElement(softwareCheckBoxes);
        CustomListeners.test.log(Status.PASS, "Selecting processor "+processor +"<br>");
        CustomListeners.test.log(Status.PASS, "Selecting RAM "+ram+"<br>");
        CustomListeners.test.log(Status.PASS, "Clicking HDD RadioButton "+hdd+"<br>");
        CustomListeners.test.log(Status.PASS, "Clicking Operating System RadioButton "+os+"<br>");
        CustomListeners.test.log(Status.PASS, "Checking software checkboxes "+software+"<br>");

    }

        public void clickOnAddToCart() {
        clickOnElement(addToCartBtn);
        CustomListeners.test.log(Status.PASS, "Click on addToCartBtn "+"<br>");
    }

    public void verifyProductHasBeenAddedMsg(String text) {
        CustomListeners.test.log(Status.PASS, "Verifying product has been added to card message displayed "+"<br>");
        verifyThatTextIsDisplayed(productHasBeenAddedMsg, text);
    }


}
