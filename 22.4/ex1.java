import java.util.ArrayList;
import java.util.Scanner;

abstract class CanBo {
    private String name;
    private int birthYear;
    private String gender;
    private String address;

    public CanBo(String name, int birthYear, String gender, String address) {
        this.name = name;
        this.birthYear = birthYear;
        this.gender = gender;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public String getGender() {
        return gender;
    }

    public String getAddress() {
        return address;
    }

    public abstract String displayInfo();
}

class NhanVien extends CanBo {
    private String job;

    public NhanVien(String name, int birthYear, String gender, String address, String job) {
        super(name, birthYear, gender, address);
        this.job = job;
    }

    public String getJob() {
        return job;
    }

    @Override
    public String displayInfo() {
        return "NhanVien{" +
                "name=" + getName() +
                ", birthYear=" + getBirthYear() +
                ", gender=" + getGender() +
                ", address=" + getAddress() +
                ", job=" + job +
                '}';
    }
}

class CongNhan extends CanBo {
    private int level;

    public CongNhan(String name, int birthYear, String gender, String address, int level) {
        super(name, birthYear, gender, address);
        this.level = level;
    }

    public int getLevel() {
        return level;
    }

    @Override
    public String displayInfo() {
        return "CongNhan{" +
                "name=" + getName() +
                ", birthYear=" + getBirthYear() +
                ", gender=" + getGender() +
                ", address=" + getAddress() +
                ", level=" + level +
                '}';
    }
}

class KySu extends CanBo {
    private String major;

    public KySu(String name, int birthYear, String gender, String address, String major) {
        super(name, birthYear, gender, address);
        this.major = major;
    }

    public String getMajor() {
        return major;
    }

    @Override
    public String displayInfo() {
        return "KySu{" +
                "name=" + getName() +
                ", birthYear=" + getBirthYear() +
                ", gender=" + getGender() +
                ", address=" + getAddress() +
                ", major=" + major +
                '}';
    }
}

class QLCB {
    private ArrayList<CanBo> canBoList = new ArrayList<>();

    public void addCanBo(CanBo canBo) {
        canBoList.add(canBo);
    }

    public ArrayList<CanBo> searchByName(String name) {
        ArrayList<CanBo> result = new ArrayList<>();
        for (CanBo canBo : canBoList) {
            if (canBo.getName().equals(name)) {
                result.add(canBo);
            }
        }
        return result;
    }

    public void displayAll() {
        for (CanBo canBo : canBoList) {
            System.out.println(canBo.displayInfo());
        }
    }
}

public class ex1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        QLCB qlcb = new QLCB();
        boolean exit = false;

        while (!exit) {
            System.out.println("1. Nhap thong tin moi cho can bo");
            System.out.println("2. Tim kiem theo ho ten");
            System.out.println("3. Hien thi thong tin danh sach can bo");
            System.out.println("4. Thoat chuong trinh");
            System.out.print("Nhap lua chon cua ban: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
    
            switch (choice) {
                case 1:
                    System.out.print("Nhap loai can bo (NhanVien, CongNhan, KySu): ");
                    String type = scanner.nextLine();
    
                    System.out.print("Nhap ten: ");
                    String name = scanner.nextLine();
    
                    System.out.print("Nhap nam sinh: ");
                    int birthYear = scanner.nextInt();
                    scanner.nextLine();
    
                    System.out.print("Nhap gioi tinh: ");
                    String gender = scanner.nextLine();
    
                    System.out.print("Nhap dia chi: ");
                    String address = scanner.nextLine();
    
                    if (type.equalsIgnoreCase("NhanVien")) {
                        System.out.print("Nhap nghe nghiep: ");
                        String job = scanner.nextLine();
                        qlcb.addCanBo(new NhanVien(name, birthYear, gender, address, job));
                    } else if (type.equalsIgnoreCase("CongNhan")) {
                        System.out.print("Nhap cap bac: ");
                        int level = scanner.nextInt();
                        scanner.nextLine();
                        qlcb.addCanBo(new CongNhan(name, birthYear, gender, address, level));
                    } else if (type.equalsIgnoreCase("KySu")) {
                        System.out.print("Nhap nganh dao tao: ");
                        String major = scanner.nextLine();
                        qlcb.addCanBo(new KySu(name, birthYear, gender, address, major));
                    } else {
                        System.out.println("Sai loai can bo!");
                    }
                    break;
                case 2:
                    System.out.print("Nhap ten de tim kiem: ");
                    String searchName = scanner.nextLine();
                    ArrayList<CanBo> searchResult = qlcb.searchByName(searchName);
                    if (searchResult.size() > 0) {
                        for (CanBo canBo : searchResult) {
                            System.out.println(canBo.displayInfo());
                        }
                    } else {
                        System.out.println("Khong co canbo nao co ten nhu vay.");
                    }
                    break;
                case 3:
                    qlcb.displayAll();
                    break;
                case 4:
                    exit = true;
                    break;
                default:
                    System.out.println("Lua chon khong hop le, vui long thu lai.");
            }
        }
        scanner.close();
    }
}
    
