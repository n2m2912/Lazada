package com.example.n2m.myapplication.model;

public class Sanpham {
    public int ID;
    public String Tensanpham;
    public Integer Giasanpham;
    public String Hinhsanpham;
    public String Motasanpham;
    public int IDSanpham;

    public Sanpham(int ID, String tensanpham, Integer giasanpham, String hinhsanpham, String motasanpham, int IDSanpham) {
        this.ID = ID;
        Tensanpham = tensanpham;
        Giasanpham = giasanpham;
        Hinhsanpham = hinhsanpham;
        Motasanpham = motasanpham;
        this.IDSanpham = IDSanpham;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getTensanpham() {
        return Tensanpham;
    }

    public void setTensanpham(String tensanpham) {
        Tensanpham = tensanpham;
    }

    public Integer getGiasanpham() {
        return Giasanpham;
    }

    public void setGiasanpham(Integer giasanpham) {
        Giasanpham = giasanpham;
    }

    public String getHinhsanpham() {
        return Hinhsanpham;
    }

    public void setHinhsanpham(String hinhsanpham) {
        Hinhsanpham = hinhsanpham;
    }

    public String getMotasanpham() {
        return Motasanpham;
    }

    public void setMotasanpham(String motasanpham) {
        Motasanpham = motasanpham;
    }

    public int getIDSanpham() {
        return IDSanpham;
    }

    public void setIDSanpham(int IDSanpham) {
        this.IDSanpham = IDSanpham;
    }
}
