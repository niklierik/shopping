import java.util.Collection;

/**
 * After each two A, you get C half price
 */
public class RuleAAC extends Rule {

    // counting product, A
    public static final String COUNTING = Product.A_ID;

    // discounted product, C
    public static final String DISCOUNTABLE = Product.C_ID;

    // discount divider (2 means 50% off)
    public static final int DISCOUNT_DIVIDER = 2;
    // number of A's for each C discount
    public static final int NUMBER_THRESHOLD_FOR_COUNTING = 2;

    private final Shop shop;

    private int discountAmount = -1;

    public RuleAAC(Shop shop) {
        this.shop = shop;
    }

    public int getDiscountAmount() {
        if (discountAmount == -1) {
            discountAmount = shop.getProduct(DISCOUNTABLE).price() / DISCOUNT_DIVIDER;
        }
        return discountAmount;
    }

    @Override
    public int apply(Collection<Product> products, int currentPrice) {
        int numberOfA = 0;
        int numberOfC = 0;
        for (var product : products) {
            if (COUNTING.equals(product.name())) {
                numberOfA++;
            } else if (DISCOUNTABLE.equals(product.name())) {
                numberOfC++;
            }
        }
        numberOfA /= NUMBER_THRESHOLD_FOR_COUNTING;
        // if you (int) divide the number of A's you get the amount of discountable C's
        // then it chooses whether you have less A (already divided) or less C
        var discount = Math.min(numberOfA, numberOfC);
        // then multiply with the discount's price
        discount *= getDiscountAmount();
        // then subtract that from the current price
        return currentPrice - discount;
    }
}
