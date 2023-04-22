# encoding: UTF-8
STDIN.set_encoding(Encoding::UTF_8)
STDOUT.set_encoding(Encoding::UTF_8)

class IMark
  def input
    raise NotImplementedError
  end

  def display
    raise NotImplementedError
  end
end

class StudentAptech < IMark
  def initialize(stu_id='', stu_name='', gender='', birthday='', native_place='')
    @stu_id = stu_id
    @stu_name = stu_name
    @gender = gender
    @birthday = birthday
    @native_place = native_place
  end

  def input
    print "Enter student ID: "
    @StuId = gets.chomp
    print "Enter student name: "
    @StuName = gets.chomp
    print "Enter gender: "
    @gender = gets.chomp
    print "Enter birthday: "
    @birthday = gets.chomp
    print "Enter native place: "
    @nativePlace = gets.chomp
  end

  def display
    puts "Student ID: #{@StuId}"
    puts "Student name: #{@StuName}"
    puts "Gender: #{@gender}"
    puts "Birthday: #{@birthday}"
    puts "Native place: #{@nativePlace}"
  end
end

class StudentMark < IMark
  def initialize(stu_id='', class_name='', subject_name='', semester=0, mark=0.0)
    @stu_id = stu_id
    @class_name = class_name
    @subject_name = subject_name
    @semester = semester
    @mark = mark
  end


  def input
    print "Enter student ID: "
    @StuId = gets.chomp
    print "Enter class name: "
    @className = gets.chomp
    print "Enter subject name: "
    @subjectName = gets.chomp
    print "Enter semester: "
    @semester = gets.chomp.to_i
    print "Enter mark: "
    @mark = gets.chomp.to_f
  end

  def display
    puts "Student ID: #{@StuId}"
    puts "Class name: #{@className}"
    puts "Subject name: #{@subjectName}"
    puts "Semester: #{@semester}"
    puts "Mark: #{@mark}"
  end
end

class StudentMarkTotal < StudentMark
  def initialize(stu_id='', class_name='', subject_name='', semester=0, mark=0.0, total_exam_subject=0, average_mark=0.0)
    super(stu_id, class_name, subject_name, semester, mark)
    @total_exam_subject = total_exam_subject
    @average_mark = average_mark
  end

  def get_total_exam_subject(list)
    @totalExamSubject = list.length
  end

  def calculate_average_mark(list)
    sum = list.inject(0) { |sum, s| sum + s.mark }
    @averageMark = sum / list.length
  end
end

def main
  students = []
  marks = []

  loop do
    puts "1. Enter information for n Aptech students."
    puts "2. Enter m exam scores for these students."
    puts "3. Sort students by name and display."
    puts "4. Find exam score information by student id."
    puts "5. Exit"
    print "Choose an option: "
    choice = gets.chomp.to_i

    case choice
    when 1
      print "Enter the number of students: "
      n = gets.chomp.to_i
      n.times do |i|
        puts "Enter information for student #{i + 1}:"
        student = StudentAptech.new
        student.input
        students << student
      end

     when 2
      print "Enter the number of exam scores: "
      m = gets.chomp.to_i
      m.times do |i|
        puts "Enter exam score for student #{i + 1}:"
        mark = StudentMarkTotal.new
        mark.input

        student_found = false
        students.each do |student|
          if student.instance_variable_get(:@StuId) == mark.instance_variable_get(:@StuId)
            student_found = true
            break
          end
        end

        if student_found
          marks << mark
        else
          puts "Student ID not found in the list of students. Please try again."
        end
      end

    when 3
      students.sort_by! { |student| student.instance_variable_get(:@StuName) }
      students.each { |student| student.display }

    when 4
      print "Enter the student ID to search: "
      search_id = gets.chomp
      found = false
      marks.each do |mark|
        if mark.instance_variable_get(:@StuId) == search_id
          mark.display
          found = true
        end
      end

      puts "No exam score information found for the given student ID." unless found

    when 5
      puts "Exiting."
      break

    else
      puts "Invalid choice. Please try again."
    end
  end
end

main

