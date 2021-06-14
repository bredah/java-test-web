package bredah.page.product;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import bredah.page.PageObject;
import io.qameta.allure.Step;

public class ProductContentsPage extends PageObject {

  @FindBy(className = "product-container")
  private List<WebElement> listProducts;

  @FindBy(css = ".ajax_add_to_cart_button")
  private WebElement buttonAddToCart;

  @Step("select a product by index: {index}")
  public void selectProduct(int index){
    waitUntil(ExpectedConditions.elementToBeClickable(this.listProducts.get(index)));
    mouseHover(this.listProducts.get(index));
    waitUntil(ExpectedConditions.elementToBeClickable(this.buttonAddToCart));
    this.buttonAddToCart.click();
  }
}
