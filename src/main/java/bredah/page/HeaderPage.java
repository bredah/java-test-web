package bredah.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import io.qameta.allure.Step;

public class HeaderPage extends PageObject {

  @FindBy(id = "search_query_top")
  private WebElement inputSearch;

  @FindBy(name = "submit_search")
  private WebElement inputSubmit;

  @Step("search product {product}")
  public void searchProduct(String product) {
    this.inputSearch.sendKeys(product);
    this.inputSubmit.click();
  }

}
