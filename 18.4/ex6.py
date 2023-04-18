from ex5 import SinhVienPoly
class SinhVienIT(SinhVienPoly):
    def __init__(self, ho_ten, nganh, diem_java, diem_html, diem_css):
        super().__init__(ho_ten, nganh)
        self.diem_java = diem_java
        self.diem_html = diem_html
        self.diem_css = diem_css

    def get_diem(self):
        return (2 * self.diem_java + self.diem_html + self.diem_css) / 4


class SinhVienBiz(SinhVienPoly):
    def __init__(self, ho_ten, nganh, diem_marketing, diem_sales):
        super().__init__(ho_ten, nganh)
        self.diem_marketing = diem_marketing
        self.diem_sales = diem_sales

    def get_diem(self):
        return (2 * self.diem_marketing + self.diem_sales) / 3


class QuanLySinhVien:
    def __init__(self):
        self.sinh_vien = []

    def nhap(self):
        n = int(input("Nhập số lượng sinh viên: "))
        for i in range(n):
            nganh = input(f"Nhập ngành của sinh viên thứ {i + 1} (IT/Biz): ")
            ho_ten = input(f"Nhập họ tên của sinh viên thứ {i + 1}: ")

            if nganh.lower() == 'it':
                diem_java = float(input("Nhập điểm Java: "))
                diem_html = float(input("Nhập điểm HTML: "))
                diem_css = float(input("Nhập điểm CSS: "))
                sinh_vien = SinhVienIT(ho_ten, nganh, diem_java, diem_html, diem_css)
            else:
                diem_marketing = float(input("Nhập điểm Marketing: "))
                diem_sales = float(input("Nhập điểm Sales: "))
                sinh_vien = SinhVienBiz(ho_ten, nganh, diem_marketing, diem_sales)

            self.sinh_vien.append(sinh_vien)

    def xuat(self):
        for sinh_vien in self.sinh_vien:
            print(f"Tên: {sinh_vien.ho_ten}, Ngành: {sinh_vien.nganh}, Điểm: {sinh_vien.get_diem()}, Học lực: {sinh_vien.get_hoc_luc()}")

    def xuat_gioi(self):
        print("Danh sách sinh viên giỏi:")
        for sinh_vien in self.sinh_vien:
            if sinh_vien.get_hoc_luc() == "Giỏi":
                print(f"Tên: {sinh_vien.ho_ten}, Ngành: {sinh_vien.nganh}, Điểm: {sinh_vien.get_diem()}, Học lực: {sinh_vien.get_hoc_luc()}")

    def sap_xep(self):
        self.sinh_vien.sort(key=lambda x: x.get_diem(), reverse=True)

    def menu(self):
        print("1. Nhập danh sách sinh viên")
        print("2. Xuất thông tin sinh viên")
        print("3. Xuất danh sách sinh viên có học lực giỏi")
        print("4. Sắp xếp danh sách sinh viên theo điểm")
        print("5. Kết thúc")

def main():
    quan_ly_sinh_vien = QuanLySinhVien()

    while True:
        quan_ly_sinh_vien.menu()
        choice = int(input("Nhập lựa chọn của bạn: "))

        if choice == 1:
            quan_ly_sinh_vien.nhap()
        elif choice == 2:
            quan_ly_sinh_vien.xuat()
        elif choice == 3:
            quan_ly_sinh_vien.xuat_gioi()
        elif choice == 4:
            quan_ly_sinh_vien.sap_xep()
            print("Danh sách sau khi sắp xếp:")
            quan_ly_sinh_vien.xuat()
        elif choice == 5:
            print("Kết thúc chương trình.")
            break
        else:
            print("Lựa chọn không hợp lệ. Vui lòng nhập lại.")


if __name__ == "__main__":
    main()

