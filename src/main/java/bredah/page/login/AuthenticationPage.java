package bredah.page.login;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import bredah.page.PageObject;
import io.qameta.allure.Step;

public class AuthenticationPage extends PageObject {

  @FindBy(id = "email_create")
  private WebElement inputNewAccountEmail;

  @FindBy(id = "SubmitCreate")
  private WebElement buttonCreateAnAccount;

  @FindBy(id = "email")
  private WebElement inputLoginEmail;

  @FindBy(id = "passwd")
  private WebElement inputLoginPassword;

  @FindBy(id = "SubmitLogin")
  private WebElement buttonSignIn;

  @Step("create an acccount - email: {email}")
  public void createAnAccount(String email) {
    waitUntil(ExpectedConditions.elementToBeClickable(this.inputNewAccountEmail));
    this.inputNewAccountEmail.sendKeys(email);
    this.buttonCreateAnAccount.click();
  }

  @Step("sign in - email: {email}, password: {password}")
  public void signin(String email, String password) {
    waitUntil(ExpectedConditions.elementToBeClickable(this.inputLoginEmail));
    this.inputLoginEmail.sendKeys(email);
    this.inputLoginPassword.sendKeys(password);
    this.buttonSignIn.click();
  }
}
