from abc import ABC, abstractmethod

class IMark(ABC):
    @abstractmethod
    def input(self):
        pass

    @abstractmethod
    def display(self):
        pass

class StudentAptech(IMark):
    def __init__(self, StuId='', StuName='', gender='', birthday='', nativePlace=''):
        self.StuId = StuId
        self.StuName = StuName
        self.gender = gender
        self.birthday = birthday
        self.nativePlace = nativePlace

    def input(self):
        self.StuId = input("Enter student ID: ")
        self.StuName = input("Enter student name: ")
        self.gender = input("Enter gender: ")
        self.birthday = input("Enter birthday: ")
        self.nativePlace = input("Enter native place: ")

    def display(self):
        print(f"Student ID: {self.StuId}")
        print(f"Student name: {self.StuName}")
        print(f"Gender: {self.gender}")
        print(f"Birthday: {self.birthday}")
        print(f"Native place: {self.nativePlace}")

class StudentMark(IMark):
    def __init__(self, StuId='', className='', subjectName='', semester=0, mark=0.0):
        self.StuId = StuId
        self.className = className
        self.subjectName = subjectName
        self.semester = semester
        self.mark = mark

    def input(self):
        self.StuId = input("Enter student ID: ")
        self.className = input("Enter class name: ")
        self.subjectName = input("Enter subject name: ")
        self.semester = int(input("Enter semester: "))
        self.mark = float(input("Enter mark: "))

    def display(self):
        print(f"Student ID: {self.StuId}")
        print(f"Class name: {self.className}")
        print(f"Subject name: {self.subjectName}")
        print(f"Semester: {self.semester}")
        print(f"Mark: {self.mark}")

class StudentMarkTotal(StudentMark):
    def __init__(self, StuId='', className='', subjectName='', semester=0, mark=0.0, totalExamSubject=0, averageMark=0.0):
        super().__init__(StuId, className, subjectName, semester, mark)
        self.totalExamSubject = totalExamSubject
        self.averageMark = averageMark

    def getTotalExamSubject(self, list):
        self.totalExamSubject = len(list)

    def calculateAverageMark(self, list):
        sum = 0
        for s in list:
            sum += s.mark
        self.averageMark = sum / len(list)

def main():
    students = []
    marks = []

    while True:
        print("1. Enter information for n Aptech students.")
        print("2. Enter m exam scores for these students.")
        print("3. Sort students by name and display.")
        print("4. Find exam score information by student id.")
        print("5. Exit")
        choice = int(input("Choose an option: "))

        if choice == 1:
            n = int(input("Enter the number of students: "))
            for i in range(n):
                print(f"Enter information for student {i + 1}:")
                student = StudentAptech()
                student.input()
                students.append(student)

        elif choice == 2:
            m = int(input("Enter the number of exam scores: "))
            for i in range(m):
                print(f"Enter exam score for student {i + 1}:")
                mark = StudentMarkTotal()
                mark.input()

                student_found = False
                for student in students:
                    if student.StuId == mark.StuId:
                        student_found = True
                        break

                if student_found:
                    marks.append(mark)
                else:
                    print("Student ID not found in the list of students. Please try again.")

        elif choice == 3:
            students.sort(key=lambda x: x.StuName)
            for student in students:
                student.display()

        elif choice == 4:
            search_id = input("Enter the student ID to search: ")
            found = False
            for mark in marks:
                if mark.StuId == search_id:
                    mark.display()
                    found = True

            if not found:
                print("No exam score information found for the given student ID.")

        elif choice == 5:
            print("Exiting.")
            break

        else:
            print("Invalid choice. Please try again.")

if __name__ == "__main__":
    main()

