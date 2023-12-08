import java.util.Arrays;

public class Class {
    private Student[] students;

    /**
     * Thêm học viên vào lớp. Không thêm học viên trùng mã học viên(id).
     * @param st Đối tượng học viên được thêm vào lớp
     * @return Thêm thành công trả về true, ngược lại trả về false.
     */
    public boolean add(Student st) {
        if(findId(st.getId()) ==null){
            students = Arrays.copyOf(students,students.length+1);
            students[students.length-1] = st;
            return true;
        }
        return false;
    }

    /**
     * Cập nhật thông tin của học viên trong lớp, cập nhật tất cả thông tin ngoại trừ mã học viên(id)
     * @param st Đối tượng chứa thông tin mới của học viên được cập nhật.
     * @return Cập nhật thành công trả về true, ngược lại trả về false.
     */
    public boolean edit(Student st) {
        Student editStudent = findId(st.getId());
        if(editStudent != null){
            editStudent.setFirstName(st.getFirstName());
            editStudent.setLastName(st.getLastName());
            editStudent.setMarkCss(st.getMarkCss());
            editStudent.setMarkJs(st.getMarkJs());
            editStudent.setMarkHtml(st.getMarkHtml());
            return true;
        }
        return false;
    }
    /**
     * Xóa học viên khỏi lớp
     * @param st Đối tượng học viên cần xóa
     * @return Xóa thành công trả về true, ngược lại trả về false.
     */
    public boolean remove(Student st) {
        Student[] newStudents = new Student[students.length-1];
        if(findIndex(st.getId()) !=0) {
            for (int i = 0,k=0; i < students.length; i++) {
                if (students[i].getId() == st.getId()) {
                    continue;
                }
                newStudents[k++] = students[i];
            }
            return true;
        }
        return false;
    }
    /**
     * Trả về vị trí học viên trong lớp
     * @param id Mã học viên cần tìm
     * @return x - là vị trí của học viên trong lớp
     */
    public int findIndex(String id) {
        for (int i = 0; i < students.length; i++) {
            if(students[i].getId() == id){
                return i+1;
            }
        }
        return 0;
    }

    /**
     * Trả về đối tượng học viên trong lớp
     * @param id Mã học viên cần tìm
     * @return trả về đối tượng học viên(Student) được tìm thấy theo mã học viên(id) truyền vào.
     */
    public Student findId(String id) {
        for (int i = 0; i < students.length; i++) {
            if(students[i].getId() == id){
                return students[i];
            }
        }
        return null;
    }
}
