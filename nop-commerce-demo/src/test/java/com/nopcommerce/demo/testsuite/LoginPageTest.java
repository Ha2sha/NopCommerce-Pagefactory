package com.nopcommerce.demo.testsuite;

import com.nopcommerce.demo.customlisteners.CustomListeners;
import com.nopcommerce.demo.pages.HomePage;
import com.nopcommerce.demo.pages.LoginPage;
import com.nopcommerce.demo.testbase.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
@Listeners(CustomListeners.class)
public class LoginPageTest extends TestBase {

    HomePage homePage;
    LoginPage loginPage;
    SoftAssert softAssert;
    @BeforeMethod(alwaysRun = true)
    public void inIt(){
        homePage = new HomePage();
        loginPage = new LoginPage();
        softAssert=new SoftAssert();
    }
    @Test(groups = {"sanity","smoke","regression"})
    public void verifyUserShouldNavigateToLoginPage() {
        homePage.clickOnLoginLink();
        String expectedMessage = "Welcome, Please Sign In!";
        String actualMessage = loginPage.getWelcomeText();
        softAssert.assertEquals(expectedMessage, actualMessage, "Login page not displayed");
        softAssert.assertAll();
    }

    @Test(groups = {"smoke","regression"})
    public void verifyErrorMessageWithInvalidCredentials() {
        homePage.clickOnLoginLink();
        loginPage.enterEmailId("hello123@gmail.com");
        loginPage.enterPassword("hello123");
        loginPage.clickOnLoginButton();
        String expectedErrorMessage = "Login was unsuccessful. Please correct the errors and try again.\n"
                + "No customer account found";
        String actualErrorMessage = loginPage.getErrorMessage();
        softAssert.assertEquals(expectedErrorMessage, actualErrorMessage, "Error message not displayed");
        softAssert.assertAll();
    }
    @Test(groups = {"regression"},priority = 2)
    public void verifyThatUserShouldLogInSuccessFullyWithValidCredentials(){
        homePage.clickOnLoginLink();
        loginPage.enterEmailId("hinal55@yahoo.com");
        loginPage.enterPassword("123896");
        loginPage.clickOnLoginButton();
        Boolean expectedElement=true;
        Boolean actualElement=homePage.checkLogoutLinkIsDisplayed();
        softAssert.assertEquals(actualElement,expectedElement,"Logout Link is not displayed");
        softAssert.assertAll();
    }

    @Test(groups = {"regression"},priority = 3)
    public void VerifyThatUserShouldLogOutSuccessFully(){
        homePage.clickOnLoginLink();
        loginPage.enterEmailId("hinal55@yahoo.com");
        loginPage.enterPassword("123896");
        loginPage.clickOnLoginButton();
        homePage.clickOnLogoutLink();
        softAssert.assertTrue(homePage.checkMyAccountLinkIsDisplayed());
        softAssert.assertAll();
    }


}
