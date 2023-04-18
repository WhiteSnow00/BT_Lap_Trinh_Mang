from abc import ABC, abstractmethod

class SinhVienPoly(ABC):
    def __init__(self, name):
        self.name = name

    @abstractmethod
    def getDiem(self):
        pass

    def getHocLuc(self):
        diem = self.getDiem()
        if diem >= 9:
            return "Xuất sắc"
        elif diem >= 7.5:
            return "Giỏi"
        elif diem >= 6.5:
            return "Khá"
        elif diem >= 5:
            return "Trung bình"
        else:
            return "Yếu"

class SinhVienIT(SinhVienPoly):
    def __init__(self, name, java, html, css):
        super().__init__(name)
        self.java = java
        self.html = html
        self.css = css

    def getDiem(self):
        return (2 * self.java + self.html + self.css) / 4

class SinhVienBiz(SinhVienPoly):
    def __init__(self, name, marketing, sales):
        super().__init__(name)
        self.marketing = marketing
        self.sales = sales

    def getDiem(self):
        return (2 * self.marketing + self.sales) / 3

def nhap_sv():
    name = input("Nhập tên sinh viên: ")
    stype = input("Nhập loại sinh viên (IT/Biz): ")
    if stype.upper() == "IT":
        java = float(input("Nhập điểm Java: "))
        html = float(input("Nhập điểm HTML: "))
        css = float(input("Nhập điểm CSS: "))
        return SinhVienIT(name, java, html, css)
    else:
        marketing = float(input("Nhập điểm Marketing: "))
        sales = float(input("Nhập điểm Sales: "))
        return SinhVienBiz(name, marketing, sales)

def xuat_sv(sv_list):
    for sv in sv_list:
        print(f"{sv.name}, Điểm: {sv.getDiem()}, Học lực: {sv.getHocLuc()}")

def xuat_gioi(sv_list):
    print("Danh sách sinh viên giỏi:")
    for sv in sv_list:
        if sv.getHocLuc() == "Giỏi":
            print(f"{sv.name}, Điểm: {sv.getDiem()}")

def sap_xep(sv_list):
    return sorted(sv_list, key=lambda sv: sv.getDiem(), reverse=True)

def main():
    sv_list = []
    while True:
        print("1. Nhập danh sách sinh viên")
        print("2. Xuất thông tin sinh viên")
        print("3. Xuất danh sách sinh viên giỏi")
        print("4. Sắp xếp danh sách sinh viên theo điểm")
        print("5. Kết thúc")
        choice = int(input("Nhập lựa chọn của bạn: "))
        if choice == 1:
            sv_list.append(nhap_sv())
        elif choice == 2:
            xuat_sv(sv_list)
        elif choice == 3:
            xuat_gioi(sv_list)
        elif choice == 4:
            sv_list = sap_xep(sv_list)
            print("Đã sắp xếp danh sách sinh viên theo điểm.")
        elif choice == 5:
            break

if __name__ == "__main__":
    main()
