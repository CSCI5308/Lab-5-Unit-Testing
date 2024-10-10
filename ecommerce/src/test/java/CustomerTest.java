import model.Customer;
import model.Product;
import model.ShoppingCart;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

public class CustomerTest {

   static  List<Product> products;
    static ShoppingCart shoppingCart;
    static Customer customer;

    @BeforeAll
    public static void init(){
        customer = new Customer("1", LocalDate.now().minusYears(2),null,5000);
    }

    @Test
    public void customerIdTest(){
        Assertions.assertEquals("1",customer.getCustomerID());
    }

    @Test
    public void checkYearJoined(){
        //TODO: Test if the customers join date is before current date
    }

    @Test
    public void checkBalance(){
        //TODO: Test if the customers balance is correct
        Assertions.assertEquals(4000,customer.getBalance(), "Balance is not correct");
    }
}
