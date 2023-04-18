import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

abstract class Person {
    abstract void input();
    abstract void display();
}

class Student extends Person {
    String name;
    int age;
    String nativePlace;
    String studentId;

    public Student(String name, int age, String nativePlace, String studentId) {
        this.name = name;
        this.age = age;
        this.nativePlace = nativePlace;
        this.studentId = studentId;
    }

    void input() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter name: ");
        name = scanner.nextLine();
        System.out.print("Enter age: ");
        age = scanner.nextInt();
        scanner.nextLine(); // Consume newline left-over
        System.out.print("Enter native place: ");
        nativePlace = scanner.nextLine();
        System.out.print("Enter student ID: ");
        studentId = scanner.nextLine();
    }

    void display() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Native Place: " + nativePlace);
        System.out.println("Student ID: " + studentId);
    }
}

class ManagerStudent {
    int n;
    List<Student> students;

    public ManagerStudent(int n) {
        this.n = n;
        students = new ArrayList<>();
    }

    void input() {
        for (int i = 0; i < n; i++) {
            System.out.println("Enter data for student " + (i + 1) + ":");
            Student student = new Student(null, 0, null, null);
            student.input();
            students.add(student);
        }
    }

    void display() {
        for (Student student : students) {
            student.display();
        }
    }

    void sortByName() {
        students.sort(Comparator.comparing(student -> student.name));
    }

    Student searchByName(String name) {
        for (Student student : students) {
            if (student.name.equals(name)) {
                return student;
            }
        }
        return null;
    }
}

public class ex1 {
    static int menu() {
        System.out.println("1. Input data.");
        System.out.println("2. Display data.");
        System.out.println("3. Sort by name.");
        System.out.println("4. Search by name.");
        System.out.println("5. Exit.");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of students: ");
        int n = scanner.nextInt();
        ManagerStudent managerStudent = new ManagerStudent(n);

        while (true) {
            int choice = menu();
            scanner.nextLine(); // Consume newline left-over

            if (choice == 1) {
                managerStudent.input();
            } else if (choice == 2) {
                managerStudent.display();
            } else if (choice == 3) {
                managerStudent.sortByName();
            } else if (choice == 4) {
                System.out.print("Enter the name to search: ");
                String name = scanner.nextLine();
                Student student = managerStudent.searchByName(name);
                if (student != null) {
                    student.display();
                } else {
                    System.out.println("Student not found.");
                }
            } else if (choice == 5) {
                System.out.println("Exiting...");
                break;
            } else {
                System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
