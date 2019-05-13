package com.example.model;

import java.io.Serializable;

public class BinhLuanPhim implements Serializable {
    String user;
    int diemDanhGia;
    String binhLuan;
    String ngayDang;
    int diemBLP;
    String image;

    public BinhLuanPhim(String user, int diemDanhGia, String binhLuan, String ngayDang, int diemBLP, String image) {
        this.user = user;
        this.diemDanhGia = diemDanhGia;
        this.binhLuan = binhLuan;
        this.ngayDang = ngayDang;
        this.diemBLP = diemBLP;
        this.image = image;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public int getDiemDanhGia() {
        return diemDanhGia;
    }

    public void setDiemDanhGia(int diemDanhGia) {
        this.diemDanhGia = diemDanhGia;
    }

    public String getBinhLuan() {
        return binhLuan;
    }

    public void setBinhLuan(String binhLuan) {
        this.binhLuan = binhLuan;
    }

    public String getNgayDang() {
        return ngayDang;
    }

    public void setNgayDang(String ngayDang) {
        this.ngayDang = ngayDang;
    }

    public int getDiemBLP() {
        return diemBLP;
    }

    public void setDiemBLP(int diemBLP) {
        this.diemBLP = diemBLP;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
