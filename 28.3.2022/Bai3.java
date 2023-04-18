import java.util.ArrayList;
import java.util.Scanner;

class ThiSinh {
    private String soBaoDanh;
    private String hoTen;
    private String diaChi;
    private int mucUuTien;
    private String khoiThi;

    public ThiSinh(String soBaoDanh, String hoTen, String diaChi, int mucUuTien, String khoiThi) {
        this.soBaoDanh = soBaoDanh;
        this.hoTen = hoTen;
        this.diaChi = diaChi;
        this.mucUuTien = mucUuTien;
        this.khoiThi = khoiThi;
    }

    public String getSoBaoDanh() {
        return soBaoDanh;
    }

    public String getHoTen() {
        return hoTen;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public int getMucUuTien() {
        return mucUuTien;
    }

    public String getKhoiThi() {
        return khoiThi;
    }

    @Override
    public String toString() {
        return "So bao danh: " + soBaoDanh +
                ", Ho ten: " + hoTen +
                ", Dia chi: " + diaChi +
                ", Muc uu tien: " + mucUuTien +
                ", Khoi thi: " + khoiThi;
    }
}

class TuyenSinh {
    private ArrayList<ThiSinh> thiSinhs;

    public TuyenSinh() {
        thiSinhs = new ArrayList<>();
    }

    public void themMoiThiSinh() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap so bao danh: ");
        String soBaoDanh = sc.nextLine();
        System.out.print("Nhap ho ten: ");
        String hoTen = sc.nextLine();
        System.out.print("Nhap dia chi: ");
        String diaChi = sc.nextLine();
        System.out.print("Nhap muc uu tien: ");
        int mucUuTien = Integer.parseInt(sc.nextLine());
        System.out.print("Nhap khoi thi (A, B, C): ");
        String khoiThi = sc.nextLine();

        ThiSinh thiSinh = null;
        switch (khoiThi.toUpperCase()) {
            case "A":
                thiSinh = new ThiSinh(soBaoDanh, hoTen, diaChi, mucUuTien, "Khoi A");
                break;
            case "B":
                thiSinh = new ThiSinh(soBaoDanh, hoTen, diaChi, mucUuTien, "Khoi B");
                break;
            case "C":
                thiSinh = new ThiSinh(soBaoDanh, hoTen, diaChi, mucUuTien, "Khoi C");
                break;
            default:
                System.out.println("Nhap sai khoi thi!");
                break;
        }
        if (thiSinh != null) {
            thiSinhs.add(thiSinh);
            System.out.println("Them moi thi sinh thanh cong!");
        }
    }

    public void hienThiThongTin() {
        for (ThiSinh thiSinh : thiSinhs) {
            System.out.println(thiSinh);
        }
    }

public void timKiemTheoSoBaoDanh() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap so bao danh can tim kiem: ");
        String soBaoDanh = sc.nextLine();
        boolean timThay = false;
    for (ThiSinh thiSinh : thiSinhs) {
        if (thiSinh.getSoBaoDanh().equals(soBaoDanh)) {
            System.out.println(thiSinh);
            timThay = true;
            break;
        }
    }
    if (!timThay) {
        System.out.println("Khong tim thay thi sinh!");
        }
    }
}
public class Bai3 {
public static void main(String[] args) {
    TuyenSinh tuyenSinh = new TuyenSinh();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Vui long chon chuc nang:");
            System.out.println("1. Them moi thi sinh");
            System.out.println("2. Hien thi thong tin thi sinh");
            System.out.println("3. Tim kiem theo so bao danh");
            System.out.println("4. Thoat chuong trinh");
            System.out.print("Nhap lua chon cua ban: ");
        int luaChon = Integer.parseInt(sc.nextLine());
    switch (luaChon) {
    case 1:
        tuyenSinh.themMoiThiSinh();
            break;
    case 2:
        tuyenSinh.hienThiThongTin();
            break;
    case 3:
        tuyenSinh.timKiemTheoSoBaoDanh();
            break;
    case 4:
        System.out.println("Chuong trinh ket thuc!");
        System.exit(0);
            break;
                default:
    System.out.println("Lua chon khong hop le!");
            break;
                    }
        System.out.println();
        }
    }
}