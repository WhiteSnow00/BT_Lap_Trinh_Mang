import java.util.Scanner;

abstract class Employee {
    protected String name;

    public Employee(String name) {
        this.name = name;
    }

    public abstract double earnings();
}

class Boss extends Employee {
    private double monthlySalary;

    public Boss(String name, double monthlySalary) {
        super(name);
        this.monthlySalary = monthlySalary;
    }

    public double earnings() {
        return this.monthlySalary;
    }
}

class PieceWorker extends Employee {
    private int numProducts;

    public PieceWorker(String name, int numProducts) {
        super(name);
        this.numProducts = numProducts;
    }

    public double earnings() {
        return this.numProducts * 0.5;
    }
}

class CommissionWorker extends Employee {
    private double baseSalary;
    private int numProductsSold;

    public CommissionWorker(String name, double baseSalary, int numProductsSold) {
        super(name);
        this.baseSalary = baseSalary;
        this.numProductsSold = numProductsSold;
    }

    public double earnings() {
        return this.baseSalary + (this.numProductsSold * 0.1);
    }
}

public class ex4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter boss name: ");
        String bossName = scanner.nextLine();
        System.out.print("Enter boss monthly salary: ");
        double bossSalary = scanner.nextDouble();
        Boss boss = new Boss(bossName, bossSalary);
        System.out.println(boss.name + " earns: $" + boss.earnings());

        scanner.nextLine(); 

        System.out.print("Enter piece worker name: ");
        String pieceWorkerName = scanner.nextLine();
        System.out.print("Enter number of products for piece worker: ");
        int numProducts = scanner.nextInt();
        PieceWorker pieceWorker = new PieceWorker(pieceWorkerName, numProducts);
        System.out.println(pieceWorker.name + " earns: $" + pieceWorker.earnings());

        scanner.nextLine(); 

        System.out.print("Enter commission worker name: ");
        String commissionWorkerName = scanner.nextLine();
        System.out.print("Enter commission worker base salary: ");
        double baseSalary = scanner.nextDouble();
        System.out.print("Enter number of products sold by commission worker: ");
        int numProductsSold = scanner.nextInt();
        CommissionWorker commissionWorker = new CommissionWorker(commissionWorkerName, baseSalary, numProductsSold);
        System.out.println(commissionWorker.name + " earns: $" + commissionWorker.earnings());

        scanner.close();
    }
}
