
package com.qlcnnh.entity;

import java.util.Date;

/**
 *
 * @author T14
 */
public class SoTietKiemImport {

    public String getChiNhanh() {
        return chiNhanh;
    }

    public void setChiNhanh(String chiNhanh) {
        this.chiNhanh = chiNhanh;
    }

    public String getKyHan() {
        return kyHan;
    }

    public void setKyHan(String kyHan) {
        this.kyHan = kyHan;
    }

    public String getMaKh() {
        return maKh;
    }

    public void setMaKh(String maKh) {
        this.maKh = maKh;
    }

    public String getTenKh() {
        return tenKh;
    }

    public void setTenKh(String tenKh) {
        this.tenKh = tenKh;
    }

    public String getCccd() {
        return cccd;
    }

    public void setCccd(String cccd) {
        this.cccd = cccd;
    }

    public String getSoTk() {
        return soTk;
    }

    public void setSoTk(String soTk) {
        this.soTk = soTk;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getSoTien() {
        return soTien;
    }

    public void setSoTien(double soTien) {
        this.soTien = soTien;
    }

    public int getLaiSuat() {
        return laiSuat;
    }

    public void setLaiSuat(int laiSuat) {
        this.laiSuat = laiSuat;
    }

    public Date getNgayMoSo() {
        return ngayMoSo;
    }

    public void setNgayMoSo(Date ngayMoSo) {
        this.ngayMoSo = ngayMoSo;
    }

    public SoTietKiemImport() {
    }

   

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public SoTietKiemImport(int id,String chiNhanh, String kyHan, String maKh, String tenKh, String cccd, String soTk, double soTien, int laiSuat, Date ngayMoSo, String address ) {
        this.id = id;
        this.chiNhanh = chiNhanh;
        this.kyHan = kyHan;
        this.maKh = maKh;
        this.tenKh = tenKh;
        this.cccd = cccd;
        this.soTk = soTk;
        this.soTien = soTien;
        this.laiSuat = laiSuat;
        this.ngayMoSo = ngayMoSo;
        this.address = address;
    }

   
    private String chiNhanh,kyHan,maKh,tenKh,cccd,soTk,address;
    private double soTien;
    private int laiSuat,id;
    private Date ngayMoSo;
}
