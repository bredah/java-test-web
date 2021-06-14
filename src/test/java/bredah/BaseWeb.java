package bredah;

import static bredah.config.ConfigurationManager.configuration;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;

import com.github.javafaker.Faker;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import bredah.driver.DriverManager;
import bredah.driver.TargetFactory;
import bredah.model.CustomerData;
import bredah.report.AllureReport;

@Listeners({ TestListener.class })
public abstract class BaseWeb {

  protected Faker faker;
  protected CustomerData customerData;

  @BeforeSuite
  public void beforeSuite() {
    AllureReport.setAllureEnvironmentInformation();
    faker = new Faker(Locale.US);
    customerData = new CustomerData();
  }

  @BeforeMethod(alwaysRun = true)
  @Parameters("browser")
  public void preCondition(@Optional("chrome") String browser) {
    WebDriver driver = new TargetFactory().createInstance(browser);
    DriverManager.setDriver(driver);

    DriverManager.getDriver().get(configuration().url());
  }

  @AfterMethod(alwaysRun = true)
  public void postCondition() {
    DriverManager.quit();
  }

  public void generateCustomerData() throws ParseException {
    customerData = new CustomerData()
      // Personal Data
      .setEmail(faker.internet().emailAddress())
      .setFirstName(faker.address().firstName())
      .setLastName(faker.address().lastName())
      .setPassword(faker.internet().password())
      .setBirthday( new SimpleDateFormat("yyyy/mm/DD", Locale.ENGLISH).parse("1980/01/24"))
      // Address
      .setAddressLine1(faker.address().streetAddress())
      .setAddressCity(faker.address().cityName())
      .setAddressState(faker.address().state())
      .setAddressPostalCode(faker.address().zipCode().replaceFirst("\\D\\d+", ""))
      .setPhoneNumber(faker.phoneNumber().cellPhone());
  }

}
