import java.util.*;

public class ShoppingCartSystem {
    // Class to represent a product
    static class Product {
        private String name;
        private double price;

        public Product(String name, double price) {
            this.name = name;
            this.price = price;
        }

        public String getName() {
            return name;
        }

        public double getPrice() {
            return price;
        }

        @Override
        public String toString() {
            return name + " ($" + price + ")";
        }
    }

    // Class to represent an item in the cart (with quantity)
    static class CartItem {
        private Product product;
        private int quantity;

        public CartItem(Product product, int quantity) {
            this.product = product;
            this.quantity = quantity;
        }

        public Product getProduct() {
            return product;
        }

        public int getQuantity() {
            return quantity;
        }

        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }

        public double getTotalPrice() {
            return product.getPrice() * quantity;
        }

        @Override
        public String toString() {
            return product.getName() + " x" + quantity + " ($" + getTotalPrice() + ")";
        }
    }

    // Shopping cart to manage products and their quantities
    static class ShoppingCart {
        private List<CartItem> cartItems;
        private Map<String, Product> productCatalog;

        public ShoppingCart() {
            cartItems = new ArrayList<>();
            productCatalog = new HashMap<>();
            // Sample products
            productCatalog.put("Laptop", new Product("Laptop", 999.99));
            productCatalog.put("Headphones", new Product("Headphones", 199.99));
            productCatalog.put("Mouse", new Product("Mouse", 29.99));
        }

        // Add product to cart
        public void addItem(String productName, int quantity) {
            Product product = productCatalog.get(productName);
            if (product == null) {
                System.out.println("Product not found!");
                return;
            }

            for (CartItem item : cartItems) {
                if (item.getProduct().getName().equals(productName)) {
                    item.setQuantity(item.getQuantity() + quantity);
                    System.out.println(quantity + " " + productName + "(s) added to the cart.");
                    return;
                }
            }

            cartItems.add(new CartItem(product, quantity));
            System.out.println(quantity + " " + productName + "(s) added to the cart.");
        }

        // Remove product from cart
        public void removeItem(String productName) {
            Iterator<CartItem> iterator = cartItems.iterator();
            while (iterator.hasNext()) {
                CartItem item = iterator.next();
                if (item.getProduct().getName().equals(productName)) {
                    iterator.remove();
                    System.out.println(productName + " removed from the cart.");
                    return;
                }
            }
            System.out.println("Product not found in the cart!");
        }

        // Update the quantity of a product in the cart
        public void updateQuantity(String productName, int newQuantity) {
            for (CartItem item : cartItems) {
                if (item.getProduct().getName().equals(productName)) {
                    item.setQuantity(newQuantity);
                    System.out.println("Updated " + productName + " to quantity " + newQuantity);
                    return;
                }
            }
            System.out.println("Product not found in the cart!");
        }

        // Calculate total price of the cart
        public double getTotalPrice() {
            double total = 0;
            for (CartItem item : cartItems) {
                total += item.getTotalPrice();
            }
            return total;
        }

        // Display all items in the cart
        public void displayCart() {
            if (cartItems.isEmpty()) {
                System.out.println("The cart is empty.");
                return;
            }
            System.out.println("\n--- Shopping Cart ---");
            for (CartItem item : cartItems) {
                System.out.println(item);
            }
            System.out.println("---------------------");
            System.out.println("Total Price: $" + getTotalPrice());
        }
    }

    // Main function with a simple menu to interact with the cart
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ShoppingCart cart = new ShoppingCart();
        
        // System.out.println("Yogesh Rathod");

        while (true) {
            System.out.println("\n--- Shopping Cart System ---");
            System.out.println("1. Add item to cart");
            System.out.println("2. Remove item from cart");
            System.out.println("3. Update item quantity");
            System.out.println("4. Display cart");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    System.out.print("Enter product name to add (Laptop, Headphones, Mouse): ");
                    String addProduct = scanner.nextLine();
                    System.out.print("Enter quantity: ");
                    int addQuantity = Integer.parseInt(scanner.nextLine());
                    cart.addItem(addProduct, addQuantity);
                    break;
                case "2":
                    System.out.print("Enter product name to remove: ");
                    String removeProduct = scanner.nextLine();
                    cart.removeItem(removeProduct);
                    break;
                case "3":
                    System.out.print("Enter product name to update: ");
                    String updateProduct = scanner.nextLine();
                    System.out.print("Enter new quantity: ");
                    int newQuantity = Integer.parseInt(scanner.nextLine());
                    cart.updateQuantity(updateProduct, newQuantity);
                    break;
                case "4":
                    cart.displayCart();
                    break;
                case "5":
                    System.out.println("Exiting program...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
