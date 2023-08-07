import java.util.Collection;

public class RuleED extends Rule {


    private final String PRODUCT1 = Product.D_ID;
    private final String PRODUCT2 = Product.E_ID;

    private static final double RAISE = 0.3;

    @Override
    public int apply(Collection<Product> products, int currentPrice) {
        boolean has1 = false;
        boolean has2 = false;
        for (var product : products) {
            if (PRODUCT1.equals(product.name())) {
                has1 = true;
            } else if (PRODUCT2.equals(product.name())) {
                has2 = true;
            }
        }
        if (has1 && has2) {
            return (int) Math.round(currentPrice * (RAISE + 1));
        }
        return currentPrice;
    }
}
