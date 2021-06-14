package bredah.page.checkout;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import bredah.page.PageObject;
import io.qameta.allure.Step;

public class CheckoutShippingPage extends PageObject {

  @FindBy(name = "processCarrier")
  private WebElement buttonProceedToCheckout;

  @FindBy(name = "cgv")
  private WebElement checkTermsOfService;

  @Step("accept terms of service")
  public void acceptTermsOfService() {
    this.checkTermsOfService.click();
  }

  @Step("submit shipping")
  public void submitShipping() {
    this.buttonProceedToCheckout.click();
  }

}
