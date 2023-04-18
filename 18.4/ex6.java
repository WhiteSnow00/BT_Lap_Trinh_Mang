
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

abstract class SinhVienPoly {
    String hoTen;
    String nganh;
  
    public SinhVienPoly(String hoTen, String nganh) {
      this.hoTen = hoTen;
      this.nganh = nganh;
    }
  
    public abstract double getDiem();
  
    public String getHocLuc() {
      if (getDiem() < 5) {
        return "Yếu";
      } else if (getDiem() <= 7) {
        return "Trung bình";
      } else if (getDiem() < 8) {
        return "Khá";
      } else {
        return "Giỏi";
      }
    }
  }
class SinhVienIT extends SinhVienPoly {
    private double diemJava;
    private double diemHtml;
    private double diemCss;

    public SinhVienIT(String hoTen, String nganh, double diemJava, double diemHtml, double diemCss) {
        super(hoTen, nganh);
        this.diemJava = diemJava;
        this.diemHtml = diemHtml;
        this.diemCss = diemCss;
    }

    @Override
    public double getDiem() {
        return (2 * diemJava + diemHtml + diemCss) / 4;
    }
}

class SinhVienBiz extends SinhVienPoly {
    private double diemMarketing;
    private double diemSales;

    public SinhVienBiz(String hoTen, String nganh, double diemMarketing, double diemSales) {
        super(hoTen, nganh);
        this.diemMarketing = diemMarketing;
        this.diemSales = diemSales;
    }

    @Override
    public double getDiem() {
        return (2 * diemMarketing + diemSales) / 3;
    }
}

class QuanLySinhVien {
    private List<SinhVienPoly> sinhVien;

    public QuanLySinhVien() {
        sinhVien = new ArrayList<>();
    }

    public void nhap() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập số lượng sinh viên: ");
        int n = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < n; i++) {
            System.out.print("Nhập ngành của sinh viên thứ " + (i + 1) + " (IT/Biz): ");
            String nganh = scanner.nextLine();
            System.out.print("Nhập họ tên của sinh viên thứ " + (i + 1) + ": ");
            String hoTen = scanner.nextLine();

            SinhVienPoly sv;
            if (nganh.equalsIgnoreCase("IT")) {
                System.out.print("Nhập điểm Java: ");
                double diemJava = scanner.nextDouble();
                System.out.print("Nhập điểm HTML: ");
                double diemHtml = scanner.nextDouble();
                System.out.print("Nhập điểm CSS: ");
                double diemCss = scanner.nextDouble();
                scanner.nextLine();

                sv = new SinhVienIT(hoTen, nganh, diemJava, diemHtml, diemCss);
            } else {
                System.out.print("Nhập điểm Marketing: ");
                double diemMarketing = scanner.nextDouble();
                System.out.print("Nhập điểm Sales: ");
                double diemSales = scanner.nextDouble();
                scanner.nextLine();

                sv = new SinhVienBiz(hoTen, nganh, diemMarketing, diemSales);
            }
            sinhVien.add(sv);
        }
    }

    public void xuat() {
        for (SinhVienPoly sv : sinhVien) {
            System.out.println("Tên: " + sv.hoTen + ", Ngành: " + sv.nganh + ", Điểm: " + sv.getDiem() + ", Học lực: " + sv.getHocLuc());
        }
    }

    public void xuatGioi() {
        System.out.println("Danh sách sinh viên giỏi:");
        for (SinhVienPoly sv : sinhVien) {
            if (sv.getHocLuc().equalsIgnoreCase("Giỏi")) {
                System.out.println("Tên: " + sv.hoTen + ", Ngành: " + sv.nganh + ", Điểm: " + sv.getDiem() + ", Học lực: " + sv.getHocLuc());
            }
        }
    }

    public void sapXep() {
        sinhVien.sort(Comparator.comparing(SinhVienPoly::getDiem).reversed());
    }

    public void menu() {
        System.out.println("1. Nhập danh sách sinh viên");
        System.out.println("2. Xuất thông tin sinh viên");
        System.out.println("3. Xuất danh sách sinh viên có học lực giỏi");
        System.out.println("4. Sắp xếp danh sách sinh viên theo điểm");
        System.out.println("5. Kết thúc");
    }
}

public class ex6 {
    public static void main(String[] args) {
        QuanLySinhVien quanLySinhVien = new QuanLySinhVien();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            quanLySinhVien.menu();
            System.out.print("Nhập lựa chọn của bạn: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    quanLySinhVien.nhap();
                    break;
                case 2:
                    quanLySinhVien.xuat();
                    break;
                case 3:
                    quanLySinhVien.xuatGioi();
                    break;
                case 4:
                    quanLySinhVien.sapXep();
                    System.out.println("Danh sách sau khi sắp xếp:");
                    quanLySinhVien.xuat();
                    break;
                case 5:
                    System.out.println("Kết thúc chương trình.");
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng nhập lại.");
            }
        }
    }
}

