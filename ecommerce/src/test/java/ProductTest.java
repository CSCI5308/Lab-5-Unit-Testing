import model.Product;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class ProductTest {

    static Product product;

    @BeforeAll
    public static void init(){
        product = new Product("bread","1111",1000,100);
    }

    @Test
    public void productNameTest(){
        Assertions.assertEquals("bread",product.getName());
    }

    @Test
    public void productSerialTest(){
        //TODO: Test if the product serial number is correct
    }

    @ParameterizedTest
    @ValueSource(doubles = {1000, 2000})
    public void productPriceTest(double input){
        Assertions.assertEquals(input, product.getPrice(), "Price is not correct");
    }


}
