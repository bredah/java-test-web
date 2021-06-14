package bredah.page.checkout;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import bredah.page.PageObject;
import io.qameta.allure.Step;

public class CheckoutOrderPage extends PageObject {

  @FindBy(css = ".box")
  private WebElement labelOrderContent;

  @FindBy(css = ".box > .price")
  private WebElement labelOrderValue;

  @FindBy(css = ".cart_navigation > [href*=history]")
  private WebElement linkBackToOrders;

  public Double orderValueDouble() {
    String capturedOrderValue = regexExtractValue("\\d+.\\d+", this.labelOrderValue.getText());
    return Double.parseDouble(capturedOrderValue);
  }
  public String orderPrice() {
    return this.labelOrderValue.getText();
  }

  public String orderReference() {
    return regexExtractValue("[A-Z]{6,}", this.labelOrderContent.getText());
  }

  public void backToOrders(){
    this.linkBackToOrders.click();
  }
}
