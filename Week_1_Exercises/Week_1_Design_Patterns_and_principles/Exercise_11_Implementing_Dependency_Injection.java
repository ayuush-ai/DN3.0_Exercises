// Save this file as DependencyInjectionExample.java

// Step 2: Define Repository Interface
interface CustomerRepository {
    String findCustomerById(int id);
}

// Step 3: Implement Concrete Repository
class CustomerRepositoryImpl implements CustomerRepository {
    @Override
    public String findCustomerById(int id) {
        // Simulate database access
        if (id == 1) {
            return "Ayaskanta Pradhan";
        } else {
            return "Customer does not exist";
        }
    }
}

// Step 4: Define Service Class
class CustomerService {
    private CustomerRepository customerRepository;

    // Step 5: Implement Dependency Injection via Constructor
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public String getCustomerName(int id) {
        return customerRepository.findCustomerById(id);
    }
}

// Step 6: Test the Dependency Injection Implementation
public class Exercise_11_Implementing_Dependency_Injection {
    public static void main(String[] args) {
        // Create an instance of CustomerRepository
        CustomerRepository customerRepository = new CustomerRepositoryImpl();

        // Inject the CustomerRepository into CustomerService
        CustomerService customerService = new CustomerService(customerRepository);

        // Use the CustomerService to find a customer
        String customerName = customerService.getCustomerName(1);
        System.out.println("Customer Name: " + customerName);
    }
}
