import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ShopTest {

    public static final int A_PRICE = 55;
    public static final int B_PRICE = 20;
    public static final int C_PRICE = 60;
    public static final int D_PRICE = 10;
    public static final int E_PRICE = 45;

    Shop shop;

    @BeforeEach
    public void init() {
        shop = Shop.initShop();
    }

    @Test
    public void shopTestAAB() {
        Assertions.assertEquals(2 * A_PRICE + B_PRICE, shop.shopIds("A", "A", "B"));
    }

    @Test
    public void shopTestAAC() {
        Assertions.assertEquals(2 * A_PRICE + (C_PRICE / 2), shop.shopIds("A", "A", "C"));
    }

    @Test
    public void shopTestAACC() {
        Assertions.assertEquals(2 * A_PRICE + C_PRICE * 1.5, shop.shopIds("A", "A", "C", "C"));
    }

    @Test
    public void shopTestAAACC() {
        Assertions.assertEquals(3 * A_PRICE + C_PRICE * 1.5, shop.shopIds("A", "A", "C", "C"));
    }

    @Test
    public void shopTestAAAACC() {
        Assertions.assertEquals(4 * A_PRICE + C_PRICE, shop.shopIds("A", "A", "C", "C"));
    }

    @Test
    public void shopTestDD() {
        Assertions.assertEquals(2 * D_PRICE, shop.shopIds("D", "D"));
    }

    @Test
    public void shopTestDDD() {
        Assertions.assertEquals(2 * D_PRICE, shop.shopIds("D", "D", "D"));
    }

    @Test
    public void shopTestDDDD() {
        Assertions.assertEquals(3 * D_PRICE, shop.shopIds("D", "D", "D", "D"));
    }

    @Test
    public void shopTestDDDDD() {
        Assertions.assertEquals(4 * D_PRICE, shop.shopIds("D", "D", "D", "D", "D"));
    }

    @Test
    public void shopTestDDDDDD() {
        Assertions.assertEquals(4 * D_PRICE, shop.shopIds("D", "D", "D", "D", "D", "D"));
    }

    @Test
    public void shopTestED() {
        Assertions.assertEquals((E_PRICE + D_PRICE) * 1.3, shop.shopIds("E", "D"));
    }

    @Test
    public void shopTestEEDD() {
        Assertions.assertEquals((2 * E_PRICE + 2 * D_PRICE) * 1.3, shop.shopIds("E", "D", "E", "D"));
    }

}
