package bredah.test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

import java.text.ParseException;

import org.testng.annotations.Test;

import bredah.BaseWeb;
import bredah.page.HeaderPage;
import bredah.page.account.OrderHistoryPage;
import bredah.page.cart.CartPage;
import bredah.page.checkout.CheckoutAddressPage;
import bredah.page.checkout.CheckoutCustomerPage;
import bredah.page.checkout.CheckoutOrderPage;
import bredah.page.checkout.CheckoutPaymentPage;
import bredah.page.checkout.CheckoutShippingPage;
import bredah.page.component.CartModel;
import bredah.page.login.AuthenticationPage;
import bredah.page.product.ProductContentsPage;

public class ShoppingTest extends BaseWeb {

  @Test
  public void makeAnOrder_checkOrderHistory() throws ParseException {
    generateCustomerData();
    // Find product
    var headerPage = new HeaderPage();
    headerPage.searchProduct("t-shirt");
    // add product to cart
    var contentsPage = new ProductContentsPage();
    contentsPage.selectProduct(0);
    // go to checkout
    new CartModel().proceedToCheckout();
    // proceed to checkout
    var cartPage = new CartPage();
    cartPage.proceedToCheckout();
    // create a new account
    var authenticationPage = new AuthenticationPage();
    authenticationPage.createAnAccount(customerData.getEmail());
    // checkou: customer data
    var checkoutCustomerPage = new CheckoutCustomerPage();
    checkoutCustomerPage.fillForm(customerData);
    checkoutCustomerPage.resgisterCustomer();
    // checkout: address
    var checkoutAddressPage = new CheckoutAddressPage();
    checkoutAddressPage.submitAddress();
    // checkout: shipping
    var checkoutShippingPage = new CheckoutShippingPage();
    checkoutShippingPage.acceptTermsOfService();
    checkoutShippingPage.submitShipping();
    // checkout: payment
    var checkoutPaymentPage = new CheckoutPaymentPage();
    checkoutPaymentPage.payWithBankWire();
    checkoutPaymentPage.submitPayment();
    // checkout: order
    var checkoutOrderPage = new CheckoutOrderPage();
    var orderPrice = checkoutOrderPage.orderPrice();
    assertNotNull(orderPrice, "order price is empty");
    var orderReference = checkoutOrderPage.orderReference();
    assertNotNull(orderReference, "order reference is empty");
    // customer - order history
    checkoutOrderPage.backToOrders();
    var orderHistoryPage = new OrderHistoryPage();
    var orderHistorList = orderHistoryPage.getOrderList();
    var orderReferenceHistory = orderHistoryPage.getOrderRefence(orderHistorList.get(0));
    assertNotNull(orderReference, "Order reference history is empty");
    assertEquals(orderReferenceHistory, orderReference, "current order reference is not present in the order history");
    var orderPriceHistory = orderHistoryPage.getOrderPrice(orderHistorList.get(0));
    assertNotNull(orderPriceHistory, "Order price history is empty");
    assertEquals(orderPriceHistory, orderPrice, "current order price is not present in the order history");
  }

}
