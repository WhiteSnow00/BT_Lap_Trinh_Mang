from abc import ABC, abstractmethod

class SinhVienPoly(ABC):
    def __init__(self, ho_ten, nganh):
        self.ho_ten = ho_ten
        self.nganh = nganh

    @abstractmethod
    def get_diem(self):
        pass

    def get_hoc_luc(self):
        diem = self.get_diem()
        if diem < 5:
            return "Yếu"
        elif diem <= 7:
            return "Trung bình"
        elif diem < 8:
            return "Khá"
        else:
            return "Giỏi"
    def xuat(self):
        pass