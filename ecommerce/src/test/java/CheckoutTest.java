import model.Checkout;
import model.Customer;
import model.Product;
import model.ShoppingCart;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import utils.InsufficientFundsException;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class CheckoutTest {
    static Customer customer;

    static ShoppingCart shoppingCart;

    static List<Product> products;

    static Checkout checkout;

    @BeforeAll
    public static void init(){
        customer = new Customer("1", LocalDate.now().minusYears(2),null,5000);
        shoppingCart = new ShoppingCart(customer);
        products  =  new ArrayList<>();
        products.add(new Product("bread","1111",1000,100));
        products.add(new Product("cheese","1112",1500,150));
        products.add(new Product("milk","1113",2000,200));
        shoppingCart.setItems(products);
        customer.setShoppingCart(shoppingCart);
        checkout = new Checkout(customer);
    }

    @Test
    public void testPointEligible(){
       Assertions.assertEquals(true, checkout.isEligibleForPointsDiscount());
    }

    @Test
    public void testDiscEligible(){
        Assertions.assertEquals(true, checkout.isEligibleForLoyaltyDiscount());
    }

    @Test
    public void testCheckoutProcessing(){
        Assertions.assertEquals(4275, checkout.calculateOrderWithDiscounts());
    }

    @Test
    public void testOrderProcessing(){

        Exception exception = assertThrows(InsufficientFundsException.class, () -> {
            checkout.processOrder();
        });

    }

    @Test
    public void testCustomerAfterOrder() throws InsufficientFundsException {
        double balanceBefore = customer.getBalance();
        checkout.processOrder();
        Assertions.assertNotEquals(balanceBefore, customer.getBalance());
    }
}
