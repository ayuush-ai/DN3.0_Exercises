// Save this file as MVCPatternExample.java

// Step 2: Define Model Class
class Student {
    private String name;
    private int id;
    private String grade;

    public Student(String name, int id, String grade) {
        this.name = name;
        this.id = id;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
}

// Step 3: Define View Class
class StudentView {
    public void displayStudentDetails(String studentName, int studentId, String studentGrade) {
        System.out.println("Student Details:");
        System.out.println("Name: " + studentName);
        System.out.println("ID: " + studentId);
        System.out.println("Grade: " + studentGrade);
    }
}

// Step 4: Define Controller Class
class StudentController {
    private Student model;
    private StudentView view;

    public StudentController(Student model, StudentView view) {
        this.model = model;
        this.view = view;
    }

    public void setStudentName(String name) {
        model.setName(name);
    }

    public String getStudentName() {
        return model.getName();
    }

    public void setStudentId(int id) {
        model.setId(id);
    }

    public int getStudentId() {
        return model.getId();
    }

    public void setStudentGrade(String grade) {
        model.setGrade(grade);
    }

    public String getStudentGrade() {
        return model.getGrade();
    }

    public void updateView() {
        view.displayStudentDetails(model.getName(), model.getId(), model.getGrade());
    }
}

// Step 5: Test the MVC Implementation
public class Exercise_10_Implementing_the_MVC_Pattern {
    public static void main(String[] args) {
        // Create a model object
        Student student = new Student("ayaskanta", 1, "A");

        // Create a view object
        StudentView view = new StudentView();

        // Create a controller object
        StudentController controller = new StudentController(student, view);

        // Display initial student details
        controller.updateView();

        // Update student details
        controller.setStudentName("abhisek");
        controller.setStudentId(2);
        controller.setStudentGrade("B");

        // Display updated student details
        controller.updateView();
    }
}
