from abc import ABC, abstractmethod

class IXe(ABC):
    @abstractmethod
    def nhap(self):
        pass

    @abstractmethod
    def hienthi(self):
        pass

class XeMay(IXe):
    def __init__(self, bienso, loaixe, mauxe, giatien):
        self.bienso = bienso
        self.loaixe = loaixe
        self.mauxe = mauxe
        self.giatien = giatien

    def nhap(self):
        self.bienso = input("Nhập biển số: ")
        self.loaixe = input("Nhập loại xe: ")
        self.mauxe = input("Nhập màu xe: ")
        self.giatien = float(input("Nhập giá tiền: "))

    def hienthi(self):
        print(f"Biển số: {self.bienso}")
        print(f"Loại xe: {self.loaixe}")
        print(f"Màu xe: {self.mauxe}")
        print(f"Giá tiền: {self.giatien}")

class XeMayHoaBinh(XeMay):
    def __init__(self, n):
        self.n = n
        self.xemays = [XeMay("", "", "", 0) for _ in range(n)]

    def nhap(self):
        for i in range(self.n):
            print(f"Nhập thông tin xe máy thứ {i + 1}:")
            self.xemays[i].nhap()

    def hienthi(self):
        for i in range(self.n):
            print(f"Thông tin xe máy thứ {i + 1}:")
            self.xemays[i].hienthi()

class XeMayHaNoi(XeMay):
    def __init__(self, n):
        self.n = n
        self.xemays = [XeMay("", "", "", 0) for _ in range(n)]

    def nhap(self):
        for i in range(self.n):
            print(f"Nhập thông tin xe máy thứ {i + 1}:")
            self.xemays[i].nhap()

    def hienthi(self):
        for i in range(self.n):
            print(f"Thông tin xe máy thứ {i + 1}:")
            self.xemays[i].hienthi()

class QuanLyChung:
    @staticmethod
    def menu():
        print("1. Nhập thông tin cho n xe máy tại tỉnh Hòa Bình.")
        print("2. Nhập thông tin cho n xe máy tại tỉnh Hà Nội.")
        print("3. Sắp xếp danh sách tăng theo biển số xe.")
        print("4. Tìm kiếm thông tin xe theo biển số xe.")
        print("5. Thống kê số lượng xe đang quản lý.")
        print("6. Thoát")

def main():
    quan_ly_chung = QuanLyChung()
    xe_may_hoa_binh = XeMayHoaBinh(0)
    xe_may_ha_noi = XeMayHaNoi(0)

    while True:
        quan_ly_chung.menu()
        choice = int(input("Nhập lựa chọn của bạn: "))

        if choice == 1:
            n = int(input("Nhập số lượng xe             máy tại tỉnh Hòa Bình: "))
            xe_may_hoa_binh = XeMayHoaBinh(n)
            xe_may_hoa_binh.nhap()
        elif choice == 2:
            n = int(input("Nhập số lượng xe máy tại tỉnh Hà Nội: "))
            xe_may_ha_noi = XeMayHaNoi(n)
            xe_may_ha_noi.nhap()
        elif choice in [3, 4, 5]:
            province = input("Nhập tỉnh cần thực hiện (Hòa Bình hoặc Hà Nội): ")
            if province.lower() == "hòa bình":
                if choice == 3:
                    xe_may_hoa_binh.xemays.sort(key=lambda x: x.bienso)
                    print("Danh sách sau khi sắp xếp:")
                    xe_may_hoa_binh.hienthi()
                elif choice == 4:
                    search_bienso = input("Nhập biển số xe cần tìm: ")
                    for xe in xe_may_hoa_binh.xemays:
                        if xe.bienso == search_bienso:
                            xe.hienthi()
                            break
                    else:
                        print("Không tìm thấy xe có biển số", search_bienso)
                elif choice == 5:
                    print("Số lượng xe đang quản lý tại Hòa Bình:", xe_may_hoa_binh.n)
            elif province.lower() == "hà nội":
                if choice == 3:
                    xe_may_ha_noi.xemays.sort(key=lambda x: x.bienso)
                    print("Danh sách sau khi sắp xếp:")
                    xe_may_ha_noi.hienthi()
                elif choice == 4:
                    search_bienso = input("Nhập biển số xe cần tìm: ")
                    for xe in xe_may_ha_noi.xemays:
                        if xe.bienso == search_bienso:
                            xe.hienthi()
                            break
                    else:
                        print("Không tìm thấy xe có biển số", search_bienso)
                elif choice == 5:
                    print("Số lượng xe đang quản lý tại Hà Nội:", xe_may_ha_noi.n)
            else:
                print("Nhập tỉnh không hợp lệ. Vui lòng nhập lại.")
        elif choice == 6:
            print("Thoát chương trình.")
            break
        else:
            print("Lựa chọn không hợp lệ. Vui lòng nhập lại.")

if __name__ == "__main__":
    main()

