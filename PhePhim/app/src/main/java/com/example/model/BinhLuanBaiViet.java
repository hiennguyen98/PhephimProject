package com.example.model;

public class BinhLuanBaiViet {
    String user;
    String ngay;
    String noiDung;
    String hinh;
    int diem;

    public BinhLuanBaiViet(String user, String ngay, String noiDung, String hinh, int diem) {
        this.user = user;
        this.ngay = ngay;
        this.noiDung = noiDung;
        this.hinh = hinh;
        this.diem = diem;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getNgay() {
        return ngay;
    }

    public void setNgay(String ngay) {
        this.ngay = ngay;
    }

    public String getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }

    public String getHinh() {
        return hinh;
    }

    public void setHinh(String hinh) {
        this.hinh = hinh;
    }

    public int getDiem() {
        return diem;
    }

    public void setDiem(int diem) {
        this.diem = diem;
    }
}
