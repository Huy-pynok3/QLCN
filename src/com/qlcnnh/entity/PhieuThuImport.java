
package com.qlcnnh.entity;

/**
 *
 * @author T14
 */
import java.util.Date;

public class PhieuThuImport  {
    
   
    private int id;
    private String  address, nameKh, lyDo;
    private Date dateCreate;


    private Double price;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(Date dateCreate) {
        this.dateCreate = dateCreate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNameKh() {
        return nameKh;
    }

    public void setNameKh(String nameKh) {
        this.nameKh = nameKh;
    }

    public String getLyDo() {
        return lyDo;
    }

    public void setLyDo(String lyDo) {
        this.lyDo = lyDo;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public PhieuThuImport(int id,  Date dateCreate, String address, String nameKh, String lyDo, double price) {
        this.id = id;
        this.dateCreate = dateCreate;
        this.address = address;
        this.nameKh = nameKh;
        this.lyDo = lyDo;
        this.price = price;
    }

    public PhieuThuImport() {
    }

    public void setName(String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
