import java.util.Collection;
import java.util.List;

public abstract class Rule {

    /**
     * @param products     products in cart
     * @param currentPrice the current price
     * @return the returned price
     */
    public abstract int apply(Collection<Product> products, int currentPrice);

}
