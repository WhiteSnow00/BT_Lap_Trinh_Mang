from abc import ABC, abstractmethod

class Employee(ABC):
    def __init__(self, name):
        self.name = name

    @abstractmethod
    def earnings(self):
        pass

class Boss(Employee):
    def __init__(self, name, monthly_salary):
        super().__init__(name)
        self.monthly_salary = monthly_salary

    def earnings(self):
        return self.monthly_salary

class PieceWorker(Employee):
    def __init__(self, name, num_products):
        super().__init__(name)
        self.num_products = num_products

    def earnings(self):
        return self.num_products * 0.5

class CommissionWorker(Employee):
    def __init__(self, name, base_salary, num_products_sold):
        super().__init__(name)
        self.base_salary = base_salary
        self.num_products_sold = num_products_sold

    def earnings(self):
        return self.base_salary + (self.num_products_sold * 0.1)

def main():
    boss_name = input("Enter boss name: ")
    boss_salary = float(input("Enter boss monthly salary: "))
    boss = Boss(boss_name, boss_salary)
    print(f"{boss.name} earns: ${boss.earnings()}")

    piece_worker_name = input("Enter piece worker name: ")
    num_products = int(input("Enter number of products for piece worker: "))
    piece_worker = PieceWorker(piece_worker_name, num_products)
    print(f"{piece_worker.name} earns: ${piece_worker.earnings()}")

    commission_worker_name = input("Enter commission worker name: ")
    base_salary = float(input("Enter commission worker base salary: "))
    num_products_sold = int(input("Enter number of products sold by commission worker: "))
    commission_worker = CommissionWorker(commission_worker_name, base_salary, num_products_sold)
    print(f"{commission_worker.name} earns: ${commission_worker.earnings()}")

if __name__ == "__main__":
    main()
