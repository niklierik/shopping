public class Program {


    public static void main(String[] args) {
        var shop = Shop.initShop();
        var price = shop.shopIds(args);
        System.out.println(price);
    }
}