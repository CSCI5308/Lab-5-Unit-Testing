import model.Customer;
import model.Product;
import model.ShoppingCart;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.ArrayList;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ShoppingcartTest {

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
        shoppingCart.setItems(products);
    }

    @Test
    public void checkTotalTest(){
//        shoppingCart.setItems(products);
        assertEquals(shoppingCart.getTotal(), 4500, "Total is not correct");
    }

}
