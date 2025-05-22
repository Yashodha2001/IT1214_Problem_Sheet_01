// Student class with all required components
class Student {
    private int studentId;
    private String name;
    private int daysAttended;

    // Complete constructor
    public Student(int studentId, String name, int daysAttended) {
        this.studentId = studentId;
        this.name = name;
        this.daysAttended = daysAttended;
    }

    // All getters and setters
    public int getStudentId() { return studentId; }
    public String getName() { return name; }
    public int getDaysAttended() { return daysAttended; }
    public void setStudentId(int studentId) { this.studentId = studentId; }
    public void setName(String name) { this.name = name; }
    public void setDaysAttended(int daysAttended) { this.daysAttended = daysAttended; }
}

// Classroom class with all required functionality
class Classroom {
    private Student[] students;
    private int studentCount;

    public Classroom() {
        students = new Student[10]; // Fixed size array
        studentCount = 0;
    }

    // Method to add student with boundary check
    public void addStudent(Student student) {
        if (studentCount < 10) {
            students[studentCount++] = student;
        } else {
            System.out.println("Classroom is at full capacity (10 students)");
        }
    }

    // Method to update attendance by ID
    public void updateAttendance(int studentId, int days) {
        for (int i = 0; i < studentCount; i++) {
            if (students[i].getStudentId() == studentId) {
                students[i].setDaysAttended(days);
                return;
            }
        }
        System.out.println("Student ID " + studentId + " not found");
    }

    // Method to display all students
    public void displayAllStudents() {
        System.out.println("Student ID\tName\t\tDays Attended");
        System.out.println("----------------------------------------");
        for (int i = 0; i < studentCount; i++) {
            System.out.printf("%-10d\t%-15s\t%d\n",
                students[i].getStudentId(),
                students[i].getName(),
                students[i].getDaysAttended());
        }
    }
}

// Main class with demonstration
public class Main {
    public static void main(String[] args) {
        Classroom classroom = new Classroom();
        
        // Add initial students
        classroom.addStudent(new Student(101, "Alice Smith", 12));
        classroom.addStudent(new Student(102, "Bob Jones", 15));
        classroom.addStudent(new Student(103, "Carol Lee", 10));
        
        // Update attendance
        classroom.updateAttendance(102, 16); // Valid update
        classroom.updateAttendance(104, 5);  // Invalid ID
        
        // Display all
        classroom.displayAllStudents();
    }
}

