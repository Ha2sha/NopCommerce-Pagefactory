package com.nopcommerce.demo.testsuite;

import com.nopcommerce.demo.customlisteners.CustomListeners;
import com.nopcommerce.demo.pages.HomePage;
import com.nopcommerce.demo.pages.RegisterPage;
import com.nopcommerce.demo.testbase.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
@Listeners(CustomListeners.class)
public class RegisterPageTest extends TestBase {

    HomePage homePage;
    RegisterPage registerPage;
    SoftAssert softAssert;
    @BeforeMethod(alwaysRun = true)
    public void inIt(){
        homePage = new HomePage();
        registerPage = new RegisterPage();
        softAssert=new SoftAssert();
    }

    @Test(groups={"sanity","smoke","regression"})
    public void verifyUserShouldNavigateToRegisterPageSuccessfully(){
        homePage.clickOnRegisterLink();
        String expectedText="Register";
        String actualText=registerPage.geRegisterText();
        softAssert.assertEquals(actualText,expectedText,"Register text not displayed");
        softAssert.assertAll();
    }

    @Test(groups={"smoke","regression"})
    public void verifyThatFirstNameLastNameEmailPasswordAndConfirmPasswordFieldsAreMandatory(
    ){
        homePage.clickOnRegisterLink();
        registerPage.clickOnRegisterButton();
        String expectedFirstNameError="First name is required.";
        String actualFirstNameError=registerPage.getFirstNameErrorMessage();
        softAssert.assertEquals(actualFirstNameError,expectedFirstNameError,"FirstName field should not be blank");

        String expectedLastNameError="Last name is required.";
        String actualLastNameError=registerPage.getLastNameErrorMessage();
        softAssert.assertEquals(actualLastNameError,expectedLastNameError,"LastName field should not be blank");

        String expectedEmailError="Email is required.";
        String actualEmailError=registerPage.getEmailErrorMessage();
        softAssert.assertEquals(actualEmailError,expectedEmailError,"Email field should not be blank");

        String expectedPasswordError="Password is required.";
        String actualPasswordError=registerPage.getPasswordErrorMessage();
        softAssert.assertEquals(actualPasswordError,expectedPasswordError,"Password field should not be blank");

        String expectedConfirmPasswordError="Password is required.";
        String actualConfirmPasswordError=registerPage.getConfirmPasswordErrorMessage();
        softAssert.assertEquals(actualConfirmPasswordError,expectedConfirmPasswordError,"Confirm Password field should not be blank");

        softAssert.assertAll();
    }
    @Test(groups={"regression"},priority = -1)
    public void verifyThatUserShouldCreateAccountSuccessfully() throws InterruptedException {
        homePage.clickOnRegisterLink();
        registerPage.clickOnFemaleRadioButton();
        registerPage.enterFirstName("Hinal1");
        Thread.sleep(1000);
        registerPage.enterLastName("Devani");
        Thread.sleep(1000);
        registerPage.selectDay("22");
        Thread.sleep(1000);
        registerPage.selectMonth("10");
        Thread.sleep(3000);
        registerPage.selectYear("1980");
        Thread.sleep(1000);
        registerPage.enterEmail("hinal55@yahoo.com");
        Thread.sleep(1000);
        registerPage.enterPassword("123896");
        Thread.sleep(1000);
        registerPage.enterConfirmPassword("123896");
        Thread.sleep(1000);
        registerPage.clickOnRegisterButton();
        Thread.sleep(1000);
        String expectedMessage="Your registration completed";
        String actualMessage=registerPage.getRegistrationCompleteText();
        Thread.sleep(1000);
        softAssert.assertEquals(actualMessage,expectedMessage,"Registration incomplete");
        softAssert.assertAll();
    }
}
