package steps;

import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.SmartBearHomePage;
import pages.SmartBearLoginPage;
import pages.SmartBearOrderPage;
import utilities.Driver;
import utilities.DropdownHandler;
import utilities.Waiter;

public class SmartBearSteps {

    WebDriver driver;
    SmartBearLoginPage smartBearLoginPage;
    SmartBearHomePage smartBearHomePage;
    SmartBearOrderPage smartBearOrderPage;

    @Before
    public void setup() {
        driver = Driver.getDriver();
        smartBearLoginPage = new SmartBearLoginPage();
        smartBearHomePage = new SmartBearHomePage();
        smartBearOrderPage = new SmartBearOrderPage();
    }

    @Then("user should see {string} Message")
    public void userShouldSeeMessage(String message) {
        Assert.assertEquals(message, smartBearLoginPage.errorMessage.getText());

    }

    @Then("user should be routed to {string}")
    public void userShouldBeRoutedTo(String link) {
        Assert.assertEquals(link, driver.getCurrentUrl());
    }

    @And("validate below menu items are displayed")
    public void validateBelowMenuItemsAreDisplayed(DataTable itemsList) {
        for (int i = 0; i < itemsList.asList().size(); i++) {
            Assert.assertEquals(itemsList.asList().get(i), smartBearHomePage.webOrderMenuItems.get(i).getText());
        }
    }

    @When("user clicks on {string} button")
    public void userClicksOnButton(String buttonText) {
        switch (buttonText){
            case ("Check All") :
                smartBearHomePage.checkAllButton.click();
                break;
            case ("Uncheck All") :
                smartBearHomePage.uncheckAllButton.click();
                break;
            case ("Process") :
                smartBearOrderPage.processButton.click();
                break;
            case "Delete Selected":
                smartBearOrderPage.deleteSelectedButton.click();
                break;
        }
    }

    @Then("all rows should be checked")
    public void allRowsShouldBeChecked() {
        for (int i = 0; i < smartBearHomePage.checkBoxes.size(); i++) {
        Assert.assertEquals("true", smartBearHomePage.checkBoxes.get(i).getAttribute("checked"));


        }
    }

    @Then("all rows should be unchecked")
    public void allRowsShouldBeUnchecked() {
        for (int i = 0; i < smartBearHomePage.checkBoxes.size(); i++) {
            Assert.assertNull(smartBearHomePage.checkBoxes.get(i).getAttribute("checked"));

        }
    }

    @When("user clicks on {string} menu item")
    public void userClicksOnMenuItem(String menuItems) {
        switch (menuItems){
            case ("Order") :
                smartBearHomePage.order.click();
                break;
            case ("View all orders") :
                smartBearHomePage.viewAllOrders.click();
        }
    }

    @And("user selects {string} as product")
    public void userSelectsAsProduct(String buttonText) {
        DropdownHandler.selectOptionByVisibleText(smartBearOrderPage.productSelector, "FamilyAlbum");
    }

    @And("user enters {int} as quantity")
    public void userEntersAsQuantity(int quantity) {
        smartBearOrderPage.orderPage.get(0).clear();
        smartBearOrderPage.orderPage.get(0).sendKeys(String.valueOf(quantity));
    }

    @And("user enters all address information")
    public void userEntersAllAddressInformation() {
        smartBearOrderPage.orderPage.get(5).sendKeys("John Doe");
        smartBearOrderPage.orderPage.get(6).sendKeys("123 Address St");
        smartBearOrderPage.orderPage.get(7).sendKeys("Chicago");
        smartBearOrderPage.orderPage.get(8).sendKeys("IL");
        smartBearOrderPage.orderPage.get(9).sendKeys("60665");
    }

    @And("user enters all payment information")
    public void userEntersAllPaymentInformation() {
        smartBearOrderPage.orderPage.get(10).click();
        smartBearOrderPage.orderPage.get(13).sendKeys("123456789");
        smartBearOrderPage.orderPage.get(14).sendKeys("03/23");
        smartBearOrderPage.processButton.click();
    }

    @Then("user should see their order displayed in the {string} table")
    public void userShouldSeeTheirOrderDisplayedInTheTable(String table) {
        Assert.assertTrue(smartBearHomePage.inputOrder.isDisplayed());
    }

    @And("validate all information entered displayed correct with the order")
    public void validateAllInformationEnteredDisplayedCorrectWithTheOrder(DataTable dataTable) {
        for (int i = 1; i < 12; i++) {
            Assert.assertEquals(dataTable.asList().get(i), smartBearHomePage.allOrdersList.get(i).getText());
        }
    }

    @Then("validate all orders are deleted from the {string}")
    public void validateAllOrdersAreDeletedFromThe(String lists) {
        Assert.assertEquals(0, smartBearOrderPage.rows.size());
    }

    @And("validate user sees {string} Message")
    public void validateUserSeesMessage(String message) {
        //smartBearHomePage.deleteButton.click();
        Assert.assertTrue(smartBearHomePage.emptyMessage.isDisplayed());
        Assert.assertEquals("List of orders is empty. In order to add new order use this link.", smartBearHomePage.emptyMessage.getText());
    }


}


