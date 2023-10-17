import model.Customer;
import model.Product;
import model.ShoppingCart;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ShoppingCartTest {

    static Customer customer;
    static ShoppingCart shoppingCart;

    static List<Product> products;

    @BeforeAll
    public static void init(){
        customer = new Customer("1", LocalDate.now().minusYears(2),null,5000);
        shoppingCart = new ShoppingCart(customer);
        products  =  new ArrayList<>();
        products.add(new Product("bread","1111",1000,100));
        products.add(new Product("cheese","1112",1500,150));
        products.add(new Product("milk","1113",2000,200));

    }
    @Test
    public void checkTotalTest(){
        shoppingCart.setItems(products);
        Assertions.assertEquals(4500, shoppingCart.getTotal());
    }

    @Test
    public void checkPointTest(){
        shoppingCart.setItems(products);
        Assertions.assertEquals(450, shoppingCart.getPoints());
    }
}
