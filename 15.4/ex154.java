import java.util.Scanner;

public interface ic {
    public void input();
    public void display();
}

public class StudentAptech implements ic {
    private String StuId;
    private String StuName;
    private String gender;
    private String birthday;
    private String nativePlace;

    public StudentAptech() {
    }

    public StudentAptech(String StuId, String StuName, String gender, String birthday, String nativePlace) {
        this.StuId = StuId;
        this.StuName = StuName;
        this.gender = gender;
        this.birthday = birthday;
        this.nativePlace = nativePlace;
    }


    public void setStuId(String StuId) {
        this.StuId = StuId;
    }

    public String getStuId() {
        return StuId;
    }

    public void setStuName(String StuName) {
        this.StuName = StuName;
    }

    public String getStuName() {
        return StuName;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getGender() {
        return gender;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setNativePlace(String nativePlace) {
        this.nativePlace = nativePlace;
    }

    public String getNativePlace() {
        return nativePlace;
    }

    @Override
    public void input() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter student ID: ");
        StuId = sc.nextLine();
        System.out.print("Enter student name: ");
        StuName = sc.nextLine();
        System.out.print("Enter gender: ");
        gender = sc.nextLine();
        System.out.print("Enter birthday: ");
        birthday = sc.nextLine();
        System.out.print("Enter native place: ");
        nativePlace = sc.nextLine();
    }

    @Override
    public void display() {
        System.out.println("Student ID: " + StuId);
        System.out.println("Student name: " + StuName);
        System.out.println("Gender: " + gender);
        System.out.println("Birthday: " + birthday);
        System.out.println("Native place: " + nativePlace);
    }
}


public class StudentMark implements ic {
    private String StuId;
    private String className;
    private String subjectName;
    private int semester;
    private float mark;

    public StudentMark() {
    }

    public StudentMark(String StuId, String className, String subjectName, int semester, float mark) {
        this.StuId = StuId;
        this.className = className;
        this.subjectName = subjectName;
        this.semester = semester;
        this.mark = mark;
    }


    public void setStuId(String StuId) {
        this.StuId = StuId;
    }

    public String getStuId() {
        return StuId;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getClassName() {
        return className;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public int getSemester() {
        return semester;
    }

    public void setMark(float mark) {
        this.mark = mark;
    }

    public float getMark() {
        return mark;
    }

    @Override
    public void input() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter student ID: ");
        StuId = sc.nextLine();
        System.out.print("Enter class name: ");
        className = sc.nextLine();
        System.out.print("Enter subject name: ");
        subjectName = sc.nextLine();
        System.out.print("Enter semester: ");
        semester = sc.nextInt();
        System.out.print("Enter mark: ");
        mark = sc.nextFloat();
        sc.nextLine(); 
    }

    @Override
    public void display() {
        System.out.println("Student ID: " + StuId);
        System.out.println("Class name: " + className);
        System.out.println("Subject name: " + subjectName);
        System.out.println("Semester: " + semester);
        System.out.println("Mark: " + mark);
    }
}

package aptech.mark;

public class StudentMarkTotal extends StudentMark {
    private int totalExamSubject;
    private float averageMark;

    public StudentMarkTotal() {
    }

    public StudentMarkTotal(String StuId, String className, String subjectName, int semester, float mark, int totalExamSubject, float averageMark) {
        super(StuId, className, subjectName, semester, mark);
        this.totalExamSubject = totalExamSubject;
        this.averageMark = averageMark;
    }

    // Setters and getters
    public void setTotalExamSubject(int totalExamSubject) {
        this.totalExamSubject = totalExamSubject;
    }

    public int getTotalExamSubject() {
        return totalExamSubject;
    }

    public void setAverageMark(float averageMark) {
        this.averageMark = averageMark;
    }

    public float getAverageMark() {
        return averageMark;
    }

    public void calculateTotalExamSubject(StudentMarkTotal[] list) {
        totalExamSubject = list.length;
    }

    public void calculateAverageMark(StudentMarkTotal[] list) {
        float sum = 0;
        for (StudentMarkTotal s : list) {
            sum += s.getMark();
        }
        averageMark = sum / list.length;
    }
}


public class ex154 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;
        StudentAptech[] students = null;
        StudentMarkTotal[] marks = null;

        do {
            System.out.println("1. Enter information for n Aptech students.");
            System.out.println("2. Enter m exam scores for these students.");
            System.out.println("3. Sort students by name and display.");
            System.out.println("4. Find exam score information by student id.");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            choice = sc.nextInt();
            sc.nextLine(); // Consume newline left over

            switch (choice) {
                case 1:
                    System.out.print("Enter the number of students: ");
                    int n = sc.nextInt();
                    sc.nextLine(); // Consume newline left over
                    students = new StudentAptech[n];
                        for (int i = 0; i < n; i++) {
                        System.out.println("Enter information for student " + (i + 1) + ":");
                        StudentAptech student = new StudentAptech();
                        student.input();
                        students[i] = student;
                    }
                    break;

                case 2:
                    if (students == null) {
                        System.out.println("Please enter student information first.");
                        break;
                    }

                    System.out.print("Enter the number of exam scores: ");
                    int m = sc.nextInt();
                    sc.nextLine(); // Consume newline left over
                    marks = new StudentMarkTotal[m];

                    for (int i = 0; i < m; i++) {
                        System.out.println("Enter exam score information for student " + (i + 1) + ":");
                        StudentMarkTotal mark = new StudentMarkTotal();
                        mark.input();

                        boolean studentFound = false;
                        for (StudentAptech student : students) {
                            if (student.getStuId().equals(mark.getStuId())) {
                                studentFound = true;
                                break;
                            }
                        }

                        if (studentFound) {
                            marks[i] = mark;
                        } else {
                            System.out.println("Student ID not found. Please enter a valid ID.");
                            i--; // Repeat the loop iteration
                        }
                    }
                    break;

                case 3:
                    if (students == null) {
                        System.out.println("Please enter student information first.");
                        break;
                    }

                    Arrays.sort(students, Comparator.comparing(StudentAptech::getStuName));
                    for (StudentAptech student : students) {
                        student.display();
                    }
                    break;

                case 4:
                    if (marks == null) {
                        System.out.println("Please enter exam score information first.");
                        break;
                    }

                    System.out.print("Enter the student ID to search for: ");
                    String searchId = sc.nextLine();
                    boolean found = false;

                    for (StudentMarkTotal mark : marks) {
                        if (mark.getStuId().equals(searchId)) {
                            mark.display();
                            found = true;
                            break;
                        }
                    }

                    if (!found) {
                        System.out.println("Student ID not found.");
                    }
                    break;

                case 5:
                    System.out.println("Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 5);
    }
}



