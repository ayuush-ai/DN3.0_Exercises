// ProxyPatternExample.java

// Step 2: Define Subject Interface
interface Image {
    void display();
}

// Step 3: Implement Real Subject Class
class RealImage implements Image {
    private String fileName;

    public RealImage(String fileName) {
        this.fileName = fileName;
        loadFromRemoteServer(fileName);
    }

    private void loadFromRemoteServer(String fileName) {
        System.out.println("Loading " + fileName + " From Remote Server...");
    }

    @Override
    public void display() {
        System.out.println("Displaying " + fileName);
    }
}

// Step 4: Implement Proxy Class
class ProxyImage implements Image {
    private RealImage realImage;
    private String fileName;

    public ProxyImage(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void display() {
        if (realImage == null) {
            realImage = new RealImage(fileName);
        }
        realImage.display();
    }
}

// Step 5: Test the Proxy Implementation
public class Exercise_6_Implementing_the_Proxy_Pattern {
    public static void main(String[] args) {
        Image image1 = new ProxyImage("Photo1.jpg");
        Image image2 = new ProxyImage("Photo2.jpg");

        // Image will be loaded from remote server
        image1.display();
        System.out.println("");

        // Image will not be loaded from remote server
        image1.display();
        System.out.println("");

        // Image will be loaded from remote server
        image2.display();
        System.out.println("");

        // Image will not be loaded from remote server
        image2.display();
    }
}
