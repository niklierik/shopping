public class Program {

    public static Shop initShop() {
        var shop = new Shop();
        shop.addProduct(new Product("A", 55));
        shop.addProduct(new Product("B", 20));
        shop.addProduct(new Product("C", 60));
        shop.addProduct(new Product("D", 10));
        shop.addProduct(new Product("E", 45));
        shop.addRule(new RuleAAC(shop));
        shop.addRule(new RuleDDD(shop));
        shop.addRule(new RuleED());
        return shop;
    }

    public static void main(String[] args) {
        var shop = initShop();
        var price = shop.shopIds(args);
        System.out.println(price);
    }
}