import java.util.Arrays;
import java.util.Comparator;

class Product {
    private String productId;
    private String productName;
    private String category;

    public Product(String productId, String productName, String category) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
    }

    // Getters
    public String getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public String getCategory() {
        return category;
    }

    // toString method for easy printing
    @Override
    public String toString() {
        return "Product ID: " + productId + ", Product Name: " + productName + ", Category: " + category;
    }
}

public class Exercise_2_E_commerce_Platform_Search_Function {

    // Linear Search method
    public static Product linearSearch(Product[] products, String productName) {
        for (Product product : products) {
            if (product.getProductName().equalsIgnoreCase(productName)) {
                return product;
            }
        }
        return null;
    }

    // Binary Search method
    public static Product binarySearch(Product[] products, String productName) {
        Arrays.sort(products, Comparator.comparing(Product::getProductName));
        int left = 0, right = products.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int comparison = products[mid].getProductName().compareToIgnoreCase(productName);
            if (comparison == 0) {
                return products[mid];
            } else if (comparison < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Product[] products = {
            new Product("101", "Laptop", "Electronics"),
            new Product("102", "phone", "Electronics"),
            new Product("103", "bahamas", "Clothing"),
            new Product("104", "chappal", "Footwear"),
            new Product("105", "Watch", "Accessories")
        };

        // Linear Search
        Product result1 = linearSearch(products, "Phone");
        System.out.println("our Linear Search Result is: " + (result1 != null ? result1 : "Product you searched not found"));

        // Binary Search
        Product result2 = binarySearch(products, "Phone");
        System.out.println("Our Binary Search Result is: " + (result2 != null ? result2 : "Product you searched not found"));
    }
}
