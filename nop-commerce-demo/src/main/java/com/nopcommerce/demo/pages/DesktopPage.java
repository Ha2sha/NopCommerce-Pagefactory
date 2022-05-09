package com.nopcommerce.demo.pages;

import com.aventstack.extentreports.Status;
import com.nopcommerce.demo.customlisteners.CustomListeners;
import com.nopcommerce.demo.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;


public class DesktopPage extends Utility {

   //By loginLink = By.linkText("Log in");
    //By registerLink = By.linkText("Register");

    //Alt+insert to add constructor
    public DesktopPage() {
        PageFactory.initElements(driver,this);
    }


    @FindBy(xpath = "//h1[normalize-space()='Desktops']")
    WebElement welcomeText;

    @FindBy(xpath = "//select[@id='products-orderby']")
    WebElement sortByFilter;

    @FindBy(xpath = "//select[@id='products-pagesize']")
    WebElement displayFilter;

    @FindBy(xpath = "(//button[@class='button-2 product-box-add-to-cart-button'])[1]")
    WebElement buildYourOwnComputer;

    @FindBys({@FindBy(xpath = "//div[@class='product-grid']//h2")})
    List<WebElement> productList;


    public String getWelcomeText(){
        CustomListeners.test.log(Status.PASS,"Getting Welcome Text "+welcomeText.toString()+"<br>");
        return getTextFromElement(welcomeText);
    }
    public void sortByZToA() {
        selectByValueFromDropDown(sortByFilter,"6");
    }

       public List<String> verifyProductSortedByZToAFilter() throws InterruptedException {
        CustomListeners.test.log(Status.PASS,"verify products sorted by Z to A"+"<br>");
        List<String> productNameList = new ArrayList<>();
        for (WebElement name : productList) {
            Thread.sleep(1000);
            productNameList.add(name.getText());
        }
        return productNameList;
    }

    public void sortByAtoZ() {
        CustomListeners.test.log(Status.PASS,"Selecting filter "+sortByFilter.toString()+"<br>");
        selectByValueFromDropDown(sortByFilter,"5");
    }

    public void sortByDisplay3Items(){
        CustomListeners.test.log(Status.PASS,"Selecting Display 3 items filter "+displayFilter.toString()+"<br>");
        selectByValueFromDropDown(displayFilter,"3");
    }

    public void sortByDisplay6Items(){
        CustomListeners.test.log(Status.PASS,"Selecting Display 6 items filter "+displayFilter.toString()+"<br>");
        selectByValueFromDropDown(displayFilter,"6");
    }

    public void sortByDisplay9Items(){
        CustomListeners.test.log(Status.PASS,"Selecting Display 9 items filter "+displayFilter.toString()+"<br>");
        selectByValueFromDropDown(displayFilter,"9");
    }
    public void clickOnBuildYourOwnComputerProduct() {
        CustomListeners.test.log(Status.PASS,"Click on Build Your Own Computer Product "+buildYourOwnComputer.toString()+"<br>");
        clickOnElement(buildYourOwnComputer);
    }
}
