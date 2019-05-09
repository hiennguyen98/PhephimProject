package com.example.model;

import java.io.Serializable;

public class BaiViet implements Serializable {
    String ma;
    String tieuDe;
    String noiDung;
    String ngayDang;
    int diemDanhGia;
    String tenTheLoai;
    String tacGia;

    public BaiViet(String ma, String tieuDe, String noiDung, String ngayDang, int diemDanhGia, String tenTheLoai, String tacGia) {
        this.ma = ma;
        this.tieuDe = tieuDe;
        this.noiDung = noiDung;
        this.ngayDang = ngayDang;
        this.diemDanhGia = diemDanhGia;
        this.tenTheLoai = tenTheLoai;
        this.tacGia = tacGia;
    }

    public BaiViet() {
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getTieuDe() {
        return tieuDe;
    }

    public void setTieuDe(String tieuDe) {
        this.tieuDe = tieuDe;
    }

    public String getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }

    public String getNgayDang() {
        return ngayDang;
    }

    public void setNgayDang(String ngayDang) {
        this.ngayDang = ngayDang;
    }

    public int getDiemDanhGia() {
        return diemDanhGia;
    }

    public void setDiemDanhGia(int diemDanhGia) {
        this.diemDanhGia = diemDanhGia;
    }

    public String getTenTheLoai() {
        return tenTheLoai;
    }

    public void setTenTheLoai(String tenTheLoai) {
        this.tenTheLoai = tenTheLoai;
    }

    public String getTacGia() {
        return tacGia;
    }

    public void setTacGia(String tacGia) {
        this.tacGia = tacGia;
    }
}
