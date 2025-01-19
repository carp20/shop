import java.util.ArrayList;
import java.util.List;

public class Shop {
        private List<Product> products;
        private double balance;

        public Shop() {
                products = new ArrayList<>();
                balance = 0.0;
        }

        public void addProduct(Product product) {
                products.add(product);
        }

        public boolean buyProduct(String productName, double money) {
                for (Product product : products) {
                        if (product.getName().equalsIgnoreCase(productName)) {
                                if (money >= product.getPrice()) {
                                        System.out.println("Покупка успешна! Вы купили " + product.getName());
                                        balance += product.getPrice();
                                        return true;
                                } else {
                                        System.out.println("Недостаточно средств для покупки.");
                                        return false;
                                }
                        }
                }
                System.out.println("Продукт не найден.");
                return false;
        }

        public boolean sellProduct(String productName, double price) {
                for (int i = 0; i < products.size(); i++) {
                        if (products.get(i).getName().equalsIgnoreCase(productName)) {
                                System.out.println("Продана единица товара " + productName);
                                balance -= price;
                                products.remove(i);
                                return true;
                        }
                }
                System.out.println("Продукт не найден.");
                return false;
        }

        public void listProducts() {
                if (products.isEmpty()) {
                        System.out.println("Нет товаров в магазине.");
                } else {
                        System.out.println("Список товаров:");
                        for (Product product : products) {
                                System.out.println(product.getName() + product.getPrice());
                        }
                }
        }

        public double getBalance() {
                return balance;
        }
}