

import java.util.Arrays;

class Employee {
    private String employeeId;
    private String name;
    private String position;
    private double salary;

    public Employee(String employeeId, String name, String position, double salary) {
        this.employeeId = employeeId;
        this.name = name;
        this.position = position;
        this.salary = salary;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public String getName() {
        return name;
    }

    public String getPosition() {
        return position;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Employee ID: " + employeeId + ", Name: " + name + ", Position: " + position + ", Salary: " + salary;
    }
}

public class Exercise_4_Employee_Management_System {
    private Employee[] employees;
    private int size;
    private int capacity;

    public Exercise_4_Employee_Management_System(int capacity) {
        this.capacity = capacity;
        this.employees = new Employee[capacity];
        this.size = 0;
    }

    // Method to add an employee
    public void addEmployee(Employee employee) {
        if (size < capacity) {
            employees[size] = employee;
            size++;
        } else {
            System.out.println(" more employees cannot be added,(as array is fuull)");
        }
    }

    // Method to search for an employee by employeeId
    public Employee searchEmployee(String employeeId) {
        for (int i = 0; i < size; i++) {
            if (employees[i].getEmployeeId().equals(employeeId)) {
                return employees[i];
            }
        }
        return null;
    }

    // Method to traverse and display all employees
    public void traverseEmployees() {
        for (int i = 0; i < size; i++) {
            System.out.println(employees[i]);
        }
    }

    // Method to delete an employee by employeeId
    public void deleteEmployee(String employeeId) {
        int index = -1;
        for (int i = 0; i < size; i++) {
            if (employees[i].getEmployeeId().equals(employeeId)) {
                index = i;
                break;
            }
        }
        if (index != -1) {
            for (int i = index; i < size - 1; i++) {
                employees[i] = employees[i + 1];
            }
            employees[size - 1] = null;
            size--;
        } else {
            System.out.println("the employees for which we were searching for not found ");
        }
    }

    public static void main(String[] args) {
        Exercise_4_Employee_Management_System empManagement = new Exercise_4_Employee_Management_System(5);

        Employee emp1 = new Employee("001", "abhisek", "Developer", 70000);
        Employee emp2 = new Employee("002", "dev", "Developer", 60000);
        Employee emp3 = new Employee("003", "ayaskanta", "Designer", 50000);

        // Add employees
        empManagement.addEmployee(emp1);
        empManagement.addEmployee(emp2);
        empManagement.addEmployee(emp3);

        // Traverse employees
        System.out.println("total Employees:");
        empManagement.traverseEmployees();

        // Search for an employee
        System.out.println("\nSearching for Employee with ID '002':......");
        Employee foundEmployee = empManagement.searchEmployee("002");
        System.out.println(foundEmployee != null ? foundEmployee : "Employee not found.");

        // Delete an employee
        System.out.println("\n The Deleted Employee with ID '002'");
        empManagement.deleteEmployee("002");

        // Traverse employees after deletion
        System.out.println("\nAll Employees after deletion:");
        empManagement.traverseEmployees();
    }
}
