import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ShopTest {


    Shop shop;

    @BeforeEach
    public void init() {
        shop = Shop.initShop();
    }

    @Test
    public void shopTestAAB() {
        Assertions.assertEquals(2 * Product.A_PRICE + Product.B_PRICE, shop.shopIds("A", "A", "B"));
    }

    @Test
    public void shopTestAAC() {
        Assertions.assertEquals(2 * Product.A_PRICE + (Product.C_PRICE / 2), shop.shopIds("A", "A", "C"));
    }

    @Test
    public void shopTestAACC() {
        Assertions.assertEquals(2 * Product.A_PRICE + Product.C_PRICE * 1.5, shop.shopIds("A", "A", "C", "C"));
    }

    @Test
    public void shopTestAAACC() {
        Assertions.assertEquals(3 * Product.A_PRICE + Product.C_PRICE * 1.5, shop.shopIds("A", "A", "C", "C"));
    }

    @Test
    public void shopTestAAAACC() {
        Assertions.assertEquals(4 * Product.A_PRICE + Product.C_PRICE, shop.shopIds("A", "A", "A", "A", "C", "C"));
    }

    @Test
    public void shopTestDD() {
        Assertions.assertEquals(2 * Product.D_PRICE, shop.shopIds("D", "D"));
    }

    @Test
    public void shopTestDDD() {
        Assertions.assertEquals(2 * Product.D_PRICE, shop.shopIds("D", "D", "D"));
    }

    @Test
    public void shopTestDDDD() {
        Assertions.assertEquals(3 * Product.D_PRICE, shop.shopIds("D", "D", "D", "D"));
    }

    @Test
    public void shopTestDDDDD() {
        Assertions.assertEquals(4 * Product.D_PRICE, shop.shopIds("D", "D", "D", "D", "D"));
    }

    @Test
    public void shopTestDDDDDD() {
        Assertions.assertEquals(4 * Product.D_PRICE, shop.shopIds("D", "D", "D", "D", "D", "D"));
    }

    @Test
    public void shopTestED() {
        Assertions.assertEquals(Math.round((Product.E_PRICE + Product.D_PRICE) * 1.3), shop.shopIds("E", "D"));
    }

    @Test
    public void shopTestEEDD() {
        Assertions.assertEquals(Math.round((2 * Product.E_PRICE + 2 * Product.D_PRICE) * 1.3), shop.shopIds("E", "D", "E", "D"));
    }

}
