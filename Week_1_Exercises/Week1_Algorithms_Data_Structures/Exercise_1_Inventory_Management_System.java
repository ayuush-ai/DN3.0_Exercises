import java.util.HashMap;

class Product {
    private String productId;
    private String productName;
    private int quantity;
    private double price;

    public Product(String productId, String productName, int quantity, double price) {
        this.productId = productId;
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
    }

    // Getters and Setters
    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}

public class Exercise_1_Inventory_Management_System {
    private HashMap<String, Product> inventory;

    public Exercise_1_Inventory_Management_System() {
        inventory = new HashMap<>();
    }

    public void addProduct(Product product) {
        inventory.put(product.getProductId(), product);
    }

    public void updateProduct(String productId, Product newProduct) {
        if (inventory.containsKey(productId)) {
            inventory.put(productId, newProduct);
        } else {
            System.out.println("Product not found in inventory.");
        }
    }

    public void deleteProduct(String productId) {
        if (inventory.containsKey(productId)) {
            inventory.remove(productId);
        } else {
            System.out.println("Product not found in inventory.");
        }
    }

    public Product getProduct(String productId) {
        return inventory.get(productId);
    }

    public void displayInventory() {
        for (Product product : inventory.values()) {
            System.out.println("Product ID: " + product.getProductId());
            System.out.println("Product Name: " + product.getProductName());
            System.out.println("Quantity: " + product.getQuantity());
            System.out.println("Price: " + product.getPrice());
            System.out.println("---------------------------");
        }
    }

    public static void main(String[] args) {
        Exercise_1_Inventory_Management_System ims = new Exercise_1_Inventory_Management_System();

        // Add products
        Product product1 = new Product("101", "Product A", 50, 99.99);
        Product product2 = new Product("102", "Product B", 30, 149.99);
        ims.addProduct(product1);
        ims.addProduct(product2);

        // Display inventory
        ims.displayInventory();

        // Update a product
        Product updatedProduct = new Product("101", "Product A+", 60, 89.99);
        ims.updateProduct("101", updatedProduct);

        // Display inventory after update
        ims.displayInventory();

        // Delete a product
        ims.deleteProduct("102");

        // Display inventory after deletion
        ims.displayInventory();
    }
}
