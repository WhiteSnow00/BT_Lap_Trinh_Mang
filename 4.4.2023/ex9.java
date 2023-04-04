import java.util.Arrays;
import java.util.Comparator;
import java.util.*;


class Person {
    protected String name;
    protected String address;

    public Person(String name, String address) {
        this.name = name;
        this.address = address;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Address: " + address;
    }
}

class Student extends Person {
    private double score1;
    private double score2;

    public Student(String name, String address, double score1, double score2) {
        super(name, address);
        this.score1 = score1;
        this.score2 = score2;
    }

    public double calculateAverageScore() {
        return (score1 + score2) / 2;
    }

    public String evaluate() {
        double avgScore = calculateAverageScore();
        if (avgScore >= 8.0) {
            return "Excellent";
        } else if (avgScore >= 6.5) {
            return "Good";
        } else if (avgScore >= 5.0) {
            return "Average";
        } else {
            return "Poor";
        }
    }

    @Override
    public String toString() {
        return super.toString() + ", Average Score: " + calculateAverageScore() + ", Evaluation: " + evaluate();
    }
}

class Employee extends Person {
    private double salaryCoefficient;

    public Employee(String name, String address, double salaryCoefficient) {
        super(name, address);
        this.salaryCoefficient = salaryCoefficient;
    }

    public double calculateSalary() {
        return salaryCoefficient * 1000;
    }

    public String evaluate() {
        double salary = calculateSalary();
        if (salary >= 20000) {
            return "High salary";
        } else if (salary >= 12000) {
            return "Average salary";
        } else {
            return "Low salary";
        }
    }

    @Override
    public String toString() {
        return super.toString() + ", Salary: " + calculateSalary() + ", Evaluation: " + evaluate();
    }
}

class Customer extends Person {
    private String companyName;
    private double invoiceValue;

    public Customer(String name, String address, String companyName, double invoiceValue) {
        super(name, address);
        this.companyName = companyName;
        this.invoiceValue = invoiceValue;
    }

    public String evaluate() {
        if (invoiceValue >= 100000) {
            return "VIP";
        } else if (invoiceValue >= 50000) {
            return "Gold";
        } else if (invoiceValue >= 10000) {
            return "Silver";
        } else {
            return "Normal";
        }
    }

    @Override
    public String toString() {
        return super.toString() + ", Company: " + companyName + ", Invoice Value: " + invoiceValue + ", Evaluation: " + evaluate();
    }
}
class Management {
    private Person[] people;
    private int totalPeople;
    private int capacity;

    public Management(int capacity) {
        this.capacity = capacity;
        this.people = new Person[capacity];
        this.totalPeople = 0;
    }

    public void addPerson(Person person) {
        if (totalPeople >= capacity) {
            capacity = (int) (capacity * 1.5);
            people = Arrays.copyOf(people, capacity);
        }
        people[totalPeople++] = person;
    }

    public void removePersonByName(String name) {
        for (int i = 0; i < totalPeople; i++) {
            if (people[i].name.equals(name)) {
                for (int j = i; j < totalPeople - 1; j++) {
                    people[j] = people[j + 1];
                }
                totalPeople--;
                break;
            }
        }
    }

    public void sortByName() {
        Arrays.sort(people, 0, totalPeople, Comparator.comparing(person -> person.name));
    }

    public void printList() {
        for (int i = 0; i < totalPeople; i++) {
            System.out.println(people[i]);
        }
    }
}

public class ex9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the initial capacity:");
        int capacity = scanner.nextInt();
        Management management = new Management(capacity);

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Add a person");
            System.out.println("2. Remove a person by name");
            System.out.println("3. Sort the list by name");
            System.out.println("4. Print the list");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); 

            if (choice == 5) {
                break;
            }

            switch (choice) {
                case 1:
                    System.out.println("Enter the person type (Student, Employee, Customer):");
                    String type = scanner.nextLine();
                    System.out.println("Enter the name:");
                    String name = scanner.nextLine();
                    System.out.println("Enter the address:");
                    String address = scanner.nextLine();

                    if (type.equalsIgnoreCase("Student")) {
                        System.out.println("Enter the score for subject 1:");
                        double subject1Score = scanner.nextDouble();
                        System.out.println("Enter the score for subject 2:");
                        double subject2Score = scanner.nextDouble();
                        management.addPerson(new Student(name, address, subject1Score, subject2Score));
                    } else if (type.equalsIgnoreCase("Employee")) {
                        System.out.println("Enter the salary coefficient:");
                        double salaryCoefficient = scanner.nextDouble();
                        management.addPerson(new Employee(name, address, salaryCoefficient));
                    } else if (type.equalsIgnoreCase("Customer")) {
                        System.out.println("Enter the company name:");
                        String companyName = scanner.nextLine();
                        System.out.println("Enter the invoice value:");
                        double invoiceValue = scanner.nextDouble();
                        management.addPerson(new Customer(name, address, companyName, invoiceValue));
                    } else {
                        System.out.println("Invalid person type. Please try again.");
                    }
                    break;
                case 2:
                    System.out.println("Enter the name of the person to remove:");
                    String personName = scanner.nextLine();
                    management.removePersonByName(personName);
                    break;
                case 3:
                    management.sortByName();
                    break;
                case 4:
                    management.printList();
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }
}