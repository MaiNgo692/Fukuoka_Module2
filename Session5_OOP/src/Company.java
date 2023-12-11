public class Company {
    public static void main(String[] args) {
        /**
         * Một công ty tuyển dụng tiếp nhận hồ sơ của các ứng viên (Person).
         * Tuyển dụng các vị trí thực tập sinh (Student) và nhân viên (Employee).
         * Viết chương trình tiếp nhận hồ sơ ứng tuyển của các ứng viên.
         * Thống kê hiển thị ra màn hình có bao nhiêu hồ sơ ưng tuyển vị trí thực tập sinh?
         * Bao nhiêu hồ sơ ứng tuyển vị trí nhân viên.
         */
        Student st1 = new Student("st01","Mai1","class1");
        Student st2 = new Student("st02","Mai2","class1");
        Student st3 = new Student("st03","Mai3","class1");
        Student st4 = new Student("st04","Mai4","class1");

        Employee em1 = new Employee("e01","ha1",20000);
        Employee em2 = new Employee("e02","ha2",20000);
        Employee em3 = new Employee("e03","ha3",20000);
        Employee em4 = new Employee("e04","ha4",20000);
        Employee em5 = new Employee("e05","ha5",20000);
        Employee em6 = new Employee("e06","ha6",20000);

        Person[] persons = new Person[10];
        persons[0] = st1;
        persons[1] = st2;
        persons[2] = st3;
        persons[3] = st4;
        persons[4] = em1;
        persons[5] = em2;
        persons[6] = em3;
        persons[7] = em4;
        persons[8] = em5;
        persons[9] = em6;

        int countStudent=0;
        int countEmp = 0;
        for (int i = 0; i < 10; i++) {
            if(persons[i] instanceof Student){
                countStudent++;
            }else if(persons[i] instanceof Employee){
                countEmp++;
            }
        }
        System.out.println("Số luong học sinh: " + countStudent);
        System.out.println("Số lượng nhân viên: " + countEmp);
    }
}
