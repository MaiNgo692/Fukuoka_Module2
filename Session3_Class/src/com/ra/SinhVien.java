package com.ra;

public class SinhVien {
    // Định nghĩa lớp SinhVien, lưu thông tin về maSV, ten, email, sdt, diaChi.
    // Khởi tạo đối tương sinh viên từ lớp SinhVien vừa định nghĩa.
    // Nhập dữ liệu cho đối tượng sinh viên và hiển thị thông tin ra màn hình
    private String maSv;
    private String ten;
    private String email;
    private String sdt;
    private String diaChi;

    public SinhVien(){

    }
    public SinhVien(String maSv, String ten, String email, String sdt, String diaChi) {
        this.maSv = maSv;
        this.ten = ten;
        this.email = email;
        this.sdt = sdt;
        this.diaChi = diaChi;
    }

    public String getMaSv() {
        return maSv;
    }

    public void setMaSv(String maSv) {
        this.maSv = maSv;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }
}
