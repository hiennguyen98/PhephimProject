package com.example.model;

import java.io.Serializable;

public class Phim implements Serializable {
    String ma;
    String ten;
    String daoDien;
    String dienVien;
    String thoiLuong;
    String ngayKhoiChieu;
    float diemDanhGia;
    String poster;
    String theLoai;

    public Phim(String ma, String ten, String daoDien, String dienVien, String thoiLuong, String ngayKhoiChieu, float diemDanhGia, String poster, String theLoai) {
        this.ma = ma;
        this.ten = ten;
        this.daoDien = daoDien;
        this.dienVien = dienVien;
        this.thoiLuong = thoiLuong;
        this.ngayKhoiChieu = ngayKhoiChieu;
        this.diemDanhGia = diemDanhGia;
        this.poster = poster;
        this.theLoai = theLoai;
    }

    public Phim() {
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getDaoDien() {
        return daoDien;
    }

    public void setDaoDien(String daoDien) {
        this.daoDien = daoDien;
    }

    public String getDienVien() {
        return dienVien;
    }

    public void setDienVien(String dienVien) {
        this.dienVien = dienVien;
    }

    public String getThoiLuong() {
        return thoiLuong;
    }

    public void setThoiLuong(String thoiLuong) {
        this.thoiLuong = thoiLuong;
    }

    public String getNgayKhoiChieu() {
        return ngayKhoiChieu;
    }

    public void setNgayKhoiChieu(String ngayKhoiChieu) {
        this.ngayKhoiChieu = ngayKhoiChieu;
    }

    public float getDiemDanhGia() {
        return (float) Math.round(diemDanhGia*10)/10 ;
    }

    public void setDiemDanhGia(float diemDanhGia) {
        this.diemDanhGia = diemDanhGia;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public String getTheLoai() {
        return theLoai;
    }

    public void setTheLoai(String theLoai) {
        this.theLoai = theLoai;
    }
}
