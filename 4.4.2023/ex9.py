from dataclasses import dataclass
from typing import List
import functools

@dataclass
class Person:
    name: str
    address: str

    def __str__(self):
        return f"Name: {self.name}, Address: {self.address}"


class Student(Person):
    def __init__(self, name, address, score1, score2):
        super().__init__(name, address)
        self.score1 = score1
        self.score2 = score2

    def calculate_average_score(self):
        return (self.score1 + self.score2) / 2

    def evaluate(self):
        avg_score = self.calculate_average_score()
        if avg_score >= 8.0:
            return "Excellent"
        elif avg_score >= 6.5:
            return "Good"
        elif avg_score >= 5.0:
            return "Average"
        else:
            return "Poor"

    def __str__(self):
        return super().__str__() + f", Average Score: {self.calculate_average_score()}, Evaluation: {self.evaluate()}"


class Employee(Person):
    def __init__(self, name, address, salary_coefficient):
        super().__init__(name, address)
        self.salary_coefficient = salary_coefficient

    def calculate_salary(self):
        return self.salary_coefficient * 1000

    def evaluate(self):
        salary = self.calculate_salary()
        if salary >= 20000:
            return "High salary"
        elif salary >= 12000:
            return "Average salary"
        else:
            return "Low salary"

    def __str__(self):
        return super().__str__() + f", Salary: {self.calculate_salary()}, Evaluation: {self.evaluate()}"


class Customer(Person):
    def __init__(self, name, address, company_name, invoice_value):
        super().__init__(name, address)
        self.company_name = company_name
        self.invoice_value = invoice_value

    def evaluate(self):
        if self.invoice_value >= 100000:
            return "VIP"
        elif self.invoice_value >= 50000:
            return "Gold"
        elif self.invoice_value >= 10000:
            return "Silver"
        else:
            return "Normal"

    def __str__(self):
        return super().__str__() + f", Company: {self.company_name}, Invoice Value: {self.invoice_value}, Evaluation: {self.evaluate()}"

class Management:
    def __init__(self, capacity):
        self.capacity = capacity
        self.people = [None] * capacity
        self.total_people = 0

    def add_person(self, person):
        if self.total_people >= self.capacity:
            self.capacity = int(self.capacity * 1.5)
            self.people.extend([None] * (self.capacity - len(self.people)))
        self.people[self.total_people] = person
        self.total_people += 1

    def remove_person_by_name(self, name):
        for i in range(self.total_people):
            if self.people[i].name == name:
                del self.people[i]
                self.total_people -= 1
                break

    def sort_by_name(self):
        self.people = sorted(self.people[:self.total_people], key=lambda person: person.name)

    def print_list(self):
        for i in range(self.total_people):
            print(self.people[i])

def main():
    capacity = int(input("Enter the initial capacity:"))
    management = Management(capacity)

    while True:
        print("\nMenu:")
        print("1. Add a person")
        print("2. Remove a person by name")
        print("3. Sort the list by name")
        print("4. Print the list")
        print("5. Exit")
        choice = int(input("Enter your choice: "))

        if choice == 5:
            break

        if choice == 1:
            person_type = input("Enter the person type (Student, Employee, Customer): ")
            name = input("Enter the name: ")
            address = input("Enter the address: ")

            if person_type.lower() == "student":
                score1 = float(input("Enter the score for subject 1: "))
                score2 = float(input("Enter the score for subject 2: "))
                management.add_person(Student(name, address, score1, score2))
            elif person_type.lower() == "employee":
                salary_coefficient = float(input("Enter the salary coefficient: "))
                management.add_person(Employee(name, address, salary_coefficient))
            elif person_type.lower() == "customer":
                company_name = input("Enter the company name: ")
                invoice_value = float(input("Enter the invoice value: "))
                management.add_person(Customer(name, address, company_name, invoice_value))
            else:
                print("Invalid person type. Please try again.")

        elif choice == 2:
            person_name = input("Enter the name of the person to remove: ")
            management.remove_person_by_name(person_name)

        elif choice == 3:
            management.sort_by_name()

        elif choice == 4:
            management.print_list()

        else:
            print("Invalid choice. Please try again.")

if __name__ == "__main__":
    main()

