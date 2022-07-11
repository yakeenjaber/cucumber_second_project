package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class SmartBearHomePage {

    public SmartBearHomePage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "ctl00_MainContent_btnCheckAll")
    public WebElement checkAllButton;

    @FindBy(id = "ctl00_MainContent_btnUncheckAll")
    public WebElement uncheckAllButton;

    @FindBy(xpath = "//input[starts-with(@id, 'ctl00_MainContent_orderGrid_')]")
    public List<WebElement> checkBoxes;

    @FindBy(xpath = "//ul[@id='ctl00_menu']/li[1]/a")
    public WebElement viewAllOrders;

    @FindBy(xpath = "//ul[@id='ctl00_menu']/li[3]/a")
    public WebElement order;

    @FindBy(id = "ctl00_MainContent_btnDelete")
    public WebElement deleteButton;

    @FindBy(id = "ctl00_MainContent_orderMessage")
    public WebElement emptyMessage;

    @FindBy(xpath = "//table[@id='ctl00_MainContent_orderGrid']//tr[2]//td")
    public List<WebElement> allOrdersList;

    @FindBy(css = "#ctl00_menu>li")
    public List<WebElement> webOrderMenuItems;

    @FindBy(xpath = "//table[@id='ctl00_MainContent_orderGrid']//tr[2]")
    public WebElement inputOrder;


}
