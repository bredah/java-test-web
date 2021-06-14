package bredah.model;

public class OrderHistory {
  private String orderReference;
  private Double totalPrice;

  public OrderHistory(String orderReference, Double totalPrice) {
    this.orderReference = orderReference;
    this.totalPrice = totalPrice;
  }


  public String getOrderReference() {
    return this.orderReference;
  }

  public void setOrderReference(String orderReference) {
    this.orderReference = orderReference;
  }

  public Double getTotalPrice() {
    return this.totalPrice;
  }

  public void setTotalPrice(Double totalPrice) {
    this.totalPrice = totalPrice;
  }

}
