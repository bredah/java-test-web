package bredah.page;

import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import static bredah.config.ConfigurationManager.configuration;
import static org.openqa.selenium.support.PageFactory.initElements;

import java.time.Duration;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import bredah.driver.DriverManager;

public class PageObject {

  protected PageObject() {
    initElements(new AjaxElementLocatorFactory(DriverManager.getDriver(), configuration().timeout()), this);
  }

  protected void mouseHover(WebElement element) {
    var action = new Actions(DriverManager.getDriver());
    action.moveToElement(element).perform();
  }

  protected void selectByVisibleText(WebElement element, String text) {
    var selecteElement = new Select(element);
    selecteElement.selectByVisibleText(text);
  }

  protected void selectByValue(WebElement element, String text) {
    var selecteElement = new Select(element);
    selecteElement.selectByValue(text);
  }

  protected void waitUntil(ExpectedCondition<WebElement> expectedConditions) {
    new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(10)).until(expectedConditions);
  }

  protected String regexExtractValue(String regex, String text) {
    var pattern = Pattern.compile(regex);
    var matcher = pattern.matcher(text);
    if (matcher.find()) {
      return matcher.group(0);
    }
    return "";
  }
}
