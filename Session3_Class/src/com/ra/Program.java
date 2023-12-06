package com.ra;

public class Program {
    public static void main(String[] args) {
        //Khởi tạo đối tượng
//        NhanVien nv = new NhanVien();
//        nv.setName("New Name");
//        nv.hello();
//        System.out.println("Mã NV: " + nv.getName());
//        NhanVien nv1 = new NhanVien("NV01","Mai");
//        nv1.hello();
//        System.out.println("Mã NV: " + nv1.getName());

        SinhVien sv = new SinhVien("SV01","Ngo Thi Mai","m@gmail.com","0123456789","Saitama Japan");
        System.out.println("Mã SV: " + sv.getMaSv());
        System.out.println("Tên SV: " + sv.getTen());
        System.out.println("email: " + sv.getEmail());
        System.out.println("sdt: " + sv.getSdt());
        System.out.println("Địa chỉ: " + sv.getDiaChi());
    }
// Định nghĩa lớp SinhVien, lưu thông tin về maSV, ten, email, sdt, diaChi.
    // Khởi tạo đối tương sinh viên từ lớp SinhVien vừa định nghĩa.
    // Nhập dữ liệu cho đối tượng sinh viên và hiển thị thông tin ra màn hình

}
