import java.util.Collection;

/**
 * After each two D, you get a free D
 */
public class RuleDDD extends Rule {

    public final String PRODUCT_ID = Product.D_ID;

    // how many D is needed for discount
    public final int THRESHOLD = 2;

    private final Shop shop;

    private int discountAmount = -1;

    public RuleDDD(Shop shop) {
        this.shop = shop;
    }

    public int getDiscountAmount() {
        if (discountAmount == -1) {
            discountAmount = shop.getProduct(PRODUCT_ID).price();
        }
        return discountAmount;
    }

    @Override
    public int apply(Collection<Product> products, int currentPrice) {
        int numberOfD = 0;
        int freeD = 0;
        for (Product product : products) {
            if (PRODUCT_ID.equals(product.name())) {
                numberOfD++;
                if (numberOfD == THRESHOLD) {
                    numberOfD = 0;
                    freeD++;
                }
            }
        }
        var discount = getDiscountAmount() * freeD;
        return currentPrice - discount;
    }
}
