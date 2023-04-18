import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

interface IXe {
    void nhap();

    void hienthi();
}

class XeMay implements IXe {
    String bienso;
    String loaixe;
    String mauxe;
    double giatien;

    public XeMay(String bienso, String loaixe, String mauxe, double giatien) {
        this.bienso = bienso;
        this.loaixe = loaixe;
        this.mauxe = mauxe;
        this.giatien = giatien;
    }

    public void nhap() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập biển số: ");
        bienso = scanner.nextLine();
        System.out.print("Nhập loại xe: ");
        loaixe = scanner.nextLine();
        System.out.print("Nhập màu xe: ");
        mauxe = scanner.nextLine();
        System.out.print("Nhập giá tiền: ");
        giatien = scanner.nextDouble();
    }

    public void hienthi() {
        System.out.println("Biển số: " + bienso);
        System.out.println("Loại xe: " + loaixe);
        System.out.println("Màu xe: " + mauxe);
        System.out.println("Giá tiền: " + giatien);
    }
}

class XeMayHoaBinh extends XeMay {
    int n;
    List<XeMay> xemays;

    public XeMayHoaBinh(int n) {
        super("", "", "", 0);
        this.n = n;
        this.xemays = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            xemays.add(new XeMay("", "", "", 0));
        }
    }

    public void nhap() {
        for (int i = 0; i < n; i++) {
            System.out.println("Nhập thông tin xe máy thứ " + (i + 1) + ":");
            xemays.get(i).nhap();
        }
    }

    public void hienthi() {
        for (int i = 0; i < n; i++) {
            System.out.println("Thông tin xe máy thứ " + (i + 1) + ":");
            xemays.get(i).hienthi();
        }
    }
}

class XeMayHaNoi extends XeMay {
    int n;
    List<XeMay> xemays;

    public XeMayHaNoi(int n) {
        super("", "", "", 0);
        this.n = n;
        this.xemays = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            xemays.add(new XeMay("", "", "", 0));
        }
    }

    public void nhap() {
        for (int i = 0; i < n; i++) {
            System.out.println("Nhập thông tin xe máy thứ " + (i + 1) + ":");
            xemays.get(i).nhap();
        }
    }

    public void hienthi() {
        for (int i = 0; i < n; i++) {
            System.out.println("Thông tin xe máy thứ " + (i + 1) + ":");
            xemays.get(i).hienthi();
        }
    }
}

public class Bai2 {
    public void menu() {
        System.out.println("1. Nhập thông tin cho n xe máy tại tỉnh Hòa Bình.");
        System.out.println("2. Nhập thông tin cho n xe máy tại tỉnh Hà Nội.");
        System.out.println("3. Sắp xếp danh sách tăng theo biển số xe.");
        System.out.println("4. Tìm kiếm thông tin xe theo biển số xe.");
        System.out.println("5. Thống kê số lượng xe đang quản lý.");
        System.out.println("6. Thoát");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Bai2 Bai2 = new Bai2();
        XeMayHoaBinh xeMayHoaBinh = new XeMayHoaBinh(0);
        XeMayHaNoi xeMayHaNoi = new XeMayHaNoi(0);

        while (true) {
            Bai2.menu();
            System.out.print("Nhập lựa chọn của bạn: ");
            int choice = scanner.nextInt();

            if (choice == 1) {
                System.out.print("Nhập số lượng xe máy tại tỉnh Hòa Bình: ");
                int n = scanner.nextInt();
                xeMayHoaBinh = new XeMayHoaBinh(n);
                xeMayHoaBinh.nhap();
            } else if (choice == 2) {
                System.out.print("Nhập số lượng xe máy tại tỉnh Hà Nội: ");
                int n = scanner.nextInt();
                xeMayHaNoi = new XeMayHaNoi(n);
                xeMayHaNoi.nhap();
            } else if (choice == 3 || choice == 4 || choice == 5) {
                System.out.print("Nhập tỉnh cần thực hiện (Hòa Bình hoặc Hà Nội): ");
                scanner.nextLine(); // To consume the newline character
                String province = scanner.nextLine().toLowerCase();

                if ("hòa bình".equals(province)) {
                    if (choice == 3) {
                        xeMayHoaBinh.xemays.sort((x1, x2) -> x1.bienso.compareTo(x2.bienso));
                        System.out.println("Danh sách sau khi sắp xếp:");
                        xeMayHoaBinh.hienthi();
                    } else if (choice == 4) {
                        System.out.print("Nhập biển số xe cần tìm: ");
                        String searchBienso = scanner.nextLine();
                        boolean found = false;
                        for (XeMay xe : xeMayHoaBinh.xemays) {
                            if (searchBienso.equals(xe.bienso)) {
                                xe.hienthi();
                                found = true;
                                break;
                            }
                        }
                        if (!found) {
                            System.out.println("Không tìm thấy xe có biển số " + searchBienso);
                        }
                    } else if (choice == 5) {
                        System.out.println("Số lượng xe đang quản lý tại Hòa Bình: " + xeMayHoaBinh.n);
                    }
                } else if ("hà nội".equals(province)) {
                    if (choice == 3) {
                        xeMayHaNoi.xemays.sort((x1, x2) -> x1.bienso.compareTo(x2.bienso));
                        System.out.println("Danh sách sau khi sắp xếp:");
                        xeMayHaNoi.hienthi();
                    } else if (choice == 4) {
                        System.out.print("Nhập biển số xe cần tìm: ");
                        String searchBienso = scanner.nextLine();
                        boolean found = false;
                        for (XeMay xe : xeMayHaNoi.xemays) {
                            if (searchBienso.equals(xe.bienso)) {
                                xe.hienthi();
                                found = true;
                                break;
                            }
                        }
                        if (!found) {
                            System.out.println("Không tìm thấy xe có biển số " + searchBienso);
                        }
                    } else if (choice == 5) {
                        System.out.println("Số lượng xe đang quản lý tại Hà Nội: " + xeMayHaNoi.n);
                    }
                } else {
                    System.out.println("Nhập tỉnh không hợp lệ. Vui lòng nhập lại.");
                }
            } else if (choice == 6) {
                System.out.println("Thoát chương trình.");
                break;
            } else {
                System.out.println("Lựa chọn không hợp lệ. Vui lòng nhập lại.");
            }
        }

        scanner.close();
    }
}

                       

       
