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

    @ParameterizedTest
    @ValueSource(strings = {"1111", "2222"})
    public void productSerialTest(String input){

        Assertions.assertEquals(input,product.getSerialNumber());
    }
    @Test
    public void productPriceTest(){

        Assertions.assertNotNull(product.getPrice());
    }
}
