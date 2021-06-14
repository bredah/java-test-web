package bredah.page.account;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import bredah.page.PageObject;

public class OrderHistoryPage extends PageObject {

  @FindBy(css = "#order-list > tbody  > tr")
  private List<WebElement> listOrderHistory;

  @FindBy(css = ".history_link > a")
  private WebElement linkOrderReferences;

  @FindBy(css = ".history_price > span")
  private WebElement labelOrderPrice;

  public List<WebElement> getOrderList() {
    return this.listOrderHistory;
  }

  public String getOrderRefence(WebElement element) {
    return element.findElement(By.cssSelector(".history_link > a")).getText();
  }

  public String getOrderPrice(WebElement element) {
    return element.findElement(By.cssSelector(".history_price > span")).getText();
  }

}
