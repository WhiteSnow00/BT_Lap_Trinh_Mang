from abc import ABC, abstractmethod

class Person(ABC):
    @abstractmethod
    def input(self):
        pass

    @abstractmethod
    def display(self):
        pass


class Student(Person):
    def __init__(self, name, age, native_place, student_id):
        self.name = name
        self.age = age
        self.native_place = native_place
        self.student_id = student_id

    def input(self):
        self.name = input("Enter name: ")
        self.age = int(input("Enter age: "))
        self.native_place = input("Enter native place: ")
        self.student_id = input("Enter student ID: ")

    def display(self):
        print(f"Name: {self.name}")
        print(f"Age: {self.age}")
        print(f"Native Place: {self.native_place}")
        print(f"Student ID: {self.student_id}")


class ManagerStudent(Student):
    def __init__(self, n):
        self.n = n
        self.students = []

    def input(self):
        for i in range(self.n):
            student = Student(None, None, None, None)
            print(f"Enter data for student {i + 1}:")
            student.input()
            self.students.append(student)

    def display(self):
        for student in self.students:
            student.display()

    def sort_by_name(self):
        self.students.sort(key=lambda student: student.name)

    def search_by_name(self, name):
        for student in self.students:
            if student.name == name:
                return student
        return None


class UsingManagerStudent:
    @staticmethod
    def menu():
        print("1. Input data.")
        print("2. Display data.")
        print("3. Sort by name.")
        print("4. Search by name.")
        print("5. Exit.")
        return int(input("Enter your choice: "))

def main():
    manager_student = ManagerStudent(int(input("Enter number of students: ")))

    while True:
        choice = UsingManagerStudent.menu()

        if choice == 1:
            manager_student.input()
        elif choice == 2:
            manager_student.display()
        elif choice == 3:
            manager_student.sort_by_name()
        elif choice == 4:
            name = input("Enter the name to search: ")
            student = manager_student.search_by_name(name)
            if student:
                student.display()
            else:
                print("Student not found.")
        elif choice == 5:
            print("Exiting...")
            break
        else:
            print("Invalid choice. Please try again.")

if __name__ == "__main__":
    main()
