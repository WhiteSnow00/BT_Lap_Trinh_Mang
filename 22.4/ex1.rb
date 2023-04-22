# encoding: UTF-8
STDIN.set_encoding(Encoding::UTF_8)
STDOUT.set_encoding(Encoding::UTF_8)

class CanBo
    attr_reader :name, :birth_year, :gender, :address
  
    def initialize(name, birth_year, gender, address)
      @name = name
      @birth_year = birth_year
      @gender = gender
      @address = address
    end
  
    def display_info
      raise NotImplementedError, 'You must implement the display_info method'
    end
  end
  
  class NhanVien < CanBo
    attr_reader :job
  
    def initialize(name, birth_year, gender, address, job)
      super(name, birth_year, gender, address)
      @job = job
    end
  
    def display_info
      "NhanVien{name=#{name}, birthYear=#{birth_year}, gender=#{gender}, address=#{address}, job=#{job}}"
    end
  end
  
  class CongNhan < CanBo
    attr_reader :level
  
    def initialize(name, birth_year, gender, address, level)
      super(name, birth_year, gender, address)
      @level = level
    end
  
    def display_info
      "CongNhan{name=#{name}, birthYear=#{birth_year}, gender=#{gender}, address=#{address}, level=#{level}}"
    end
  end
  
  class KySu < CanBo
    attr_reader :major
  
    def initialize(name, birth_year, gender, address, major)
      super(name, birth_year, gender, address)
      @major = major
    end
  
    def display_info
      "KySu{name=#{name}, birthYear=#{birth_year}, gender=#{gender}, address=#{address}, major=#{major}}"
    end
  end
  
  class QLCB
    def initialize
      @can_bo_list = []
    end
  
    def add_can_bo(can_bo)
      @can_bo_list << can_bo
    end
  
    def search_by_name(name)
      @can_bo_list.select { |can_bo| can_bo.name == name }
    end
  
    def display_all
      @can_bo_list.each { |can_bo| puts can_bo.display_info }
    end
  end
  
  qlcb = QLCB.new
  exit = false
  
  while !exit
    puts '1. Nhap thong tin moi cho can bo'
    puts '2. Tim kiem theo ho ten'
    puts '3. Hien thi thong tin danh sach can bo'
    puts '4. Thoat chuong trinh'
    print 'Nhap lua chon cua ban: '
    choice = gets.chomp.to_i
  
    case choice
    when 1
      print 'Nhap loai can bo (NhanVien, CongNhan, KySu): '
      type = gets.chomp
  
      print 'Nhap ten: '
      name = gets.chomp
  
      print 'Nhap nam sinh: '
      birth_year = gets.chomp.to_i
  
      print 'Nhap gioi tinh: '
      gender = gets.chomp
  
      print 'Nhap dia chi: '
      address = gets.chomp
  
      case type.downcase
      when 'nhanvien'
        print 'Nhap nghe nghiep: '
        job = gets.chomp
        qlcb.add_can_bo(NhanVien.new(name, birth_year, gender, address, job))
      when 'congnhan'
        print 'Nhap cap bac: '
        level = gets.chomp.to_i
        qlcb.add_can_bo(CongNhan.new(name, birth_year, gender, address, level))
      when 'kysu'
        print 'Nhap nganh dao tao: '
        major = gets.chomp
        qlcb.add_can_bo(KySu.new(name,  birth_year, gender, address, major))
    else
      puts 'Sai loai can bo!'
    end
    when 2
        print 'Nhap ten de tim kiem: '
            search_name = gets.chomp
            search_result = qlcb.search_by_name(search_name)
                if search_result.size > 0
                    search_result.each { |can_bo| puts can_bo.display_info }
            else
        puts 'Khong co canbo nao co ten nhu vay.'
            end
    when 3
        qlcb.display_all
    when 4
        exit = true
            else
        puts 'Lua chon khong hop le, vui long thu lai.'
    end
end    
  