package bredah.page.checkout;

import java.text.SimpleDateFormat;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import bredah.model.CustomerData;
import bredah.page.PageObject;
import io.qameta.allure.Step;

public class CheckoutCustomerPage extends PageObject {

  @FindBy(id = "customer_firstname")
  private WebElement inputCustomerFirstName;

  @FindBy(id = "customer_lastname")
  private WebElement inputCustomerLastName;

  @FindBy(id = "passwd")
  private WebElement inputCustomerPassword;

  @FindBy(id = "days")
  private WebElement optionCustomerBirthdayDay;

  @FindBy(id = "months")
  private WebElement optionCustomerBirthdayMonth;

  @FindBy(id = "years")
  private WebElement optionCustomerBirthdayYear;

  @FindBy(id = "firstname")
  private WebElement inputAddressFirstName;

  @FindBy(id = "lastname")
  private WebElement inputAddressLastName;

  @FindBy(id = "address1")
  private WebElement inputAddressLine1;

  @FindBy(id = "city")
  private WebElement inputAddressCity;

  @FindBy(id = "id_state")
  private WebElement inputAddressState;

  @FindBy(id = "postcode")
  private WebElement inputAddressPostalCode;

  @FindBy(id = "phone_mobile")
  private WebElement inputMobilePhone;

  @FindBy(id = "submitAccount")
  private WebElement buttonRegister;

  @Step("fill customer data")
  public void fillForm(CustomerData data) {
    waitUntil(ExpectedConditions.elementToBeClickable(this.inputCustomerFirstName));
    // personal data
    this.inputCustomerFirstName.sendKeys(data.getFirstName());
    this.inputCustomerLastName.sendKeys(data.getLastName());
    this.inputCustomerPassword.sendKeys(data.getPassword());
    selectByValue(this.optionCustomerBirthdayDay, new SimpleDateFormat("d").format(data.getBirthday()));
    selectByValue(this.optionCustomerBirthdayMonth, new SimpleDateFormat("MM").format(data.getBirthday()).replaceFirst("^0", ""));
    selectByValue(this.optionCustomerBirthdayYear, new SimpleDateFormat("y").format(data.getBirthday()));
    // address data
    this.inputAddressFirstName.sendKeys(data.getFirstName());
    this.inputAddressLastName.sendKeys(data.getLastName());
    this.inputAddressLine1.sendKeys(data.getAddressLine1());
    this.inputAddressCity.sendKeys(data.getAddressCity());
    selectByVisibleText(this.inputAddressState, data.getAddressState());
    this.inputAddressPostalCode.sendKeys(data.getAddressPostalCode());
    this.inputMobilePhone.sendKeys(data.getPhoneNumber());
  }

  @Step("register new customer")
  public void resgisterCustomer() {
    this.buttonRegister.click();
  }

}
