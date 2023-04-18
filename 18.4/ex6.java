import java.util.*;

abstract class SinhVienPoly {
    protected String name;

    public SinhVienPoly(String name) {
        this.name = name;
    }

    public abstract double getDiem();

    public String getHocLuc() {
        double diem = getDiem();
        if (diem >= 9) {
            return "Xuất sắc";
        } else if (diem >= 7.5) {
            return "Giỏi";
        } else if (diem >= 6.5) {
            return "Khá";
        } else if (diem >= 5) {
            return "Trung bình";
        } else {
            return "Yếu";
        }
    }
}

class SinhVienIT extends SinhVienPoly {
    private double java, html, css;

    public SinhVienIT(String name, double java, double html, double css) {
        super(name);
        this.java = java;
        this.html = html;
        this.css = css;
    }

    @Override
    public double getDiem() {
        return (2 * java + html + css) / 4;
    }
}

class SinhVienBiz extends SinhVienPoly {
    private double marketing, sales;

    public SinhVienBiz(String name, double marketing, double sales) {
        super(name);
        this.marketing = marketing;
        this.sales = sales;
    }

    @Override
    public double getDiem() {
        return (2 * marketing + sales) / 3;
    }
}

public class ex6 {
    private static SinhVienPoly nhapSV() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập tên sinh viên: ");
        String name = scanner.nextLine();
        System.out.print("Nhập loại sinh viên (IT/Biz): ");
        String stype = scanner.nextLine();

        if (stype.equalsIgnoreCase("IT")) {
            System.out.print("Nhập điểm Java: ");
            double java = scanner.nextDouble();
            System.out.print("Nhập điểm HTML: ");
            double html = scanner.nextDouble();
            System.out.print("Nhập điểm CSS: ");
            double css = scanner.nextDouble();
            return new SinhVienIT(name, java, html, css);
        } else {
            System.out.print("Nhập điểm Marketing: ");
            double marketing = scanner.nextDouble();
            System.out.print("Nhập điểm Sales: ");
            double sales = scanner.nextDouble();
            return new SinhVienBiz(name, marketing, sales);
        }
    }

    private static void xuatSV(List<SinhVienPoly> svList) {
        for (SinhVienPoly sv : svList) {
            System.out.println(sv.name + ", Điểm: " + sv.getDiem() + ", Học lực: " + sv.getHocLuc());
        }
    }

    private static void xuatGioi(List<SinhVienPoly> svList) {
        System.out.println("Danh sách sinh viên giỏi:");
        for (SinhVienPoly sv : svList) {
            if (sv.getHocLuc().equals("Giỏi")) {
                System.out.println(sv.name + ", Điểm: " + sv.getDiem());
            }
        }
    }

    private static void sapXep(List<SinhVienPoly> svList) {
        svList.sort(Comparator.comparing(SinhVienPoly::getDiem).reversed());
    }

    public static void main(String[] args) {
        List<SinhVienPoly> svList = new ArrayList<>();
        while (true) {
            System.out.println("1. Nhập danh sách sinh viên");
            System.out.println("2. Xuất thông tin sinh viên");
            System.out.println("3. Xuất danh sách sinh viên giỏi");
            System.out.println("4. Sắp xếp danh sách sinh viên theo điểm");
            System.out.println("5. Kết thúc");
            System.out.print("Nhập lựa chọn của bạn: ");
            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();

            if (choice == 1) {
                svList.add(nhapSV());
            } else if (choice == 2) {
                xuatSV(svList);
            } else if (choice == 3) {
                xuatGioi(svList);
            } else if (choice == 4) {
                sapXep(svList);
                System.out.println("Đã sắp xếp danh sách sinh viên theo điểm.");
            } else if (choice == 5) {
                break;
            }
        }
    }
}

