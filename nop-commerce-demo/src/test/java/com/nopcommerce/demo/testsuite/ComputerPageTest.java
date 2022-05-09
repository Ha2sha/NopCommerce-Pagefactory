package com.nopcommerce.demo.testsuite;

import com.nopcommerce.demo.customlisteners.CustomListeners;
import com.nopcommerce.demo.pages.BuildYourOwnComputerPage;
import com.nopcommerce.demo.pages.ComputerPage;
import com.nopcommerce.demo.pages.DesktopPage;
import com.nopcommerce.demo.pages.HomePage;
import com.nopcommerce.demo.testbase.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import resources.testdata.TestData;
@Listeners(CustomListeners.class)
public class ComputerPageTest extends TestBase {

    HomePage homePage;
    ComputerPage computerPage;
    DesktopPage desktopPage;
    BuildYourOwnComputerPage buildYourOwnComputerPage;

    @BeforeMethod(alwaysRun = true)
    public void inIt(){
        homePage = new HomePage();
        computerPage=new ComputerPage();
        desktopPage=new DesktopPage();
        buildYourOwnComputerPage=new BuildYourOwnComputerPage();
    }
    @Test(groups = {"sanity","smoke","regression"},retryAnalyzer = RetryAnalyzer.class)
    public void verifyUserShouldNavigateToComputerPageSuccessfully(){
        homePage.clickOnComputerLink();
        String expectedText="Computers";
        String actualText=computerPage.getComputerNavigationText();
        Assert.assertEquals(actualText,expectedText,"Computers text not displayed");
    }
    @Test(groups = {"smoke","regression"},retryAnalyzer = RetryAnalyzer.class)
    public void verifyUserShouldNavigateToDesktopsPageSuccessfully(){
        homePage.clickOnComputerLink();
        computerPage.clickOnDesktop();
        String expectedText="Desktops";
        String actualText=computerPage.getDesktopNavigationText();
        Assert.assertEquals(actualText,expectedText,"Desktops text not displayed");
    }
    @Test(groups = {"regression"}, dataProvider = "AddToCart",dataProviderClass = TestData.class,retryAnalyzer = RetryAnalyzer.class)
    public void verifyThatUserShouldBuildYouOwnComputerAndAddThemToCartSuccessfully(String processor, String ram, String hdd, String os, String software) throws InterruptedException {
        homePage.clickOnComputerLink();
        computerPage.clickOnDesktop();
        desktopPage.clickOnBuildYourOwnComputerProduct();
        buildYourOwnComputerPage.buildConfigurationFromList(processor, ram, hdd, os, software);
        buildYourOwnComputerPage.clickOnAddToCart();
        Thread.sleep(2000);
        buildYourOwnComputerPage.verifyProductHasBeenAddedMsg("The product has been added to your shopping cart");
    }

}

