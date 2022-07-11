package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class SmartBearOrderPage {

    public SmartBearOrderPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(css = "[id='ctl00_MainContent_fmwOrder_ddlProduct']")
    public WebElement productSelector;

    @FindBy(css = "[id='ctl00_MainContent_fmwOrder'] ol li input")
    public List<WebElement> orderPage;

    @FindBy(css = ".buttons_process a")
    public WebElement processButton;

    @FindBy(id = "ctl00_MainContent_btnDelete")
    public WebElement deleteSelectedButton;

    @FindBy(xpath = "//table[@id='ctl00_MainContent_orderGrid']//tr")
    public List<WebElement> rows;
}
