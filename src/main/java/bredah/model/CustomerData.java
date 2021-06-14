package bredah.model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CustomerData {

  private String email;
  private String firstName;
  private String lastName;
  private String password;
  private Date birthday;
  private String phoneNumber;
  private String addressLine1;
  private String addressLine2;
  private String addressCity;
  private String addressState;
  private String addressPostalCode;

  public String getEmail() {
    return this.email;
  }

  public String getFirstName() {
    return this.firstName;
  }

  public String getLastName() {
    return this.lastName;
  }

  public String getPassword() {
    return this.password;
  }

  public Date getBirthday() {
    return this.birthday;
  }

  public String getPhoneNumber() {
    return this.phoneNumber;
  }

  public String getAddressLine1() {
    return this.addressLine1;
  }

  public String getAddressLine2() {
    return this.addressLine2;
  }

  public String getAddressCity() {
    return this.addressCity;
  }

  public String getAddressState() {
    return this.addressState;
  }

  public String getAddressPostalCode() {
    return this.addressPostalCode;
  }

  public CustomerData setEmail(String email) {
    this.email = email;
    return this;
  }

  public CustomerData setFirstName(String firstName) {
    this.firstName = firstName;
    return this;
  }

  public CustomerData setLastName(String lastName) {
    this.lastName = lastName;
    return this;
  }

  public CustomerData setPassword(String password) {
    this.password = password;
    return this;
  }

  public CustomerData setBirthday(Date birthday) {
    this.birthday = birthday;
    return this;
  }

  public CustomerData setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
    return this;
  }

  public CustomerData setAddressLine1(String addressLine1) {
    this.addressLine1 = addressLine1;
    return this;
  }

  public CustomerData setAddressLine2(String addressLine2) {
    this.addressLine2 = addressLine2;
    return this;
  }

  public CustomerData setAddressCity(String addressCity) {
    this.addressCity = addressCity;
    return this;
  }

  public CustomerData setAddressState(String addressState) {
    this.addressState = addressState;
    return this;
  }

  public CustomerData setAddressPostalCode(String addressPostalCode) {
    this.addressPostalCode = addressPostalCode;
    return this;
  }


  @Override
  public String toString() {
    return "{" +
      " email='" + getEmail() + "'" +
      ", firstName='" + getFirstName() + "'" +
      ", lastName='" + getLastName() + "'" +
      ", password='" + getPassword() + "'" +
      ", birthday='" + new SimpleDateFormat("yyyy/MM/dd").format(getBirthday()) + "'" +
      ", phoneNumber='" + getPhoneNumber() + "'" +
      ", addressLine1='" + getAddressLine1() + "'" +
      ", addressLine2='" + getAddressLine2() + "'" +
      ", addressCity='" + getAddressCity() + "'" +
      ", addressState='" + getAddressState() + "'" +
      ", addressPostalCode='" + getAddressPostalCode() + "'" +
      "}";
  }

}
