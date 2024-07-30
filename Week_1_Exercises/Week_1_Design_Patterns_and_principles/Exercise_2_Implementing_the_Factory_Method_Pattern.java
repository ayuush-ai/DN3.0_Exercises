// Save this file as Exercise_3.java

// Step 2: Define a Product Class

class Computer {
    // Attributes of the Computer
    private String CPU;
    private String RAM;
    private String storage;
    private String GPU;
    private String powerSupply;
    private String motherboard;

    // Private constructor to enforce the use of the Builder
    private Computer(Builder builder) {
        this.CPU = builder.CPU;
        this.RAM = builder.RAM;
        this.storage = builder.storage;
        this.GPU = builder.GPU;
        this.powerSupply = builder.powerSupply;
        this.motherboard = builder.motherboard;
    }

    // Getters for the attributes (optional)
    public String getCPU() {
        return CPU;
    }

    public String getRAM() {
        return RAM;
    }

    public String getStorage() {
        return storage;
    }

    public String getGPU() {
        return GPU;
    }

    public String getPowerSupply() {
        return powerSupply;
    }

    public String getMotherboard() {
        return motherboard;
    }

    @Override
    public String toString() {
        return "Computer [CPU=" + CPU + ", RAM=" + RAM + ", storage=" + storage + ", GPU=" + GPU
                + ", powerSupply=" + powerSupply + ", motherboard=" + motherboard + "]";
    }

    // Step 3: Implement the Builder Class
    public static class Builder {
        private String CPU;
        private String RAM;
        private String storage;
        private String GPU;
        private String powerSupply;
        private String motherboard;

        public Builder setCPU(String CPU) {
            this.CPU = CPU;
            return this;
        }

        public Builder setRAM(String RAM) {
            this.RAM = RAM;
            return this;
        }

        public Builder setStorage(String storage) {
            this.storage = storage;
            return this;
        }

        public Builder setGPU(String GPU) {
            this.GPU = GPU;
            return this;
        }

        public Builder setPowerSupply(String powerSupply) {
            this.powerSupply = powerSupply;
            return this;
        }

        public Builder setMotherboard(String motherboard) {
            this.motherboard = motherboard;
            return this;
        }

        // Build method to create an instance of Computer
        public Computer build() {
            return new Computer(this);
        }
    }
}

// Step 5: Test the Builder Implementation
public class Exercise_3_Implementing_the_Builder_Pattern {
    public static void main(String[] args) {
        // Creating different configurations of Computer using the Builder pattern
        Computer gamingPC = new Computer.Builder()
                .setCPU("Intel i5")
                .setRAM("16GB")
                .setStorage("1TB SSD")
                .setGPU("intel graphics 620")
                .setPowerSupply("50W")
                .setMotherboard("dell latitude")
                .build();

        Computer officePC = new Computer.Builder()
                .setCPU("Intel i3")
                .setRAM("6GB")
                .setStorage("1tb SSD")
                .setPowerSupply("5W")
                .setMotherboard("samsung")
                .build();

        System.out.println("professional/personel PC Configuration: " + gamingPC);
        System.out.println("Office PC Configuration: " + officePC);
    }
}
