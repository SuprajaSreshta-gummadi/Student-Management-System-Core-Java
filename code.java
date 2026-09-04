import java.util.ArrayList;
import java.util.Scanner;

class Student {

    int id;
    String name;
    int age;
    String course;

    // Constructor
    public Student(int id, String name, int age, String course) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.course = course;
    }

    // Display student details
    public void displayStudent() {
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Course: " + course);
        System.out.println("---------------------------");
    }
}

public class Main {

    static ArrayList<Student> students = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    // ADD STUDENT
    public static void addStudent() {

        System.out.print("Enter Student ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        // Check duplicate ID
        for (Student student : students) {
            if (student.id == id) {
                System.out.println("Student ID already exists!");
                return;
            }
        }

        System.out.print("Enter Student Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Age: ");
        int age = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Course: ");
        String course = sc.nextLine();

        Student student = new Student(id, name, age, course);

        students.add(student);

        System.out.println("Student added successfully!");
    }

    // VIEW STUDENTS
    public static void viewStudents() {

        if (students.isEmpty()) {
            System.out.println("No students found.");
            return;
        }

        System.out.println("\n===== Student List =====");

        for (Student student : students) {
            student.displayStudent();
        }
    }

    // SEARCH STUDENT
    public static void searchStudent() {

        System.out.print("Enter Student ID to search: ");
        int id = sc.nextInt();

        for (Student student : students) {

            if (student.id == id) {
                System.out.println("\nStudent Found!");
                student.displayStudent();
                return;
            }
        }

        System.out.println("Student not found.");
    }

    // UPDATE STUDENT
    public static void updateStudent() {

        System.out.print("Enter Student ID to update: ");
        int id = sc.nextInt();
        sc.nextLine();

        for (Student student : students) {

            if (student.id == id) {

                System.out.print("Enter New Name: ");
                student.name = sc.nextLine();

                System.out.print("Enter New Age: ");
                student.age = sc.nextInt();
                sc.nextLine();

                System.out.print("Enter New Course: ");
                student.course = sc.nextLine();

                System.out.println("Student updated successfully!");
                return;
            }
        }

        System.out.println("Student not found.");
    }

    // DELETE STUDENT
    public static void deleteStudent() {

        System.out.print("Enter Student ID to delete: ");
        int id = sc.nextInt();

        for (Student student : students) {

            if (student.id == id) {

                students.remove(student);

                System.out.println("Student deleted successfully!");
                return;
            }
        }

        System.out.println("Student not found.");
    }

    // MAIN METHOD
    public static void main(String[] args) {

        while (true) {

            System.out.println("\n==============================");
            System.out.println("   STUDENT MANAGEMENT SYSTEM");
            System.out.println("==============================");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Search Student");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Exit");
            System.out.println("==============================");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    addStudent();
                    break;

                case 2:
                    viewStudents();
                    break;

                case 3:
                    searchStudent();
                    break;

                case 4:
                    updateStudent();
                    break;

                case 5:
                    deleteStudent();
                    break;

                case 6:
                    System.out.println("Thank you for using Student Management System!");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
