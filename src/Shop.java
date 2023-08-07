import lombok.Getter;

import java.util.*;
import java.util.stream.Collectors;

public class Shop {

    // I could've put only (String, int) pairs into the map,
    // but with this approach, aditional info about the product can be stored
    @Getter
    private final HashMap<String, Product> products = new HashMap<>();

    /**
     * Order matters
     */
    @Getter
    private final List<Rule> rules = new ArrayList<>();

    public void addProduct(Product p) {
        products.put(p.name().toUpperCase(), p);
    }

    public void addRule(Rule r) {
        rules.add(r);
    }

    public Product getProduct(String id) {
        if (id == null) {
            throw new NullPointerException("Product ID cannot be null.");
        }
        id = id.toUpperCase();
        var product = products.get(id);
        if (product == null) {
            throw new NullPointerException("Product " + id + " does not exist.");
        }
        return product;
    }

    public int shopIds(String... products) {
        return shopIds(List.of(products));
    }

    public int shopIds(Collection<String> products) {
        return shopProducts(products.stream().map(this::getProduct).collect(Collectors.toList()));
    }

    public int shopProducts(Product... products) {
        return shopProducts(List.of(products));
    }

    public int shopProducts(Collection<Product> products) {
        int sum = products.stream().map(Product::price).reduce(0, Integer::sum);
        for (var rule : rules) {
            sum = rule.apply(products, sum);
        }
        return sum;
    }

}
