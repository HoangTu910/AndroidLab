package com.example.btvn6;

public class Student {
    private int id;
    private String name;
    private String mssv;
    private String avatar;
    private String ngaysinh;
    private String lop;
    private String chuyennganh;

    public Student(int id, String name, String mssv, String avatar, String ngaysinh, String lop, String chuyennganh) {
        this.id = id;
        this.name = name;
        this.mssv = mssv;
        this.avatar = avatar;
        this.ngaysinh = ngaysinh;
        this.lop = lop;
        this.chuyennganh = chuyennganh;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getMssv() {
        return mssv;
    }

    public String getAvatar() {
        return avatar;
    }
    public String getNgaysinh() {
        return ngaysinh;
    }
    public String getLop() {
        return lop;
    }
    public String getChuyennganh() {
        return chuyennganh;
    }
}
